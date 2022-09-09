package com.example.pc2;

public class NoUpperAlphaException extends Exception{
    public NoUpperAlphaException() { }

    public NoUpperAlphaException  (String word) {super(word); }

}
