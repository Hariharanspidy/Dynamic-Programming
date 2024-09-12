import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a={7,1,4,5,3,6,4};
        int[][] dp=new int[a.length][2];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        System.out.println(sol(a,0,1));
        System.out.println(sol(a,0,1,2));
        System.out.println(sol(a,0,1,dp));
        sol(a);

    }

    private static int sol(int[] a, int i, int b) {
        if(i==a.length)return 0;
        int profit=0;
        if(b==1)
            profit=Math.max(-a[i]+sol(a,i+1,0),sol(a,i+1,1));
        else
            profit=Math.max(a[i]+sol(a,i+1,1),sol(a,i+1,0));
        return profit;
    }
    private static int sol(int[] a, int i, int b,int cap) {
        if(i==a.length)return 0;
        int profit=0;
        if(b==1)
            profit=Math.max(-a[i]+sol(a,i+1,0,cap),sol(a,i+1,1,cap));
        else
            profit=Math.max(a[i]+sol(a,i+1,1,cap-1),sol(a,i+1,0,cap));
        return profit;
    }
    private static int sol(int[] a, int i, int b,int[][] dp) {
        if(i==a.length)return 0;
        if(dp[i][b]!=-1) return dp[i][b];
        int profit=0;
        if(b==1)
            profit=Math.max(-a[i]+sol(a,i+1,0),sol(a,i+1,1));
        else
            profit=Math.max(a[i]+sol(a,i+1,1),sol(a,i+1,0));
        return dp[i][b]=profit;
    }
    private static void sol(int[] a) {
        int n=a.length+1;
        int[][] dp=new int[n][2];
        for(int i=a.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==0)
                    profit=Math.max(-a[i]+dp[i+1][1], dp[i + 1][0]);
                else
                    profit=Math.max(a[i]+dp[i+1][0],dp[i+1][1]);
                dp[i][j]=profit;
            }
        }

        System.out.println(dp[0][0]);
    }
}