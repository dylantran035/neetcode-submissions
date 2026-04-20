class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length  + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        }

        int[] res = new int[k];
        int counter = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (counter != k) {
                if (buckets[i] != null) {
                    for (int num : buckets[i]) {
                        res[counter] = num;
                        counter++;
                    }
                }
            }
        }
        return res;
    }
}
