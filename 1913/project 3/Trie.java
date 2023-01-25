// vennela dupati 1913 project 3

public class Trie<T> {

    private TrieNode<T> root;

    public Trie() {
        root = new TrieNode<>();
    }

    /**
     * 
     * @param x - passed in string
     * @return  trienode assoicated with string
     */
    private TrieNode<T> getNode(String x) {
        TrieNode<T> node = root;
        for(int  i=0; i<x.length(); i++) {
           node = node.getChild(x.charAt(i));
        }   

        return node;
    
    }

    /**
     * 
     * @param x - string
     * @return - gets data currently stored on trienode associated with input string
     */
    public T get(String x) {
        return getNode(x).getData();
    }

    /**
     * sets data currently stored on trienode associated with input string to T value 
     * @param x - string
     * @param data - <T> data
     * @return data currently stored on trienode assoicated with string
     */
    public T put(String x, T data) {
        TrieNode<T> node = getNode(x);
        node.setData(data);
        return node.getData();
    }






}
