import java.util.HashMap;

public class TrieNode{

    Character value;
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(char value, boolean isWord){
        this.value = value;
        this.isWord = isWord;
        children = new HashMap<Character, TrieNode>();
    }

    public void addChild(char value, boolean isWord){
        children.put(value, new TrieNode(value, isWord));
    }

}