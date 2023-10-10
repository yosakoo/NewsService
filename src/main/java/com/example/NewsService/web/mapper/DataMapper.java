package com.example.NewsService.web.mapper;


import com.example.NewsService.model.News;
import com.example.NewsService.web.dto.NewsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<News, NewsDto> {
}