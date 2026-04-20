class Solution {

    public String encode(List<String> strs) {
        String encoded_string = "";

        for (String str : strs) {
            encoded_string += str.length() + "#" + str;
        }
        return encoded_string;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < str.length();) {
            int j = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, j));

            strs.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return strs;
    }
}
