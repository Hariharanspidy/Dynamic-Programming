
public class Main {
    public static void main(String[] args) {
        String s1="acd";
        String s2="mkfdmfkacd";
        sol(s1,s2);

    }
    private static void sol(String s1, String s2) {
        int n=s1.length()+1;
        int m=s2.length()+1;
        int[][] dp=new int[n][m];
        int ans=0;
        int ind=0;
        for(int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                    if(ans<dp[i][j]){
                        ans=dp[i][j];
                        ind=i-1;
                    }
                }
                else dp[i][j]=0;
            }
        }
        System.out.println(s1.substring(ind-ans+1,ind+1));
    }
}
