//vennela dupati 1913 project 3

public class Gibberisher {
    
    private Trie<CharBag> storage;
    private int segLength;
    private int processed;

    public Gibberisher(int segLength){
        this.segLength = segLength;
        storage = new Trie<>();
        processed = 0;
    }

    /**
     * generates lettersamples from strings passed in and add each sample into storage
     * @param array - strings passed in
     */
    public void train(String[] array) {
        for (int i=0; i<array.length; i++){

            LetterSample[] result = LetterSample.toSamples(array[i],segLength);
            processed += result.length;

            for (int x =0; x< result.length; x++) {
                CharBag cb = storage.get(result[x].getSegment());
                if (cb == null) {
                    CharBag sb = new CharBag();
                    cb = storage.put(result[x].getSegment(), sb);
                }
                cb.add(result[x].getNextLetter());

            }

        }
    }

    /**
     * 
     * @return number of letter samples processed
     */
    public int getSampleCount() {
        return processed;
    }

    /**
     * @return a generated string
     */
    public String generate(){
        String word = "";
        char x = 'a';
        while (x != LetterSample.STOP){

            String str = word;

            if (word.length() > segLength){
                str = word.substring(word.length() - segLength);
            }

            char y = storage.get(str).getRandomChar();
            x = y;
            word +=y;
        }
        return word.substring(0, word.length() - 1);
        }

    }

            


