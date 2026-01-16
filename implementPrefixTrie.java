public class implementPrefixTrie{
    static class Trie{
        Trie children[] = new Trie[26];
        boolean endOfWord = false;

        public Trie(){
            for(int i = 0; i < children.length; i++){
                children[i] = null;
            }
        }
    }

    // In leetcode class Trie is already defined. So if we want to use the wrapper class directly we can use this method.
    // Instead of creating a totally different class, we can just create class Node directly

    // When running on leetcode, use this instead of `static class trie`:

    // class Node{
    //     Node children[] = new Node[26];
    //     boolean endOfWord;
    // }

    public Trie root = new Trie();

    public void insert(String word){
        Trie curr = root;

        for(int level = 0; level < word.length(); level++){
            int index = word.charAt(level) - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new Trie();
            }

            curr = curr.children[index];
        }

        curr.endOfWord = true;
    }

    public boolean search(String key){ //O(L)
        Trie curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    public boolean startsWith(String prefix){
        Trie curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String[] args){
        implementPrefixTrie trie = new implementPrefixTrie();

        System.out.println("null");                     // Trie()

        trie.insert("apple");
        System.out.println("null");                     // insert

        System.out.println(trie.search("apple"));       // true
        System.out.println(trie.search("app"));         // false
        System.out.println(trie.startsWith("app"));     // true

        trie.insert("app");
        System.out.println("null");                     // insert

        System.out.println(trie.search("app"));         // true
    }

}