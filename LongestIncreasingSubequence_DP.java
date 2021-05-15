/*
 i/p[] : 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
 o/p : 6  // 0, 2, 6, 9, 11, 15

 inclu : 0, 8, 12, 14 ,15
 exclu : 0, 4, 12, 14, 15

 inclu1 : 0, 8, 10, 13, 15 //9
 exclu1 : 0, 4, 10, 13 // 6 9 5


 inclu : LIS(a, i+1, a.length(), curr)
 exclu : LIS(a, i+1, a.lenght(), prev )

 a[] : 0
 LIS(0, -1) = LIS(1, -1), LIS(1, 0)
 LIS(1, -1) = LIS(2, 0), LIS()


 */

public class LongestIncreasingSubequence_DP {
    public static void main(String[] args) {
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int x = LIS(a);//, 0, Integer.MIN_VALUE);
        System.out.println();
        System.out.println(x);
    }

    private static int LIS(int[] a) {
        int[] lcs = new int[a.length];
        lcs[0] = 1;
        int superMax = Integer.MIN_VALUE;
        for (int i = 1; i < a.length ; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (a[i]>a[j]) {
                    max = Integer.max(lcs[j] +1, max);
                }
            }
            lcs[i] = max;
            System.out.print(lcs[i]+",");
            superMax = Integer.max(max, superMax);
        }
        return superMax;
    }

//
//    private static int LIS(int[] a, int i, int n, int prev) {
//        if(i==n){
//            return 0;
//        }
//        int exclu = LIS(a,i+1,n, prev);
//        int inclu = 0;
//        if(a[i] > prev){
//            inclu = 1 + LIS(a, i+1, n, a[i]) ;
//
//        }
//        return  Integer.max(inclu,exclu);
//    }
}
