package assignments;

import java.util.Scanner;

public class Assignment3 {
	
	private static int max(int a,int b) {
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}
	public static int knapSack(int W, int wt[], int val[], int n)
	{
		int i, w;
		int K[][] = new int[n + 1][W + 1];
		
		for (i = 0; i <= n; i++)
		{
			for (w = 0; w <= W; w++)
			{
			    if (i == 0 || w == 0) {
			        K[i][w] = 0;		    	
			    } else if (wt[i - 1] <= w) {
			        K[i][w]= max(val[i - 1]+ K[i - 1][w - wt[i - 1]], K[i - 1][w]);
			    }else {
			        K[i][w] = K[i - 1][w];
			    }
			}
		}
		
		int res=K[n][W];
		w = W;
        for (i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w])
                continue;
            else {
                System.out.println("Item "+i+" - Weight "+wt[i - 1] + " ");
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
		return K[n][W];
	}

	public static void main(String[] args) {
		System.out.println("------------------ 0/1 Knapsack ------------------");
		int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Items placed in KnapSack : ");
        System.out.println("Total Profit = "+knapSack(W, wt, val, n));
        
        
		Scanner sc=new Scanner(System.in);

		System.out.println("--------------------------------------------------");
        System.out.println("Enter no of items : ");
		n=sc.nextInt();
        System.out.println("Enter knapsack capacity : ");
		W=sc.nextInt();
		val = new int[n];
		wt = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("\nEnter item weight : ");
			wt[i]=sc.nextInt();

			System.out.print("\nEnter item profit : ");
			val[i]=sc.nextInt();
		}
		System.out.println();
		System.out.println("------------------ 0/1 Knapsack ------------------");
		
		System.out.println("Items placed in KnapSack : ");
        System.out.println("Total Profit = "+knapSack(W, wt, val, n));
        
        sc.close();
	}

}