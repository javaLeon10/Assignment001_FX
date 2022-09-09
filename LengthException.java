package com.example.pc2;
public class LengthException extends Exception{
    public LengthException() { }

    public LengthException (String word) {
        super(word);
    }
}
