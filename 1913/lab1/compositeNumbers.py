# CSCI 1913 Lab 01 Fall 2022
# All assignments should start with a "header comment" like this one.
# it should list what the file is (lab01 fall 2022) and who wrote it (below)
# This will be a standing REQUIREMENT for the whole semester.
# Authors: TODO: Vennela Dupati


# NOTE: You should pay attention to how this file is structured -- you'll be making these files on your own after this
# lab -- so you'll want to know about all the "details" (other than correct code) that we expect! The big things to pay
# attention to here is the header comment at the top, and the docstrings (STRINGS on the first line of a function
# describing what the function does) -- this is a formal part of the programming language that is used to document code.

def num_divisors(n):
    """Given an integer input n, return the number of positive integers that are divisors of n
    (including 1 and itself)"""
    y=0
    for x in range(1,n+1):
        if n%x==0:
            y=y+1
    
    return y






# hard to make this NOT work on negative numbers with num_divisors being weird for negatives.
def is_highly_composite_number(n):
    """ an integer n is a highly composite number if and only if it is a positive integer with
    more divisors than any positive interger smaller than it."""
    y=True
    if n<0:
        return False

    elif n == 0:
        return False

    else:
        for x in range(n):
            if num_divisors(x) >= num_divisors(n):
                y=False
        return y

    


def kluver_cat_name():
    '''returns name of Daniel's cat'''
    return ("Willow")



