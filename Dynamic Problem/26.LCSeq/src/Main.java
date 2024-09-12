//Inorder to find the Palindrome in LCS reverse the give String then find th LCS

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1="bbabcbcab";
        String s2="bacbcbabb";

//For Length of LCS
        int[][] dpLen=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++)
            for (int j=0;j<=s2.length();j++)
                dpLen[i][j]=-1;
        System.out.println("Length of LCS : "+solLen(s1,s2,s1.length(),s2.length()));
        System.out.println("Length of LCS using mem : "+solLen(s1,s2,s1.length(),s2.length(),dpLen));
//Minimum Insertion to make given string palindrome
//Find the LCS of given String and reverse of String
//Then minus it to length of give String
        System.out.println("Minimum insertion to make given string palindrome : "+(s1.length()-solLen(s1,s2,s1.length(),s2.length(),dpLen)));
//Minimum Insertion and Deletion to convert S1 -> S2
//Find the LCS of given Strings
//Then len(s1)+len(s2)-2*lcs(s1,s2)
        System.out.println("Minimum Insertion and Deletion to convert S1 -> S2 : "+(s1.length()+s2.length()-2*solLen(s1,s2,s1.length(),s2.length(),dpLen)));



//For Print of LCS
        String[][] dpStr=new String[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++)
            for (int j=0;j<=s2.length();j++)
                dpStr[i][j]="-";
        System.out.println("Print LCS : "+solStr(s1,s2,s1.length(),s2.length()));
        System.out.println("Print of LCS using mem : "+solStr(s1,s2,s1.length(),s2.length(),dpStr));
        sol(s1,s2);

    }
//Length of LCS ~RECURSION~
    private static int solLen(String s1, String s2, int i1, int i2) {
        if(i1==0 || i2==0) return 0;
        if(s1.charAt(i1-1)==s2.charAt(i2-1)) return 1+solLen(s1,s2,i1-1,i2-1);
        return Math.max(solLen(s1,s2,i1-1,i2),solLen(s1,s2,i1,i2-1));
    }

//Length of LCS ~RECURSION WITH MEMORIZATION~
    private static int solLen(String s1, String s2, int i1, int i2,int[][] dp) {
        if(i1==0 || i2==0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s1.charAt(i1-1)==s2.charAt(i2-1)) return dp[i1][i2]=1+solLen(s1,s2,i1-1,i2-1,dp);
        return dp[i1][i2]=Math.max(solLen(s1,s2,i1-1,i2,dp),solLen(s1,s2,i1,i2-1,dp));
    }

//Print of LCS ~RECURSION~
    private static String solStr(String s1, String s2, int i1, int i2) {
        if(i1==0 || i2==0) return "";
        if(s1.charAt(i1-1)==s2.charAt(i2-1)) return s1.charAt(i1-1)+solStr(s1,s2,i1-1,i2-1);
        String o1=solStr(s1,s2,i1-1,i2);
        String o2=solStr(s1,s2,i1,i2-1);
        return o1.length()>o2.length()?o1:o2;
    }

//Print of LCS ~RECURSION WITH MEMORIZATION~
    private static String solStr(String s1, String s2, int i1, int i2,String[][] dp) {
        if(i1==0 || i2==0) return "";
        if(!dp[i1][i2].equals("-")) return dp[i1][i2];
        if(s1.charAt(i1-1)==s2.charAt(i2-1))
            return dp[i1][i2]=s1.charAt(i1-1)+solStr(s1,s2,i1-1,i2-1,dp);
        String o1=solStr(s1,s2,i1-1,i2,dp);
        String o2=solStr(s1,s2,i1,i2-1,dp);
        return dp[i1][i2]=o1.length()>o2.length()?o1:o2;
    }

    private static void sol(String s1, String s2) {
        int n=s1.length()+1;
        int m=s2.length()+1;
        int[][] dp=new int[n][m];
        for(int i=1;i<n;i++)
            for (int j=1;j<m;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                Print LCS
        int i=n-1;
        int j=m-1;
        char[] s=new char[dp[n-1][m-1]];
        int ind=dp[n-1][m-1];
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                s[--ind]=s1.charAt(i-1);i--;j--;
            }
            else if (dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
        }
//        Smallest common subsequence
        i=n-1;
        j=m-1;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));i--;j--;
            }
            else if (dp[i-1][j]>dp[i][j-1]) {
                sb.append(s1.charAt(i-1));
                i--;
            }
            else {
                sb.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i>0)sb.append(s1.charAt(--i));
        while(j>0)sb.append(s2.charAt(--j));

        System.out.println("Print smallest super sequence : "+ sb.reverse());
        System.out.println("Print LCS : "+ Arrays.toString(s));
        System.out.println("Length of LCS : "+dp[n-1][m-1]);
    }
}