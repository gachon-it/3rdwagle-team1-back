package com.example.yoURL.domain.entity.Folder.entity.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    FOLDER_NOT_FOUND("폴더를 찾을 수 없습니다."),
    FOLDER_ALREADY_LIKED("이미 즐겨찾기로 등록한 폴더입니다."),
    FOLDER_NOT_LIKED("즐겨찾기로 등록되지 않은 폴더입니다.");


    private final String message;
}