public class Main {
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[][] dp=new int[n][m];
        System.out.println(sol(n-1,m-1));
        System.out.println(sol(n-1,m-1,dp));
        solDP(n,m);

    }
//Recursion
    private static int sol(int n, int m) {
        if(n==0 && m==0) return 1;
        if(n<0 || m<0) return 0;
        return sol(n-1,m)+sol(n,m-1);
    }
//Recursion with memorization
    private static int sol(int n, int m,int[][] dp) {
        if(n==0 && m==0) return 1;
        if(n<0 || m<0) return 0;
        if(dp[n][m]!=0) return dp[n][m];
        return sol(n-1,m)+sol(n,m-1);
    }
//Dynamic Programming
    private static void solDP(int n, int m) {
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(i==0 && j==0) dp[i][j]=1;
                else {
                    int down=0,right=0;
                    if(i>0) down=dp[i-1][j];
                    if(j>0)right=dp[i][j-1];
                    dp[i][j]=down+right;
                }
        }
        System.out.println(dp[n-1][m-1]);
    }
}