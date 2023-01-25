// vennela dupati 1913 project 3

public class TrieNode<T> {

    private T data;

    private TrieNode<T>[] children = new TrieNode[26];

    public TrieNode() {
        data = null;
        for(int i=0; i<26; i++) {
            children[i] = null;
        }
    }

    /**
     * 
     * @return data from trienode
     */
    public T getData() {
        return data;
    }

    /**
     * sets data value in trienode
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 
     * @param letter character passed in
     * @return trienode associated with certain character. if there is none, creates one and returns it.
     */
    public TrieNode<T> getChild(char letter) {
        if (letter <= 'z') {

            int count = 0;
            for (char c = 'a'; c<= 'z'; c++) {
                if (letter != c){
                    count += 1;
                }
                else {
                    break;
                }
            }

            if (children[count] != null) {
                return children[count];
            }
            else {
                children[count] = new TrieNode<T>();
                return children[count];
            }
        }
        else {
            return null;
        }
    }



}
