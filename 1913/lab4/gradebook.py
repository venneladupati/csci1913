# CSCI 1913 Lab 04 Fall 2022
# Authors: Vennela Dupat, Wendy Meng

def is_sorted(gradebook):
    '''checks if the gradebook is sorted'''
    count = ""
    if gradebook == []:
        return True
    for x,y in gradebook:
        if y>count:
            count = y
        else:
            return False
    return True


def grade_average(gradebook):
    '''returns average grade in gradebook'''
    if gradebook == []:
        return 0.0
    count = 0
    for x,y in gradebook:
        count = count + x
    
    gpa = (count)/(len(gradebook))
    return gpa
    

def unsorted_get(gradebook,name):
    '''returns the grade of a given name'''
    value = None
    for x,y in gradebook:
        if y == name:
            value = x
    
    return value



def unsorted_put(gradebook, name, grade):
    '''changes the grade of a name in gradebook. if name is not in gradebook, this function adds the 
    name and their grade '''
    count = 0

    for x,y in gradebook:
        if y == name:
            gradebook.insert(gradebook.index((x,y)),(grade,name))
            gradebook.remove((x,y))
        else:
            count = count + 1
    
    if count == len(gradebook):
        gradebook.append((grade,name))

def sorted_get(gradebook, name):
    '''returns grade of given name in a sorted gradebook using binary search'''

    low = 0
    high = len(gradebook) - 1

    while high >= low:
        mid = (high + low) // 2
        (x,y) = gradebook[mid] 
        if y < name:
            low = mid + 1
        elif y > name:
            high = mid - 1
        else:
            return x
    return None

def sorted_put(gradebook, name , grade):
    '''changes the grade of a name in a sorted gradebook. if name is not in gradebook, this function adds the 
    name and their grade in the correct position, ensuring that the gradebook is still sorted'''
    count = 0
    val = 0

    for x,y in gradebook:
        if y == name:
            gradebook.insert(gradebook.index((x,y)),(grade,name))
            gradebook.remove((x,y))
        else:
            count = count + 1
    
    if count == len(gradebook):
        for x,y in gradebook:
            if name>y:
                val = val + 1

        if val == 0:
            gradebook.insert(0,(grade,name))
        elif val == len(gradebook):
            gradebook.append((grade,name))
        else:
            gradebook.insert(val,(grade,name))

