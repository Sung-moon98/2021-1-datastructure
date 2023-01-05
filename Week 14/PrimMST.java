package Kim;

import java.util.*;
public class PrimMST {		// 그래프를 최소신장트리로
	int N;		// 그래프의 정점 수
	List<Edge>[] graph;
	int[] previous;			// 최소신장트리의 이전에 이어지는 정점
	int[] D;				// 정점의 최소가중치
	
	public PrimMST(List<Edge>[] adjList) {		// 생성자
		N = adjList.length;
		graph = adjList;
		previous = new int[N];
		D = new int[N];
	}
	
	public int[] mst(int s) {		// s는 시작정점
		boolean[] visited = new boolean[N];		// 방문된 정점은 true로
		for(int i = 0; i < N; i++) {			// 초기화
			visited[i] = false;	
			previous[i] = 1;
			D[i] = Integer.MAX_VALUE;			// D[i]를 최댓값으로 초기화
		}
		previous[s] = 0;			// 시작정점 s의 관련 정보 초기화
		D[s] = 0;
		
		for(int k = 0; k < N; k++) {		// 방문안된 정점들의 D 원소들 중에서 최솟값을 가진 정점 minVertex 찾기
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) {
				if((!visited[j]) && (D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;		// MST에 추가됨
			for(Edge i : graph[minVertex]) {	// minVertex에 인접한 각 정점의 D의 원소 갱신
				if(!visited[i.adjvertex]) {		// 트리에 아직 포함 안된 정점이라면
					int currentDist = D[i.adjvertex];
					int newDist = i.weight;
					if(newDist < currentDist) {		// D에 저장된 가중치보다 현재 정점에서 이어지는 가중치가 더 작으면
						D[i.adjvertex] = newDist;
						previous[i.adjvertex] = minVertex;
					}
				}
			}
		}
		return previous;		// 최소신장트리 간선정보 리턴
	}
	
	public void print(int s) {
		int total = 0;
		System.out.println("최소신장트리 간선: ");
		for(int i = 0; i < N; i++) {
			if(i != s) {
				System.out.print("("+i+","+this.previous[i]+")  ");
				total += D[i];
			}
		}
		System.out.println();
		System.out.println("\n최소신장트리의 간선 가중치 합 = "+total);
	}
}
