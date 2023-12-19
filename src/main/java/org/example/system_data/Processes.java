package org.example.system_data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Processes {

    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("tasklist").start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                // Process each line (which contains information about a running process)
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Command exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

