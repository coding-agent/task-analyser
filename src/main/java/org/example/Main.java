package org.example;
import javax.swing.*;
import org.example.system_data.*;
import org.example.gui.*;

public class Main {
    public static void main(String[] args) {
        Processes processes = new Processes();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}