package Astar;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
	  private int V; // Nombre de sommets
	    private List<List<Integer>> adjacencyMatrix;

	    public Matrix(int v) {
	        V = v;
	        adjacencyMatrix = new ArrayList<List<Integer>>(v);
	        for (int i = 0; i < v; i++) {
	            List<Integer> row = new ArrayList<Integer>(v);
	            for (int j = 0; j < v; j++) {
	                row.add(0); 
	            }
	            adjacencyMatrix.add(row);
	        }
	    }

	    public void addEdge(int v1, int v2) {
	        adjacencyMatrix.get(v1).set(v2, 1); // Mettre à jour la matrice d'adjacence pour une arête entre v1 et v2
	        //adjacencyMatrix.get(v2).set(v1, 1); // Si le graphe est non orienté, mettez à jour l'entrée correspondante
	    }

	    public void printAdjacencyMatrix() {
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                System.out.print(adjacencyMatrix.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	    }

}
