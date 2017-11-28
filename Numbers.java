package com.pano;

public class Numbers {

    public static void main(String[] args) {
        String[] result = new String[args.length];
        for (int i=0; i<args.length; i++){
            switch (args[i]){
                case ("zero"):
                    result[i] = "0";
                    break;
                case ("one"):
                    result[i] = "1";
                    break;
                case ("two"):
                    result[i] = "2";
                    break;
                case ("three"):
                    result[i] = "3";
                    break;
                case ("four"):
                    result[i] = "4";
                    break;
                case ("five"):
                    result[i] = "5";
                    break;
                case ("six"):
                    result[i] = "6";
                    break;
                case ("seven"):
                    result[i] = "7";
                    break;
                case ("eight"):
                    result[i] = "8";
                    break;
                case ("nine"):
                    result[i] = "9";
                    break;
            }
            System.out.print(result[i]);
        }
    } 
}
