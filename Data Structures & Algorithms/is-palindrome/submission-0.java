class Solution {
    public boolean isPalindrome(String s) {
       List<Character> l = new ArrayList<>();
        for(int i = 0 ; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))) {
                l.add(Character.toLowerCase(s.charAt(i)));
            } else if(Character.isDigit(s.charAt(i))) {
                l.add(s.charAt(i));
            }
        }

        if(l.size() < 2) return true;
        int i = 0;
        int j = l.size()-1;
        while(i<j) {
            if(l.get(i) != l.get(j)) return false;
            i++; j--;
        }
        return true; 
    }
}
