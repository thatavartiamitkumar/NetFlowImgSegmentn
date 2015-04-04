package edu.ua.algos.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphBuilder {

	public static void main(String[] args) {
		try {
			List<String> adjacencyLists = Files
					.readAllLines(
							Paths.get("E:/Mahesh/Workspace/Eclipse/NetFlowImgSegmentn/resources/graphModel.txt"),
							Charset.defaultCharset());

			Graph graph = new Graph(adjacencyLists.size());

			for (int i = 0; i < adjacencyLists.size(); i++) {
				String adjList = adjacencyLists.get(i).trim();
				String[] split = adjList.split(" ");

				Vertex vertex = new Vertex();
				vertex.setVertexNo(i);

				Map<Integer, Integer> edges = new HashMap<Integer, Integer>();
				for (int j = 0; j < split.length; j++) {
					if (!split[j].trim().equalsIgnoreCase("")) {
						int neighbour = Integer.parseInt(split[j]);
						j++;
						int capacity = Integer.parseInt(split[j]);

						edges.put(neighbour, capacity);
					}
				}

				vertex.setEdges(edges);
				// Setting the first vertex to be the source or root
				if (i == 0)
					vertex.setSourceNode(true);

				graph.getVerticesArray()[i] = vertex;
			}

			breadthFirstSearch(graph);
			System.out.println("BFS completed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void breadthFirstSearch(Graph graph) {
		Object[] vertices = graph.getVerticesArray();
		Vertex sourceVertex = null;
		for (int i = 0; i < vertices.length; i++) {
			Vertex v = (Vertex) vertices[i];

			if (v.isSourceNode()) {
				v.setColor("gray");
				v.setDistance(0);
				v.setPredecessor(null);

				// setting the source vertex
				sourceVertex = v;
			} else {
				v.setColor("white");
				v.setDistance(-1);
				v.setPredecessor(null);
			}
		}

		LinkedList<Vertex> queue = new LinkedList<>();
		queue.addLast(sourceVertex);

		while (!queue.isEmpty()) {
			Vertex u = queue.removeFirst();

			Set<Integer> neighbours = u.getEdges().keySet();

			Iterator<Integer> setIterator = neighbours.iterator();

			while (setIterator.hasNext()) {
				int adjVertex = setIterator.next();

				Vertex neighbour = (Vertex) vertices[adjVertex];

				if (neighbour.getColor().equalsIgnoreCase("white")) {
					neighbour.setColor("gray");
					if (neighbour.getDistance() == -1)
						neighbour.setDistance(0); // just to remove the -1
					neighbour.setDistance(u.getDistance()
							+ u.getEdges().get(adjVertex));
					neighbour.setPredecessor(u.getVertexNo());

					queue.addLast(neighbour);
				}
			}

			u.setColor("black");
		}
	}
}
