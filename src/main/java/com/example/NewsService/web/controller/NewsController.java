package com.example.NewsService.web.controller;

import com.example.NewsService.model.News;
import com.example.NewsService.service.KafkaDataService;
import com.example.NewsService.web.dto.NewsDto;
import com.example.NewsService.web.mapper.DataMapper;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.Valid;
import jakarta.validation.ConstraintViolation;
import java.util.stream.Collectors;

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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}