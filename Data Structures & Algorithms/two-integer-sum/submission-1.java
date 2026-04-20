class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        int difference = 0;
        for (int i = 0; i < nums.length; i++) {
            difference = target - nums[i];

            if (numMap.containsKey(difference)){
                return new int[] {numMap.get(difference), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
