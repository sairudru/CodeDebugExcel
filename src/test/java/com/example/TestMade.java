package com.example;

public class TestMade {
    public static void main(String[] args) {

        CustomThread t1= new CustomThread("First Thread","chrome");
        CustomThread t2= new CustomThread("Second Thread","safari");
        t1.start();
        t2.start();
    }
}
