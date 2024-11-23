import dataBasa.DataBase;
import enums.Genre;
import moduls.Actor;
import moduls.Movie;
import moduls.Producer;
import service.MovieService;
import service.MovieSortableService;
import serviceImpl.MovieServiceImpl;
import serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      /*  Movie Task
        Movie:
        private String name;
        private LocalDate year;
        private Genre genre;
        private Producer producer;
        private List<Actor> actors;

        Actor:
        private String actorFullName;
        private String role;

        Producer:
        private String firstName;
        private String lastName;

        MovieFindableService:

        List<Movie> getAllMovies();
        Movie findMovieByFullNameOrPartName(String name);
        Movie findMovieByActorName(String actorName);
        Movie findMovieByYear(LocalDate year);
        Movie findMovieByProducer(String producerFullName);
        Movie findMovieByGenre(Genre genre);
        Movie findMovieByRole(String role);

        MovieSortableService:
        void sortMovieByName(String ascOrDesc);
        -from A to Z
                -from Z to A
        void sortByYear(String ascOrDesc);
        -Ascending
                -Descending
        void sortByProducer(String nameOrlastName);

****** Main де кайсыл иш аракетти аткаргыбыз келсе ошол метод switch case аркылуу чакырылып иштесин.
                Бардык маалыматтар туура жана так болуп консольго чыксын.*/
        Scanner scanner = new Scanner(System.in);
        MovieService movieService = new MovieServiceImpl();
        MovieSortableService movieService1 = new MovieSortableServiceImpl();
        ArrayList<Actor> actors = new ArrayList<>(
                List.of(new Actor(1L,"Max","Box"),
                        new Actor(2L,"Genifer","Mother")));
        Producer producer = new Producer(1L,"Maikl","Gekson");
        Producer producer1 = new Producer(1L,"Aaikl","Gekson");
        Producer producer2 = new Producer(1L,"haikl","Gekson");

        Movie  movie = new Movie(1L,"Hided", LocalDate.of(2021,2,12), Genre.HORROR,producer,actors);
        ArrayList<Movie> movies = new ArrayList<>(
                List.of( new Movie(1L,"Hided", LocalDate.of(2022,2,12), Genre.HORROR,producer,actors),
                        new Movie(2L, "YFUITYU", LocalDate.of(2023, 12, 12), Genre.POEM, producer1, actors),
                        new Movie(3L, "Another Movie", LocalDate.of(2020, 5, 25), Genre.POEM, producer2, actors))
        );
        DataBase.movies.addAll(movies);
       while (true){
           try {
               System.out.println("1. Information about movie:");
               System.out.println("2. Sort movie by what: ");

               int choice= scanner.nextInt();
               scanner.nextLine();

               switch (choice) {
                   case 1:
                       try {
                           boolean check = true;
                           while (check) {
                               System.out.println("1. Get all movies: ");
                               System.out.println("2. Find movie by full name: ");
                               System.out.println("3. Find movie by year: ");
                               System.out.println("4. Find movie by producer: ");
                               System.out.println("5. Find movie by genre: ");
                               System.out.println("6. Find movie by role");
                               System.out.println("7. Return to main menu");
                               int choice2 = scanner.nextInt();
                               scanner.nextLine();
                               switch (choice2) {

                                   case 1: {
                                       System.out.println("All movies: ");
                                       System.out.println(movieService.getAllMovies());
                                   }
                                   break;
                                   case 2: {
                                       try {
                                           System.out.println("Write movie name: ");
                                           String name = scanner.nextLine();
                                            boolean movieFound= false;
                                            for (Movie movie1:DataBase.movies){
                                                if (movie1.getName().equalsIgnoreCase(name)){
                                                    System.out.println(movieService.findMovieByFullNameOrPartName(name));
                                                    movieFound=true;
                                                }
                                            }
                                            if (!movieFound){
                                                System.out.println("Try again");
                                                break;
                                            }
                                       } catch (IllegalArgumentException e) {
                                           System.out.println(e.getMessage());
                                       }
                                   }
                                   break;
                                   case 3: {
                                       try {
                                           System.out.println("Write local date: ");
                                           String date = scanner.next();
                                           LocalDate issuedDate = LocalDate.parse(date);
                                           boolean dateFound=false;
                                           for (Movie movie1:DataBase.movies){
                                               if (movie1.getYear().equals(issuedDate)){
                                                   System.out.println(movieService.findMovieByYear(issuedDate));
                                                   dateFound=true;
                                               }
                                           }
                                           if (!dateFound){
                                               System.out.println("We cant find movie");
                                               break;
                                           }
                                       } catch (Exception e) {
                                           System.out.println("Try again" + e.getMessage());
                                       }
                                   }
                                   break;
                                   case 4: {
                                       try {
                                           System.out.println("Write name producer: ");
                                           String name = scanner.nextLine();
                                           boolean found= false;
                                           for (Movie movie1:DataBase.movies){
                                               if (movie1.getProducer().getFirstName().equalsIgnoreCase(name)){
                                                   System.out.println(movieService.findMovieByProducer(name));
                                                   found=true;
                                               }
                                           }if (!found){
                                               System.out.println("Have some problem");
                                               break;
                                           }

                                           for (int i = 0; i < DataBase.movies.size(); i++) {
                                               if (!Character.isLetter(name.charAt(i))) {
                                                   throw new IllegalArgumentException("Only letters");
                                               }
                                           }
                                       } catch (IllegalArgumentException e) {
                                           System.out.println(e.getMessage());
                                       }
                                   }
                                   break;
                                   case 5: {
                                       try {
                                           System.out.println("Choice one and write correct: ");
                                           System.out.println("HORROR,\n" +
                                                   "    POEM,\n" +
                                                   "    LIRIKA,\n" +
                                                   "    ROMANTIK,\n" +
                                                   "    DORAMA,\n" +
                                                   "    FANTASTICA");
                                           String genre1 = scanner.next().toUpperCase();
                                           Genre genre = Genre.valueOf(genre1);
                                           boolean found= false;
                                           for (Movie movie1:DataBase.movies){
                                               if (movie1.getGenre().equals(genre)){
                                                   System.out.println(movieService.findMovieByGenre(genre));
                                                   found=true;
                                               }
                                           }if (!found){
                                               System.out.println("Have some issues try again");
                                               break;
                                           }

                                       } catch (Exception e) {
                                           System.out.println("Try again " + e.getMessage());
                                       }
                                   }
                                   break;
                                   case 6: {
                                       try {
                                           System.out.println("Write role: ");
                                           String role = scanner.nextLine();
                                           System.out.println(movieService.findMovieByRole(role));
                                           for (int i = 0; i < DataBase.movies.size(); i++) {
                                               if (!Character.isLetter(role.charAt(i))) {
                                                   throw new IllegalArgumentException("Only letters");
                                               }
                                           }
                                       } catch (IllegalArgumentException e) {
                                           System.out.println(e.getMessage());
                                       }
                                   }
                                   break;
                                   case 7: {
                                       check = false;
                                       break;
                                   }
                                   default: {
                                       System.out.println("Problem try again");
                                   }
                               }
                               if (!check) {
                                   break;
                               }
                           }
                       } catch (Exception e) {
                           System.out.println("Some problem try again " + e.getMessage());
                       }
                       scanner.nextLine();
                       break;

                   case 2: {
                       try {
                           boolean choice4 = true;
                           while (choice4) {
                               System.out.println("1. Sort movie by name: ");
                               System.out.println("2. Sort movie by year: ");
                               System.out.println("3. Sort movie by producer name: ");
                               System.out.println("4. Stop: ");

                               int choice2 = scanner.nextInt();
                               scanner.nextLine();
                               switch (choice2) {
                                   case 1: {
                                       try {
                                           movieService1.sortMovieByName(movies, "desc");
                                       } catch (Exception e) {
                                           System.out.println(e.getMessage());
                                       }
                                   }
                                   break;
                                   case 2: {
                                       movieService1.sortByYear();
                                   }
                                   break;
                                   case 3: {
                                       movieService1.sortByProducer("Max");
                                   }
                                   break;
                                   case 4: {
                                       System.out.println("Stop");
                                       break;
                                   }
                                   default: {
                                       System.out.println("Problem try again");
                                   }
                               }
                               if (!choice4) {
                              break;
                               }
                           }
                       }catch(Exception e){
                           System.out.println(e.getMessage());
                       }
                       scanner.nextLine();
                       break;
                   }
               }

           }catch (Exception e){
               System.out.println(e.getMessage());
           }
       }
    }
}
