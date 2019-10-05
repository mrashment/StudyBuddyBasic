import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RecordHelper {

    private File record;

    public RecordHelper(StudyMain root) {
        String fileName = "src/record.txt";
        record = new File(fileName);
        //search for the record.txt file, if not found create it
        if (!record.exists()) {
            try {
                record.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // populate root.tasks with the info from record.txt
        else {
            try {
                BufferedReader reader;
                reader = new BufferedReader(new FileReader(fileName));

                String line;
                boolean taskNext = true;
                int taskCounter = 0;
                // read through the entire file
                while ((line = reader.readLine()) != null) {
                    // if the line show ***, the next three lines contain a task
                    if (line.contains("***")) {
                        String name = reader.readLine();
                        String desc = reader.readLine();
                        int time = Integer.parseInt(reader.readLine());
                        root.addTask(name,desc,time);
                    }
                }

            } catch (Exception e) {
                System.err.println("ERROR reading file");
            }
        }
    }
}
