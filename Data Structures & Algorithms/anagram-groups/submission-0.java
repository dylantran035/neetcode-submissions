class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            List<String> group = map.getOrDefault(sorted, new ArrayList<>());
            group.add(str);
            map.put(sorted, group);
        }
        return new ArrayList<>(map.values());        
    }
}
