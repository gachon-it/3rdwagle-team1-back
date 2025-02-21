package com.example.yoURL.domain.entity.Folder.entity.exception;

import static com.example.yoURL.domain.entity.Folder.entity.exception.ErrorMessage.FOLDER_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.yoURL.global.common.exception.BaseException;

public class FolderNotFoundException extends BaseException {
    public FolderNotFoundException() {
        super(NOT_FOUND, FOLDER_NOT_FOUND.getMessage());
    }
}
