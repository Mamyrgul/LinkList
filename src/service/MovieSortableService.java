package service;

import moduls.Movie;
import moduls.Producer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface MovieSortableService {
    public void sortMovieByName(ArrayList<Movie> movies, String ascOrDesc);
    void sortByYear();
    void sortByProducer(String nameOrLastName);
}
