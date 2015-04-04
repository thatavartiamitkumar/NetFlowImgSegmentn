package edu.ua.algos.impl;

public class Graph {
	private Object[] verticesArray;

	public Graph(int vertexCount) {
		verticesArray = new Vertex[vertexCount];
	}

	public Object[] getVerticesArray() {
		return verticesArray;
	}

	public void setVerticesArray(Object[] verticesArray) {
		this.verticesArray = verticesArray;
	}
}
