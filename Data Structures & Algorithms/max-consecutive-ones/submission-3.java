class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // iterate over array
        // increment j if one is consecutive
        // increment temp for next consecutive sequence
        // compare j to temp
        // return greater of j or temp
        int j = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                j++;
            }
            if (nums[i] == 0) {
                j = 0;
            }
            if (j > temp) {
                temp = j;
            }
        }
        return temp;
    }
}