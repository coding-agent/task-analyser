package org.example.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.example.system_data.Performance;
import org.example.system_data.Processes;

public class GUI extends JFrame {
    JPanel processesPanel;
    public GUI() {
        setTitle("Task Analyser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        cardPanel.add(this.processesPanel());

        System.out.println(new Performance().getPerformaceMap());

        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("Dashboard");

        JMenuItem processesMenuItem = new JMenuItem("Processes");
        JMenuItem servicesMenuItem = new JMenuItem("Performance");

        processesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Processes");
            }
        });

        servicesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Performance");
            }
        });

        add(cardPanel);
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
            var len = data.size();
            if (len==4){
                Vector<String> row = new Vector<>(4);
                row.add(data.get(0));
                row.add(data.get(1));
                row.add(data.get(2));
                row.add(data.get(3).replaceAll("[^\\p{Print}]", "."));
                tableModel.addRow(row);
            }
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        this.processesPanel.add(scrollPane, BorderLayout.CENTER);

        return this.processesPanel;
    }

    private JPanel performance() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("hey");
        panel.add(label);

        return panel;
    }
}
