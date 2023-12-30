class Solution {
  public String minWindow(String s, String t) {
    HashMap<Character,Integer> map2 = new HashMap();
    HashMap<Character,Integer> map1 = new HashMap();
    String ans = "";

  for (int i = 0; i < t.length(); i++) {
    char ch = t.charAt(i);
    map2.put(ch, map2.getOrDefault(ch, 0) + 1);
  }

  int matchCount = t.length();
  int currMatch = 0;
  int start = 0;

  for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    map1.put(ch, map1.getOrDefault(ch, 0) + 1);

    if(map2.containsKey(ch) && map1.get(ch) <= map2.get(ch)) {
      currMatch++;
    }

    while (matchCount == currMatch) {
      String temp = s.substring(start, i+1);
      if(ans == "" || ans.length() > temp.length()) {
        ans = temp;
      }

      char chr = s.charAt(start);
      map1.put(chr, map1.get(chr) - 1);

    if(map2.containsKey(chr) && map2.get(chr) > map1.get(chr)) {
      currMatch--;
    }
      start++;
    }
  }
    return ans;
  }
