package Astar;

import javax.swing.JFrame;

//import test1.tuto;

public class Main {
	 
		 
		 public static void main(String[] args) {
			 
			 GraphVisualisation frame = new GraphVisualisation();
		 	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	 frame.setSize(400, 320);
		 	 frame.setVisible(true);
		 	 
		 	 //la matrice d'djacence
		 	 int numVertices = 5;
		     Matrix graph = new Matrix(numVertices);
		     graph.addEdge(0, 1);
		     graph.addEdge(0, 2);
		     graph.addEdge(1, 3);
		     graph.addEdge(2, 3);
		     graph.addEdge(3, 4);
             System.out.println("La matrice d'adjacence");
		     graph.printAdjacencyMatrix();
		     System.out.println("\n");
			 Node nodeS = new Node("S", 3.0); // Setting S heuristic of 3.0 for nodeA
	    	 Node nodeA = new Node("A", 3.0); // Setting A heuristic of 3.0 for nodeA
	         Node nodeB = new Node("B", 1.0); // Setting B heuristic of 1.0 for nodeB
	         Node nodeC = new Node("C", 0.0); // Setting C heuristic of 0.0 for nodeC
	         Node nodeG = new Node("G", 0.0); // Setting G heuristic of 0.0 for nodeD

	         // Establishing connections
	         nodeS.addBranch(1, nodeA); 
	         nodeA.addBranch(1, nodeC); // nodeA connected to nodeB with a weight of 3
	         nodeS.addBranch(2, nodeB); // nodeB connected to nodeC with a weight of 4
	         nodeB.addBranch(1, nodeC); // nodeA connected to nodeD with a weight of 2
	         nodeC.addBranch(2, nodeG); // nodeD connected to nodeC with a weight of 5

	         // Utilizing the A* algorithm to find a path
	         Node startNode = nodeS; // Define the start node
	         Node targetNode = nodeG; // Define the target node

	         Node result = Astaralgorithme.aStar(startNode, targetNode); // Running A* algorithm

	         // Printing the found path
	         System.out.print("Le chemin: ");
	         Astaralgorithme.printPath(result);
	         
	         
	        
	         }
	  
}
