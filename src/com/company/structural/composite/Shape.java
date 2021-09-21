package com.company.structural.composite;

public class Shape implements Component{
    @Override
    public void render(){
       System.out.println("Rendering Shape");
   }

    @Override
    public void move() {
        System.out.println("Moving Shape");
    }
}
