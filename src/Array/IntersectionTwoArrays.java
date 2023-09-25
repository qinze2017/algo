package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: java_algo
 * @description: Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * appear as many times as it shows in both arrays and you may return the result in any order.
 * https://medium.com/@punitkmr/intersection-of-two-arrays-ii-ffb26f04dfd1
 * @author: Ze QIN
 * @create: 2023-09-15 19:06
 **/
public class IntersectionTwoArrays {

    public int[] intersectList(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length==0  || nums2.length==0)
            return new int[0];

        /*sorting, would be better since it does not need extra memory.*/
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;

        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();


        while(i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        int[] nums = new int[list.size()];

        for (int k=0; k< list.size(); k++) {
            nums[k] = list.get(k);
        }
        return nums;
    }

    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                int freq = map.get(num);
                freq--;
                map.put(num, freq);
            }
        }

        int[] nums = new int[result.size()];

        for (int k=0; k< result.size(); k++) {
            nums[k] = result.get(k);
        }
        return nums;
    }

    public static void main (String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        IntersectionTwoArrays ista = new IntersectionTwoArrays();
        //int[] nums = ista.intersectList(nums1, nums2);
        int[] nums = ista.intersectHashMap(nums1, nums2);

        for(int i = 0; i <= nums.length-1; i++){
            System.out.println(nums[i]);
        }

    }
}
