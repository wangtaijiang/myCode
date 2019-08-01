package com.example.elasticsearchxx;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.elasticsearchxx.bean.Article;
import com.example.elasticsearchxx.bean.Person;
import com.example.elasticsearchxx.repository.PersonRepository;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprinbootElasticsearch01ApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void testRepositoryES(){
//        Person person = new Person();
//        person.setId(1l);
//        person.setName("xiaoming");
//        personRepository.save(person);
//        Optional<Person> byId = personRepository.findById(1l);
        List<Person> personList = personRepository.findByFirstnameLike("m");


    }

    @Test
    public void contextLoads() {
        //1、给ES中索引（保存）一个文档；
        Article article = new Article();
        article.setId(1);
        article.setAuthor("张三");
        article.setTitle("消息");
        article.setContent("hello world");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("sanguo").type("news").build();
        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    public void testSearch(){
        //查询表达式
        String json = "";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("sanguo").addType("news").build();
        try {
            //执行搜索
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
