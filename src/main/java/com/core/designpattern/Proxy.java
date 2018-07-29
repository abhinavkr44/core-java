package com.core.designpattern;

class Test {
    public static void main(String[] args) {
        DBConnectionObject object = new Proxy();
        object.connect();
        object.connect();
    }
}

public class Proxy implements DBConnectionObject{
    DBConnectionObject obj;
    @Override
    public String connect() {
        if (obj == null)
            obj = new DBConnectionObjectImpl();
        return obj.connect();
    }
}

interface DBConnectionObject{
    public String connect();
}

class DBConnectionObjectImpl implements DBConnectionObject{

    @Override
    public String connect() {
        return null;
    }
}