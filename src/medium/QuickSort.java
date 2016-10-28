package medium;

/**
 * Created by danny on 2016/10/26.
 */
public class QuickSort {

     public static void quickSort(int s[],int l,int r){
         if (l < r)
         {
             int i = l, j = r, x = s[l]; //s[1]即s[i]就是第一个坑
             while (i < j)
             {
                 while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                     j--;
                 if(i < j)            //s[j] < x 找到填写坑位
                     s[i++] = s[j];   //找到之后i后移1位,再从左往右

                 while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                     i++;
                 if(i < j)
                     s[j--] = s[i];  //找到之后j前移1位,再从右边往左
             }
             //退出时,i==j,将x填写到这个坑
             s[i] = x;
             quickSort(s, l, i - 1); // 递归调用
             quickSort(s, i + 1, r);
         }

     }

     public static void main(String args[]){

         int a[] = {49, 38, 65,12,45,5,20,32};
         quickSort(a,0,7);
         for (int i=0;i<a.length;i++){
             System.out.print(a[i]+" ");
         }

     }

}
