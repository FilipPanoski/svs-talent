package com.pano.zipcode;

public class ZipCode {

    private int zipCode;
    
    public void setZipCode(int newZipCode){
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
            System.out.println("Nevaliden zipCode!");
        }
    }
    public static void main(String[] args) {
        ZipCode zc = new ZipCode();
        zc.setZipCode(12345678);
    }
    
}
