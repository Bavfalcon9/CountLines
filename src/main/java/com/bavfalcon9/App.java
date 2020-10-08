package com.bavfalcon9;
import java.lang.*;
import java.io.*;
import java.util.*;
import com.bavfalcon9.Counter;

public class App {


    public static void main( String[] args ) {
        File path;

        if (args.length == 0) {
            // args 0 does not exist
            // use current directory path
            path = new File(System.getProperty("user.dir"));
            System.out.println("Using current directory as no path was specified!");
        } else {
            // args 0 exists, append to cwd
            path = new File(System.getProperty("user.dir") + args[0]);
        }

        Counter linecounter = new Counter(path);
    }
}
