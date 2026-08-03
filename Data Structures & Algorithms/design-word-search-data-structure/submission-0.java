public class WordDictionary {

    public class Node {
        Node[] child;
        boolean isEnd;
        Node() {
            child = new Node[26];
        }
    }

    public Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return dfs(root, word, 0);
    }

    private boolean dfs(Node node, String word, int index) {
        if (node == null) return false;

        if (index == word.length())
            return node.isEnd;

        char ch = word.charAt(index);

        if (ch == '.') {
            for (Node child : node.child) {
                if (child != null && dfs(child, word, index + 1))
                    return true;
            }
            return false;
        }

        return dfs(node.child[ch - 'a'], word, index + 1);
    }
}
