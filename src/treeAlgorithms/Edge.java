package treeAlgorithms;

public class Edge 
{
	private int startVertex,endVertex;
	private double weight;
	public Edge(int startVertex, int endVertex, double weight) 
	{
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}
	public int getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(int startVertex) {
		this.startVertex = startVertex;
	}
	public int getEndVertex() {
		return endVertex;
	}
	public void setEndVertex(int endVertex) {
		this.endVertex = endVertex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
