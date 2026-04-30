class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs){
            sb.append(str.length()).append('#').append(str);
        }

    return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }
            String sub = str.substring(i, j);
            int length = Integer.parseInt(sub);

            i = j + 1;
            ans.add(str.substring(i, i + length));
            i = i + length;
           

        }

        return ans;

    }
}
