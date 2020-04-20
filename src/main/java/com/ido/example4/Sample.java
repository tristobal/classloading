package com.ido.example4;

public class Sample {
    private Sample instance;

    public void setSample(Object instance) {
        this.instance = (Sample) instance;
        System.out.println("invoked!");
    }
}