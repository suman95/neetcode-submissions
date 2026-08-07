class Solution {
    public class Pair {
        int p,s;
        float ttl;
        Pair(int p, int s,float ttl) {
            this.p = p;
            this.s = s;
            this.ttl = ttl;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0 ; i < position.length ; i++) {
            list.add(new Pair(position[i],speed[i], (float) (target-position[i])/(float) speed[i]));
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.p - o1.p;
            }
        });
//        for(Pair p : list){
//            System.out.print("{"+p.p+"," +p.s+","+p.ttl+"},");
//        }
        Stack<Float> s = new Stack<>();
        s.push(list.get(0).ttl);
        for(int i = 1 ; i < list.size() ; i++) {
            if(list.get(i).ttl > s.peek()) {
                s.push(list.get(i).ttl);
            }
        }
        return s.size();
    }
}
