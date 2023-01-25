# CSCI 1913 Fall 2022
# Author: Vennela Dupati

# QUESTIONS -- DO THESE LAST.
# Assumptions: assume the letter grid has width W and height H
# Further assume the word parameter has length L (for find) and than the max_len parameter is L (for extract)
# Finally, Assume that concatenating a letter to a string takes time O(1)
# List any other assumptions you make.

# For each question below, answer your questions by filling in the provided multi-line strings.
# (yes it's a bit of a hokey way to do this, but it should work well enough and it keeps the answers in 1 file)
# For each question state any extra assumptions you made, and explain your answer.
# An incorrect answer with no explanation will get no partial credit.

# Question 1: What is the worst-case big-O runtime of your get_size function?
Question1 = '''
O(1)
'''

# Question 2: What is the worst-case big-O runtime of your copy_word_grid function?
Question2 = '''
O(n^2)
'''

# Question 3: What is the worst-case big-O runtime of your extract function?
Question3 = '''
O(n)
'''

# Question 4: What is the worst-case big-O runtime of your find function?
Question4 = '''
O(n^2)
'''

### LEAVE THESE LINES ALONE BEGIN:
# So the code I provide at the bottom needs these lines of code.
import random
import string

# This code defines valid directions a word can travel.
# Each direction is a tuple (dx, dy) that says how you change x and y 
# coordinates to go in a given direction.
RIGHT=(1, 0)       # to go right add 1 to x
DOWN=(0,1)         # to go down add 1 to y
RIGHT_DOWN=(1, 1)  # to go right_down add 1 to both x and y
RIGHT_UP=(1,-1)    # to go right_up add 1 to x and subtract 1 from y
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)
# Good use of these direction-tuples makes for much easier programs for this project. assignment.

### LEAVE THESE LINES ALONE END:


def get_size(word_grid):
    '''returns the dimensions of a given grid'''
    return (len(word_grid[0]),len(word_grid));

def print_word_grid(word_grid):
    '''prints the given grid in a dense format, with no lists, commas, or spaces.'''
    for i in range(len(word_grid)):
        for x in range(len(word_grid[i])):
            print (word_grid[i][x], end ='', sep= '');
        print()


def copy_word_grid(word_grid):
    '''makes a copy list of a given list'''
    copy_grid = []
    for i in range(len(word_grid)):
        copy_grid.append([])

    for x in range(len(word_grid)):
        for i in range(len(word_grid[x])):
            copy_grid[x].append(word_grid[x][i])

        
    return copy_grid
    

def extract(word_grid, position, direction, max_len):
    '''returns a string of letters given a grid, a starting postiion, a direction, and string length'''
    (x,y) = position
    first_word=''
    if direction == DOWN:
        for i in range(max_len):
            if  y+i<(len(word_grid)) and x<(len(word_grid[0])):
                first_word = first_word + word_grid[y+i][x]
    if direction == RIGHT:
        for i in range(max_len):
            if y<(len(word_grid)) and x+i<(len(word_grid[0])):
               first_word = first_word + word_grid[y][x+i]
    if direction == RIGHT_DOWN:
        for i in range(max_len):
            if y+i<(len(word_grid)) and x+i<(len(word_grid[0])):
                    first_word = first_word + word_grid[y+i][x+i]
    if direction == RIGHT_UP:
        for i in range(max_len):
            if y-i>=(0) and x+i<(len(word_grid[0])):
                first_word = first_word + word_grid[y-i][x+i]
    
    return first_word

def find(word_grid, word):
    '''returns the starting position of a word and the direction that the word continues into'''

    answer = None

    for i in range(len(word_grid)):
        for x in range(len(word_grid[i])):
            if word[0] == word_grid[i][x]:
                if extract(word_grid,(x,i),DOWN,len(word)) == word:
                    answer = ((x,i), (0,1))
                if extract(word_grid,(x,i),RIGHT,len(word)) == word:
                    answer = ((x,i), (1,0))
                if extract(word_grid,(x,i),RIGHT_UP,len(word)) == word:
                    answer = ((x,i), (1,-1))
                if extract(word_grid,(x,i),RIGHT_DOWN, len(word)) == word:
                    answer = ((x,i), (1,1))
    
    return answer


def show_solution(word_grid, word):
    '''if the given word is in the given word grid, this function returns the grid with the given word capitalized.
    otherwise, it informs the user that the given grid does not have the given word'''
    new_grid = copy_word_grid(word_grid)

    if find(word_grid,word) == None:
        print (word + " is not found in this word search")
    else:
        ((a,b),(c,d))= find(word_grid,word)
        if (c,d) == (1,0):
            for i in range(len(word)):
                new_grid[b][a+i] = new_grid[b][a+i].capitalize()
            answer = new_grid
        if (c,d) == (0,1):
            for i in range(len(word)):
                new_grid[b+i][a] = new_grid[b+i][a].capitalize()
            answer = new_grid
        if (c,d) == (1,1):
            for i in range(len(word)):
                new_grid[b+i][a+i] = new_grid[b+i][a+i].capitalize()
            answer = new_grid
        if (c,d) == (1,-1):
            for i in range(len(word)):
                new_grid[b-i][a+i] = new_grid[b-i][a+i].capitalize()
            answer = new_grid
        
        print(word.upper() + " can be found as below" )
        print_word_grid(new_grid)







def make_empty_grid(width, height):
    '''given dimensions, this function makes a grid with those dimensions, with question marks as every element'''
    new_grid= []

    for i in range(height):
        new_grid.append([])


    for i in range(height):
        for x in range(width):
            new_grid[i].append("?")

    return new_grid

def can_add_word(word_grid, word, position, direction):
    '''given a grid, a word, a starting position, and a direction, this function determines 
    if the word can be adding with that starting position and direction.'''
    (x,y) = position
    answer = None
    
    if direction == (1,0):
        for i in range(len(word)):
            if x+i>(len(word_grid[0])-1):
                answer = False
    if direction == (0,1):
        for i in range(len(word)):
            if y+i>(len(word_grid)-1):
                answer = False
    if direction == (1,1):
        for i in range(len(word)):
            if y+i>(len(word_grid)-1 or x+i>(len(word_grid[0])-1)):
                answer = False
    if direction == (1,-1):
        for i in range(len(word)):
            if y-1<0 or x+i>(len(word_grid[0])-1):
                answer = False

    if answer != False:

        if direction == (1,0):
            count = 0
            for i in range(len(word)):
                if word_grid[y][x+i] == '?' or word[i]:
                    count = count + 1
            if count == len(word):
                answer = True
        if direction == (0,1):
            count = 0
            for i in range(len(word)):
                if word_grid[y+i][x] == '?' or word[i]:
                    count = count + 1
            if count == len(word):
                answer = True
        if direction == (1,1):
            count = 0
            for i in range(len(word)):
                if word_grid[y+i][x+i] == '?' or word[i]:
                    count = count + 1
            if count == len(word):
                answer = True
        if direction == (1,-1):
            count = 0
            for i in range(len(word)):
                if word_grid[y-i][x+i] == '?' or word[i]:
                    count = count + 1
            if count == len(word):
                answer = True



    return answer


def do_add_word(word_grid, word, position, direction):
    '''given a grid, and a word, this function adds that word at a given starting position in a given direction.'''
    (x,y) = position
    if direction == DOWN:
        for i in range(len(word)):
            if  y+i<(len(word_grid)) and x<(len(word_grid[0])):
                word_grid[y+i][x] = word[i]
    if direction == RIGHT:
        for i in range(len(word)):
            if y<(len(word_grid)) and x+i<(len(word_grid[0])):
               word_grid[y][x+i] = word[i]
    if direction == RIGHT_DOWN:
        for i in range(len(word)):
            if y+i<(len(word_grid)) and x+i<(len(word_grid[0])):
                word_grid[y+i][x+i] = word[i]
    if direction == RIGHT_UP:
        for i in range(len(word)):
            if y-i>=(0) and x+i<(len(word_grid[0])):
                word_grid[y-i][x+i] = word[i]

def fill_blanks(word_grid):
    '''this function fills all the blank indices in a given grid with a random lowercase letter'''

    for i in range(len(word_grid)):
        for x in range(len(word_grid[0])):
            if word_grid[i][x] == '?':
                word_grid[i][x] = random.choice(string.ascii_lowercase)
                

    return word_grid
####
#
#  PROVIDED CODE -- You shouldn't need to change any of this.
#  (it's not that we didn't think you could write this, it's this stuff is either
#  1) really easy and not worth putting in a 1913 project or
#  2) really, really specific. (it's hard to describe the correct function of
#     these two functions without just telling you exactly how to do it.)
#
#  These are provided to "complete" the project -- I.E. these work with the code you write and allow you to use your
#  functions to generate word-searches for personal use. It is RECOMMENDED that you build a front-end for this behavior
#  so you can more easily use and play-with the finished product.
####
def add_word(word_grid, word):
    ''' Attempts to '''
    width, height = get_size(word_grid)
    for attempt_num in range(50):
        direction = random.choice(DIRECTIONS)
        x = random.randrange(width)
        y = random.randrange(height)
        location = (x, y)
        if can_add_word(word_grid, word, location, direction):
            do_add_word(word_grid, word, location, direction)
            return True
    return False

def generate(width, height, words):
    words_actual = []
    word_grid = make_empty_grid(width, height)
    for word in words:
        if add_word(word_grid, word):
            words_actual.append(word)
    fill_blanks(word_grid)
    return word_grid, words_actual
