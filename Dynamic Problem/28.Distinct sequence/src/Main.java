import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       String s1="bagbbag";
       String s2="bag";
       int[][] dp=new int [s1.length()][s2.length()];
       for(int[] i:dp) Arrays.fill(i,-1);
       System.out.println(sol(s1,s2,s1.length()-1,s2.length()-1));
       System.out.println(sol(s1,s2,s1.length()-1,s2.length()-1,dp));
       sol(s1,s2);
    }

    private static int sol(String s1,String s2, int i,int j) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(s1.charAt(i)==s2.charAt(j))
            return sol(s1,s2,i-1,j-1)+ sol(s1,s2,i-1,j);
        return sol(s1,s2,i-1,j);
    }
    private static int sol(String s1,String s2, int i,int j,int[][]dp) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=sol(s1,s2,i-1,j-1,dp)+ sol(s1,s2,i-1,j,dp);
        return dp[i][j]=sol(s1,s2,i-1,j,dp);
    }
    private static void sol(String s1,String s2) {
        int n=s1.length()+1;
        int m=s2.length()+1;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) dp[i][0]=1;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
    private static void solSpace(String s1,String s2) {
        int n=s1.length()+1;
        int m=s2.length()+1;
//        int[][] dp=new int[n][m];
//        int[] prev=new int[m];
        int[] dp=new int[m];
        int[] cur=new int[m];

//        for(int i=0;i<n;i++) dp[i][0]=1;
        dp[0]=1;

        for(int i=1;i<n;i++){
            for(int j=m;j>=1;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[j]=dp[j-1]+dp[j];
//                else
//                    cur[j]=prev[j];
            }
        }

        System.out.println(dp[m-1]);
    }
}