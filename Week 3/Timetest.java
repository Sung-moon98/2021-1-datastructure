package Kim;

public class Timetest {
	public static void main(String[] args) {
		int [] arr = new int[1000];
		for(int i = 0; i < arr.length; i++) 
			arr[i] = 1;
		
		long beforeTime = System.currentTimeMillis();
		fConstant(arr);
		//fLinear(arr);
		//fQuadratic(arr);
		//fCubic(arr);
		//fFourth(arr);
		long afterTime = System.currentTimeMillis();
		long diffTimeMilliSecond = afterTime - beforeTime;
		System.out.println("Time diff (ms): "+ diffTimeMilliSecond);
		
	}

	public static void fConstant(int[] a) {				// O(1) 
		System.out.println(a.length*2);
	}
	public static int fLinear(int[] a) {				// O(N)
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}
	public static int fQuadratic(int[] a) {				// O(N^2)
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				sum += a[i];
			}
		}
		return sum;
	}
	public static int fCubic(int[] a) {					// O(N^3)
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				for(int k = 0; k < a.length; k++) {
					sum += a[i];
					}
				}
			}
		return sum;
	}
	public static int fFourth(int[] a) {				// O(N^4)
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				for(int k = 0; k < a.length; k++) {
					for(int l = 0; l < a.length; l++) {
					sum += a[i];
					}
				}
			}
		}
		return sum;
	}
	
	
	
	
}
