package me.muklis.galleryservice.controller;

import me.muklis.galleryservice.domain.Gallery;
import me.muklis.galleryservice.domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/")
    public String getHome() {
        return "Hello from gallery service from port: " + environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable("id") String id) {
        Gallery gallery = new Gallery();
        gallery.setId(id);
        List<Image> images = restTemplate.getForObject("http://image-service/images", List.class);
        gallery.setImage(images);
        return gallery;
    }


    @GetMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + environment.getProperty("local.server.port");
    }
}
