class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> Math.abs(a-x) != Math.abs(b-x) ? Math.abs(b-x) - Math.abs(a-x) : b - a);


    for (int num : arr){

        maxheap.add(num);
        if (maxheap.size() > k){
            maxheap.poll();
        }

    }

    while (!maxheap.isEmpty()){
        ans.add(maxheap.poll());
    }

    Collections.sort(ans);
    return ans;
  }
}