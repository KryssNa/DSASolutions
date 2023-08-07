package Graph.HW;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class RoadNetworkGui {

    private JFrame frame;
    private JPanel mapPanel;
    private JPanel controlPanel;
    private JLabel statusLabel;
    private Graph roadNetwork;

    public RoadNetworkGui() {

        // Create a graph to represent the road network
        roadNetwork = new Graph();

        // Create a frame for the GUI
        frame = new JFrame("Road Network");
        frame.setLayout(new BorderLayout());

        // Create a map panel and add it to the frame's center
        mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the road network on the map panel
                for (Graph.Edge edge : roadNetwork.getEdges()) {
                    int startX = edge.getStartX();
                    int startY = edge.getStartY();
                    int endX = edge.getEndX();
                    int endY = edge.getEndY();

                    g.drawLine(startX, startY, endX, endY);
                }
            }
        };
        frame.add(mapPanel, BorderLayout.CENTER);

        // Create a control panel and add it to the frame's top
        controlPanel = new JPanel();
        frame.add(controlPanel, BorderLayout.NORTH);

        // Create a status label and add it to the frame's bottom
        statusLabel = new JLabel("Status:");
        frame.add(statusLabel, BorderLayout.SOUTH);

        // Set the layout for the control panel
        controlPanel.setLayout(new FlowLayout());

        // Create input fields for road coordinates
        JTextField startXField = new JTextField(5);
        JTextField startYField = new JTextField(5);
        JTextField endXField = new JTextField(5);
        JTextField endYField = new JTextField(5);

        // Create a button to add a road to the network
        JButton addRoadButton = new JButton("Add Road");
        addRoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the start and end points of the road from the user
                int startX = Integer.parseInt(startXField.getText());
                int startY = Integer.parseInt(startYField.getText());
                int endX = Integer.parseInt(endXField.getText());
                int endY = Integer.parseInt(endYField.getText());

                // Add a new road to the network
                roadNetwork.addEdge(new Graph.Edge(startX, startY, endX, endY));

                // Clear the input fields
                startXField.setText("");
                startYField.setText("");
                endXField.setText("");
                endYField.setText("");

                // Update the map panel
                mapPanel.repaint();
            }
        });

        // Create a button to find the shortest path between two points
        JButton findShortestPathButton = new JButton("Find Shortest Path");
        findShortestPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the start and end points of the path from the user
                int startX = Integer.parseInt(startXField.getText());
                int startY = Integer.parseInt(startYField.getText());
                int endX = Integer.parseInt(endXField.getText());
                int endY = Integer.parseInt(endYField.getText());

                // Find the shortest path between the two points
                List<Graph.Edge> shortestPath = roadNetwork.shortestPath(startX, startY, endX, endY);

                // Display the shortest path in the status label
                statusLabel.setText("Shortest Path: " + shortestPath);
            }
        });

        // Add components to the control panel
        controlPanel.add(new JLabel("Start X:"));
        controlPanel.add(startXField);
        controlPanel.add(new JLabel("Start Y:"));
        controlPanel.add(startYField);
        controlPanel.add(new JLabel("End X:"));
        controlPanel.add(endXField);
        controlPanel.add(new JLabel("End Y:"));
        controlPanel.add(endYField);
        controlPanel.add(addRoadButton);
        controlPanel.add(findShortestPathButton);

        // Set the size of the frame
        frame.setSize(600, 400);

        // Make the frame visible
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create a new instance of the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RoadNetworkGui();
            }
        });
    }
}
