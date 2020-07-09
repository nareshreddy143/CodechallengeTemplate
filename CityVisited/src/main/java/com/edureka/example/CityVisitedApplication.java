package com.edureka.example;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CityVisitedApplication {

	public static void main(String[] args) {
		 
		CitiesGraph graph = new CitiesGraph();
	 
	    assertEquals(
	    		  "[Boston, New York, Newark, Philadelphia, Trenton,Albany]", depthFirstTraversal(graph, "Boston").toString());
	    assertEquals(
	    		  "[Boston, New York, Newark, Philadelphia, Trenton,Albany]", depthFirstTraversal(graph, "New York").toString());
	    assertEquals(
	    		  "[Boston, New York, Newark, Philadelphia, Trenton,Albany]", depthFirstTraversal(graph, "Newark").toString());
	    assertEquals(
	    		  "[Boston, New York, Newark, Philadelphia, Trenton,Albany]", depthFirstTraversal(graph, "Philadelphia").toString());
	    assertEquals(
	    		  "[Boston, New York, Newark, Philadelphia, Trenton,Albany]", depthFirstTraversal(graph, "Trenton").toString());
	    assertEquals(
	    		  "[Boston, New York, Newark, Philadelphia, Trenton,Albany]", depthFirstTraversal(graph, "Albany").toString());
	    
	    
	    
	    SpringApplication.run(CityVisitedApplication.class, args);
	}

	private static void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	private static Object depthFirstTraversal(CitiesGraph graph, String root1) {
		// TODO Auto-generated method stub
		 Set<String> visited = new LinkedHashSet<String>();
	        Stack<String> stack = new Stack<String>();
	        stack.push(root1);
	        while (!stack.isEmpty()) {
	            String vertex = stack.pop();
	            if (!visited.contains(vertex)) {
	                visited.add(vertex);
	                for (Vertex v : graph.getAdjVertices(vertex)) {              
	                    stack.push(v.label);
	                }
	            }
	        }
	        return visited;
	}

}
