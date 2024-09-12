public class Main {
    public static void main(String[] args) {
        int[][] max={
                {0,1,0},
                {0,1,0},
                {0,0,0}
        };
        int n=max.length-1;
        int m=max[0].length-1;
        int[][] dp=new int[n+1][m+1];
        System.out.println(sol(max,n,m));
        System.out.println(sol(max,n,m,dp));
        sol(max);

    }
//Recursion
    private static int sol(int[][] max, int n, int m) {
        if(n==0&&m==0)return 1;
        if(n<0 || m<0 ) return 0;
        if(max[n][m]==1) return 0;
        return sol(max,n-1,m)+sol(max,n,m-1);
    }
//Recursion with memorization
    private static int sol(int[][] max, int n, int m,int[][] dp) {
        if(n==0&&m==0)return 1;
        if(n<0 || m<0 ) return 0;
        if(max[n][m]==1) return 0;
        if(dp[n][m]!=0) return dp[n][m];
        return dp[n][m]=sol(max,n-1,m)+sol(max,n,m-1);
    }
//Dynamic Programming
    private static void sol(int[][] max) {
        int n=max.length;
        int m=max[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(max[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else {
                    int down=0,right=0;
                    if(i>0) down=dp[i-1][j];
                    if(j>0)right=dp[i][j-1];
                    dp[i][j]=down+right;
                }
            }
        }
    }
}