package entryPoint;

import java.util.Random;
import java.util.Scanner;

import treeAlgorithms.KruskalAdjList;
import treeAlgorithms.KruskalAdjMatrix;
import treeAlgorithms.PrimAdjList;
import treeAlgorithms.PrimAdjMatrix;

public class Main 
{	
	private static boolean representationMethod; // true for adj list , false for adj matrix
	public static Random randomGenerator = new Random();
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		representationMethod = true;
		int choice;
		boolean onGoing = true;
		while(onGoing)
		{
			printMainMenu();
			choice = in.nextInt();
			System.out.println("------------------------------");
			switch(choice)
			{
				case 1:
						printGraphRepresentationMenu();
						int graphMethod = in.nextInt();
						if(graphMethod==1) representationMethod = true;
						else if(graphMethod==2) representationMethod = false;
					 	break;
				case 2:
						if(representationMethod)
						{
							KruskalAdjList kruskalList = new KruskalAdjList();
							kruskalList.entryPoint();
						}
						else
						{
							KruskalAdjMatrix kruskalList = new KruskalAdjMatrix();
							kruskalList.entryPoint();
						}
				 		break;
				case 3:
						if(representationMethod)
						{
							PrimAdjList PrimList = new PrimAdjList();
							PrimList.entryPoint();
						}
						else
						{
							PrimAdjMatrix PrimList = new PrimAdjMatrix();
							PrimList.entryPoint();
						}
				 		break;
				default:
						onGoing = false;
						break;
			}
		}
		

	}
	
	private static void printGraphRepresentationMenu() 
	{
		System.out.println("|----------------------------|");
		System.out.println(" 1) Adjacency List");
		System.out.println(" 2) Adjacency Matrix");
		System.out.println(" *) Back");
		System.out.println("|----------------------------|");
		System.out.print("Your Choice: ");
	}

	private static void printMainMenu()
	{
		System.out.println("|------------Menu------------|");
		System.out.println(" 1) Change graph representation");
		System.out.println(" 2) Apply Kruskal's Algorithm");
		System.out.println(" 3) Apply Prim's Algorithm");
		System.out.println(" *) Exit");
		System.out.println("|----------------------------|");
		if(representationMethod) System.out.println("--      Adjacency List      --");
		else System.out.println("--     Adjacency Matrix     --");
		System.out.println("|----------------------------|");
		System.out.print("Your Choice: ");
	}

}
