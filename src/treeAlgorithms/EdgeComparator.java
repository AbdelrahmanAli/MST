package treeAlgorithms;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge>
{

	@Override
	public int compare(Edge first, Edge second) 
	{
		if(first.getWeight()-second.getWeight() < 0) return -1;
		else if(first.getWeight()-second.getWeight() == 0) return 0;
		else return 1;
	}

}
