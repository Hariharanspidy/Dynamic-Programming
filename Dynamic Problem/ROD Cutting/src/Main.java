import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] p={2,5,7,8,10};
        int n=5;
        int[][] dp = new int[p.length][n + 1];
        System.out.println(sol(p,n,p.length-1));
        System.out.println(sol(p,n,p.length-1,dp));
        sol(p,n);
    }
    private static int sol(int[] p, int n, int i) {
        if(i==0)return p[i]*n;
        int notPick=sol(p,n,i-1);
        int pick=0;
        if(n>=i+1) pick=p[i]+sol(p,n-(i+1),i);
        return Math.max(pick,notPick);
    }

    private static int sol(int[] p, int n, int i,int[][] dp) {
        if(i==0)return p[i]*n;
        if(dp[i][n]!=0)return dp[i][n];
        int notPick=sol(p,n,i-1,dp);
        int pick=0;
        if(n>=i+1) pick=p[i]+sol(p,n-(i+1),i,dp);
        return dp[i][n]=Math.max(pick,notPick);
    }

    private static void sol(int[] p, int l) {
        int n=p.length;
        int m=l+1;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0) dp[i][j]=p[i]*j;
                else{
                    int notPick=dp[i-1][j];
                    int pick=0;
                    if(j>=i+1) pick=dp[i][j-(i+1)]+p[i];
                    dp[i][j]=Math.max(pick,notPick);
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}