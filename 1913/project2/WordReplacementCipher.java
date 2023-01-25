//Author: vennela dupati
public class WordReplacementCipher extends BaseCipher {
    
    private String originalWord;
    private String newWord;

    /**
     * constructor
     */
    public WordReplacementCipher(String originalWord, String newWord) {
        super("WordReplacementCipher");
        this.originalWord = originalWord;
        this.newWord = newWord;
    }

    /**
     * 
     * @param text - a string of text
     * @return - an encrypted version of the text, replacing original word with the new word
     */
    public String encrypt(String text) {

           return text.replace(originalWord, newWord);

    }

    /**
     * @param text - string of text
     * @return a decrypted version of the text, replacing new word with the original word
     */
    public String decrypt(String text) {

     return text.replace(newWord, originalWord);
    
    }

    public boolean equals(Object o) {
        if (o instanceof WordReplacementCipher) {
            WordReplacementCipher w = (WordReplacementCipher) o;
            if (w.toString().equals(this.toString())) {
                return true;
            } 
            else {
                return false;
            }
            } 
        else {
            return false;
        }
    
    }
    
    /**
     * @return the info of the cipher
     */
    public String toString() {
        return "WordReplacementCipher(" + originalWord + ", " + newWord + ")";
    }
}
