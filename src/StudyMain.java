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

            tasks.forEach((k,v) -> System.out.println(k + " " + v.getName() + "\n"));

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
                    case "D":
                        System.out.print("Which task would you like to delete?");
                        int deleteId = Integer.parseInt(in.nextLine());
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
        System.out.println("I'm outside the while loop!");
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
        tasks.entrySet().remove(tasks.get(id));
        System.out.println("Task removed successfully");
    }
}

