# Lab 5, CSCI 1913 Fall 2022
# Author: Vennela Dupati


# LAB5 has a substantial written Q&A component as well. You answer these questions by updating the
# multi-line strings below to indicate your answer. It's a bit hokey, but it works.

# Question 1: Which image file you submitted covers which analysis case?
Answer1 = '''
File anmes are obvious
'''

# Question 2: For each algorithm, explain how you see it behaving in your images.
# If the algorithm's behavior differed case-by-case say this and explain how it behaved in each case.

Answer2_insertion = '''
On the backwards sorted list, the insertion sort had an exponentially increasing curve
On the random sorted list, the insertion sort had a seemingly abitrary system of increase
On the near sorted and sorted lists, the insertion sort was mostly flat, increasing very slightly
'''

Answer2_selection = '''
On the sorted, random, and near sorted lists, the selection sort had an exponentially increasing curve
On the backwards sorted list, the selection sort plot was also exponentially increasing, but at a much lower rate than the insertion sort.
'''

Answer2_merge = '''
On the sorted and near sorted lists, the merge sort plot is increasing slightly, at a greater rate than the insertion sort.
On the backwards sorted and random sorted lists, the merge sort was generally flat
'''


# Question 3: For each algorithm, What is the theoretical expectation. I.E. what is the expected big-O runtime behavior.
# If the algorithm's expected behavior differs case-by-case say this and explain how it is
# expected to behave case-by-case. (You should be able to find this information in the textbook.
# If not we will discuss this in class)

Answer3_insertion = '''
O(N) for nearly sorted and sorted and
O(N^2) for others
'''

Answer3_selection = '''
O(N^2)
'''

Answer3_merge = '''
O(N log N)

Requires O(N) more memory elemnts for the temporary array
'''



# Question 4: For each algorithm, How did the observed behavior match the theoretical behavior? Again, if your answer
# differs case by case, say that here and explain your findings for each case.

Answer4_insertion = '''
It matched, as the nearly sorted and sorted lists were flat, 
but the other two were increasing
'''

Answer4_selection = '''
It matched as it was exponentially increasing for all cases
'''

Answer4_merge = '''
It matched as it was increasing more for the lists that were sorted and near sorted.
'''


# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = '''
If the right and left sub-lists have alternating elements, selection sort would likely be faster.
'''


# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = '''
I would use selection sort. According to the plots, the selection sort is always increasing exponentially, with no cases where it is flat. 
This indicates a likely reasonable performance for all cases.
'''






# Selection, Insertion, and Merge sorts -- taken from ZyBooks.
# Not too different, its still the same algorithm, they just did it using less memory than I did
# (Which leads to a slightly harder to understand piece of code)

def selection_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers). Returns number of comparisons between elements."""
    count = 0
    for i in range(len(numbers) - 1):
        # Find index of smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            count = count + 1
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j
    
        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp
    
    return count

def insertion_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers). Returns number of comparisons between elements."""
    count = 0
    for i in range(1, len(numbers)):
        j = i
        # Insert numbers[i] into sorted part
        # stopping once numbers[i] in correct position
        # KLUVER NOTE - PLEASE READ - so this line is a bit tricky. Technically, if j > 0 then numbers would not be compared
        #               to make things easier you can assume that every time the list condition is checked one array element
        #               comparison occurs. That is -- you can ignore the short-circuit evaluatio of the logical and in this
        #               counting problem.
        count = count +1
        while j > 0 and numbers[j] < numbers[j - 1]:
            count = count +1
            # Swap numbers[j] and numbers[j - 1]
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1
    
    return count


def merge(numbers, i, j, k):
    """ Given two sorted sub-lists create one sorted list. This is done in-place, meaning we are given one list
    and expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the list)
    The list named numbers may contain other types of data than just numbers
    the variables i, j, and k are all indices into the numbers list
    So so the part of the list to be sorted is from position i to k (inclusive) with i to j being one sorted list, and j+1 to k being another."""
    mergeCount = 0 

    merged_size = k - i + 1   #  Size of merged partition
    merged_numbers = []        #  Temporary list for merged numbers
    for l in range(merged_size):
        merged_numbers.append(0)

    merge_pos = 0      #  Position to insert merged number

    left_pos = i       #  Initialize left partition position
    right_pos = j + 1  #  Initialize right partition position

    #  Add smallest element from left or right partition to merged numbers
    while left_pos <= j and right_pos <= k:
        mergeCount += 1
        if numbers[left_pos] < numbers[right_pos]:
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  If left partition is not empty, add remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge number back to numbers
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1
    
    return mergeCount


def merge_sort_recursive(numbers, i, k):
    """ Sort the sub-list in numbers from position i to k (inclusive)"""
    count = 0
    if i < k:
        j = (i + k) // 2  #  Find the midpoint in the partition

        #  Recursively sort left and right partitions
        # KLUVER NOTE - PLEASE READ - you should think about these two function calls as returning a count of
        #     comparisons. Naturally the comparisons done by those function-calls will count against this function-call.
        #     make sure you're not ignoring the return values on the following two lines.
        count += merge_sort_recursive(numbers, i, j)
        merge_sort_recursive(numbers, i, j)
        count += merge_sort_recursive(numbers, j + 1, k)
        merge_sort_recursive(numbers, j + 1, k)

        #  Merge left and right partition in sorted order
        count += merge(numbers,i,j,k)
        merge(numbers, i, j, k)


    return count

def merge_sort(numbers):
    """ Sort a list of numbers

    This function is added on-top of the textbook's code to simply start the recursive process with the
    appropriate parameters. This also gives us a consistent sorting interface over the three sorts."""
    return merge_sort_recursive(numbers, 0, len(numbers)-1)


