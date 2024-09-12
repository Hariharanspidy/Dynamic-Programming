//public class Main {
//    public static void main(String[] args) {
//
//
//    }
//}
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a={15,6,2,4,1,15};
        int[] dp=new int[a.length];
        int[] a1=Arrays.copyOfRange(a,0,a.length-1);
        int[] a2=Arrays.copyOfRange(a,1,a.length);
        int ans1=sol(a1,a1.length-1);
        int ans2=sol(a2,a2.length-1);
        System.out.println(Math.max(ans1, ans2));
        System.out.println(sol(a,a.length-1));
        System.out.println(sol(a,a.length-1,dp));
        sol(a);
    }
    //Recursion
    private static int sol(int[] a, int n) {
        if(n==0) return a[n];
        if(n<0) return 0;
        return Math.max(a[n]+sol(a,n-2),sol(a,n-1));

    }
    //Recursion with memorization
    private static int sol(int[] a, int n,int[] dp) {
        if(n==0) return a[n];
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        return dp[n]=Math.max(a[n]+sol(a,n-2,dp),sol(a,n-1,dp));

    }
    //Dynamic Programming
    private static void sol(int[] a) {
        int[] dp=new int[a.length];
        dp[0]=a[0];
        for(int i=1;i<a.length-1;i++){
            int pick=a[i];
            if(i-2>=0)
                pick+=dp[i-2];
            dp[i]=Math.max(pick,dp[i-1]);
        }
        System.out.println(dp[a.length-1]);
    }

}