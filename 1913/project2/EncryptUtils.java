
// author : vennela dupati
public class EncryptUtils {
    /*
     * encrypts every item in list using given cipher adn returns new array
     */
    public static String[] encryptMany(BaseCipher cipher, String[] list) {
        String [] newArray = new String[list.length];

        for(int i=0; i<list.length; i++) {
        newArray[i] = cipher.encrypt(list[i]);
        }
        return newArray;
    }

    /*
     * encrypts every item in list using given cipher and returns new array
     */
    public static String[] decryptMany(BaseCipher cipher, String[] list) {
        String [] newArray = new String[list.length];

        for(int i=0; i<list.length; i++) {
        newArray[i] = cipher.decrypt(list[i]);
        }
        return newArray;
    }


}