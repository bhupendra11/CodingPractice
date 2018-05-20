package codingBlocks.RecursionGet;

public class GetAllIndices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,8,1,8,8,4};
		int[] res = allIndices(arr,0, 8, 0);

		for(int i: res) {
			System.out.print(i+" ");
		}
	}
	
	private static int[] allIndices(int[] arr, int start, int data, int count) {
		
		if(start==arr.length) {
			int res[] = new int[count];
			return res;
		}
		int indices[] = null;
		if(arr[start]==data) {
			indices = allIndices(arr, start+1, data, count+1);
		}
		else {
			indices = allIndices(arr, start+1, data, count);
		}
		
		if(arr[start]== data) {
			indices[count] = start;
		}
		
		return indices;
	}

}
