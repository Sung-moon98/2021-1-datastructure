package Kim;

import java.util.*;
public class MyGraph {
	static int N;
	static int [][]adjMatrix;
	static List<Edge>[] adjList;
	
	public MyGraph() {
		
	}
	
	public static int[][] getAdjMatrixFromAdjList(List<Edge>[] lst){
		N = lst.length;
		adjMatrix = new int[N][N];		// 초기화
		
		for(int i = 0; i < N; i++) {	// 인접리스트를 인접행렬로 변환
			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = 0;	// 인접행렬을 전부 0으로 초기화
			}
		}
		// 연결되어 있는 정점들에만 가중치를 부여
		for(int i = 0; i < N; i++) {					// i는 자신 정점
			for(int j = 0; j < lst[i].size(); j++) {
				int k = lst[i].get(j).adjvertex;		// k는 다른 쪽 정점
				adjMatrix[i][k] = lst[i].get(j).weight;		// i에서 k로 가는 간선의 가중치
			}
		}
		
		return adjMatrix;
	}
	
	public static List<Edge>[] getAdjListFromAdjMatrix(int[][] mat){
		N = mat.length;
		adjList = new List[N];
		
		for(int i = 0; i < N; i++) { 		
			adjList[i] = new LinkedList<>();	// 초기화
			for(int j = 0; j < N; j++) {		// 인접행렬을 인접 리스트로
				if(mat[i][j] != 0) {
					Edge e = new Edge(j, mat[i][j]);
					adjList[i].add(e);
				}
			}
		}
		return adjList;
	}
	
	public static void print(int[][] mat) {		// 인접행렬 출력
		N = mat.length;
		System.out.println("AdjMatrix");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(mat[i][j]);
				if(j != (N -1)) 
					System.out.print(", ");
			}
			System.out.println();
		}
	}
	
	
	public static void print(List<Edge>[] lst) {		// 인접리스트 출력
		System.out.println("AdjList: ");
		N = lst.length;
		for(int i = 0; i < N; i++) {
			System.out.print("["+i+"]");
			for(int j = 0; j < lst[i].size(); j++) {
				System.out.print(" ==> "+ lst[i].get(j).adjvertex+"("+lst[i].get(j).weight+")");
			}
			System.out.println();
		}
	}
	
	
	
	
}
