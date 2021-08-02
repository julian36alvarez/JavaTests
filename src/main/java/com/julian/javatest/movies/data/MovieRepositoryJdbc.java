package com.julian.javatest.movies.data;

import com.julian.javatest.movies.model.Genre;
import com.julian.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Movie> findByName(String name){
        Collection<Movie> allMovies = jdbcTemplate.query("select * from movies", movieMapper);

        Collection<Movie> moviesFound = new ArrayList<>();

        for(Movie movie : allMovies) {
            if(movie.getName().toLowerCase().contains(name.toLowerCase())) {
                moviesFound.add(movie);
            }
        }

        return moviesFound;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = {id};

        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }




    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")));


}
