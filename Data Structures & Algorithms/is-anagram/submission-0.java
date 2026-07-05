class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map1 = new int[27];
        int[] map2 = new int[27];
        for(int i = 0 ; i < 27; i++){
            map1[i] = 0;
            map2[i] = 0;
        }
        for(int i = 0 ; i < s.length() ; i++) {
            map1[s.charAt(i) - 'a'] +=1;
            map2[t.charAt(i) - 'a'] +=1;
        }
        for(int i = 0 ; i < 27; i++) {
            if(map1[i] != map2[i]) return false;
        }
        return true;
    }
}
