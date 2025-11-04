package coms3620.fashion.util;

import java.util.Scanner;

public class Stdin {
    private static final Scanner scnr = new Scanner(System.in);

    public static String nextLine() {
        return scnr.nextLine();
    }

    public static int nextInt() {
        int rtn = scnr.nextInt();
        scnr.nextLine();
        return rtn;
    }

}
