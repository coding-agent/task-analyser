package org.example;
import javax.swing.JFrame;
import org.example.system_data.Processes;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Processes processes = new Processes();

        ArrayList<String> processesList = processes.getProcesses();

        JFrame frame = new JFrame("Task Analyser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setVisible(true);
    }
}