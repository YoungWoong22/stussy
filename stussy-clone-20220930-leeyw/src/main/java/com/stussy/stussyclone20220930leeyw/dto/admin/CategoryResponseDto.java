package com.stussy.stussyclone20220930leeyw.dto.admin;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDto {
    private int id;
    private String name;
}
