package array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestUsingHeap {

	public static void main(String[] args) {
        int[] a = {68, 60, 92, 36, 12, 61, 80, 39, 53, 39, 25, 6, 87, 65, 6, 88, 80, 6, 75, 97, 4, 76, 75, 73, 96, 73, 32, 6, 81, 50, 43, 40, 49, 3, 9, 74, 29, 15, 40 };
        int k =39;
        System.out.println(findKthSmallest(a, k));
        
    }
	
	public static int findKthSmallest(int[] a, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
		for(int i=0; i<a.length ;i++) {
			pq.add(a[i]);
		}
		
		for(int i=0; i<k-1 ;i++) {
			System.out.print(pq.poll()+"  ");
		}
		System.out.println();
		return pq.poll();
	}
}
