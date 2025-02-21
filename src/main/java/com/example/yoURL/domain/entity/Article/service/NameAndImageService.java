package com.example.yoURL.domain.entity.Article.service;

import com.example.yoURL.domain.entity.Article.service.openGraph.OpenGraph;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NameAndImageService {
    public NameAndImage fetchNameAndImage(String url) {

        String name = "null";
        String imageUrl = "null";

        try {
            Document doc = Jsoup.connect(url).get();

            name = doc.select("meta[property=og:title]").attr("content");
            imageUrl = doc.select("meta[property=og:image]").attr("content");

            log.info("제목 = {}", name);
            log.info("썸네일 = {}", imageUrl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new NameAndImage(name, imageUrl, url);
    }

    @Getter
    public static class NameAndImage {
        private final String name;
        private final String url;
        private final String imageUrl;

        public NameAndImage(String name, String imageUrl, String url) {
            this.url = url;
            this.name = name;
            this.imageUrl = imageUrl;
        }

    }
}





