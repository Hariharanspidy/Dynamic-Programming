import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1="abc*cd";
        String s2="abcedcd";
        int[][] dp=new int [s1.length()][s2.length()];
        for(int[] i:dp) Arrays.fill(i,-1);
        System.out.println(sol(s1,s2,s1.length()-1,s2.length()-1));
        System.out.println(sol(s1,s2,s1.length()-1,s2.length()-1,dp));
        sol(s1,s2);
    }

    private static boolean sol(String s1,String s2, int i,int j) {
        if(i<0 && j<0) return true;
        if(i<0) return false;
        if(j<0){
            for(int ind=0;ind<i;ind++)
                if(s1.charAt(ind)!='*') return false;
            return true;
        }
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
            return sol(s1,s2,i-1,j-1);
        if(s1.charAt(i)=='*') return sol(s1,s2,i-1,j) || sol(s1,s2,i,j-1);
        return false;
    }
    private static boolean sol(String s1,String s2, int i,int j,int[][]dp) {
        if(i<0 && j<0) return true;
        if(i<0) return false;
        if(j<0){
            for(int ind=0;ind<i;ind++)
                if(s1.charAt(ind)!='*') return false;
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            dp[i][j]=sol(s1,s2,i-1,j-1)?1:0;
            return dp[i][j] == 1;

        }
        if(s1.charAt(i)=='*') {
            dp[i][j]=sol(s1,s2,i-1,j) || sol(s1,s2,i,j-1)?1:0;
            return dp[i][j]==1;
        }
        dp[i][j]=0;
        return false;
    }
    private static void sol(String s1,String s2) {
        int n = s1.length() + 1;
        int m = s2.length() + 1;
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        for(int i=1;i<n;i++){
            boolean flag=true;
            for(int j=0;j<=i;j++){
                if(s1.charAt(i-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[i][0]=flag;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (s1.charAt(i - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
