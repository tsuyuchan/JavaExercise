package timeComplexity;

public class maxSubSum {
    /*
    最大的子序列和问题，研究时间复杂度
     */

     public static int maxSubSum1(int[] a){
         /*
         时间复杂度为O（N^3）
          */
         int maxSum=0;
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a.length;j++){
                 int thisSum=0;
                 for (int k=i;k<=j;k++){
                     thisSum+=a[k];
                 }
                 if(thisSum>maxSum){
                     maxSum=thisSum;
                 }
             }
         }
         return maxSum;
     }

    public static int maxSubSum2(int[] a){
         /*
         时间复杂度为O（N^2）
          */
        int maxSum=0;
        for(int i=0;i<a.length;i++){
            int thisSum=0;
            for(int j=0;j<a.length;j++){
                thisSum+=a[j];
                if (thisSum>maxSum){
                    maxSum=thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSum3(int[] a,int left,int right){
         /*
         时间复杂度为O（NlogN）
          */
         if(left==right){
             if (a[left]>0){
                 return a[left];
             }else{
                 return 0;
             }
         }
         int center=(left+right)/2;
         int maxLeftSum=maxSubSum3(a,left,center);
         int maxRightSum=maxSubSum3(a,center+1,right);
         int maxLeftBorderSum=0,leftBorderSum=0;
         for (int i=center;i>=left;i--){
             leftBorderSum+=a[i];
             if(leftBorderSum>maxLeftBorderSum){
                 maxLeftBorderSum=leftBorderSum;
             }
         }
        int maxRightBorderSum=0,rightBorderSum=0;
        for (int i=center+1;i<=right;i++){
            rightBorderSum+=a[i];
            if(rightBorderSum>maxRightBorderSum){
                maxRightBorderSum=rightBorderSum;
            }
        }
        int maxSum=maxLeftBorderSum+maxRightBorderSum;
        if(maxSum<maxLeftSum){
            maxSum=maxLeftSum;
        }
        if(maxSum<maxRightSum){
            maxSum=maxRightSum;
        }
        return maxSum;
    }

    public static void main(String[]args){
         int a[]={4,-3,5,-2,-1,2,6,-2};
         System.out.println(maxSubSum1(a));
         System.out.println(maxSubSum2(a));
         System.out.println(maxSubSum3(a,0,a.length-1));
    }
}
