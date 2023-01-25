# CSCI 1913 Lab 01 Fall 2022
# Author: Vennela Dupati

import math

def steepest_angle(x):
    '''Finds the largest change in heights, calculates the resulting angle,
    and converts that value into degrees, which is then returned. Returns 0 if the 
    the list does not have ample data.'''

    dy= 0
    if len(x)>1:
        for i in range(len(x)-1):
            if abs(x[i+1]-x[i]) > dy:
                dy = abs(x[i+1]-x[i]) 

        radVal = math.atan2(dy,1)
        steepestAngle = math.degrees(radVal)  
    else:
        steepestAngle = 0.0

    return steepestAngle


def total_distance(x):
    '''Calculates the total distance traveled over the heights, and returns that value.Returns 0 if the 
    the list does not have ample data.'''

    y = 0
    if len(x)>1:
        for i in range(len(x)-1):
            y = y + distance(x[i+1],x[i])
                
        totalDistance = y  
    else:
        totalDistance = 0

    return totalDistance

def longest_sequential_climb(x):
    '''Calculating the total distances over increasing-height segments, and adds them to a list. Returns the list's maximum value, or returns 0 if the 
    the list does not have ample data.'''

    y=0
    climbs=[]

    if len(x)>1:
        for i in range(len(x)-1):
            if x[i+1]>x[i]:
                y = y + distance(x[i], x[i+1])
            else:
                climbs.append(y)
                y=0
    else:
        climbs.append(0)

    longestClimb = max(climbs)
    return longestClimb

def num_of_peaks_and_valleys(x):
    '''Identifies peaks and valleys and adds them into respective lists. Returns the lengths of these lists, or returns 0 if the 
    the list does not have ample data.'''

    peaks=[]
    valleys=[]
    if len(x)>2:
        for i in range(len(x)-2):
            if x[i+1]>x[i] and x[i+1]>x[i+2]:
                peaks.append(x[i+1])
            elif x[i+1]<x[i] and x[i+1]<x[i+2]:
                valleys.append(x[i+1])

        return (len(peaks),len(valleys))
    else:
        return (0,0)

def fill_valleys(x, y):
    '''Puts all the height values in a new list. Simultaneously replaces with values 
    lower than the given minimum with the given minimum. Returns this new list.'''
    
    filledValleys=[]

    for i in range(len(x)):
        if x[i]>=y:
            filledValleys.append(x[i])
        else:
            filledValleys.append(y)
    
    return filledValleys

    
def distance(x,y):
    '''Given two numbers, calculates the distance 
    between them with respect to altitude.'''

    return math.sqrt(((x-y)**2)+1)

