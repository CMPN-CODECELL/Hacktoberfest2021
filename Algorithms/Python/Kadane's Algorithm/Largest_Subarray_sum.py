# Kadane's Algorithm is used for finding the Largest continous Sub+array Sum of a given array

# The problem goes something like:
# we will be given an array consisting of random values
# then we have to select a Subarray of any length that gives us the maximum sum


#Let's take a look at some Example Input and Output along with Explanation
#given input will be in string format and output will be in number format
'''
@Example Input 1:
1 2 3 -3 5

@Example Output 1:
8

@Explanation:
We can select the entire array as it is giving us the maximum sum
''' 

'''
@Example Input 2:
4 6 -3 -1 -4 -5 4 6 3

@Example Output 2:
13
@Explanation: 
we can select the last three elements giving us the maximum sum
'''

# Solution to this problem using Kadane's Algorithm

# We will first Initialize two pointes (variables) one will store the maximum till now and the other will store maximum after including this number
# we will then traverse the array
    # for every number the maximum after including this number will be incremented by the current number
    # Then we check if the maximum after including this number is greater than the maximum till now variable
    # if thats true then we update the value of maximum till now and make the maximum till now value equals to maximum after including this number
    #else nothing happens for maximum till now 
    #if maximum after including this number gets less than 0 we update the maximum after including this number to 0 that is we don't consider it in our sub-array
    #else nothing happens for maximum ending now 

# The intution behind this Algorithm is that to look for all positive contiguous sub-arrays 
# Each time we get a positive sum we compare it with the maximum till now and update it accordingly

# code:

#input:
arr = input() #taking the whole string as input
arr = arr.split() #spliting the white spaces and converting the string to list
array = list(map(int,arr)) # mapping every element of the arr which is in string format to integer format 

#you can do all this in single line -> array = list(map(int,input().split()))

def Kadanes_Algorithm(array,n):
    #initialization
    if n==0:
        print("Please Enter ateast one number") #Base case if user provides an empty string
        return 
    maximum_including_this_number = 0
    maximum_till_now = None

    #Traversing
    for i in range(n): # i goes from 0 to n-1 inclusive
        maximum_including_this_number += array[i] #incrementing the value 
        if(maximum_till_now is None): #considering for the first iteration as it will always be considered 
            maximum_till_now = maximum_including_this_number
        if(maximum_including_this_number>maximum_till_now):
            maximum_till_now = maximum_including_this_number #updating the value of maximum till now as it is less than maximum after including the current number
        if(maximum_including_this_number<0):
            maximum_including_this_number = 0 #updating maximum including this number as we won't consider this subarray segment
    print(maximum_till_now) #printing the maximum contiguous sum 
    return  #just to return from the function but returns nothing
Kadanes_Algorithm(array,len(array)) #calling the function and passing array and its length as parameters 

# You can do dry run on this Algorithm code to understand in depth mechanism