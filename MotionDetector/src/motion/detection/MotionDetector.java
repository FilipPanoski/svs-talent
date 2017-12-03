package motion.detection;

import alarms.Alarm;
import alarms.SystemAlarm;
import image.capturing.devices.ScannerDevice;
import static java.lang.Thread.sleep;

public class MotionDetector {

    private static ScannerDevice scannerDevice;
    private static Alarm systemAlarm;
    private static byte[] lastImage;

    public static void main(String[] args){
        setupImageDevices();
        setupAlarms();
        startScanning();
    }

    private static void setupImageDevices(){
        scannerDevice = new ScannerDevice();
        scannerDevice.startScanning();
    }

    private static void setupAlarms(){
        systemAlarm = new SystemAlarm();
    }

    private static void startScanning(){
        Thread scanImages = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);

                        if (lastImage != null){
                            for (int i = 0; i < lastImage.length; i++){
                                if (lastImage[i] != scannerDevice.getConvertedImage()[i]){
                                    systemAlarm.triggerAlarm();;
                                    lastImage = scannerDevice.getConvertedImage();
                                    break;
                                }
                            }
                        } else {
                            lastImage = scannerDevice.getConvertedImage();
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        });
        scanImages.start();
    }
}
