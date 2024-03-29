package treeAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import entryPoint.Main;

public class PrimAdjMatrix 
{
	private double[][] graph;
	private final int INFINITY = 999999999;
	private int[] parent;
	private double[] key;
	public void entryPoint() 
	{
		Scanner in = new Scanner(System.in);
		int choice,edges,vertices,start,end,root;
		String edge; 
		String[] splittedEdge;
		boolean onGoing = true;
		while(onGoing)
		{
			printMenu();
			choice = in.nextInt();
			System.out.println("========================");
			switch(choice)
			{
				case 1:
						System.out.println("Number of Vertices:");
						vertices = in.nextInt();
						key = new double[vertices];
						parent = new int[vertices];
						System.out.println("Number of Edges:");
						edges = in.nextInt();
						System.out.println("Weight Range starts from: ");
						start = in.nextInt();
						System.out.println("Weight Range ends at: ");
						end = in.nextInt();
						generateRandomizedGraph(vertices,edges,start,end);
						System.out.println("Enter source vertex #: ");
						root = in.nextInt(); 
						startPrims(root);
						break;
				case 2:
						System.out.println("Number of Vertices:");
						vertices = in.nextInt();
						if(vertices<=0)
						{
							System.out.println("Minimum # of vertices is 1");
							break;
						}
						graph = new double[vertices][vertices];
						key = new double[vertices];
						parent = new int[vertices];
						
						System.out.println("Number of Edges:");
						edges = in.nextInt();
						if(edges<vertices-1)
						{
							System.out.println("Minimum # of edges = vertices-1");
							break;
						}
						System.out.println("Enter Edges");
						System.out.println("Edge Format: start vertex,end vertex,weight");
						for(int i = 0 ; i < edges; i++)
						{
							System.out.println("Enter Edge "+(i+1));
							edge = in.next();
							splittedEdge = edge.split(",");
							graph[Integer.parseInt(splittedEdge[0])][Integer.parseInt(splittedEdge[1])]
									=Double.parseDouble(splittedEdge[2]);
							graph[Integer.parseInt(splittedEdge[1])][Integer.parseInt(splittedEdge[0])]
									=Double.parseDouble(splittedEdge[2]);
						}
						formedGraphPrinter();
						System.out.println("Enter source vertex #: ");
						root = in.nextInt(); 
						startPrims(root);
						break;
				case 3:
						preMadeTest();
						break;
				default:
						onGoing=false;
						break;
			}
		}
	}
	
	private void preMadeTest() 
	{
		System.out.println("================================");
		System.out.println("Graph 1:");
		int vertices = 5;
		int edges = 7;
		key = new double[vertices];
		parent = new int[vertices];
		graph = new double[vertices][vertices];
		graph[0][1]=2;
		graph[1][0]=2;
		graph[0][3]=5;
		graph[3][0]=5;
		graph[1][2]=14;
		graph[2][1]=14;
		graph[1][3]=5;
		graph[3][1]=5;
		graph[1][4]=4;
		graph[4][1]=4;
		graph[2][4]=34;
		graph[4][2]=34;
		graph[3][4]=58;
		graph[4][3]=58;
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startPrims(0);
		System.out.println("================================");
		System.out.println("Graph 2:");
		vertices = 3;
		edges = 3;
		key = new double[vertices];
		parent = new int[vertices];
		graph = new double[vertices][vertices];
		graph[0][1]=10;
		graph[1][0]=10;
		graph[0][2]=20;
		graph[2][0]=20;
		graph[1][2]=30;
		graph[2][1]=30;
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startPrims(0);
		System.out.println("================================");
		System.out.println("Graph 3:");
		vertices = 6;
		edges = 10;
		key = new double[vertices];
		parent = new int[vertices];
		graph = new double[vertices][vertices];
		graph[0][1]=20;
		graph[1][0]=20;
		graph[0][2]=70;
		graph[2][0]=70;
		graph[0][5]=10;
		graph[5][0]=10;
		graph[1][2]=60;
		graph[2][1]=60;
		graph[1][3]=30;
		graph[3][1]=30;
		graph[2][3]=50;
		graph[3][2]=50;
		graph[2][4]=80;
		graph[4][2]=80;
		graph[3][4]=40;
		graph[4][3]=40;
		graph[3][5]=90;
		graph[5][3]=90;
		graph[4][5]=100;
		graph[5][4]=100;
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startPrims(0);
		System.out.println("================================");
		System.out.println("Graph 4:");
		vertices = 8;
		edges = 13;
		key = new double[vertices];
		parent = new int[vertices];
		graph = new double[vertices][vertices];
		graph[0][1]=1;
		graph[1][0]=1;
		graph[0][2]=12;
		graph[2][0]=12;
		graph[0][7]=15;
		graph[7][0]=15;
		graph[1][2]=10;
		graph[2][1]=10;
		graph[1][4]=11;
		graph[4][1]=11;
		graph[2][3]=8;
		graph[3][2]=8;
		graph[2][4]=9;
		graph[4][2]=9;
		graph[3][4]=7;
		graph[4][3]=7;
		graph[3][5]=14;
		graph[5][3]=14;
		graph[4][6]=16;
		graph[6][4]=16;
		graph[5][6]=5;
		graph[6][5]=5;
		graph[6][7]=3;
		graph[7][6]=3;
		graph[7][5]=4;
		graph[5][7]=4;
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startPrims(0);
		System.out.println("================================");
		System.out.println("Graph 5:");
		vertices = 9;
		edges = 14;
		key = new double[vertices];
		parent = new int[vertices];
		graph = new double[vertices][vertices];
		graph[0][1]=4;
		graph[1][0]=4;
		graph[0][7]=8;
		graph[7][0]=8;
		graph[1][2]=8;
		graph[2][1]=8;
		graph[1][7]=11;
		graph[7][1]=11;
		graph[2][3]=7;
		graph[3][2]=7;
		graph[2][8]=2;
		graph[8][2]=2;
		graph[2][5]=4;
		graph[5][2]=4;
		graph[3][4]=9;
		graph[4][3]=9;
		graph[3][5]=14;
		graph[5][3]=14;
		graph[4][5]=10;
		graph[5][4]=10;
		graph[5][6]=2;
		graph[6][5]=2;
		graph[6][7]=1;
		graph[7][6]=1;
		graph[7][8]=7;
		graph[8][7]=7;
		graph[8][6]=6;
		graph[6][8]=6;
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startPrims(0);
		System.out.println("================================");
		System.out.println("Graph 6:");
		vertices = 2;
		edges = 1;
		key = new double[vertices];
		parent = new int[vertices];
		graph = new double[vertices][vertices];
		graph[0][1]=10;
		graph[1][0]=10;
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startPrims(0);
		System.out.println("================================");
	}

	private void startPrims(int root) 
	{
		long startTime = System.currentTimeMillis();
		if(root>=key.length || root<0) 
		{
			System.out.println("Invalid root, root = 0 will be used instead.");
			root = 0;
		}
		
		double[][] result = new double[key.length][key.length];
		
		PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(key.length,new PairWeightComparator());
		for(int i = 0 ; i < key.length ; i++)
		{
			if(i!=root)
			{
				key[i] = INFINITY;
				parent[i] = -1;
				priorityQueue.add(new Pair(i,INFINITY));
			}
			else
			{
				key[i] = 0;
				parent[i] = -1;
				priorityQueue.add(new Pair(i,0));
			}
		}
		int numberOfOperations = key.length;
		Pair minimumDistanceVertex;
		while(!priorityQueue.isEmpty())
		{
			//get vertex with minimum weight
			minimumDistanceVertex = priorityQueue.poll();
			numberOfOperations++;
			//for each child of this vertex
			for(int i = 0 ; i < graph[0].length ; i++)
			{
				if(graph[minimumDistanceVertex.getVertex()][i]!=0)
				{
					Pair neighbour = new Pair(i,graph[minimumDistanceVertex.getVertex()][i]);
					if(priorityQueue.contains(neighbour) && neighbour.getWeight() < key[neighbour.getVertex()])
					{
						parent[neighbour.getVertex()] = minimumDistanceVertex.getVertex();
						key[neighbour.getVertex()] = neighbour.getWeight();
						priorityQueue.remove(neighbour);
						priorityQueue.add(new Pair(neighbour.getVertex(),key[neighbour.getVertex()]));
						numberOfOperations++;
					}
				}
			}
		}
		
		double minimumCost = 0;
		for (int i = 0; i < key.length; i++)
		{
			if(parent[i]!=-1)
			{
				result[parent[i]][i]=key[i];
				result[i][parent[i]]=key[i];
				minimumCost+=key[i];
			}
		}
		
		System.out.println("----");
		System.out.println("MST:");
		System.out.println("----");
		System.out.print("   ");
		for (int i = 0; i < result.length; i++) 	System.out.printf("%4s", "  "+i);
		System.out.println();
		for (int i = 0; i < result.length; i++) 
		{
			System.out.print(i+" : ");
			for (int j = 0; j < result[i].length; j++) 
			{
				System.out.printf("%4s",result[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
		System.out.println("Minimum Cost = "+minimumCost);
		System.out.println("------------------------------------");
		System.out.println("Number Of Operations = "+numberOfOperations);
		System.out.println("------------------------------------");
		System.out.println("Time Required = "+(System.currentTimeMillis() - startTime));
		System.out.println("------------------------------------");
	}
	
	private void generateRandomizedGraph(int vertices, int edges, int start,int end) 
	{
		if(vertices<=0)
		{
			System.out.println("# of vertices is below allowed minimum.");
			System.out.println("Minimum No.of verices 1 will be used");
			vertices = 1;
		}
		if(edges<vertices-1)
		{
			System.out.println("# of edges is below allowed minimum.");
			System.out.println("Minimum No.of edges"+(vertices-1) + " will be used");
			edges = vertices-1;
		}
		if(start>end)
		{
			System.out.println("Start weight is less than end weight.");
			System.out.println("Swappig will be done.");
			int temp = start;
			start = end;
			end = temp;
			System.out.println("Start = "+start+" End = "+end);
		}
		graph = new double[vertices][vertices];
		
		int randomStartVertex,randomEndVertex,randomWeight;
		for (int i = 0; i < edges; i++) 
		{
			//each vertex has at least 1 edge
			if(i<vertices)	randomStartVertex = i;
			else randomStartVertex = Main.randomGenerator.nextInt(vertices);
			
			randomEndVertex = Main.randomGenerator.nextInt(vertices);
			//remove self loops and repeated edges
			while( (vertices!=1) 
					&& (randomEndVertex==randomStartVertex || graph[randomStartVertex][randomEndVertex]!=0)) 
			{
				randomEndVertex = Main.randomGenerator.nextInt(vertices);
			}
			randomWeight = start+Main.randomGenerator.nextInt(end-start)+1;
			graph[randomStartVertex][randomEndVertex] = randomWeight;
			graph[randomEndVertex][randomStartVertex] = randomWeight;
		}
		formedGraphPrinter();
	}
	private void formedGraphPrinter()
	{
		System.out.println("-------------");
		System.out.println("Formed Graph:");
		System.out.println("-------------");
		System.out.print("   ");
		for (int i = 0; i < graph.length; i++) 	System.out.printf("%4s", "  "+i);
		System.out.println();
		for (int i = 0; i < graph.length; i++) 
		{
			System.out.print(i+" : ");
			for (int j = 0; j < graph[0].length; j++) 
			{
				System.out.printf("%4s", graph[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
	}
	
	private void printMenu() 
	{
		System.out.println("=======PrimAdjMatrix=======");
		System.out.println("1) Randomized input Test");
		System.out.println("2) Manual input Test");
		System.out.println("3) Pre-made Test");
		System.out.println("*) Back");
		System.out.println("===========================");
		System.out.print("Your Choice: ");
		
	}

}
