package com.example.yoURL.domain.entity.Folder.entity.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    CREATE_SUCCESS(HttpStatus.CREATED.value(), "폴더 생성 성공했습니다."),
    UPDATE_SUCCESS(HttpStatus.OK.value(), "폴더 수정 성공했습니다."),
    DELETE_SUCCESS(HttpStatus.OK.value(), "폴더 삭제 성공했습니다"),

    FOLDER_LIKE_SUCCESS(HttpStatus.OK.value(), "즐겨찾기 등록에 성공했습니다."),
    FOLDER_LIKE_REMOVE_SUCCESS(HttpStatus.OK.value(), "즐겨찾기 해제에 성공했습니다.");

    private final int code;
    private final String message;

}
