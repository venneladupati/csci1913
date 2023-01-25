//Author: vennela dupati
public class KnownSpy {

    private String name;
    private CaesarCipher cObject;

    /**
     * constructor
     * @param name - name of spy
     * @param object - caesarcipher object
     */
    public KnownSpy(String name, CaesarCipher object) {
        this.name = name;
        this.cObject = object;
    }

    /**
     * 
     * @return name of KnownSpy 
     */
    public String getName() {
        return name;
    }

    /**
     * if object is from known spy, decrypt message
     * @param object - message given
     */
    public void decrypt(Message object) {
        if (object.getFrom() == getName()) {
            cObject.decrypt(object.getMessage());
        }
    }

    /**
     * 
     * @param array - array of known spies
     * @param object - given message
     * @return whether or not message is from a known spy in the array
     */
    public static boolean isFromSpy(KnownSpy[] array, Message object){
        int count = 0;
        for (int i = 0; i<array.length; i++) {
            if (array[i].getName() == object.getFrom()) {
                count +=1;
            }
        }

        return count == 1;
    }

    /**
     * 
     * @param encryptedCommonWord - encrypted word
     * @param commonwords - list of words
     * @return returns decrypted word if it is in the string of common words
     */
    public String tryDecrypt(String encryptedCommonWord, String commonwords) {
        String count = null;
        for (int i = 1; i<27; i++){
            CaesarCipher cipher = new CaesarCipher(i);
            if (commonwords.contains(" " + cipher.decrypt(encryptedCommonWord + " ")))  {
                count = cipher.decrypt(encryptedCommonWord);
            }
            
        }

        return count;
    }
}
