package com.codingpractice.array;

public class KthSmallest {

	public static void main(String args[]) {
		
	//	int arr[] = {65, 70, 75, 80, 85, 60 , 55, 50, 45 };
		int arr[] = {72, 10, 91, 11, 64, 39, 57, 14, 57, 67, 18, 12, 57, 10, 60, 82, 31, 51, 60, 68, 33, 24, 17, 98, 29, 70, 44, 7, 3, 80, 88, 96, 78, 65, 15, 43, 77, 62, 32, 60, 77, 65, 30, 77};
		//int res = partitionArr(arr, 0, arr.length);
		
		int res = findKthSmallest(arr, 22);
		
		/*for(int i:arr) {
			System.out.print(i+" ");
		}*/
		
		System.out.println("Res = "+res);
		
	}
	
	
	public static int findKthSmallest(int arr[], int k) {
		
		int n = arr.length;
		int low =0;
		int high = n;
		int j =-1;
		while(low<=high) {
			j = partition2(arr, low, high);
			
			if(j==k)return arr[k];
			else if(j <k) {
				low =j+1;
			}
			else {
				high = j;
			}
		}
		return -1;
	}
	
	
	
	/*public static int partition(int arr[] , int p, int n) {
		
		int i=p+1;
		int j = n-1;		
		int pivot = arr[p];
		while(i<=j) {
			
			while(i<n && arr[i] < pivot)
			{
				i++;
			}
			while(j >=0 && arr[j] > pivot) {
				j--;
			}		
			if(i<j) {
				arr =swap(arr, i, j);
			}			
			arr =swap(arr, p, j);
		}		
		return j;
	}*/
	
	public static int[] swap(int arr[] , int i, int j) {
		int temp =arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		return arr;
	}
	
	
	
	
 public static int partition2(int arr[] , int p, int n) {
		
		int i=p+1;
		int j = n-1;		
		int pivot = arr[p];
		while(true) {
			
			while(i<n && arr[i] < pivot)
			{
				i++;
			}
			while(j >=0 && arr[j] > pivot) {
				j--;
			}		
			if(i>=j) {
				break;
			}		
			arr =swap(arr, i, j);
			
		}	
		arr =swap(arr, p, j);
		return j;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//new kth smallest method
	
	/* public static int findKthSmallest(int[] a, int k) {
	        return findKthSmallestHelper(a, k, 0, a.length - 1);
	    }
	    public static int findKthSmallestHelper(int[] a, int k, int lo, int hi) {
	        if(k > 0 && k <= hi - lo + 1) {
	            int pos = partition(a, lo, hi);
	            if(pos - lo == k - 1) {
	                return a[pos];
	            }
	            if(pos - lo  > k - 1) {
	                return findKthSmallestHelper(a, k, lo, pos - 1);
	            }
	            else {
	                return findKthSmallestHelper(a, k - pos + lo - 1, pos + 1, hi);
	            }       
	        }
	        return Integer.MAX_VALUE;
	    }*/
	
	
	/* public static int partition(int[] a, int lo, int hi){
	        int i = lo;
	        int j = hi ;
	        int v = a[lo];
	        while(true) {
	            while(a[++i] < v) {
	                if(i == hi)
	                    break;
	            }
	            while( v < a[--j]) {
	                if(j == lo)
	                    break;
	            }
	            if(i >= j)
	                break;
	            swap(a, i, j);
	        }
	        swap(a, lo, j);
	        return j;
	    }*/
	
}
