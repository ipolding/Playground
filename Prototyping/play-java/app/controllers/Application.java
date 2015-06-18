package controllers;

import models.Blog;
import models.Event;
import play.mvc.*;

import views.html.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result blog() {

        String content = "A Play Scala template is a simple text file that contains small blocks of Scala code. Templates can generate any text-based format, such as HTML, XML or CSV.\n" +
                "\n" +
                "The template system has been designed to feel comfortable to those used to working with HTML, allowing front-end developers to easily work with the templates.\n" +
                "\n" +
                "Templates are compiled as standard Scala functions, following a simple naming convention. If you create a views/Application/index.scala.html template file, it will generate a views.html.Application.index class that has a render() method.";

        Blog blog = new Blog("My first blog", "Joe Bloggs", content);


    return ok(views.html.blog.render(blog));
    }

    public static Result event() {

        String title = "Let's meet up and discuss the biggest challenges of public sector innovation.";
        String description = "For our inaugural meeting, let's get together to discuss the biggest challenges when innovating in the public sector, and from there we'll try to pull in people for future events that can talk about each of those topics.";
        LocalDateTime feb28 = LocalDateTime.of(2015, Month.FEBRUARY, 28, 19, 30);

        Event event = new Event(title, feb28, "Village Hall", description);

        return ok(views.html.events.render(event));




    }



}
