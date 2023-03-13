import java.util.*;
/*
 * 
 * Build Min Heap
        You are given an integer array arr of size n. 
        Your task is to build a binary min heap from the given array. 
        You need to just min-heapify the array and return it printing 
        is handled by the driver code.

        Note

        A binary heap is a complete tree so that it can be represented in array format.
        The indices for child, parent are:
        Root is at index 0 in array.
        Left child of i-th node is at (2*i + 1)th index.
        Right child of i-th node is at (2*i + 2)th index.
        Parent of i-th node is at (i-1)/2 index.


        Input Format
            Input consists of two lines.
            First line contains an integer n which is the size of array
            Next line contains n spaced integers which are the elements of the array.

        Output Format
            Change the input array to a heap and implement 
            this in the buildHeap() function. 
            The output printed is Correct if your heap is correct. 
            Otherwise it prints Incorrect.

        Example 1
        Input

            5
            4 10 3 5 1
        Output

            Correct
 * 
 * 
*/
class Solution {

	//for checking that if array is minHeap or not
    boolean checkHeap(int arr[]) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[2 * i + 1] < arr[i]) {
                return false;
            }

            if (2 * i + 2 < n && arr[2 * i + 2] < arr[i]) {
                return false;
            }
        }
        return true;
    }

	//main logic for heapify the function
	// 1 --> we will run the loop from
	// 2 --> size half till first element
	// 3 --> because as it is a complete binary tree
	// 4 --> second half part will be having leafs only
	void swap(int i,int j,int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// void downHipyfiy(int parent,int n,int[] arr){
	// 	int leftchildInd = 2*parent + 1;
	// 	int rightchildInd = 2*parent + 2;

	// 	int leftVal = (leftchildInd >= n) ? Integer.MAX_VALUE : arr[leftchildInd];
	// 	int rightVal = (rightchildInd >= n) ? Integer.MAX_VALUE : arr[rightchildInd];

	// 	int samallerInd = parent;

	// 	if(arr[samallerInd] > leftVal){
	// 		samallerInd = leftchildInd;
	// 	}
	// 	if(arr[samallerInd] > rightVal){
	// 		samallerInd = rightchildInd;
	// 	}

	// 	if(samallerInd != parent){
	// 		swap(samallerInd,parent,arr);
	// 		downHipyfiy(samallerInd,n,arr);
	// 	}
	// }
	void downHipyfiy(int parent,int n,int[] arr){
		// first we will calculate the left and right child's index
		int left = (parent*2+1);
		int right = parent*2 + 2;

		//calculation of the value of left and right childs
		int leftVal = left < n ? arr[left] : Integer.MAX_VALUE;
		int rightVal = right < n ? arr[right] : Integer.MAX_VALUE;

		int minInd = parent;
		if(leftVal < arr[parent]){
			minInd = left;
		}
		if(rightVal < arr[minInd]){
			minInd = right;
		}

		if(parent != minInd){
			swap(parent,minInd,arr);
			downHipyfiy(minInd,n,arr);
		}
	}
	// As we want to creat heaf using arr
	// we will start from below so that smaller values go below

	// we will use down heapify for every element
    void buildHeap(int arr[]) {
        //Write code here
		int n = arr.length;
		for(int i = n/2 - 1; i >= 0 ; i--){
			downHipyfiy(i,n,arr);
		}
    }
}

public class BuildMinHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.buildHeap(arr);
        if (Obj.checkHeap(arr)) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
        sc.close();
    }
}