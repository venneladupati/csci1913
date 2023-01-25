//Author: vennela dupati
public class CaesarCipher extends BaseCipher{
    
    private int key;
    private String allLetters = "abcdefghijklmnopqrstuvwxyz";

    /**
     * constructor
     * @param key - rotation increment
     */
    public CaesarCipher(int key) {
        super("Caeser Cipher");
        this.key = key;
    }


    /**
     * @return - whether or not the key is valid
     */
    public boolean isValid() {
        if (key >= 1) {
            return key <= 25;
        }

        else {
            return false;
        }
    }

    /**
     * 
     * @param text - a string of text
     * @return - an encrypted version of the text rotated with the key
     */
    public String encrypt(String text) {

        String newText = text.toLowerCase();
        String encrypted = "";

        for (int i = 0; i<newText.length(); i++) {
            if (allLetters.indexOf(newText.charAt(i)) >= 0){
                encrypted += rotate(newText.charAt(i),key);
            }
            else {
                encrypted += (newText.charAt(i));
            }
        }  
        return encrypted;
    }

    /**
     * @param text - string of next
     * @return a decrypted version of the text rotated by the key
     */
    public String decrypt(String text) {

        String newText = text.toLowerCase();
        String decrypted = "";

        for (int i = 0; i<newText.length(); i++) {
            if (allLetters.indexOf(newText.charAt(i)) >= 0){
                decrypted += rotate(newText.charAt(i),-1 * key);
            }
            else {
                decrypted += (newText.charAt(i));
            }
        
        }
        return decrypted;   
    }

    /**
     * @param text - an object
     * @return whether or not the object is an instance of the class
     */
    public boolean equals(Object o) {
        if (o instanceof CaesarCipher) {
            CaesarCipher w = (CaesarCipher) o;
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
     * 
     * @param letter - a character
     * @param key - rotation increment
     * @return - rotates the letter based on the given key
     */
    private char rotate(char letter, int key) {
        
        int position = allLetters.indexOf(letter);
        int newPosition = (position + key) % 26;
        if (newPosition < 0 ){
            newPosition = allLetters.length() + newPosition;
        }
        char newLetter = allLetters.charAt(newPosition);
        return newLetter;
    }
    
    /**
     * @return the info of the cipher
     */
    public String toString() {
        return "Caesar(" + key + ")";
    }
}
