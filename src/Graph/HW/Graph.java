package Graph.HW;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Graph {
    static class Edge {
        private int startX, startY, endX, endY;

        public Edge(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {
            return startY;
        }

        public int getEndX() {
            return endX;
        }

        public int getEndY() {
            return endY;
        }

        public double calculateLength() {
            int dx = endX - startX;
            int dy = endY - startY;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }
        private List<Edge> edges;
        private Map<Point, List<Edge>> adjacencyMap;

        public Graph() {
            edges = new ArrayList<>();
            adjacencyMap = new HashMap<>();
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
            addEdgeToAdjacencyMap(edge);
        }

        private void addEdgeToAdjacencyMap(Edge edge) {
            Point startPoint = new Point(edge.getStartX(), edge.getStartY());
            Point endPoint = new Point(edge.getEndX(), edge.getEndY());

            if (!adjacencyMap.containsKey(startPoint)) {
                adjacencyMap.put(startPoint, new ArrayList<>());
            }
            adjacencyMap.get(startPoint).add(edge);

            if (!adjacencyMap.containsKey(endPoint)) {
                adjacencyMap.put(endPoint, new ArrayList<>());
            }
            adjacencyMap.get(endPoint).add(edge);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public List<Edge> shortestPath(int startX, int startY, int endX, int endY) {
            Point start = new Point(startX, startY);
            Point end = new Point(endX, endY);

            Map<Point, Integer> distance = new HashMap<>();
            Map<Point, Edge> previous = new HashMap<>();
            Set<Point> visited = new HashSet<>();

            for (Point point : adjacencyMap.keySet()) {
                distance.put(point, Integer.MAX_VALUE);
            }

            distance.put(start, 0);

            PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
            queue.offer(start);

            while (!queue.isEmpty()) {
                Point current = queue.poll();
                visited.add(current);

                if (current.equals(end)) {
                    break;
                }

                for (Edge edge : adjacencyMap.get(current)) {
                    Point neighbor = getNeighbor(edge, current);

                    if (!visited.contains(neighbor)) {
                        int newDistance = (int) (distance.get(current) + edge.calculateLength());
                        if (newDistance < distance.get(neighbor)) {
                            distance.put(neighbor, newDistance);
                            previous.put(neighbor, edge);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            List<Edge> shortestPath = new ArrayList<>();
            Point current = end;
            while (previous.containsKey(current)) {
                Edge edge = previous.get(current);
                shortestPath.add(0, edge);
                current = getNeighbor(edge, current);
            }

            return shortestPath;
        }

        private Point getNeighbor(Edge edge, Point current) {
            Point startPoint = new Point(edge.getStartX(), edge.getStartY());
            Point endPoint = new Point(edge.getEndX(), edge.getEndY());

            return startPoint.equals(current) ? endPoint : startPoint;
        }
    }

    // ... (remaining code remains the same)


