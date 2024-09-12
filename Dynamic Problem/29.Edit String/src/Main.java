import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1="horse";
        String s2="ros";
        int[][] dp=new int [s1.length()][s2.length()];
        for(int[] i:dp) Arrays.fill(i,-1);
        System.out.println(sol(s1,s2,s1.length()-1,s2.length()-1));
        System.out.println(sol(s1,s2,s1.length()-1,s2.length()-1,dp));
        sol(s1,s2);
        solSpace(s1,s2);
    }

    private static int sol(String s1,String s2, int i,int j) {
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(s1.charAt(i)==s2.charAt(j))
            return sol(s1,s2,i-1,j-1);
        int ins=1+sol(s1,s2,i,j-1);
        int del=1+sol(s1,s2,i-1,j);
        int rep=1+sol(s1,s2,i-1,j-1);
        return Math.min(ins,Math.min(del,rep));
    }
    private static int sol(String s1,String s2, int i,int j,int[][]dp) {
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=sol(s1,s2,i-1,j-1,dp);
        int ins=1+sol(s1,s2,i,j-1,dp);
        int del=1+sol(s1,s2,i-1,j,dp);
        int rep=1+sol(s1,s2,i-1,j-1,dp);
        return dp[i][j]=Math.min(ins,Math.min(del,rep));
    }
    private static void sol(String s1,String s2) {
        int n=s1.length()+1;
        int m=s2.length()+1;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) dp[i][0]=i;
        for(int i=0;i<m;i++) dp[0][i]=i;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    int ins=1+dp[i][j-1];
                    int del=1+dp[i-1][j];
                    int rep=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(ins,Math.min(del,rep));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(dp[n-1][m-1]);
    }
    private static void solSpace(String s1,String s2) {
        int n=s1.length()+1;
        int m=s2.length()+1;
        int[] cur=new int[m];
        int[] prev=new int[m];
        for(int i=0;i<m;i++) prev[i]=i;
        for(int i=1;i<n;i++){
            cur[0]=i;
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    cur[j]=prev[j-1];
                else
                    cur[j]=1+Math.min(prev[j],Math.min(cur[j-1],prev[j-1]));
            }
            System.out.println(Arrays.toString(cur));
            prev=cur.clone();
        }
        System.out.println(prev[m-1]);
    }
}