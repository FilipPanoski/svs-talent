package com.pano.zipcodewithexceptions;

public class ZipCodeWithExceptions {
   
    private int zipCode;
    
    public void setZipCode(int newZipCode) throws InvalidZipCodeException{
        int temp = newZipCode;
        int counter = 0;
        while (temp != 0){
            temp/=10;
            counter++;
        }
        if (counter == 5 || counter == 9){
            zipCode = newZipCode;
            System.out.println("zipCode-ot e uspesno vnesen! Bravo");
        }
        else {
            InvalidZipCodeException izce = new InvalidZipCodeException();
            throw izce;
        }
    }
    public static void main(String[] args) {
       ZipCodeWithExceptions zcwe = new ZipCodeWithExceptions();
       try {
           zcwe.setZipCode(123456);
       } catch (InvalidZipCodeException ex){ex.printStackTrace();}
    }
    
}

class InvalidZipCodeException extends RuntimeException {
    public InvalidZipCodeException(){
        System.out.println("Nevaliden zipCode!");
    }
}
