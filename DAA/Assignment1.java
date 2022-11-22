package assignments;
import java.util.*;
public class Assignment1 {

	public static int fibonnaciNonRecursive(int n) {
		if(n==1 || n==2) {
			return n-1;
		}else {
			int f0=0,f1=1;
			int fib=0;
			for(int i=3;i<=n;i++) {
				fib=f0+f1;
				f0=f1;
				f1=fib;
			}
			return fib;
		}
		
	}
	public static int fibonnaciRecursive(int n) {
		if(n==1 || n==2) {
			return n-1;
		}else {
			return (fibonnaciRecursive(n-1)+fibonnaciRecursive(n-2));
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Non-recursive and recursive program to calculate Fibonacci numbers");
		System.out.println("------------------------------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value for \"N\" : ");
		int n=sc.nextInt();
		System.out.println("Non recursive Fibonacci : "+fibonnaciNonRecursive(n));
		System.out.println("\nRecursive Fibonacci : "+fibonnaciRecursive(n));
		sc.close();
	}

}
