public class RobotWorker implements Robot {

    @Override
    public void work() {
        System.out.println("RobotWorker.work");
    }

    @Override
    public void stopWorking() {
        System.out.println("RobotWorker.stopWorking");
    }

}
