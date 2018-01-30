package sequence;
//随便写写排序
import java.util.Arrays;

public class Sequence {
    static int []array={183,4,12,3,1,83,236,6,13,72,472,47,124,36,37,12};
    //以下冒泡排序
    static int[] bubbleSort(int []array){
        int []a=array.clone();
        int temp=0;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }
    //直接插入排序
    static int[] insertSort(int []array){
        int []a=array.clone();
        int insertNum;
        for(int i=1;i<a.length;i++){
            insertNum=a[i];
            int j=i-1;
            while(j>=0 && a[j]>insertNum){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=insertNum;
        }
        return a;
    }
    //快速排序
    static int[] quickSort(int []array){
        int []a=array.clone();
        quickSortDo(a,0,array.length-1);
        return a;
    }
    static void quickSortDo(int []array,int start, int end){
        if(start>end){
            return;
        }
        int i,j,index;
        i=start;
        j=end;
        index=array[i];
        while(i<j){
            while(i<j && array[j]>=index){
                j--;
            }
            if(i<j){
                array[i++]=array[j];
            }
            while (i < j && array[i] < index){
                i++;
            }
            if (i < j)
                array[j--] = array[i];
        }
        array[i] = index;
        quickSortDo(array, start, i - 1);
        quickSortDo(array, i + 1, end);
    }
    //实用
    static int[] ok(int []array){
        //需要import java.util.Arrays;
        int []a=array.clone();
        Arrays.sort(a);
        return a;
    }
    public static void main(String []args){
        //测试调用
        //int []a=bubbleSort(array);
        //int []a=insertSort(array);
        int []a=quickSort(array);
        //int []a=ok(array);
        for (int i:a){
            System.out.println(i);
        }

    }
}
