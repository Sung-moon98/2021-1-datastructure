package Kim;

import java.util.*;
public class TopologicalSort {		// 위상정렬
	int N;
	boolean[] visited;	
	List<Edge>[] adjList;			// 인접리스트 형태의 입력 그래프
	List<Integer> sequence;			// 위상정렬 순서를 담을 배열리스트
	public TopologicalSort(List<Edge>[] graph) {		// 생성자
		N = graph.length;
		visited = new boolean[N];
		adjList = graph;
		sequence = new ArrayList<>();
	}
	
	public List<Integer> tsort(){		// 위상정렬을 위한 DFS 수행
		for(int i = 0; i < N; i++)		
			if(!visited[i])  dfs(i);	// 깊이우선탐색
		Collections.reverse(sequence);	// sequence를 역순으로 만들기
		return sequence;
	}
	
	public void dfs(int i) {			// DFS 수행
		visited[i] = true;
		for(Edge e: adjList[i]) {			// 정점 i에 인접한 각 정점에 대해
			if(!visited[e.adjvertex])		// 정점 i에 인접한 정점이 방문이 안되어있으면
				dfs(e.adjvertex);			// 재귀호출
		}
		sequence.add(i); 				// i에서 진출하는 간선이 더 이상 없으므로 i를 sequence에 추가
	}
	
	public void print() {
		System.out.println("위상정렬: ");
		System.out.print("[");
		for(int i = 0; i < sequence.size(); i++) {
			System.out.print(" "+sequence.get(i)+" ");
		}
		System.out.println("]");
	}
	
}
