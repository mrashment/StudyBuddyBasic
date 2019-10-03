public class Task {

    private int id;
    private String taskName;
    private String taskDesc;
    private int timeSpent;

    public Task(int id, String taskName, String taskDesc) {
        this.id = id;
        this.taskName = taskName;
        this.taskDesc = taskDesc;

    }

    //setters
    public void setTimeSpent(int time) {
        this.timeSpent = time;
    }


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
}
