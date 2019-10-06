import java.util.Timer;
import java.util.TimerTask;

public class Task {

    private int id;
    private String taskName;
    private String taskDesc;
    private int timeSpent;
    private Timer timer;
    private boolean running;

    public Task(int id, String taskName, String taskDesc,int timeSpent) {
        this.id = id;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.running = false;
        this.timeSpent = timeSpent;
    }

    //toString
    public String toString() {
        String taskString = "";
        taskString += this.getTaskId() + "\tName: " + this.getTaskName() + "\n";
        taskString += "\tDescription: " + this.getDesc();
        taskString += "\n\tTime spent on this task: " + this.getTimeSpent();

        return taskString;
    }

    public void startTask() {
        this.running = true;
        timer = new Timer();
        //increments timeSpent
        TimerTask count = new TimerTask() {

            @Override
            public void run() {
                setTimeSpent(timeSpent + 1);
            }
        };
        //perform count once every second
        timer.schedule(count, 1000,1000);
    }

    public void endTask() {
        if (this.running) {
            this.running = false;
            this.timer.cancel();
        }
    }

    //setters
    public void setTimeSpent(int time) { this.timeSpent = time; }
    public void setTaskName(String name) {this.taskName = name;}
    public void setDesc(String desc) {this.taskDesc = desc;}


    //getters
    public int getTaskId() { return this.id; }
    public String getTaskName() { return this.taskName; }
    public String getDesc() { return this.taskDesc; }
    public int getTimeSpent() { return this.timeSpent; }
    public boolean getRunning() {return this.running;}

} // Task
