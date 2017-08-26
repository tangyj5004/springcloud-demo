package com.xuliugen.springcloud.controller;

import com.xuliugen.springcloud.bean.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuliugen on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @GetMapping
    public List<Movie> get() {
        List<Movie> movies = assemberMovies();
        return movies;
    }

    /***
     * 组装Users
     */
    private List<Movie> assemberMovies() {
        List<Movie> movies = new ArrayList<Movie>(5);
        Movie movie1 = new Movie("id:1", "MIT'S Story", "xuliugen");
        Movie movie2 = new Movie("id:2", "zhangsan's story", "zhangsan");
        Movie movie3 = new Movie("id:3", "lisi's story", "lisi");
        Movie movie4 = new Movie("id:4", "wangwu's story", "wangwu");
        Movie movie5 = new Movie("id:5", "zhaoliu's story", "zhaoliu");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        return movies;
    }
}
