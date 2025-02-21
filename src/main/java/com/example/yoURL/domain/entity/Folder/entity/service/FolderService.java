package com.example.yoURL.domain.entity.Folder.entity.service;

import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import com.example.yoURL.domain.entity.Folder.entity.repository.FolderRepository;
import com.example.yoURL.domain.entity.Folder.entity.response.FolderResponse;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.domain.entity.Member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;
    private final MemberRepository memberRepository;

    // ✅ 폴더 생성
    public FolderResponse createFolder(Long member_id,String name) {
            Member member = memberRepository.findById(member_id)
        .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다."));


        // 같은 이름의 폴더가 존재하는지 확인 (동일한 멤버 내에서)
        if (folderRepository.existsByName(name)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 같은 이름의 폴더가 존재합니다.");
        }

        // 폴더 생성
        Folder folder = Folder.builder()
                .name(name)
                .member(member)  // ✅ 반드시 Member를 설정해야 함
                .build();

        Folder savedFolder = folderRepository.save(folder);

        return FolderResponse.of(
                savedFolder.getId(),
                savedFolder.getName()
        );
    }

    // ✅ 폴더 수정 (이름 변경)
    public FolderResponse updateFolder(Long folderId, String newName) {


        Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "폴더를 찾을 수 없습니다."));

        folder.rename(newName);

        return FolderResponse.of(
                folder.getId(),
                folder.getName()
        );
    }


    public void deleteFolder(Long memberId, String name) {
    // Ensure the folder belongs to the authenticated member
    Folder folder = folderRepository.findByNameAndMemberId(name, memberId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 유저의 폴더를 찾을 수 없습니다."));

    folderRepository.delete(folder);
}

    public FolderRepository getFolderRepository() {
        return folderRepository;
    }
}