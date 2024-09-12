
public class Main {
    public static void main(String[] args) {
        int[] c={9,5,6,1};
        int t=11;
        int[][] dp=new int[c.length][t+1];
        System.out.println(sol(c,t,c.length-1));
        System.out.println(sol(c,t,c.length-1,dp));
        sol(c,t);
    }

//Recursion
    private static int sol(int[] c, int t, int n) {
        if(n==0){
            if(t%c[n]==0)return (int)t/c[n];
            else return (int)1e9;
        }
        int notPick=sol(c,t,n-1);
        int Pick=(int)1e9;
        if(c[n]<=t)
            Pick=1+sol(c,t-c[n],n);
        return Math.min(notPick,Pick);
    }
//    Mem
    private static int sol(int[] c, int t, int n,int[][] dp) {
        if(n==0){
            if(t%c[n]==0)return (int)t/c[n];
            else return (int)1e9;
        }
        if(dp[n][t]!=0)return dp[n][t];
        int notPick=sol(c,t,n-1);
        int Pick=(int)1e9;
        if(c[n]<=t)
            Pick=1+sol(c,t-c[n],n);
        return dp[n][t]=Math.min(notPick,Pick);
    }
    private static void sol(int[] c, int t) {
        int n=c.length;
        int m=t+1;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    if(j%c[i]==0) dp[i][j]= (int)j/c[i];
                    else dp[i][j]=(int)1e9;
                }
                else{
                    int notPick=dp[i-1][j];
                    int pick=(int)1e9;
                    if(c[i]<=j) pick=1+dp[i-1][j-c[i]];
                    dp[i][j]=Math.min(pick,notPick);
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
        System.out.print("  ");
        for(int j=0;j<m;j++)
            System.out.print(j+" ");
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0) System.out.print(c[i]+" ");
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

//        if(n==0){
//            if(t%c[n]==0)return (int)t/c[n];
//            else return (int)1e9;
//        }
//        if(dp[n][t]!=0)return dp[n][t];

//        int notPick=sol(c,t,n-1);
//        int Pick=(int)1e9;
//        if(c[n]<=t)
//            Pick=1+sol(c,t-c[n],n);
//        return dp[n][t]=Math.min(notPick,Pick);
    }
}