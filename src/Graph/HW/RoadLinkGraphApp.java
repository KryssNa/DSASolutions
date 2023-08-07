//package Graph.HW;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class RoadLinkGraphApp extends JFrame {
//    private Graph graph;
//
//    public RoadLinkGraphApp() {
//        // Create a new graph
//        graph = new Graph();
//
//        // Initialize the GUI components
//        initializeComponents();
//
//        // Set up the JFrame properties
//        setTitle("Road Link Graph");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    private void initializeComponents() {
//        JPanel panel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//
//                // Draw the road links
//                for (RoadLink roadLink : graph.getRoadLinks()) {
//                    int x1 = roadLink.getStartX();
//                    int y1 = roadLink.getStartY();
//                    int x2 = roadLink.getEndX();
//                    int y2 = roadLink.getEndY();
//
//                    g.drawLine(x1, y1, x2, y2);
//                }
//            }
//        };
//
//        // Add mouse listener to create new road links
//        panel.addMouseListener(new MouseAdapter() {
//            private int startX, startY;
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                startX = e.getX();
//                startY = e.getY();
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                int endX = e.getX();
//                int endY = e.getY();
//
//                // Create a new road link and add it to the graph
//                RoadLink roadLink = new RoadLink(startX, startY, endX, endY);
//                graph.addRoadLink(roadLink);
//
//                // Repaint the panel to update the road links
//                panel.repaint();
//            }
//        });
//
//        getContentPane().add(panel);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new RoadLinkGraphApp());
//    }
//}
//
//class RoadLink {
//    private int startX, startY, endX, endY;
//
//    public RoadLink(int startX, int startY, int endX, int endY) {
//        this.startX = startX;
//        this.startY = startY;
//        this.endX = endX;
//        this.endY = endY;
//    }
//
//    public int getStartX() {
//        return startX;
//    }
//
//    public int getStartY() {
//        return startY;
//    }
//
//    public int getEndX() {
//        return endX;
//    }
//
//    public int getEndY() {
//        return endY;
//    }
//}
//
//class Graph {
//    private java.util.List<RoadLink> roadLinks;
//
//    public Graph() {
//        roadLinks = new java.util.ArrayList<>();
//    }
//
//    public void addRoadLink(RoadLink roadLink) {
//        roadLinks.add(roadLink);
//    }
//
//    public java.util.List<RoadLink> getRoadLinks() {
//        return roadLinks;
//    }
//}
//
