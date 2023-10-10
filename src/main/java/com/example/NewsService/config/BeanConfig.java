package com.example.NewsService.config;


import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @SneakyThrows
    @Bean
    public XML producerXml() {
        return new XMLDocument(
                getClass().getResourceAsStream("/kafka/producer.xml").readAllBytes()
        );
    }

}