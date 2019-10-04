import java.util.Timer;
import java.util.TimerTask;

public class Task implements Runnable {

    private int id;
    private String taskName;
    private String taskDesc;
    private int timeSpent;
    private Timer timer;
    private boolean running;

    public Task(int id, String taskName, String taskDesc) {
        this.id = id;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.running = false;
        this.timer = new Timer();

    }



    //toString
    public String toString() {
        String taskString = "";
        taskString += this.getId() + "\tName: " + this.getName() + "\n";
        taskString += "\tDescription: " + this.getDesc();
        taskString += "\n\tTime spent on this task: " + this.getTimeSpent();

        return taskString;
    }

    //setters
    public void setTimeSpent(int time) {
        this.timeSpent = time;
    }
    public void setName(String name) {this.taskName = name;}
    public void setDesc(String desc) {this.taskDesc = desc;}


    //getters
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.taskName;
    }
    public String getDesc() {
        return this.taskDesc;
    }
    public int getTimeSpent() {
        return this.timeSpent;
    }

    public void startTask() {this.running = true;}

    public void endTask() {
        this.running = false;
        this.timer.cancel();
    }
    @Override
    public void run() {
        TimerTask count = new TimerTask() {

            @Override
            public void run() {
                setTimeSpent(timeSpent + 1);
                //System.out.println("I ran once!");
            }
        };

        timer.schedule(count, 1000,1000);

    }


    //
}
