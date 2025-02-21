package com.example.yoURL.domain.entity.Folder.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindDTO {
    private Long id;
    private LocalDate date;
}