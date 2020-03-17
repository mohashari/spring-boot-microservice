package me.muklis.imageservice.controller;

import me.muklis.imageservice.domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/images")
public class HomeController {

    @Autowired
    private Environment environment;

    @GetMapping("")
    public List<Image> getImages() {
        List<Image> images = Arrays.asList(
                new Image("1", "url1", "img1"),
                new Image("2", "url2", "img2"),
                new Image("3", "url3", "img3")
        );
        return images;
    }
}
