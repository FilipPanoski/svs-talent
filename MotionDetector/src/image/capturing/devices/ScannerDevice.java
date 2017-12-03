package image.capturing.devices;

import java.util.Scanner;

public class ScannerDevice implements ImageCapturingDevice {

    private boolean isRunning = false;
    private byte[] convertedImage;

    public void startScanning(){
        Thread imageScanning = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                while (isRunning){
                    Scanner scanner = new Scanner(System.in);
                    String image = scanner.nextLine();
                    convertedImage = image.getBytes();
                }
            }
        });
        imageScanning.start();
    }

    public void stopScanning(){
        isRunning = false;
    }

    public byte[] getConvertedImage(){
        return convertedImage;
    }
}
