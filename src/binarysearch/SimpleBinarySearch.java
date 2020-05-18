package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
//        System.out.println(findFirstMatchElementIndex(arr, arr.length, 15)); //查找第一个值匹配的元素下标
//        System.out.println(findLastMatchElementIndex(arr, arr.length, 3)); //查找最后一个值匹配的元素下标
//        System.out.println(findGatherThanOrEqualsElementValue(arr, arr.length, 6)); //查找第一个大于等于匹配值的元素下标
//        System.out.println(findLessThanOrEqualsElementValue(arr, arr.length, 6));//查找最后一个小于等于匹配值的元素下标
//        System.out.println(totalMethod(3,null));
        //  获取一个数据的所有不重复子集(幂集)
//          int[] temp = {1,2,3};
//        List<List<Integer>> subsets = subsets(temp);
//        for (List<Integer> subset : subsets) {
//            System.out.println(subset.toString());
//        }


    }


    // 获取一个数据的所有不重复子集(幂集)
    public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, nums, 0);
        return res;
    }
    private static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        res.add(new ArrayList<Integer>(temp));
        for(int i = j; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }

    //有n个台阶, 每次可以走1个 或者2个, 一共有多少个走法 n为正整数
    public static  int totalMethod(int n,Map<Integer,Integer> hasSolvedMap) {
        if(hasSolvedMap == null ){
//            hasSolvedMap = Maps.newHashMap();
            hasSolvedMap = new HashMap<>();
        }
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (hasSolvedMap.containsKey(n)) {
            return hasSolvedMap.get(n);
        }

        int ret = totalMethod(n-1,hasSolvedMap) + totalMethod(n-2,hasSolvedMap);
        hasSolvedMap.put(n, ret);
        return ret;
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
