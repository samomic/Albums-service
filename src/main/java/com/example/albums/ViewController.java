package com.example.albums;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/view-users")
    public String viewUsers() {
        return "view-users";
    }
    @RequestMapping("/view-albums")
    public String viewAlbums() {
        return "view-albums";
    }
    @RequestMapping("/")
    public String homePage() {
        return "index";
    }
}