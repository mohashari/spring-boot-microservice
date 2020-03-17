package me.muklis.galleryservice.domain;

import java.util.List;

public class Gallery {

    private String id;
    private List<Image> image ;

    public Gallery(String id, List<Image> image) {
        this.id = id;
        this.image = image;
    }

    public Gallery() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
