public class TrieDriver{
    public static void main(String[] args){
        Trie wordTrie = new Trie();
        wordTrie.add("Hello");
        wordTrie.add("Yes");
        wordTrie.add("Goodbye...");
        System.out.println(wordTrie.contains("Hello"));
        System.out.println(wordTrie.contains("Not here."));
        System.out.println(wordTrie.contains("test should return no"));
        System.out.println(wordTrie.contains("goodbye..."));
        System.out.println(wordTrie.contains("Goodbye..."));
        System.out.println(wordTrie.contains("Goodbye...!!"));
    }
}