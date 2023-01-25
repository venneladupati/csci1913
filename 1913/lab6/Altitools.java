/*
 * CSCI 1913
 * Lab 06
 * Author: Vennela Dupati
 * */

// keep this line.
import java.lang.Math;
// this line will let you use function from the Java math package:
// details here: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Math.html
// but a few functions you might need:
// Math.abs(number)
// Math.atan2(y, x)
// Math.pow(a,b) (which equals a^b)
// Math.toDegrees(radians)
// Math.sqrt(number)
// Use these roughly as written (so include the "Math." part)

public class Altitools {

    /**
     * Computes the steepest angle (Raising or falling) in a mountain range
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return the steepest upward/downward angle in the mountain range as a positive value measured in degrees.
     */
    public static double steepest_angle(double [] mountainRange) {
        double dy = 0;
        double steepestAngle = 0.0;
        if (mountainRange.length>1) {
            for (int i = 0; i<(mountainRange.length - 1); i++) {
                if((Math.abs(mountainRange[i+1]-mountainRange[i]) > dy)) {
                    dy = Math.abs(mountainRange[i+1]-mountainRange[i]) ;
                }
            }
        
            double radVal = Math.atan2(dy,1);
            steepestAngle = Math.toDegrees(radVal);  
        }

        return steepestAngle;
        
    }

    /**
     * Get the total "travel distance" over a mountain range
     * @param mountainRange an array of doubles representing the heights of a mountain range.  Will not be modified
     * @return the travel distance -- a non-negative double.
     */
    public static double total_distance(double [] mountainRange) {
        // replace with real code
        double y = 0;
        double totalDistance = 0;

        if (mountainRange.length>1) {
        for(int i = 0; i < mountainRange.length-1; i++) {
            y = y +  Math.sqrt(Math.pow((mountainRange[i+1]-mountainRange[i]),2)+1);
        totalDistance = y; 
        }

        }
    return totalDistance;
    }

    /**
     * compute the longest (in terms of travel distance) seuqentially climbing part of a mountain range.
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return the latest travel distance of any sequentially climbing segment of the mountain range
     */
    public static double longest_sequential_climb(double [] mountainRange) {
        double y=0;
        double currentClimb = 0;
        double longestClimb = 0;
    
        if (mountainRange.length>1) {
            for(int i = 0; i<mountainRange.length-1; i++) {
                if (mountainRange[i+1]>mountainRange[i]) {
                    y = y +  Math.sqrt(Math.pow((mountainRange[i+1]-mountainRange[i]),2)+1);
                    currentClimb = y;
                }                   
                else {
                    if(currentClimb>longestClimb) {
                        longestClimb = y;
                        y = 0; 
                    }
                }
                }

             }
             if (longestClimb > 0) {
                return longestClimb;
             }
             else {
                return currentClimb;
             }
            }
    
    

    /**
     * compute the numebr of peaks (higher than it's neighbors) and valleys (lower than it's neighbors) in a mountain
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return a length 2 int array. position 1 is the number of peaks and position 2 the number of valleys.
     */
    public static int[] num_of_peaks_and_valleys(double [] mountainRange){

        int peak = 0; 
        int valley = 0;
        if (mountainRange.length >2) {
        for (int i = 0; i < mountainRange.length-2; i++) {
            if (mountainRange[i+1]>mountainRange[i] && mountainRange[i+1]>mountainRange[i+2]) {
                peak = peak + 1; }
            else if ( mountainRange[i+1]<mountainRange[i] && mountainRange[i+1]<mountainRange[i+2]) {
                valley = valley + 1;
            }
        }
        return new int [] {peak,valley};
        }
    else {
        return new int [] {0,0};
    }
    }

    /**
     * Creates a new array to indicate what would happen if we were to hypothetically fill the lowest parts of a
     * mountain range up to a fixed height
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @param target a double. the new array will have all positions below this filled up to this height
     * @return a new array showing the result of filling in the array
     */
    public static double[] fill_valleys(double [] mountainRange, double target){
        double [] filledValleys = new double[mountainRange.length];

    for(int i = 0; i<mountainRange.length; i++) {
        if (mountainRange[i]>=target) {
            filledValleys[i] = mountainRange[i]; }
        else {
        filledValleys[i] = target;
        }
    }
    return filledValleys;
    
    }

    public static int galoob (int [] dat, int k) {
        int prod = 1;
        for (int i = k-1; i <= k+1; i++) {
            prod *= dat[i];
        
        }
        System.out.println(prod);
        return prod;
        
        }
        

}
