package com.example.NewsService.web.controller;

import com.example.NewsService.model.News;
import com.example.NewsService.service.KafkaDataService;
import com.example.NewsService.web.dto.NewsDto;
import com.example.NewsService.web.mapper.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
@Validated
public class NewsController {

    private final KafkaDataService kafkaDataService;
    private final DataMapper dataMapper;

    @PostMapping("/send")
    public void send(@RequestBody @Valid NewsDto newsDto, BindingResult bindingResult) {

        News news = dataMapper.toEntity(newsDto);
        kafkaDataService.send(news);

    }
}