//Nathan
//No - wrong answer.
//YES

import java.util.*;

public class ProblemA {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int testcases = sc.nextInt();
		
		for(int x = 0; x < testcases; x++)
		{
			int n = sc.nextInt();
			int t = sc.nextInt();
			
			int[] arr = new int[n];
			int i;
			for (i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			i = 0;
			
			while (arr[i] <= t) {
				t -= arr[i];
				i++;
				if (i == n || t < 0) {
					break;
				}
			}
			
			System.out.println(i);
		}
	}

}
