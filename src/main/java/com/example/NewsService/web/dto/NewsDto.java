package com.example.NewsService.web.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    @NotEmpty(message = "company_tag should not be empty")
    private String company_tag;
    @NotEmpty(message = "Content should not be empty")
    private String content;
}