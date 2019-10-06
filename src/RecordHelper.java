import java.io.*;
import java.util.Scanner;

public class RecordHelper {

    private File record;
    private String fileName;

    public RecordHelper(StudyMain root) {
        this.fileName = "src/record.txt";
        this.record = new File(this.fileName);

        try {
            // creates new file if not already there
            boolean newFile = this.record.createNewFile();
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(this.record));

            // read through the entire file
            String line;
            while ((line = reader.readLine()) != null) {
                // if the line show ***, the next three lines contain a task
                if (line.contains("***")) {
                    String name = reader.readLine();
                    String desc = reader.readLine();
                    int time = Integer.parseInt(reader.readLine());
                    root.addTask(name, desc, time);
                }
            }

        } catch (Exception e) {
            System.err.println("ERROR in RecordHelper constructor");
        }
    }

    // save tasks to file for later use
    void writeToFile(StudyMain root) {
        try {
            // create a blank file
            this.record.delete();
            this.record.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.record));
            // write each task to the new file
            for (Task t : root.getTasks().values()) {
                writer.write("***\n");
                writer.write(t.getTaskName() + "\n");
                writer.write(t.getDesc() + "\n");
                writer.write(t.getTimeSpent() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
