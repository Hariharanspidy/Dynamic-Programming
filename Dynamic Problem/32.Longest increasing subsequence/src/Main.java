import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] a={10,9,2,5,3,7,101,8};
        int[][] dp=new int[a.length][a.length+1];
        for(int[] i:dp) Arrays.fill(i,-1);
//        System.out.println(sol(a,a.length-1,0));
        System.out.println(sol(a,0,-1));
        System.out.println(sol(a,0,-1,dp));
        System.out.println(sol(a));

    }

//    private static int sol(int[] a, int i,int prev) {
//        if(i<0) return 0;
//        int pick=0;
//        if(prev<a[i])
//            pick=1+sol(a,i-1,a[i]);
//        int notPick=sol(a,i-1,prev);
//        return Math.max(pick,notPick);
//    }
    private static int sol(int[] a, int i,int preInd) {
        if(i==a.length)return 0;
        int pick=0;
        if(preInd==-1||a[preInd]<a[i]) pick=1+sol(a,i+1,i);
        int notPick=sol(a,i+1,preInd);
        return Math.max(pick,notPick);
    }
    private static int sol(int[] a, int i,int preInd,int[][]dp) {
        if(i==a.length)return 0;
        if(dp[i][preInd+1]!=-1)return dp[i][preInd];
        int pick=0;
        if(preInd==-1||a[preInd]<a[i]) pick=1+sol(a,i+1,i,dp);
        int notPick=sol(a,i+1,preInd,dp);
        return dp[i][preInd+1]=Math.max(pick,notPick);
    }
    private static int sol(int[] a) {
        int n=a.length+1;
        int m=a.length+1;
        int[][] dp=new int[n][m];
        for(int i=n-2;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int pick=0;
                if(j==-1 || a[j]<a[i]) pick=1+dp[i+1][i+1];
                dp[i][j+1]=Math.max(dp[i+1][j+1],pick);
            }
        }
        return dp[0][0];
    }
}