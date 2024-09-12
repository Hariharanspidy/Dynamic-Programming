
public class Main {
    public static void main(String[] args) {
        int[][] maz={
                {2,3,5},
                {4,5,6},
                {7,8,9}
        };
        int n=maz.length;
        int m=maz[0].length;
        int[][] dp=new int[n][m];
        System.out.println(sol(maz,n-1,m-1));
        System.out.println(sol(maz,n-1,m-1,dp));
        sol(maz);
    }
//Recursion
    private static int sol(int[][] maz, int n, int m) {
        if(n==0 && m==0) return maz[n][m];
        if(n<0 || m<0) return 9999;
        return Math.min(maz[n][m]+sol(maz,n,m-1),maz[n][m]+sol(maz,n-1,m));
    }
//Recursion with memorization
    private static int sol(int[][] maz, int n, int m,int[][]dp) {
        if(n==0 && m==0) return maz[n][m];
        if(n<0 || m<0) return 9999;
        if(dp[n][m]!=0) return dp[n][m];
        return dp[n][m]=Math.min(maz[n][m]+sol(maz,n,m-1,dp),maz[n][m]+sol(maz,n-1,m,dp));
    }
    private static void sol(int[][] maz) {
        int n=maz.length;
        int m=maz[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=maz[i][j];
                else {
                    int up=99999;
                    int left=99999;
                    if(i>0)up=maz[i][j]+dp[i-1][j];
                    if(j>0)left=maz[i][j]+dp[i][j-1];
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}