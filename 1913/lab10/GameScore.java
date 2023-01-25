// author : vennela dupati
/*
 * GameScore class creates an object in the GameScore class, with methods to access it's name, score, and mode.
 * It can also return a string of its attributes, and compare it to an object in the GameScore class.
 */

public class GameScore implements Comparable<GameScore>{

    private double score;
    private String name;
    private boolean hardMode;

    public GameScore(String name, double score, boolean hardMode) {
        this.name = name;
        this.score = score;
        this.hardMode = hardMode;
    }
    

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
    
    public boolean isHardMode() {
        return hardMode;
    }

    /*
     * returns string of all GameScore variables
     */
    public String toString() {
        String answer = name + " " + score;
        if (hardMode == true) {
            answer += "*";
        }
        return answer;
    }

/*
 * returns whether or not current GameScore object is equal to object in parameter
 */
public boolean equals(Object o) {

    if (o instanceof GameScore) {
        GameScore w = (GameScore) o;
        if (w.name.equals(this.name) == false) {
            return false;
        } 
        else if (w.getScore() != this.getScore()) {
            return false;
        } 
        else {
            return w.isHardMode() == this.isHardMode();
        }
        } 
    else {
        return false;
    }

        
}

/*
 * returns whether or not current GameScore is equal to gamescore passed in parameter
 */
@Override
public int compareTo(GameScore other) {
    if (this.hardMode == true && other.hardMode == false) {
        return 1;
    }
    else if (this.hardMode == false && other.hardMode == true) {
        return -1;
    }
    else if (this.score > other.score) {
        return 1;
    }
    else if (other.score > this.score) {
        return -1;
    }
    else {
        return 0;
    }
    }
}

