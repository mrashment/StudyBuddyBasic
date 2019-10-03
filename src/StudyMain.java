import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudyMain {

    private Scanner in;
    private HashMap<Integer, Task> tasks;
    private int idCounter;

    public StudyMain() {
        tasks = new HashMap<>();
        idCounter = 1;
    }

    //main
    public static void main(String[] args) {
        //store tasks that the user inputs
        //keep track of amount of time that user spends on that task
        //create interface
        StudyMain root = new StudyMain();
        root.showMenu(root);


    }

    //shows menu and allows user to choose an option to interact
    void showMenu(StudyMain root) {
        in = new Scanner(System.in);
        boolean quit = false;

        while(!quit) {
            System.out.println("Main Menu");
            System.out.println("ID\tTask");


            tasks.forEach((k,v) -> System.out.println(k + "\t" + v.getName() + "\n"));

            System.out.print("Please select an option: " +
                    "(A = Add Task, D = Delete Task, I = Task Info, Q = Quit): ");
            String input;
            boolean invalid = true;
            while (invalid) {
                input = in.nextLine();
                input = input.toUpperCase();

                switch (input) {
                    case "A":
                        root.addTask();
                        invalid = false;
                        break;
                    case "D": //delete a task from the list given an ID
                        System.out.print("Enter the ID of the task you would like to delete: ");
                        String deleteInput = in.nextLine();
                        int deleteId = -1;
                        try {
                            deleteId = Integer.parseInt(deleteInput);
                        } catch (Exception e) {
                            System.out.println("Invalid input.");
                        }
                        root.deleteTask(deleteId);
                        invalid = false;
                        break;
                    case "I":
                        invalid = false;
                        break;
                    case "Q":
                        invalid = false;
                        quit = true;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Oops! Invalid entry. Try again: ");

                }

            } //while invalid loop
        }//while quit
        in.close();
    } // showMenu()

    //add a task to the tasklist
    void addTask() {
        in = new Scanner(System.in);

        //get user input for task name and description
        System.out.print("Please enter a task name: ");
        String taskName = in.nextLine();
        System.out.println("Please enter a task description: ");
        String taskDesc = in.nextLine();
        tasks.put(this.idCounter, new Task(this.idCounter++, taskName, taskDesc));
        System.out.println("Task added!" + "\n");
    }
    void deleteTask(int id) {
        if (tasks.keySet().contains(id)) {
            tasks.remove(id);
            System.out.println("Task removed successfully");

        }
        else {
            System.out.println("Task not found.");
        }
    }
}

