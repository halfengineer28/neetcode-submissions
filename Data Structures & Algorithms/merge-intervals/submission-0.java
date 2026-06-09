class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
      List<int []> ans = new ArrayList<>();
      ans.add(intervals[0]);

      for (int [] interval : intervals){
        int start = interval[0];
        int end = interval[1];
        if(ans.get(ans.size()-1)[1]  >= start){
            ans.get(ans.size()-1)[1] = Math.max(end,  ans.get(ans.size()-1)[1]);

        }else{
            ans.add(interval);
        }
      }
    return ans.toArray(new int [ans.size()][]);

        
    }
}
