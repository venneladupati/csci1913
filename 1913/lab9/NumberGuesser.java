// lab9 author: vennela dupati

import java.util.Random;

public class NumberGuesser extends Game {

    private Random rng;
    private int maxNumber;
    private int maxGuesses;

    private int secret;
    private int guessCount;
    private boolean ifCorrect;


    /**
     * constructor
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses) {
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;

    }

    /**
     * @return name for menu system
     */
    @Override
    public String getName() {
        return "NumberGuesser";
    }

    /**
     * sets up for a new game by creating a new secret number
     * also updates the guess-count number and the ifCorrect variable
     * @return a message indicating the range of possible numbers and number of guesses
     */
    @Override
    protected String prepToPlay() {
        secret = rng.nextInt(maxNumber) +1;
        guessCount = 0;
        ifCorrect = false;

        return "I've picked a number from 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }

    /**
     * Check if move entered is a positive integer
     */
    @Override
    protected boolean isValid(String move) {

        if (move.length() > 0 && move.charAt(0) == '-') {
            return false;
        }
        if (move.length() == 0) {
            return false;
        }
        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * check if the game is over
     */
    @Override
    protected boolean isOver() {
        return guessCount == maxGuesses || ifCorrect == true;
    }

    /**
     * Check if the move is the answer or not.
     */
    @Override
    protected String processMove(String move) {
        int guess = Integer.parseInt(move);

        if (guess>secret) {
            guessCount += 1;
            ifCorrect = false;
            return "Too High";
        }
        if (guess<secret) {
            guessCount += 1;
            ifCorrect = false;
            return "Too Low";
        }
        else {
            guessCount += 1;
            ifCorrect = true;
            return "That's it!";
        }
    
    }

    /**
     * print game's final message
     */
    @Override
    protected String finalMessage() {
        
        return "The number was: " + secret;
    }



}
