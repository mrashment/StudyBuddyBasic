
import java.util.HashMap;
import java.util.Scanner;

public class StudyMain {

    private Scanner in;
    private HashMap<Integer, Task> tasks;
    private int idCounter;

    public StudyMain() {
        this.tasks = new HashMap<>();
        this.idCounter = 1;

    }

    //main
    public static void main(String[] args) {
        // store tasks that the user inputs
        // keep track of amount of time that user spends on that task
        // create interface
        StudyMain root = new StudyMain();
        root.showMenu();
    }

    // shows the main menu
    void showMenu() {
        in = new Scanner(System.in);
        boolean quit = false;

        // shows the menu and options while the user hasn't triggered quit
        while(!quit) {
            System.out.println("Main Menu");
            System.out.println("ID\tTask");

            // prints tasks
            tasks.forEach((k,v) -> System.out.println(k + "\t" + v.getTaskName() + "\n"));

            System.out.print("Please select an option " +
                    "(S = Start Task, T = Stop Task, A = Add Task, D = Delete Task, I = Task Info, Q = Quit): ");

            //prompts the user for input until they give something valid
            String input;
            boolean invalid = true;
            while (invalid) {
                input = in.nextLine();
                input = input.toUpperCase();

                switch (input) {
                    case "S": //start logging time on this task
                        System.out.print("Enter the ID of the task you would like to start: ");
                        int startId = parseId();
                        startTask(startId);
                        invalid = false;
                        break;
                    case "T":
                        System.out.print("Currently running tasks by ID: (");
                        tasks.forEach((k,v) -> System.out.print(v.getRunning() ? k + ", ": ""));
                        System.out.print(")\nWhich task would you like to stop?: ");
                        int stopId = parseId();
                        stopTask(stopId);
                        invalid = false;
                        break;
                    case "A": //add task to tasks
                        addTask();
                        invalid = false;
                        break;
                    case "D": //delete a task from the list given an ID
                        System.out.print("Enter the ID of the task you would like to delete: ");
                        int deleteId = parseId();
                        deleteTask(deleteId);
                        invalid = false;
                        break;
                    case "I": //show information about the task
                        System.out.println("Enter the ID of the task you would like to know more about: ");
                        int infoId = parseId();
                        showInfo(infoId);
                        invalid = false;
                        break;
                    case "Q": //quit this program
                        invalid = false;
                        quit = true;
                        quit();
                        System.out.println("Goodbye!");
                        break;
                    default: //make them retry
                        System.out.println("Oops! Invalid entry. Try again: ");

                }

            } // while invalid loop
        }// while quit
        in.close();
    } // showMenu()

    // add a task to the tasklist
    void addTask() {
        in = new Scanner(System.in);

        //get user input for task name and description
        System.out.print("Please enter a task name: ");
        String taskName = in.nextLine();
        System.out.println("Please enter a task description: ");
        String taskDesc = in.nextLine();
        //create the task
        tasks.put(this.idCounter, new Task(this.idCounter++, taskName, taskDesc));
        System.out.println("Task added!" + "\n");
    }

    // delete the task from tasks
    void deleteTask(int id) {
        //if the task actually exists
        if (tasks.keySet().contains(id)) {
            tasks.remove(id);
            System.out.println("Task removed successfully");
            pause();

        }
        else {
            System.out.println("Task not found.");
            pause();
        }
    }

    // show info about the task
    void showInfo(int id) {
        if (tasks.keySet().contains(id)) {
            System.out.println(tasks.get(id).toString());
            pause();
        }
        else {
            System.out.println("Task not found.");
            pause();
        }
    }

    // start logging time on task
    void startTask(int id) {
        if (tasks.keySet().contains(id)) {
            tasks.get(id).startTask();
            System.out.println("Task Started!");
            pause();
        }
        else {
            System.out.println("Task not found.");
        }
    }

    //stop a currently running task
    void stopTask(int id) {
        if (tasks.keySet().contains(id)) {
            tasks.get(id).endTask();
            System.out.println("Task Stopped.");
            pause();
        }
        else {
            System.out.println("Task not found.");
        }
    }

    //end program
    void quit() {
        tasks.forEach((k,v) -> v.endTask());
    }

    // pause before going to next action
    void pause() {
        System.out.print("Press enter to continue...");
        in.nextLine();
    }

    // parse input to get chosen task id
    int parseId() {
        String userIn = in.nextLine();
        int id = -1; // if invalid input, this will be passed to the corresponding function and they will be sent back to menu
        try {
            id = Integer.parseInt(userIn); // if the number is not a real id, they'll just be sent back to the menu
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        return id;
    }
}

