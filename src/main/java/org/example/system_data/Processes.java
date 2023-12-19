package org.example.system_data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Processes {
    private ArrayList<List<String>> processes;

    public ArrayList<List<String>> getProcesses() {
        updateProcesses();
        return this.processes;
    }

    private void updateProcesses() {
        try {
            Process process = new ProcessBuilder("tasklist").start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            ArrayList<List<String>> arr = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                var list = Arrays.stream(line.split("\\s{4,}"))
                        .map(String::trim)
                        .toList();
                arr.add(list);
            }

            int exitCode = process.waitFor();
            System.out.println("Command exited with code " + exitCode);
            this.processes = arr;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

