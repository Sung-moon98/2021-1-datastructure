package Kim;

public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE;
	private int D[];			// 최소 가중치 합
	private int previous[];		// 경로 추출을 위해
	private int N;				// 정좀 수
	
	public BellmanFord(int numOfVertices) {	 // 생성자
		N = numOfVertices;
		D = new int[N];				// 최단거리 저장
		previous = new int[N];		// 최단경로 추출하기 위해
	}
	
	public void shortestPath(int s, int adjMatrix[][]) {
		for(int i = 0; i < N; i++)
			D[i] = INF;		// 초기화
		D[s] = 0; previous[s] = 0;
		for(int k = 0; k < N-1; k++) {			// N-1번 반복
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(adjMatrix[i][j] != INF) {	// 인접해있다면
						if(D[j] > D[i] + adjMatrix[i][j]) {
							D[j] = D[i] + adjMatrix[i][j];		// 간선완화
							previous[j] = i;			// i 덕분에 거리가 단축됨
							}
					}
				}
			}
		}
	}
	
	public void printPaths(int s) {
		System.out.println("정점 "+s+"(으)로부터의 최단거리");
		for(int i = 0; i < N; i++) {
			if(i != s) {
				System.out.println("["+s+","+i+"] =\t"+D[i]);
			}
		}
		
		System.out.println();
		
		System.out.print("정점 "+s+"(으)로부터의 최단경로");
		for(int i = 0; i < N; i++) {
			int back = i;
			if(i != s) {
				System.out.println();
				System.out.print(i);
			}
			while(back != s) {
				System.out.print("<-"+previous[back]);
				back = previous[back];
			}
			
		}
	}
}
