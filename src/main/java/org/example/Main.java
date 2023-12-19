package org.example;
import javax.swing.JFrame;
import org.example.system_data.Tasks;
import org.example.system_data.Processes;

public class Main {
    public static void main(String[] args) {
        Processes.main(args);
        JFrame frame = new JFrame("Task Analyser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setVisible(true);

        Tasks taskInfo = new Tasks();
        taskInfo.getTasks();

    }
}