class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
       HashMap<Character, Character> seen = new HashMap<>();
       seen.put(')', '(');
       seen.put(']', '[');
       seen.put('}', '{');

       for(char c : s.toCharArray()){
        if (seen.containsKey(c)){
            if (!stack.isEmpty() && stack.peek() == seen.get(c)){
                stack.pop();
            }else{
                return false;

            }
        }else{
            stack.push(c);
        }
       }
       return stack.isEmpty();
    }
}
