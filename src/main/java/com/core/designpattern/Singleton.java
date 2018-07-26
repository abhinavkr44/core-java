package com.core.designpattern;

public class Singleton {

    private Singleton(){}

    private static class SingletonFactory{
        private static Singleton obj = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonFactory.obj;
    }
}
