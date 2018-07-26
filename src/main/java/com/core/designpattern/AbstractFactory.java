package com.core.designpattern;

class FactoryProvider {

    AbstractFactory getFactory(String type){
        AbstractFactory factory = null;
        if (type == "ware"){
            factory = new WareFactory();
        } else if(type == "fare" ){
            factory = new FareFactory();
        }
        return factory;
    }
}



interface AbstractFactory {
    public Ware getWare(String type);
    public Fare getFare(String type);
}


class WareFactory implements  AbstractFactory{
    public Ware getWare(String type){
        Ware ware = null;
        if (type == "soft"){
            ware = new Software();
        } else if(type == "hard" ){
            ware = new Hardware();
        }
        return ware;
    }

    @Override
    public Fare getFare(String type) {
        throw new UnsupportedOperationException();
    }
}

class FareFactory implements  AbstractFactory{
    public Ware getWare(String type){
        throw new UnsupportedOperationException();
    }

    @Override
    public Fare getFare(String type) {
        Fare fare = null;
        if (type == "blr"){
            fare = new JobFare();
        } else if(type == "pat" ){
            fare = new NoFare();
        }
        return fare;
    }
}

interface Ware{
    String city();
}

class Software implements  Ware {
    @Override
    public String city() {
        return "bangaluru";
    }
}

class Hardware implements  Ware {
    @Override
    public String city() {
        return "patna";
    }
}

interface Fare{
    String pity();
}

class JobFare implements  Fare {
    @Override
    public String pity() {
        return "bangaluru";
    }
}

class NoFare implements  Fare {
    @Override
    public String pity() {
        return "patna";
    }
}

