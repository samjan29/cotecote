class Solution {
    public int solution(int[] numbers) {        
        quickSort(numbers, 0, numbers.length - 1);
        
        int a = numbers[0] * numbers[1];
        int b = numbers[numbers.length - 2] * numbers[numbers.length - 1];
        
        return a > b ? a : b;
    }
    
    private void quickSort(int[] arr, int low, int high) {
        
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            
            quickSort(arr, low, pivotIndex);
            quickSort(arr, pivotIndex + 1, high);
        }
        
    }
    
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        
        left--;
        right++;
        
        while (true) {
            
            do {
                left++;
            } while (arr[left] < pivot);
            
            do {
                right--;
            } while (arr[right] > pivot && left <= right);
            
            if (left >= right) {
                return right;
            }
            
            swap(arr, left, right);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}