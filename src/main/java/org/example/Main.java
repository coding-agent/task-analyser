package org.example;
import javax.swing.*;
import org.example.system_data.*;
import org.example.gui.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Processes processes = new Processes();
        ArrayList<String> processesList = processes.getProcesses();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}