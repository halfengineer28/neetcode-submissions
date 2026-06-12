class Solution {
  public int numRescueBoats(int[] people, int limit) {
    int count = 0;
    int start = 0;
    int end = people.length - 1;
    Arrays.sort(people);

    while (start <= end) {
      if (people[start] + people[end] <= limit) {
        count++;
        start++;
        end--;
      } else {
        count++;
        end--;
      }
    }
    return count;
  }
}