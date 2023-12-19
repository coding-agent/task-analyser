package org.example.system_data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Processes {
    private ArrayList<String> processes;

    public ArrayList<String> getProcesses() {
        checkProcesses();
        return this.processes;
    }

    private void checkProcesses () {
        try {
            Process process = new ProcessBuilder("tasklist").start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            ArrayList<String> arr = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                arr.add(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Command exited with code " + exitCode);
            this.processes = arr;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

