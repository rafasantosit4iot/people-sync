package com.example.people_sync_backend.shared.classes.errors;

public class GlobalNotFoundException extends RuntimeException{
    public GlobalNotFoundException() {
        super("Não encontrado");
    }
}
