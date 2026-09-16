class PrefixTree {

    // Each node has 26 possible children (a-z)
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            // Create node if it doesn't exist
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        // Mark the end of the complete word
        current.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        // Must be the end of an inserted word
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char c : prefix.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        // If we reached here, the prefix exists
        return true;
    }
}