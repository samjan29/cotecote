import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        quickSort(A, 0, A.length - 1);
        quickSort(B, 0, B.length - 1);
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
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