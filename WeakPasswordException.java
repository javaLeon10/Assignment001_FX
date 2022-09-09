package com.example.pc2;

public class WeakPasswordException extends Exception {
    public WeakPasswordException() { }

    public WeakPasswordException (String word) {
        super(word);
    }
}
