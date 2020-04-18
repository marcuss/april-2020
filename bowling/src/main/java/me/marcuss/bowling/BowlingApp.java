package me.marcuss.bowling;

public class BowlingApp {

    public static void main (String args[]) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No input file");
        }
        System.out.println("hola mundo");
    }
}
