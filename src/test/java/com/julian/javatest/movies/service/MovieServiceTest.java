package com.julian.javatest.movies.service;

import com.julian.javatest.movies.data.MovieRepository;
import com.julian.javatest.movies.model.Genre;
import com.julian.javatest.movies.model.Movie;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MovieServiceTest {
    @Test
    public void return_movies_by_genre() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark", 152, Genre.ACTION),
                        new Movie(1, "Memento", 152, Genre.THRILLER)
                )
        );
        MovieService movieService = new MovieService(movieRepository);
        movieService.findMoviesByGenre(Genre.COMEDY);
    }
}