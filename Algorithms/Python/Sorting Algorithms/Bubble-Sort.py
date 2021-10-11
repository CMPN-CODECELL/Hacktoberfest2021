class Sorts:
	#it brings the largest element in end at every pass
	def bubbleSort(self, arr: list[int]):
		for i in range(0, len(arr)):
			swapped = False
			for j in range(1, len(arr)-i):
				if arr[j] < arr[j-1]:
					arr[j-1], arr[j] = arr[j], arr[j-1]
					swapped = True
			if not swapped:
				break
if __name__ == '__main__':
	s = Sorts()
	# taking array input
	arr = list(map(int, input().split()))
	s.bubbleSort(arr)
	print(arr)