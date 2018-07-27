package com.core.designpattern;

class  BuilderClient{
    public static void main(String[]args){
        new Builder.Bodybuilder("206").wash("no").build();
    }
}


public class Builder {
    //mandatory
    String bone;
    //optional
    String facewash;

    Builder(Bodybuilder bodybuilder){
        this.bone = bodybuilder.bone;
        this.facewash =  bodybuilder.facewash;
    }

    public static class Bodybuilder {
        String bone;
        String facewash;

        Bodybuilder(String bone){
            this.bone = bone;
        }

        Bodybuilder wash(String wash){
            this.facewash = wash;
            return  this;
        }

        Builder build(){
            return new Builder(this);
        }



    }

}
