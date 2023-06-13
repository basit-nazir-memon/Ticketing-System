package com.example.sdaproject;

public class PersistanceHandlerFactory {
    public static PersistanceHandler createPersistanceHandler(String name) {
        if (name.equals("My SQL")){
            return new MySQL();
        }
        return null;
    }
}
