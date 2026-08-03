class PrefixTree {
    public class Node {
        Node[] child;
        boolean isEnd;
        Node() {
            child = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    public PrefixTree() {
        root = new Node(); 
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.child[ch-'a'] == null) {
                curr.child[ch-'a'] = new Node();
            }
            curr = curr.child[ch-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.child[ch-'a'] == null) return false;
            curr = curr.child[ch-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.child[ch-'a'] == null) return false;
            curr = curr.child[ch-'a'];
        }
        return true;
    }
}
