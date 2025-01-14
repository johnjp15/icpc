//John
//YES

import java.util.*;

public class ProblemA {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		
		while(sc.hasNext())
		{
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println(k + " " + sum(n, 1) + " " + sum(n, 2) + " " + sum(n, 3));
		}
		
		sc.close();
	}
	
	//casenum: 1 = positive integers; 2 = odd integers; 3 = even integers
	public static int sum(int n, int casenum)
	{
		int a1 = (casenum == 3) ? 2 : 1;
		int d = (casenum == 1) ? 1 : 2;
		int an = a1 + (n - 1) * d;
		
		return (n * (a1 + an) / 2);
	}
}
