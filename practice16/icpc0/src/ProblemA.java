import java.util.*;

public class ProblemA {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		int p = sc.nextInt();
		
		int caseNum = 1;
		
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			for(int i = 0; i < arr.length; i++)	{
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.println(n + " " + arr[7]);
			caseNum++;
		}
	}

}