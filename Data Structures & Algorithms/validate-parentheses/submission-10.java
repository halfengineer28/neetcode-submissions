class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (!stack.isEmpty() && stack.peek() == map.get(ch)) {
                        stack.pop();
                }else{
                        return false;
                }
            }else{
                stack.add(ch);
            }
        }
        return stack.isEmpty();
    }
}
