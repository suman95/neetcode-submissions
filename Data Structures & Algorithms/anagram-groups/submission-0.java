class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sorted = new String[strs.length];
        Map<String,List<Integer>> m= new HashMap<String,List<Integer>>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0 ; i < strs.length ; i++) {
            sorted[i] = strs[i].chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
            if(!m.containsKey(sorted[i])) m.put(sorted[i],new ArrayList<>());
            m.get(sorted[i]).add(i);
        }
        for(Map.Entry<String, List<Integer>> entry : m.entrySet()) {
            List<String> tmp = new ArrayList<>();
            for(int i = 0 ; i < entry.getValue().size(); i++) {
                tmp.add(strs[entry.getValue().get(i)]);
            }
            res.add(tmp);
        }
        return res;
    }
}
