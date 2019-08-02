/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.elasticsearchxx.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @authur wtj
 * @date 2019/8/1    21:28
 */
@Document(indexName = "sanguo",type = "person")
public class Person {
    private Long id;
    private String name;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
