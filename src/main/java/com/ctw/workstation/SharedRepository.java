package com.ctw.workstation;

import java.util.ArrayList;
import java.util.HashMap;

public class SharedRepository <I, T>{

    HashMap<I, T> database = new HashMap<>();

    public void addEntity(I id, T entity){
        database.put(id, entity);
    }

    public ArrayList<T> findAll(){
        return new ArrayList<>(database.values());
    }

    public T findById(String id) {
        return database.get(id);
    }

    public void deleteById(String id){
        database.remove(id);
    }
}
