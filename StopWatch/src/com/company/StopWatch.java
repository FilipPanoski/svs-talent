package com.company;

public class StopWatch implements Runnable{
    int seconds = 0;
    Thread timer;
    boolean isRunning = false;
    boolean wasRunning = false;

    public void start() {
        timer = new Thread(this);
        isRunning = true;
        timer.start();
    }

    @Override
    public void run(){
        while (isRunning){
            try {
                timer.sleep(1000);
                seconds++;
                System.out.println(seconds);
            }catch (Exception ex){}
        }
    }

    public void stop(){
        isRunning = false;
        wasRunning = false;
        seconds = 0;
    }

    public void pause(){
        if (isRunning) {
            isRunning = false;
            wasRunning = true;
        }
    }

    public void resume(){
        if (wasRunning) {
            isRunning = true;
            timer = new Thread(this);
            timer.start();
        }
    }

}

