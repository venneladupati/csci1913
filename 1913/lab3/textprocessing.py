# CSCI 1913 Lab 03 Fall 2022
# Author: Vennela Dupati
from cmath import sqrt
import math

def generate_words_list(list):
    '''Takes a string and returns a list where said string is split into words with 
no spaces'''

    new_list = list.split()
    return new_list

def remove_stop_words(list,set):
    '''Compares list to set of common words in dictionary and 
    returns list with all common words removed  '''
    new_list = []

    for i in range(len(list)):
        if list[i] not in set:
            new_list.append(list[i])

    return new_list

def word_count(x):
    '''takes a word in a string and returns how many times the 
    word appeared in the string. returns in a dictionary format.  '''
    words_list=generate_words_list(x)
    count_list= []
    dictionary = {}

    for x in words_list:
        count = 0

        for i in range(len(words_list)):
            if x == words_list[i]:
                count = count+1

        count_list.append(count)

    for i in range(len(words_list)):
        dictionary[words_list[i]]= count_list[i]

    return dictionary

def get_longest_words(x):
    '''Takes a string and returns all the longest words in a set'''
    words_list=generate_words_list(x)
    longestSet = set()
    count=0

    for x in words_list:
        if len(x) == count:
            longestSet.add(x)
            count = len(x)
        elif len(x) > count:
            longestSet.clear()
            longestSet.add(x)
            count = len(x)

    return longestSet

def cal_cosine_similarity(x,y):
    '''Calculates cosine similarity between two dictionaries'''
    S1 = 0
    for i in x.values():
        S1= i**2 + S1

    S2 = 0
    for i in y.values():
        S2= i**2 + S2

    S3 = 0
    for i in x.keys():
        if i in y.keys():
            S3 = (x[i] * y[i]) + S3
            
    if S1 or S2 != 0 :
        cos_sim = (S3/((math.sqrt(S1))*(math.sqrt(S2))))
    else:
        cos_sim = 0.0

    return round(cos_sim,4)

def most_similar_string(x,y):
    '''Takes a string and a list of strings, and returns the string that is most similar
    to the original string '''
    count = 0
    mostSim = 0

    if len(y)>0:

        for i in range(len(y)):
            if cal_cosine_similarity(word_count(x),word_count(y[i])) > count:
                count = cal_cosine_similarity(word_count(x),word_count(y[i]))
                mostSim = y[i]
    else: 
        mostSim = ""
     
    return mostSim
