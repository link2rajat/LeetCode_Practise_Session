class Solution {
    public  List<Integer> findAnagrams(String s, String p) {
 List<Integer> ans = new ArrayList<>();

        int windowStart = 0;
        int missingCharacters = p.length();

        HashMap<Character, Integer> origMap = new HashMap<>();
        HashMap<Character, Integer> currentMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            int count = origMap.getOrDefault(p.charAt(i), 0);
            origMap.put(p.charAt(i), count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Integer charCount = currentMap.getOrDefault(s.charAt(i), 0) + 1;
            currentMap.put(s.charAt(i), charCount);

            //Hash comparison
            if (origMap.containsKey(s.charAt(i))) {
                if (charCount <= origMap.get(s.charAt(i))) {
                    missingCharacters--;
                }
            }
            // hash comparison ends

            if ((i - windowStart + 1) == p.length()) {
                if (missingCharacters == 0) {
                    ans.add(windowStart);
                }

                // rehashing begins
                char ch = s.charAt(windowStart);
                currentMap.put(ch, currentMap.get(ch) - 1);
                if (origMap.containsKey(ch)) {
                    if (currentMap.get(ch) < origMap.get(ch)) {
                        missingCharacters++;
                    }
                }
                // rehashing ends

                windowStart++;
            }
        }

        return ans;
    }
}//T-O(N+M),S-(1) ->N is length of s and m is length of p , S is 1 since origMap and curr Map contains only 26 chars