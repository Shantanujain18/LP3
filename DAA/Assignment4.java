package assignments;
import java.util.*;
public class Assignment4 {
	private static boolean isSafe(int r,int c,int n,int[] lrdiag,int []rldiag, int[] colLookup) {
		if(lrdiag[r-c+n-1]==1 || rldiag[r+c]==1 || colLookup[c]==1) {
			return false;
		}
		return true;
    }

    private static boolean nQueen(int[][] board, int row, int n,int[] lrdiag,int []rldiag, int[] colLookup) {
        if (row >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(row, i,n,lrdiag,rldiag,colLookup)) {
                board[row][i] = 1;
                colLookup[i] = 1;
    			lrdiag[row-i+n-1] =1;
    			rldiag[row+i] =1;
    			
                if (nQueen(board, row + 1,n, lrdiag,rldiag,colLookup)) {
                    return true;
                }
                board[row][i] = 0;
                colLookup[i] = 0;
    			lrdiag[row-i+n-1] =0;
    			rldiag[row+i] =0;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of board : ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        int[] colLookup=new int[n];
        int[] lrdiag =new int[2*n-1];
    	int[] rldiag=new int[2*n-1];
        System.out.println();
        nQueen(board, 0, n,lrdiag,rldiag,colLookup);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        
        System.out.println();
        // System.out.print("Set the first queen's place row : ");
        //int r=sc.nextInt();
        System.out.print("Set the first queen's place column : ");
        int c=sc.nextInt();

        board = new int[n][n];
        colLookup=new int[n];
        lrdiag =new int[2*n-1];
    	rldiag=new int[2*n-1];
    	
    	c-=1;
        board[0][c]=1;
        colLookup[c] = 1;
    	lrdiag[n-1-c] = 1;
    	rldiag[0+c] = 1;
    	
        nQueen(board, 1, n,lrdiag,rldiag,colLookup);

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
	}

}
