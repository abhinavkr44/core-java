package com.core.designpattern;

public interface Adaptor {
    public double speedInMPH(String car);
}

class AdaptorImpl implements Adaptor{

    Movable movable;
    @Override
    public double speedInMPH(String car) {
        return ((movable.speedKPH(car))*0.62);
    }
}



interface Movable{
    public double speedKPH(String car);
}

class Speed implements Movable{

    @Override
    public double speedKPH(String car) {
        if (car == "maruti"){
            return 20;
        }else{
          return 100;
        }
    }
}