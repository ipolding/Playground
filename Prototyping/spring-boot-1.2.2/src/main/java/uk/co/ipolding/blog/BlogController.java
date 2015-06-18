package uk.co.ipolding.blog;


import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.mustache.web.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;

import com.samskivert.mustache.Template;

@Controller
@EnableAutoConfiguration
public class BlogController {

    @RequestMapping("/blog")
    public String home() {

        ModelAndView mav = new ModelAndView("blog");
        mav.addObject("name", "Sausage");
       return "blog";
    }


}
