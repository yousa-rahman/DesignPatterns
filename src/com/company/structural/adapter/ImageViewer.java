package com.company.structural.adapter;

public class ImageViewer {
    private Image image;

    public ImageViewer(Image image) {
        this.image = image;
    }

    public void apply(Filter filter){
        filter.apply(image);
    }
}
