class Sorts:
	#This will ony work when the array has 0 to (n-1) elements
	def cyclicSort(self, arr: list[int]):
		i = 0
		while i<len(arr):
			correct = arr[i]-1
			if arr[i] != arr[correct]:
				arr[i], arr[correct] = arr[correct], arr[i]
			else:
				i += 1

if __name__ == '__main__':
	s = Sorts()
	# taking array input
	arr = list(map(int, input().split()))
	s.cyclicSort(arr)
	print(arr)