package serviceImpl;

import dataBasa.DataBase;
import moduls.Movie;
import moduls.Producer;
import service.MovieSortableService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieSortableServiceImpl implements MovieSortableService {
    @Override
    public void sortMovieByName(ArrayList<Movie> movies, String ascOrDesc) {
        Comparator<Movie> movieComparator = Comparator.comparing(Movie::getName);
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            movieComparator = movieComparator.reversed();
        }
        movies.sort(movieComparator);
        for (Movie movie:DataBase.movies){
            System.out.println(movie);
        }

    }

    @Override
    public void sortByYear() {
  Comparator<Movie> movieComparator= Comparator.comparing(Movie::getYear);
  DataBase.movies.sort(movieComparator);
  for (Movie movie:DataBase.movies){
      System.out.println(movie);
  }

    }

    @Override
    public void sortByProducer(String nameOrLastName) {
    Comparator<Movie> producerComparator= Comparator.comparing(movie -> movie.getProducer().getFirstName());
    if (nameOrLastName.equalsIgnoreCase("desc")){
        producerComparator.reversed();
    }
    DataBase.movies.sort(producerComparator);
    for (Movie m:DataBase.movies){
        System.out.println(m);

    }
    }
}
