package edu.ua.algos.impl;

import java.util.Map;

public class Vertex {

	private Integer vertexNo;
	private Map<Integer, Integer> edges;
	private boolean isSourceNode;

	private String color;
	private Integer distance;
	private Integer predecessor;

	public Integer getVertexNo() {
		return vertexNo;
	}

	public void setVertexNo(Integer vertexNo) {
		this.vertexNo = vertexNo;
	}

	public Map<Integer, Integer> getEdges() {
		return edges;
	}

	public void setEdges(Map<Integer, Integer> edges) {
		this.edges = edges;
	}

	public boolean isSourceNode() {
		return isSourceNode;
	}

	public void setSourceNode(boolean isSourceNode) {
		this.isSourceNode = isSourceNode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Integer predecessor) {
		this.predecessor = predecessor;
	}

}