public class Main {
    public static void main(String[] args) {
        int[][] point={
                {10,50,1},
                {5,100,11}
                };
        int[][] dp=new int[point.length+1][4];
        System.out.println(sol(point,point.length-1,0));
        System.out.println(sol(point,point.length-1,0,dp));
        sol(dp);

    }
//Recursion
    private static int sol(int[][] point, int n, int prev) {
        if(n==0){
            int pp=0;
            if (prev==1)
                pp=Math.max(point[0][2],point[0][0]);
            else if (prev==2)
                pp=Math.max(point[0][1],point[0][0]);
            else if (prev==0)
                pp=Math.max(point[0][1],point[0][2]);
            return pp;
        }
        int max=0;
        for(int i=0;i<3;i++){
            if(i!=prev){
                int pp=point[n][i]+sol(point,n-1,i);
                max=Math.max(pp,max);
            }
        }
        return max;
    }
//Recursion with memorization
    private static int sol(int[][] point, int n, int prev,int[][] dp) {
        if(n==0){
            int pp=0;
            if (prev==1)
                pp=Math.max(point[0][2],point[0][0]);
            else if (prev==2)
                pp=Math.max(point[0][1],point[0][0]);
            else if (prev==0)
                pp=Math.max(point[0][1],point[0][2]);
            return pp;
        }
        if(dp[n][prev]!=0)
            return dp[n][prev];
        int max=0;
        int pp;
        pp=point[n][0]+sol(point,n-1,0);
        max=Math.max(pp,max);
        pp=point[n][1]+sol(point,n-1,1);
        max=Math.max(pp,max);
        pp=point[n][2]+sol(point,n-1,2);
        max=Math.max(pp,max);
        return dp[n][prev]=max;
    }
//Dynamic Programing
    private static void sol(int[][] point) {
        int[][] dp=new int[point.length+1][4];
        dp[0][0]=Math.max(point[0][1],point[0][2]);
        dp[0][1]=Math.max(point[0][2],point[0][0]);
        dp[0][2]=Math.max(point[0][1],point[0][0]);
        int n=point.length;
        for(int i=1;i< n;i++){
            for(int j=0;j<3;j++){
                int max=0;
                for(int task = 0; task <3; task++){
                    if(task !=j){
                        int pp=point[i][task]+dp[i-1][task];
                        max=Math.max(pp,max);
                    }
                }
                dp[i][j]=max;
            }
        }
        System.out.println(dp[n-1][2]);
    }
}