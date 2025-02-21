package com.example.yoURL.domain.entity.Article.service;

import com.example.yoURL.domain.entity.Article.service.openGraph.OpenGraph;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class NameAndImageService {
    public NameAndImage fetchNameAndImage(String url) {

        String name = "null";
        String imageUrl = "null";

        try {
            OpenGraph website = new OpenGraph(url, true);
            name = website.getContent("title");
            imageUrl = website.getContent("iamge");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new NameAndImage(name, imageUrl);
    }

    @Getter
    public static class NameAndImage {
        private final String name;
        private final String imageUrl;

        public NameAndImage(String name, String imageUrl) {
            this.name = name;
            this.imageUrl = imageUrl;
        }

    }
}