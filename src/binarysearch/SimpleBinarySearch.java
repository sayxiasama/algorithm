package binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:SimpleBinarySearch
 * @Describe:
 * @Data:2020/5/1514:06
 * @Author:Ago
 * @Version 1.0
 */
public class SimpleBinarySearch {

    public static int binarySearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,3,5,7,9, 11, 13};
//        System.out.println(binarySearch(arr, arr.length, 11));//二分查找
//        System.out.println(findFirstMatchElementIndex(arr, arr.length, 3)); //查找第一个值匹配的元素下标
//        System.out.println(findLastMatchElementIndex(arr, arr.length, 3)); //查找最后一个值匹配的元素下标
//        System.out.println(findGatherThanOrEqualsElementValue(arr, arr.length, 6));
        System.out.println(findLessThanOrEqualsElementValue(arr, arr.length, 6));
    }

    //

    /**
     * 查找第一个值等于给定值得元素
     *
     * @param arr   给定数组
     * @param n     数组长度
     * @param value 查询值
     * @return
     */
    public static int findFirstMatchElementIndex(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(arr[mid] < value){
                low = mid+1;
            }else if ( arr[mid] > value){
                high = mid - 1;
            }else{
                if(arr[mid] == 0 || arr[mid - 1] != value) {
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param arr   给定数组
     * @param n     数组长度
     * @param value 查询值
     * @return
     */
    public static int findLastMatchElementIndex(int[] arr,int n,int value){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + ((high - low ) >> 1);
            if(arr[mid] < value){
                low = mid + 1;
            }else if( arr[mid] > value){
                high = mid -1;
            }else{
                if (arr[mid] == n - 1 || arr[mid + 1] != value) {
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * findGatherThanOrEqualsElementValue
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int findGatherThanOrEqualsElementValue(int [] arr , int n , int value){
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + ((high - low ) >> 1);
            if(arr[mid] >= value){
                if(mid == 0 || arr[mid-1] < value ){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    //findLessThanOrEqualsElementValue
    public static int findLessThanOrEqualsElementValue(int[] arr , int n , int value){
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + ((high - low ) >> 1);
                if(arr[mid] > value){
                    high = mid -1;
                }else{
                    if(mid == n - 1 || arr[mid + 1] > value){
                        return mid;
                    }else{
                        low = mid + 1;
                    }
                }
            }
        return -1;
    }

}
