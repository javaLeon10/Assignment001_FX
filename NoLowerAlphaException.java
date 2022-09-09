package com.example.pc2;

public class NoLowerAlphaException extends Exception{
    public NoLowerAlphaException() { }

    public NoLowerAlphaException  (String word) {super(word); }


}
