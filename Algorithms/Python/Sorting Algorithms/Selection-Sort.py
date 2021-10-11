class Sorts:
	# it selects the max element and swaps it with the recent last one
	def selectionSort(self, arr: list[int]):
		for i in range(0, len(arr)):
			last = len(arr)-i
			maxIndex = 0
			for j in range(0, last):
				if arr[j]>arr[maxIndex]:
					maxIndex = j
			arr[last-1], arr[maxIndex] = arr[maxIndex], arr[last-1]

if __name__ == '__main__':
	s = Sorts()
	# taking array input
	arr = list(map(int, input().split()))
	s.selectionSort(arr)
	print(arr)