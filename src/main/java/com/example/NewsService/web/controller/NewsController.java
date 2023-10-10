package com.example.NewsService.web.controller;

import com.example.NewsService.model.News;
import com.example.NewsService.service.KafkaDataService;
import com.example.NewsService.web.dto.NewsDto;
import com.example.NewsService.web.mapper.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final KafkaDataService kafkaDataService;


    private final DataMapper dataMapper;

    @PostMapping("/send")
    public void send(@RequestBody NewsDto newsDto) {
        try{
        News news = dataMapper.toEntity(newsDto);
        kafkaDataService.send(news);}
        catch (Exception e){
            System.out.println(e);
        }
    }



}