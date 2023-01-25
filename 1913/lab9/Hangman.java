public class Hangman extends Game {

        private WordsList words;
        private int maxWordLen;
        private int maxGuesses;
        private int minWordLen;
    
        private String secret;
        private int guessCount;
        private String clueString;
        private boolean ifCorrect = false;
    
    
        /**
         * constructor
         */
        public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses) {
            this.words = words;
            this.maxWordLen = maxWordLen;
            this.maxGuesses = maxGuesses;
            this.minWordLen = minWordLen;
    
        }

        /**
        * @return name for menu system
        */
        @Override
        public String getName() {
            return "Hangman";
        }

        protected String prepToPlay() {
            ifCorrect = false;
            secret = words.getWord(minWordLen,maxWordLen);
            guessCount = 0;
            clueString = "";
            for (int i = 0; i < secret.length(); i++) {
                clueString += "_";
            }
            return "I've picked a " + secret.length() + " letter word. Guess letters you think are in the word. You get " + maxGuesses + " guesses.";
        }

        /**
        * check if the game is over
         */
        @Override
        protected boolean isOver() {
            return ifCorrect == true || guessCount == maxGuesses;
        }

        /**
         * Check if move entered is a single letter
         */
        @Override
        protected boolean isValid(String move) {
            String alpha = "abcdefghijklmnopqrstuvwxyz";
            if (move.length() == 1 && alpha.contains(move)) {
                return true;
            }
            else {
                return false;
            }
        }

    /**
     * Check if the move is the answer or not.
     */
    @Override
    protected String processMove(String move) {
        guessCount += 1;
        char letter = move.charAt(0);
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == letter) {
                clueString = clueString.substring(0, i) + letter + clueString.substring(i + 1);
            }
        }
        if (clueString == secret) {
            ifCorrect = true;
        }
        return clueString;
    }

    /**
     * print game's final message
     */
    @Override
    protected String finalMessage() {
        
        return "The word was: " + secret;
    }


}