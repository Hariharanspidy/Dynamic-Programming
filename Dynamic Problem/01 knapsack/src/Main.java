
public class Main {
    public static void main(String[] args) {
        int[]w={3,4,5};
        int[]p={3,5,6};
        int wi=8;
        int[][] dp=new int[w.length+1][wi+1];
        System.out.println(sol(w,p,wi,w.length-1));
        System.out.println(sol(w,p,wi,w.length-1,dp));
        sol(w,p,wi);

    }
//Recursion
    private static int sol(int[] w, int[] p, int wi, int n) {
        if(n==0)
            if(w[0]<=wi) return p[0];
            else return 0;
        if(n<0 || wi<0) return 0;
        int Pick=0;
        if(wi>=w[n]) Pick=p[n]+sol(w,p,wi-w[n],n-1);
        return Math.max(sol(w,p,wi,n-1),Pick);
    }
//Recursion with mem
    private static int sol(int[] w, int[] p, int wi, int n,int[][]dp) {
        if(n==0)
            if(w[0]<=wi) return p[0];
            else return 0;
        if(n<0 || wi<0) return 0;
        if(dp[n][wi]!=0) return dp[n][wi];
        int Pick=0;
        if(wi>=w[n]) Pick=p[n]+sol(w,p,wi-w[n],n-1);
        return dp[n][wi]=Math.max(sol(w,p,wi,n-1),Pick);
    }
//DP
    private static void sol(int[] w, int[] p, int wi) {
        int n=w.length;
        int m=wi+1;
        int[][] dp=new int[n+1][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0)
                    if(w[i]<=j)dp[i][j]=p[0];
                    else dp[i][j]=0;
                else{
                int notPick=dp[i-1][j];
                int pick=0;
                if(j>=w[i])
                    pick=dp[i-1][j-w[i]]+p[i];
                dp[i][j]=Math.max(pick,notPick);}

            }
        }
        System.out.print("  ");
        for(int j=0;j<m;j++)
            System.out.print(j+" ");
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0) System.out.print(w[i]+" ");
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[n-1][m-1]);


    }
}

