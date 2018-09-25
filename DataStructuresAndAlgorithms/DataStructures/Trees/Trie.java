public class Trie{

    TrieNode root;

    public Trie(){
        root = new TrieNode((char)0, false);
    }

    public boolean contains(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            if(current.children.containsKey(word.charAt(i)))
                current = current.children.get(word.charAt(i));
            else
                return false;
        }
        return true;
    }

    public void add(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            Character currentChar = word.charAt(i);
            if(current.children.containsKey(currentChar))
                current = current.children.get(currentChar);
            else{
                current.children.put(currentChar, new TrieNode(currentChar, false));
                current = current.children.get(currentChar);
            }
        }
        current.isWord = true;
    }

}