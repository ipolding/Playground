package uk.co.ipolding;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import uk.co.ipolding.blog.*;

@EnableAutoConfiguration
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(BlogController.class, args);
    }
}
