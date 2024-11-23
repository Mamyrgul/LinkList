package service;

import enums.Genre;
import moduls.Movie;

import java.time.LocalDate;
import java.util.ArrayList;

public interface MovieService {

    public ArrayList<Movie> getAllMovies();
    public Movie findMovieByFullNameOrPartName(String name);
    public Movie findMovieByActorName(String actorName);
    public Movie findMovieByYear(LocalDate year);
    public Movie findMovieByProducer(String producerFullName);
    public Movie findMovieByGenre(Genre genre);
    public Movie findMovieByRole(String role);
}
