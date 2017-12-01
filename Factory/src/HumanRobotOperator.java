public class HumanRobotOperator implements RobotOperator {

    @Override
    public void run(Robot robot) {
        robot.work();
        robot.stopWorking();
    }
}
