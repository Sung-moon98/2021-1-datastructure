package Kim;

import java.util.*;
public class AdjListGraphExt extends AdjListGraph {
	private List<Edge>[] adjListReverse;
	
	public AdjListGraphExt() {
		super.N = 4;
		adjListReverse = new List[super.N];
		super.adjList = new List[super.N];
		for(int i = 0; i < 4; i++) {
			adjList[i] = new LinkedList<>();
			adjListReverse[i] = new LinkedList<>();
		}
		super.bulidGraph();
	}
	
	public AdjListGraphExt(int n) {
		super.N = n;
		super.adjList = new List[N];
		adjListReverse = new List[super.N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<>();
			adjListReverse[i] = new LinkedList<>();
		}
	}
	
	public List<Edge>[] getListReverse() { return adjListReverse; }
	
	public void getReverse() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < adjList[i].size(); j++) {
				int t = adjList[i].get(j).get();
				Edge e = new Edge(i);
				adjListReverse[t].add(e);
			}
		}
		
		
		
	}
	
	public void printReverse() {
		System.out.println("Graph (AdjListReverse): ");
		for(int i = 0; i < N; i++) {
			System.out.print("["+i+"]");
			for(int j = 0; j < adjListReverse[i].size(); j++) {
				System.out.print(" ==> "+ adjListReverse[i].get(j).get());
			}
			System.out.println();
		}
	}
	
	
}
