// author : vennela dupati

public class SuperCipher extends BaseCipher {

    private BaseCipher[] types;

    public SuperCipher(BaseCipher[] types) {
        super("SuperCipher");
        this.types = types;
    }
    
    /*
     * checks if is every object is in supercipher object is valid
     */
    public boolean isValid() {
        boolean isValid = false;
        for (int i =0; i<types.length; i++) {
            if (types[i].isValid() == true) {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    /*
     * encrypts every item in supercipher object
     */
    public String encrypt(String text) {
        for(int i = 0; i<types.length; i++) {
            text = types[i].encrypt(text);
        }
        return text;
    }

    /*
     * decrypts every item in supercipher object
     */
    public String decrypt(String text) {
        for(int i = types.length-1; i>=0; i--) {
            text = types[i].decrypt(text);
        }
        return text;
    }

    /*
     * prints all the ciphers in supercipher object
     */
    public String toString() {
        String[] strArr = new String[types.length];
        for(int i = 0; i<types.length; i++) {
            strArr[i] = types[i].toString();
        }
        
        return "SuperCipher("+String.join(" | ", strArr)+")";
    }

    /*
     * checks if two supercipher objects were equal
     */
    public boolean equals(Object o) {
         if (o instanceof SuperCipher) {
            SuperCipher w = (SuperCipher) o;
            if (w.toString().equals(this.toString())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}