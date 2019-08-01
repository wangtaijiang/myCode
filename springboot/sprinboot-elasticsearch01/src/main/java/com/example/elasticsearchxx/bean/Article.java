/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.elasticsearchxx.bean;

import io.searchbox.annotations.JestId;

/**
 * @authur wtj
 * @date 2019/8/1    20:30
 */
public class Article {
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Article() {
    }

    public Article(Integer id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
