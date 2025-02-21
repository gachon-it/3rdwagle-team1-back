package com.example.yoURL.domain.entity.Folder.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDTO {
    private String name;
    private Long id;
    private Long memberid;
}