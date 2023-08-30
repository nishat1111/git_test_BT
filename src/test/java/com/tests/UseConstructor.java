package com.tests;

public class UseConstructor {
    // Constructor is a special type of method.
    // Constructor name should be same as class name.

    int age=25;
    String houseName="Rumel's House";
    String address="Bronx,NY";


    //Default Constructor
    public UseConstructor() {

    }

    // parameterised constructor
    public UseConstructor(String houseName) {
        this.houseName=houseName;
    }

    public UseConstructor(String houseName,String address) {
        this.houseName=houseName;
        this.address=address;
    }
    void house() {
        System.out.println(houseName + " House Address "+ address);

    }

}
