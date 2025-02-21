package com.example.yoURL.domain.entity.Folder.entity.service;

import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import com.example.yoURL.domain.entity.Folder.entity.exception.FolderAlreadyLikedException;
import com.example.yoURL.domain.entity.Folder.entity.exception.FolderNotFoundException;
import com.example.yoURL.domain.entity.Folder.entity.exception.FolderNotLikedException;
import com.example.yoURL.domain.entity.Folder.entity.repository.FolderRepository;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.domain.entity.Member.exception.MemberNotFoundException;
import com.example.yoURL.domain.entity.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FolderLikeService {

    private final FolderRepository folderRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void addLikeFolder(Long id, String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(MemberNotFoundException::new);
        Folder folder = folderRepository.findById(id)
                .orElseThrow(FolderNotFoundException::new);

        if (member.getLikes().contains(folder)) {
            throw new FolderAlreadyLikedException();
        }
        member.addLike(folder);
        memberRepository.save(member);
    }

    @Transactional
    public void deleteLikeFolder(Long id, String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(MemberNotFoundException::new);
        Folder folder = folderRepository.findById(id)
                .orElseThrow(FolderNotFoundException::new);

        if (!member.getLikes().contains(folder)) {
            throw new FolderNotLikedException();
        }
        member.deleteLike(folder);
        memberRepository.save(member);
    }
}
