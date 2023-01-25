// vennela dupati csci 1913 project 3

import java.util.Random;

public class CharBag {

    private int[] array = new int[27];

    public CharBag() {
    }

    /**
     * adds a character's count into charbag
     * @param x - the character to be added
     */
    public void add(char x) {

        char let;
        if (x <= 'z') {
            String letter = String.valueOf(x);
            letter = letter.toLowerCase();
            let = letter.charAt(0);
        }
        else {
            let = '.';
        }


        int count =0;
        
        for (char c = 'a'; c<= 'z'; c++) {
            if (let != c){
                count += 1;
            }
            else {
                break;
            }
        }

        array[count] += 1;
    }


    /**
     * removes a character's count from charbag
     * @param x - the character to be added
     */
    public void remove(char x) {

        char let;
        if (x <= 'z') {
            String letter = String.valueOf(x);
            letter = letter.toLowerCase();
            let = letter.charAt(0);
        }
        else {
            let = '.';
        }


        int count =0;
        for (char c = 'a'; c<= 'z'; c++) {
            if (let != c){
                count += 1;
            }
            else {
                break;
            }
        }
        if (array[count] >0) {
            array[count] = array[count] - 1;
        }
    }

    /**
     * returns a character's count from charbag
     * @param x - the character
     */
    public int getCount(char x){
    
        char let;
        if (x <= 'z') {
            String letter = String.valueOf(x);
            letter = letter.toLowerCase();
            let = letter.charAt(0);
        }
        else {
            let = '.';
        }

            int count =0;
        for (char c = 'a'; c<= 'z'; c++) {
            if (let != c){
                count += 1;
            }
            else {
                break;
            }
        }

            return array[count];
        }

    /**
     * returns total amount of characters in charbag
     */
    public int getSize(){
        int total = 0;

        for(int x = 0; x<27; x++) {
            total = total + array[x];
        }

        return total;
    }

    /**
     *returns charbag in a string form
     */
    public String toString() {
        String answer = "CharBag{";
        int count = 0;

        for (char c = 'a'; c<= 'z'; c++) {
            answer = answer + c + ":" + array[count] + ", ";
            count = count +1; 
        }

        answer = answer + ".:" + array[26] + "}";

        return answer;
    }

    /**
     * returns a random character proportionately to its frequency in charbag
     */
    public char getRandomChar() {

        if (getSize() == 0) {
            return '.';
        }
        else {
        Random r = new Random();
        int count = r.nextInt(getSize());

        for (char c = 'a'; c<= 'z'; c++) {
            count -= getCount(c);
            if (count <0) {
                return c;
            }
        }
        return '.';
    }

    }
}
