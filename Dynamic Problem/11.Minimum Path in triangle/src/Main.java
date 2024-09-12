
public class Main {
    public static void main(String[] args) {
        int[][] maz={
                {1},
                {2,3},
                {3,6,7},
                {8,9,6,10}
        };
        int n=maz.length;
        int[][] dp=new int[n][n];
        System.out.println(sol(maz,0,0,n-1));
        System.out.println(sol(maz,0,0,n-1,dp));
        sol(maz);
    }
//Recursion
    private static int sol(int[][] maz, int i, int j,int n) {
        if(n==i) return maz[i][j];
        return Math.min(maz[i][j]+sol(maz,i+1,j,n),maz[i][j]+sol(maz,i+1,j+1,n));
    }
//Recursion with memorization
    private static int sol(int[][] maz, int i, int j,int n, int[][]dp) {
        if(n==i) return maz[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        return dp[i][j]=Math.min(maz[i][j]+sol(maz,i+1,j,n,dp),maz[i][j]+sol(maz,i+1,j+1,n,dp));
    }
//    Dynamic Programing
    private static void sol(int[][] maz) {
        int n=maz.length;
        int[][] dp=new int[n][n];
        for(int j=0;j<n;j++)
            dp[n-1][j]=maz[n-1][j];
        for(int i=n-2;i>=0;i--)
            for(int j=i;j>=0;j--)
                dp[i][j]=Math.min(maz[i][j]+dp[i+1][j],maz[i][j]+dp[i+1][j+1]);
        System.out.println(dp[0][0]);
    }
}