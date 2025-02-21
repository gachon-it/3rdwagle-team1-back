package com.example.yoURL.domain.entity.Folder.entity.exception;

import static com.example.yoURL.domain.entity.Folder.entity.exception.ErrorMessage.FOLDER_ALREADY_LIKED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class FolderAlreadyLikedException extends BaseException {
    public FolderAlreadyLikedException() {
        super(BAD_REQUEST, FOLDER_ALREADY_LIKED.getMessage());
    }

}
