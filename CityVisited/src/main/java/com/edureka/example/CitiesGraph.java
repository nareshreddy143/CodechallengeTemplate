package com.edureka.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CitiesGraph {
	private Map<Vertex, List<Vertex>> adjVertices;

	  

	  // Add edges
	  public void addEdge(String label1, String label2) {
		  Vertex v1 = new Vertex(label1);
		    Vertex v2 = new Vertex(label2);
		    adjVertices.get(v1).add(v2);
		    adjVertices.get(v2).add(v1);
	  }
	  
	  //Remove edges
	  void removeEdge(String label1, String label2) {
		    Vertex v1 = new Vertex(label1);
		    Vertex v2 = new Vertex(label2);
		    List<Vertex> eV1 = adjVertices.get(v1);
		    List<Vertex> eV2 = adjVertices.get(v2);
		    if (eV1 != null)
		        eV1.remove(v2);
		    if (eV2 != null)
		        eV2.remove(v1);
		}

	  void addVertex(String label) {
		    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
		}
	  
	  void removeVertex(String label) {
		    Vertex v = new Vertex(label);
		    adjVertices.values().stream().forEach(e -> e.remove(v));
		    adjVertices.remove(new Vertex(label));
		}
	 
	  CitiesGraph createGraph() {
			
			CitiesGraph graph = new CitiesGraph();
			
			graph.addVertex("Boston");
		    graph.addVertex("New York");
		    graph.addVertex("Newark");
		    graph.addVertex("Philadelphia");
		    graph.addVertex("Trenton");
		    graph.addVertex("Albany");
		    graph.addEdge("Boston", "New York");
		    graph.addEdge("Boston", "Newark");
		    graph.addEdge("New York", "Newark");
		    graph.addEdge("Newark", "Philadelphia");
		    graph.addEdge("New York", "Philadelphia");
		    graph.addEdge("Trenton", "Albany");
		    return graph;
		}
	  List<Vertex> getAdjVertices(String label) {
		    return adjVertices.get(new Vertex(label));
		}
	 
}