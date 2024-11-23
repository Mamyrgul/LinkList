package serviceImpl;

import dataBasa.DataBase;
import enums.Genre;
import moduls.Actor;
import moduls.Movie;
import moduls.Producer;
import service.MovieService;
import java.time.LocalDate;
import java.util.ArrayList;

public class MovieServiceImpl implements MovieService {
    @Override
    public ArrayList<Movie> getAllMovies() {
        return DataBase.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie:DataBase.movies){
            if (movie.getName().equalsIgnoreCase(name)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie:DataBase.movies){
            for (Actor actor: movie.getActors()){
                if (actor.getActorFullName().equalsIgnoreCase(actorName)){
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
            for (Movie localDate:DataBase.movies){
                if (localDate.getYear().equals(year)){
                    return localDate;
                }
            }
            return null;
        }


    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie: DataBase.movies){
           Producer producer = movie.getProducer();
           if (producer.getFirstName().equals(producerFullName)){
               return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie:DataBase.movies){
            if (movie.getGenre().equals(genre)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie:DataBase.movies){
            for(Actor actor:movie.getActors()) {
                if (actor.getRole().equals(role)){
                    return movie;
                }
            }
        }
        return null;
    }
}
