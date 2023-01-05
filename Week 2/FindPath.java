package Kim;

// 0000 = no path
// 1000 = can go left
//  100 = can go right
//   10 = can go up
//    1 = can go down

public class FindPath {
	public static void main(String[] args) {
		
		int[][] map1 = { {   0,  100, 0},
						 { 100,   10, 0},
						 {  10,    0, 0}}; // there IS a path from Start to Finish
		
		int[][] map2 = { {   0, 1000, 0},
						 { 100,   10, 0},
						 {  10,    0, 0}}; // there is NO such a path
		

		int nROW = 3;
		int nCOL = 3;
		
		int startY = 2, startX = 0; 
		int finishY = 0, finishX = 2; 
		
		final int FOUND_PATH = 1; 
		


		if( findPath(map1, startY, startX) == 1 )
			System.out.println("map1: Found a path!");
		else
			System.out.println("map1: There is no path!");
		

		if( findPath(map2, startY, startX) == 1)
			System.out.println("map2: Found a path!");
		else
			System.out.println("map2: There is no path!");
		

	
	}
		
		public static int findPath(int[][] a, int x, int y) {
			if(a[x][y] == 1) {
				return findPath(a, x+1, y);
			}
			else if(a[x][y] == 10) {
				return findPath(a, x-1, y);
			}
				
			else if(a[x][y] == 100) {
				return findPath(a, x, y+1);
			}
			else if(a[x][y] == 1000) {
				return findPath(a, x, y-1);
			}

			else if(a[x][y] == 0) {
				if(x==0 && y == 2) 
					return 1;
				
				else
					return 0;
			}
			else
				return 0;
			
	

	
		
		}
		
}


		
	


