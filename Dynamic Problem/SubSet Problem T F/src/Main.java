import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]a={1,2,3,4};
        int target=4;
        int[][] dp=new int[a.length][target+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        boolean ans=sol(a,a.length-1,target);
        boolean ans1=sol(a,a.length-1,target,dp);
        System.out.println(ans+" "+ans1);
        sol(a,target);
    }

    private static boolean sol(int[] a, int n, int target) {
        if(target==0) return true;
        if(n<0 || target<0) return false;
        boolean take=false;
        if(target>=a[n]) take=sol(a,n-1,target-a[n]);
        boolean notTake=sol(a,n-1,target);
        return take|| notTake;
    }
//    Memorization
    private static boolean sol(int[] a, int n, int target,int[][] dp) {
        if(target==0) return true;
        if(dp[n][target]!=-1) return dp[n][target]==0?false:true;
        boolean take=false;
        if(target>=a[n]) take=sol(a,n-1,target-a[n]);
        boolean notTake=sol(a,n-1,target);
        dp[n][target]=take|| notTake?1:0;
        return take|| notTake;
    }
//    Dp
    private static void sol(int[] a, int target) {
        boolean[][] dp=new boolean[a.length][target+1];
        for(int i=0;i<target;i++)dp[i][0]=true;
        if (a[0] <= target) {
            dp[0][a[0]] = true;
        }
        for(int i=1;i<a.length;i++){
            for(int j=1;j<=target;j++){
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(j>=a[i]) take=dp[i-1][j-a[i]];
                dp[i][j]=take||notTake;
            }
        }
        System.out.println(dp[a.length-1][target]);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<=target;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}