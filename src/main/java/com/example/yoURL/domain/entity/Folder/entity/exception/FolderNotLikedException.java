package com.example.yoURL.domain.entity.Folder.entity.exception;

import static com.example.yoURL.domain.entity.Folder.entity.exception.ErrorMessage.FOLDER_NOT_LIKED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class FolderNotLikedException extends BaseException {
    public FolderNotLikedException() {
        super(BAD_REQUEST, FOLDER_NOT_LIKED.getMessage());
    }
}
