class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack <Double> stack = new Stack<>();
        int [][] dest = new int [position.length][2];
        for(int i = 0; i< position.length; i++){
                dest[i][0] = position[i];
                dest[i][1] = speed[i];
        }
        
        Arrays.sort(dest,(a, b) -> Integer.compare(b[0], a[0]));
        for(int [] p : dest){
            stack.push((double)(target-p[0])/p[1]);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size()-2) ){
                stack.pop();
            }
        }
        return stack.size();

    }
}
