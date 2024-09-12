//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] mat={
                {1,2,10,1},
                {100,10,2,1},
                {10,5,10,100},
                {20,10,30,6}
        };
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp=new int[n][m];
        int maxR =Integer.MIN_VALUE;
        int maxM=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            maxR =Math.max(sol(mat,n-1,i), maxR);
            maxM =Math.max(sol(mat,n-1,i,dp), maxM);
        }
        System.out.println(maxR);
        System.out.println(maxM);
        sol(mat);

    }
//Recursion
    private static int sol(int[][] mat, int n, int m) {
        if(m<0 || mat.length<=m) return Integer.MIN_VALUE;
        if(n==0) return mat[n][m];
        int up=mat[n][m]+sol(mat,n-1,m);
        int ld=mat[n][m]+sol(mat,n-1,m-1);
        int rd=mat[n][m]+sol(mat,n-1,m+1);
        return Math.max(up,Math.max(ld,rd));
    }
//Recursion with memorization
    private static int sol(int[][] mat, int n, int m,int[][] dp) {
        if(m<0 || mat.length<=m) return Integer.MIN_VALUE;
        if(n==0) return mat[n][m];
        if(dp[n][m]!=0) return dp[n][m];
        int up=mat[n][m]+sol(mat,n-1,m,dp);
        int ld=mat[n][m]+sol(mat,n-1,m-1,dp);
        int rd=mat[n][m]+sol(mat,n-1,m+1,dp);
        return dp[n][m]=Math.max(up,Math.max(ld,rd));
    }
//Dynamic Programing
    private static void sol(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = mat[i][j] + dp[i-1][j];
                int ld = (j > 0) ? mat[i][j] + dp[i-1][j-1] : Integer.MIN_VALUE;
                int rd = (j < m-1) ? mat[i][j] + dp[i-1][j+1] : Integer.MIN_VALUE;
                dp[i][j] = Math.max(up, Math.max(ld, rd));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, dp[n-1][j]);
        }
        System.out.println(max);
    }

}