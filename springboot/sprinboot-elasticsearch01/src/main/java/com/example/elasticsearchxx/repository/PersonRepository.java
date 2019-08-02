/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.elasticsearchxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.elasticsearchxx.bean.Person;

/**
 * @authur wtj
 * @date 2019/8/1    21:26
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    /**
     * 方法名的命名可以参考：https://docs.spring.io/spring-data/elasticsearch/docs/3.1.9.RELEASE/reference/html/#elasticsearch.repositories
     *
     * 详见官方文档
     * @param firstname
     * @return
     */
//    方法名findByFirstnameLike的命名等同于 加注解 @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstname\" : \"?\"}}}}")
    List<Person> findByFirstnameLike(String firstname);

    /**
     *
     * @param lastname
     * @return
     */

    List<Person> findByLastname(String lastname);


}
