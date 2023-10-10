package com.example.NewsService.service;


import com.example.NewsService.model.News;

public interface KafkaDataService {

    void send(News news);

}