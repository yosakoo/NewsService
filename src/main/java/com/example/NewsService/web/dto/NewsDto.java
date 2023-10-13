package com.example.NewsService.web.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    @NotEmpty(message = "company should be not empty")
    private String company_tag;
    @NotEmpty(message = "content should be not empty")
    private String content;
}