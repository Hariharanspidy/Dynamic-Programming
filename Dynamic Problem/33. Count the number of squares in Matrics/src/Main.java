
public class Main {
    public static void main(String[] args) {
        int[][] mat={
                {1,1,0},
                {1,1,1},
                {1,1,0}
        };
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp=new int[n][m];
        int count=0;
        for(int i=0;i<m;i++) {
            if(mat[0][i]==1)
                count++;
            dp[0][i]=mat[0][i];
        }
        for(int i=1;i<n;i++){
            if(mat[i][0]==1)
                count++;
            dp[i][0]=mat[i][0];
        }
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                if(mat[i][j]==0) dp[i][j]=0;
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    count+=dp[i][j];
                }
        System.out.println(count);
    }
}