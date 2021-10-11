"""
Implementation for binary search algorithm for searching an integer in a sorted array.
It performs search in O(log(n)) time comeplexity. 'n' is the size of input array.
It returns -1 if element is not found in the array.
"""
def binary_search(n,arr,ele):
    """
    Function to perform iterative binary search
    params:
        n   : Size of input array
        arr : input array
        ele : element to be searched in array
    returns:
        index : index of element if found else -1.
    """
    left = 0
    right = n
    while left<right:
        mid = left + int((right-left)/2)
        if arr[mid] == ele:
            return mid
        elif ele > arr[mid]:
            left = mid+1
        else:
            right = mid-1
    return -1

n = int(input("Enter size of array: "))
arr = list(map(int, input("Enter sorted array elements: ").split()))
ele = int(input("Enter element to search for: "))

index = binary_search(n, arr, ele)
if index == -1:
    print("Elment not found in given array")
else :
    print("Element found at index: {}".format(index))