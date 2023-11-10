package Astar;

//import com.mxgraph.model.mxCell;
//import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import javax.swing.JFrame;

public class GraphVisualisation extends JFrame{
	private static final long serialVersionUID = -8123406571694511514L;
	 
	  public GraphVisualisation() {
	    super("Visualisation du graphe Ex1");
	 
	    mxGraph graph = new mxGraph();
	    Object parent = graph.getDefaultParent();
	 
	    graph.getModel().beginUpdate();
	    try {
	      Object v1 = graph.insertVertex(parent, null, "S", 20, 100, 20, 20);
	      Object v2 = graph.insertVertex(parent, null, "A", 100, 20, 20, 20);
	      Object v3 = graph.insertVertex(parent, null, "B", 100, 180, 20, 20);
	      Object v4 = graph.insertVertex(parent, null, "C", 180, 100, 20, 20);
	      Object v5 = graph.insertVertex(parent, null, "G", 290, 100, 20, 20);
	      
	      graph.insertEdge(parent, null, "1", v1, v2);
	      graph.insertEdge(parent, null, "2", v1, v3);
	      graph.insertEdge(parent, null, "1", v2, v4);
	      graph.insertEdge(parent, null, "1", v3, v4);
	      graph.insertEdge(parent, null, "2", v4, v5);
	    } finally {
	      graph.getModel().endUpdate();
	    }
	 
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    getContentPane().add(graphComponent);
	  }
	 
	  /**
	   * @param args
	   */

}
