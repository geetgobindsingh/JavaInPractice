package leetcode.medium;

public class ImplementTrie {

    static class Trie {

        public final Trie[] tree;
        boolean isEnd = false;

        public Trie() {
            this.tree = new Trie[26];
        }

        public void insert(String word) {
            if (word.isEmpty()) return;
            Trie t = this;
            for (char c : word.toCharArray()) {
                if (t.tree[c - 'a'] == null) {
                    t.tree[c - 'a'] = new Trie();
                }
                t = t.tree[c - 'a'];
            }
            t.isEnd = true;
        }

        private Trie searchPrefix(String word) {
            if (word.isEmpty()) return null;
            Trie t = this;
            for (char c : word.toCharArray()) {
                if (t.tree[c - 'a'] == null) return null;
                t = t.tree[c - 'a'];
            }
            return t;
        }

        public boolean search(String word) {
            if (word.isEmpty()) return false;
            Trie t = searchPrefix(word);
            return t != null && t.isEnd;
        }

        public boolean startsWith(String prefix) {
            if (prefix.isEmpty()) return false;
            Trie t = searchPrefix(prefix);
            return t != null;
        }
    }
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }


}
