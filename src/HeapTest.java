
public class HeapTest {

	public static void main(String args[]) {
		HeapMin heap = new HeapMin(10);
		heap.add(1);
		heap.add(10);
		heap.add(5);
		heap.add(12);
		heap.add(7);
		heap.add(22);
		heap.add(3);
		heap.add(2);
		heap.add(97);
		
		System.out.println("before sort");
		for(int i : heap.items) {
			System.out.print(i+" ");
		}
		
		heap.heapSort();
		
		System.out.println();
		System.out.println("after sort");
		for(int i : heap.items) {
			System.out.print(i+" ");
		}
	}
	
}
