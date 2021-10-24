package com.company.behaviouralPattern.strategy;

public class Main {

    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("FileName", new JpegCompressor(),new BlackAndWhiteFilter());
        imageStorage.store("FileName", new PngCompressor(), new BlackAndWhiteFilter());
    }
}
