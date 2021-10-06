#include <stdio.h>
void swap(int *xq, int *yq)
{
    int temp = *xq;
    *xq = *yq;
    *yq = temp;
}

void selection(int arr[], int n)
{
    int i, j, index;

    for (i = 0; i < n - 1; i++)
    {
        index = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] < arr[index])
                index = j;

        swap(&arr[index], &arr[i]);
    }
}

void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main()
{
    int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr) / sizeof(arr[0]);
    selection(arr, n);
    printf("Sorted array: \n");
    printArray(arr, n);
    return 0;
}
