package Kim;
import java.util.*;

public class Array {
	public static void main(String[] args) {
		int arr [] = new int[100];
		int num_j;
		int num_k;
		int num_l;
		for(int i =0; i<100; i++) {
			arr[i] = i+1;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String input = sc.next();
		System.out.printf("You entered: %d\n", Integer.parseInt(input));
		sc.close();
		for(int j = 0; j<98; j++) {
			num_j = arr[j];
			for(int k = j+1; k<99; k++) {
				num_k = arr[k];
				for(int l = k+1; l<100; l++) {
					num_l = arr[l];
					if(num_j+num_k+num_l == Integer.parseInt(input) ) {
						System.out.println("number1: "+num_j+" number2: "+ num_k+" number3: "+ num_l);
						return;
					}
				}
			}
		}			
	}
}
