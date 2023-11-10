package Astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Astaralgorithme {
	
	  public static Node aStar(Node start, Node target) {
	        PriorityQueue<Node> closedList = new PriorityQueue<>();
	        PriorityQueue<Node> openList = new PriorityQueue<>();

	        start.f = start.g + start.calculateHeuristic(target);
	        openList.add(start);

	        while (!openList.isEmpty()) {
	            Node n = openList.poll(); 
	            if (n == target) {
	                return n;
	            }

	            for (Node.Edge edge : n.neighbors) {
	                Node m = edge.node;
	                double totalWeight = n.g + edge.weight;

	                if (!openList.contains(m) && !closedList.contains(m)) {
	                    m.parent = n;
	                    m.g = totalWeight;
	                    m.f = m.g + m.calculateHeuristic(target);
	                    openList.add(m);
	                } else {
	                    if (totalWeight < m.g) {
	                        m.parent = n;
	                        m.g = totalWeight;
	                        m.f = m.g + m.calculateHeuristic(target);

	                        if (closedList.contains(m)) {
	                            closedList.remove(m);
	                            openList.add(m);
	                        }
	                    }
	                }
	            }

	            closedList.add(n); 
	        }
	        return null;
	    }

	    public static void printPath(Node target) {
	        Node n = target;

	        if (n == null)
	            return;

	        
	        List<String> nodeNames = new ArrayList<>();

	        while (n.parent != null) {
	           // ids.add(n.id);
	        	nodeNames.add(n.getName());
	            n = n.parent;
	        }
	       // ids.add(n.id);
	        nodeNames.add(n.getName()); 
	        Collections.reverse(nodeNames);

	        for (String name : nodeNames) {
	            System.out.print(name + " ");
	        }
	        System.out.println();
	    }
	    
	    
	    public List<List<Integer>> getEdges(List<Node> nodes) {
	        List<List<Integer>> edges = new ArrayList<>();

	        for (Node node : nodes) {
	            for (Node.Edge edge : node.getEdges()) {
	                List<Integer> edgeData = new ArrayList<>();
	                edgeData.add(node.getId());
	                edgeData.add(edge.node.getId());

	               
	                List<Integer> reversedEdge = new ArrayList<>();
	                reversedEdge.add(edge.node.getId());
	                reversedEdge.add(node.getId());

	                if (!edges.contains(edgeData) && !edges.contains(reversedEdge)) {
	                    edges.add(edgeData);
	                }
	            }
	        }

	        return edges;
	    }

}
