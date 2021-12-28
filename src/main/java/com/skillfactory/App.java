package com.skillfactory;

import com.skillfactory.utils.RandomUserRequester;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println(RandomUserRequester.requestUser(null));
        } catch (IOException e) {
            //Exception handling
        }
    }
}
