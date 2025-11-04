package coms3620.fashion.util;

public class InputValidation {

    public static int IntegerRangeInput(int min, int max) {
        int rtn;
        while(true) {
            rtn = Stdin.nextInt();
            if(rtn >= min && rtn <= max) {
                break;
            }
            System.out.println("Invalid input, value must be between " + min + " and " + max);
        }
        return rtn;
    }

    public static int IntegerMinInput(int min) {
        int rtn;
        while(true) {
            rtn = Stdin.nextInt();
            if(rtn >= min) {
                break;
            }
            System.out.println("Invalid input, value must be more than " + min);
        }
        return rtn;
    }
}
