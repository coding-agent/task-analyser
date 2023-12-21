package org.example.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.example.system_data.Performance;
import org.example.system_data.Processes;

public class GUI extends JFrame {
    int processesCount;
    final static String PROCESSESPANEL = "processes";
    final static String PERFORMANCEPANEL = "performance";

    public GUI() {
        setTitle("Task Analyser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        var cardPanel = new JPanel(new CardLayout());

        JMenuBar menuBar = this.createMenu();

        cardPanel.add(PROCESSESPANEL, this.processesPanel());
        cardPanel.add(PERFORMANCEPANEL, this.performancePanel());


        add(menuBar, BorderLayout.PAGE_START);
        add(cardPanel, BorderLayout.CENTER);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem processesMenuItem = new JMenuItem(PROCESSESPANEL);
        JMenuItem servicesMenuItem = new JMenuItem(PERFORMANCEPANEL);

        menu.add(processesMenuItem);
        menu.add(servicesMenuItem);

        menuBar.add(menu);

        return menuBar;
    }
    private JPanel processesPanel(){
        JPanel processesPanel = new JPanel();
        processesPanel.setLayout(new BorderLayout());
        ArrayList<List<String>> processesData = new Processes().getProcesses();

        DefaultTableModel tableModel = new DefaultTableModel();

        processesData.get(1).forEach(tableModel::addColumn);
        processesData.remove(1);
        processesData.remove(1);

        this.processesCount = processesData.size();

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

        processesPanel.add(scrollPane, BorderLayout.CENTER);

        return processesPanel;
    }

    private JPanel performancePanel() {
        System.out.println(new Performance().getPerformaceMap());
        JPanel panel = new JPanel();
        HashMap<String, String> performance = new Performance().getPerformaceMap();

        performance.put("numberOfProcesses", String.valueOf(this.processesCount));
        performance.forEach((k, v)-> {
            panel.add(new JLabel(k+": "+v));
        });

        return panel;
    }
}
