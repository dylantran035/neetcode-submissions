class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char paren = s.charAt(i);
            if (paren == '[' || paren == '{' || paren == '(') {
                stack.push(paren);
            }
            else {
                if (stack.isEmpty()) return false;
                switch (paren) {
                    case ']':
                        if (stack.peek() != '[')
                        return false;
                        break;
                    case '}':
                        if (stack.peek() != '{')
                        return false;
                        break;
                    case ')':
                        if (stack.peek() != '(')
                        return false;
                        break;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
