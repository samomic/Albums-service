package com.example.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Controller
public class AlbumsController {

    private static final Logger log = LoggerFactory.getLogger(AlbumsApplication.class);

    private static final String GET_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String GET_USERS_ALBUM = "https://jsonplaceholder.typicode.com/users/{id}/albums";

    Users[] users;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Users[] users = restTemplate.getForObject(GET_USERS, Users[].class);
            //log.info(users.toString());
            for(int i = 0; i < users.length; i++){
                System.out.println(users[i].toString());
            }
        };
    }

    @GetMapping("/albums")
    public String albumsForm(Model model){
        model.addAttribute("albums", new Albums());
        return "albums";
    }

    @PostMapping("/albums")
    public String albumsSubmit(@ModelAttribute Albums albums, Model model) {
        model.addAttribute("albums", albums);
        return "view-albums";
    }

    /*@GetMapping("/albums")
    public String albumsSubmit(@ModelAttribute Users users, Model model) {
        model.addAttribute("users", users);
        return "result";
    }*/
}
