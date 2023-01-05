package Kim;

import java.util.*;
public class CheckGraph {
	
	public static boolean isReverseSame(int[][] G) {		// 인접행렬로 표현된 그래프와 역방향 그래프 비교
		int N = G.length;
		boolean same = true;
		int[][] GR = new int[N][N];
		
		for(int i = 0; i < N; i++) {		// 인접행렬 G의 역방향 그래프 GR 생성
			for(int j = 0; j < N; j++) {
				GR[i][j] = G[j][i];
			}
		}
		
		for(int i = 0; i < N; i++) {		// G와 GR 비교
			for(int j = 0; j < N; j++) {
				if(GR[i][j] != G[i][j]) {
					same = false;
					return same;
				}
					
			}
		}
		return same;		// 조건을 이상없이 통과했다면 true
	}
	
	public static boolean isReverseSame(List<Edge>[] G) {	// 인접리스트로 표현된 그래프와 역방향 그래프 비교
		int N = G.length;
		boolean same = true;
		List<Edge>[] GR = new List[N];
		
		for(int i = 0; i < N; i++)				// GR의 인덱스별로 초기화
			GR[i] = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {			// G의 역방향 그래프 GR 생성
			for(int j = 0; j < G[i].size(); j++) {
				int t = G[i].get(j).adjvertex;
				int w = G[i].get(j).weight;
				Edge e = new Edge(i, w);
				GR[t].add(e);
			}
		}
		
		for(int i = 0; i < N; i++) {			// G와 GR 비교
			if(G[i].size() != GR[i].size()){	// 인접리스트의 인덱스 별 연결리스트의 size가 다르면 false
				same = false;
				return same;
			}
			// size가 같으면 넘어옴
			for(int j = 0; j < G[i].size(); j++) {
				if(G[i].get(j).adjvertex != GR[i].get(j).adjvertex) {	// 다른 쪽 정점이 다르면 false
					same = false;
					return same;
				}
				if(G[i].get(j).weight != GR[i].get(j).weight) {			// 가중치가 다르면 false
					same = false;
					return same;
				}
			}
		}
		return same;		// 모든 조건을 이상없이 통과했다면 true
	}

	
	
	
	
	
	
	
}
