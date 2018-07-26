package com.core.designpattern;

public class Factory {
    public static Computer getObject(String type){
        Computer computer = null;
        if (type == "pc"){
            computer = new PC();
        } else if(type == "server" ){
            computer = new Server();
        }
        return computer;
    }
}

interface Computer{
    public int getRam();
}

class Server implements Computer{

    @Override
    public int getRam() {
        return 512;
    }
}

class PC implements Computer{

    @Override
    public int getRam() {
        return 1024;
    }
}
