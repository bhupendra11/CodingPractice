package array;

public class SearchSortedRoatatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = search(arr, 1, 0, arr.length - 1);
		System.out.println(n);
	}

	private static int search(int[] arr, int n, int lo, int hi) {

		int pivot = pivot(arr, lo, hi);

		if (pivot == -1) {
			// no rotation
			return binarySearch(arr, n, 0, arr.length - 1);
		}
		
		if(arr[pivot]==n)return pivot;
		if (n >= arr[pivot]) {
			return binarySearch(arr, n, pivot + 1, hi);
		} else {
			return binarySearch(arr, n, 0, pivot - 1);
		}

	}

	private static int pivot(int arr[], int low, int high) {
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return pivot(arr, low, mid - 1);
		return pivot(arr, mid + 1, high);
	}

	private static int binarySearch(int[] arr, int n, int lo, int hi) {

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] == n)
				return mid;
			else if (arr[mid] < n) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return -1;

	}
}
