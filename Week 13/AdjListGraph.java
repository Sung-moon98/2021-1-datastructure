package Kim;

import java.util.*;
public class AdjListGraph {
	protected List<Edge>[] adjList;		// 인접리스트
	int N;								// 정점 수
	
	public AdjListGraph() {
		this.N = 4;
		adjList = new List[4];
		for(int i = 0; i < 4; i++)
			adjList[i] = new LinkedList<>();
		this.bulidGraph();
	}
	
	public AdjListGraph(int n) {
		N = n;
		adjList = new List[N];
		for(int i = 0; i < N; i++)
			adjList[i] = new LinkedList<>();
	}
	
	public List<Edge>[] getList()	{ return adjList; }
	
	public void bulidGraph() {
		Edge a = new Edge(0);
		Edge b = new Edge(1);
		Edge c = new Edge(2);
		Edge d = new Edge(3);
		
		this.adjList[0].add(b);		this.adjList[0].add(c);
		this.adjList[1].add(a);		this.adjList[1].add(c);		this.adjList[1].add(d);
		this.adjList[2].add(a);		this.adjList[2].add(b);		this.adjList[2].add(d);
		this.adjList[3].add(b);		this.adjList[3].add(c);
	}
	
	public void put(int i, int o) {			// 무방향 정점 삽입
		Edge a = new Edge(i);
		Edge b = new Edge(o);
		adjList[i].add(b);
		adjList[o].add(a);
	}
	
	public void putSingle(int i, int o) {	// i에서 o로 가는 간선
		Edge a = new Edge(o);
		adjList[i].add(a);
	}
	
	public void print() {
		System.out.println("Graph (AdjList): ");
		for(int i = 0; i < N; i++) {
			System.out.print("["+i+"]");
			for(int j = 0; j < adjList[i].size(); j++) {
				System.out.print(" ==> "+ adjList[i].get(j).get());
			}
			System.out.println();
		}
	}
	
}
