import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 3 , k = 1;
        int[] height = {2, 5, 2};
        sol(n,k,height);
    }
//Using Dp
    private static void sol(int n, int k, int[] height) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump=dp[i-j]+Math.abs(height[i]-height[i-j]);
                    min=Math.min(jump,min);
                }
            }
            dp[i]=min;
        }
        System.out.println(dp[n-1]);
    }
}