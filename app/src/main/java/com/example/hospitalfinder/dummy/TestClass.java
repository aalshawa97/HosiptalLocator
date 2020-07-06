package com.example.hospitalfinder.dummy;

public class TestClass {
    private int age;
    private String color;
    private String name;

    private class TestInnerClass{
        private String name;
    }

    public void TestInnerClass(String name){
        this.name = name;
    }

    private void printHospitalName(){
        System.out.println("Hospital Name: " + name);
    }
}
