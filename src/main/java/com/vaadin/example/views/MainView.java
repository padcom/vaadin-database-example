package com.vaadin.example.views;

import java.beans.IntrospectionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.vaadin.example.ApplicationServiceInitListener;
import com.vaadin.example.components.HelloWorld;
import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.service.MovieService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import elemental.json.JsonArray;
import elemental.json.JsonFactory;
import elemental.json.impl.JreJsonFactory;

/**
 * A simple Vaadin View class that shows all Movies in a database.
 * <p>
 * See {@link MovieService} for details on the database, and
 * {@link ApplicationServiceInitListener} for adding more demo data.
 */
@Route
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    private JsonArray convert(List<Movie> movies) {
        Gson gson = new Gson();
        JsonFactory jsonFactory = new JreJsonFactory();

        return jsonFactory.parse(gson.toJson(movies));
    }

    public MainView(@Autowired MovieService movieService) throws IntrospectionException {
        HelloWorld hello = new HelloWorld();
        hello.setColumns("this is a list of columns!");
        hello.setItems(convert(movieService.getMovies()));
        hello.addClickListener(e -> { System.out.println("Clicked!"); });
        add(hello);
/*
        // Create and add header text
        add(new H3("Accessing in-memory database using JdbcTemplate"));

        // create Grid component
        final Grid<Movie> movies = new Grid<>(Movie.class);

        System.out.println(movieService.getMovies());

        // fetch all movies from our Service
        movies.setItems(movieService.getMovies());

        // Use these auto-generated columns
        movies.setColumns("title", "releaseYear");

        // Add 'Director' column
        movies.addColumn(movie -> movie.getDirector().getName()).setHeader("Director");

        // Add link to iMDB column; the TemplateRenderer allows us to use a HTML link.
        movies.addColumn(
                TemplateRenderer.<Movie>of("<a href='[[item.imbdLink]]' target='_blank'>Click to IMBD site</a>").withProperty("imbdLink", Movie::getImbdLink))
                .setHeader("IMBD Link");

        // set one column to specific width
        movies.getColumnByKey("releaseYear").setWidth("55px");

        // Add Grid to view
        add(movies);
*/
    }

}
