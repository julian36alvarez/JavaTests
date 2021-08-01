package com.julian.javatest.movies.data;

import com.julian.javatest.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    public Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
