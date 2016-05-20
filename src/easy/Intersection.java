package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class IntersectionTest{
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,5,1,3,10};
        int[] nums2 = new int[]{2,3,5,7};
        Intersection intersection = new Intersection();
       int[] results =  intersection.intersection(nums1, nums2);
        for(int result:results) {

            System.out.println(result);
        }

    }
}

public class Intersection {

    public  int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1){
            if(binarySearch(nums2, num))
                set.add(num);
        }

        int i = 0;
        int[] res = new int[set.size()];
        for(Integer num : set){
            res[i++] = num;
        }
        return res;
    }


    private boolean binarySearch(int[] num, int x){
        int high = num.length - 1;
        int low = 0;

        while(low <= high){
            //数学上是一样的，但是计算上可能需要考虑溢出吧。至少用代码中的写法，
            // 不会存在溢出问题。如果直接加，由于是地址，可能会溢出。
            int mid = low + (high - low)/2;
            if(x < num[mid]){
                high = mid - 1;
            } else if(x > num[mid]){
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}