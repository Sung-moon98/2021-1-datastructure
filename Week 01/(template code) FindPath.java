public class FindPath {
	
	// 각 cell에 저장된 값의 의미: 이동 가능한 방향을 알려줌
	// 0000 = no path
	// 1000 = can go left
	//  100 = can go right
	//   10 = can go up
	//    1 = can go down
	
	public static void main(String[] args) {
		// 지도 (1개의 cell 에서는 한 방향으로만 이동이 가능하다고 가정)
		// <1번 지도>
		int[][] map1 = { {   0,  100, 0},
						 { 100,   10, 0},
						 {  10,    0, 0}}; // there IS a path from Start to Finish
		// <2번 지도>
		int[][] map2 = { {   0, 1000, 0},
						 { 100,   10, 0},
						 {  10,    0, 0}}; // there is NO such a path
		// 지도의 행과 열의 개수는 정해져 있다고 가정
		int nROW = 3;
		int nCOL = 3;
		
		int startY = 2, startX = 0; // 시작위치 (항상 고정됨)
		int finishY = 0, finishX = 2; // 목적지 (항상 고정됨)
		
		final int FOUND_PATH = 1; // 상수 정의
		
		// 지도 1번: 탈출경로가 있는지 확인
		if( findPath(map1, ...) == FOUND_PATH )
			System.out.println("map1: Found a path!");
		else
			System.out.println("map1: There is no path!");
		
		// 지도 2번: 탈출경로가 있는지 확인
		if( findPath(map2, ...) == FOUND_PATH )
			System.out.println("map2: Found a path!");
		else
			System.out.println("map2: There is no path!");
		
	}
	...
}