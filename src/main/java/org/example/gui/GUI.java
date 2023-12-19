package org.example.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.example.system_data.Processes;

public class GUI extends JFrame {
    JPanel processesPanel;
    public GUI() {
        setTitle("Task Analyser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        add(this.processesPanel());
    }

    private JPanel processesPanel(){
        this.processesPanel = new JPanel();
        this.processesPanel.setLayout(new BorderLayout());
        ArrayList<List<String>> processesData = new Processes().getProcesses();

        DefaultTableModel tableModel = new DefaultTableModel();

        processesData.get(1).forEach(tableModel::addColumn);
        processesData.remove(1);
        processesData.remove(1);

        for(List<String> data : processesData) {
            tableModel.addRow(new Vector<>(data));
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        this.processesPanel.add(scrollPane, BorderLayout.CENTER);

        return this.processesPanel;
    }
}
