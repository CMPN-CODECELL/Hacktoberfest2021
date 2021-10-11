class Sorts:
	def partition(self, arr, low, high):
	    i = (low-1)  
	    pivot = arr[high]
	  
	    for j in range(low, high):
	        if arr[j] <= pivot:
	            i = i+1
	            arr[i], arr[j] = arr[j], arr[i]
	  
	    arr[i+1], arr[high] = arr[high], arr[i+1]
	    return (i+1)
	    
	def quickSort(self, arr, low, high):
	    if len(arr) == 1:
	        return arr
	    if low < high:
	        pi = self.partition(arr, low, high)
	  
	        self.quickSort(arr, low, pi-1)
	        sself.quickSort(arr, pi+1, high)

if __name__ == '__main__':
	s = Sorts()
	# taking array input
	arr = list(map(int, input().split()))
	s.quickSort(arr, 0, len(arr)-1)
	print(arr)