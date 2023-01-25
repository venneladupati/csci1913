//Author: vennela dupati
public class EvenOddCipher extends BaseCipher{
    

    public EvenOddCipher() {
        super("EvenOddCipher");
    }

    /**
     * 
     * @param text - a string of text
     * @return - an encrypted version of the text
     */
    public String encrypt(String text) {

        String answer = "";
        for (int i=0; i<text.length(); i+=2) {
            answer += text.charAt(i);
            }
        for (int i = 1; i<text.length(); i+=2) {
            answer += text.charAt(i);
        }

        return answer;
    }

    /**
     * @param text - string of text
     * @return a decrypted version of the text
     */
    public String decrypt(String text) {
        String answer = "";
        int crossover = (int) Math.ceil((double) text.length()/2);
        
        if (text.length()%2 == 0) {
            for (int i=0; i<text.length()/2; i++) {
    
                answer += text.charAt(i);
                answer += text.charAt(i+crossover);
                }
        }
        else {
        for (int i=0; i<crossover; i++) {

            answer += text.charAt(i);
            if(i+crossover < text.length()) {
                answer += text.charAt(i+crossover);
            }
            }
            
            }
        
        
        return answer;
    
}

    /**
     * @param text - an object
     * @return whether or not the object is an instance of the class
     */
    public boolean equals(Object o) {
        if (o instanceof EvenOddCipher) {
            EvenOddCipher w = (EvenOddCipher) o;
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
        return "EvenOddCipher";
    }
}
