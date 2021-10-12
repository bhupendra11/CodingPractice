package com.codingpractice.heapsAndMaps;
import java.util.Arrays;

/**
 * 
 * @author I342303 A Binary Heap is a Binary Tree with following properties. 1)
 *         It�s a complete tree (All levels are completely filled except
 *         possibly the last level and the last level has all keys as left as
 *         possible). This property of Binary Heap makes them suitable to be
 *         stored in an array.
 * 
 *         2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary
 *         Heap, the key at root must be minimum among all keys present in
 *         Binary Heap. The same property must be recursively true for all nodes
 *         in Binary Tree. Max Binary Heap is similar to Min Heap.
 *
 *
 *         A Binary Heap is a Complete Binary Tree. A binary heap is typically
 *         represented as array.
 * 
 *         The root element will be at Arr[0]. Below table shows indexes of
 *         other nodes for the ith node, i.e., Arr[i]: Arr[i/2] Returns the
 *         parent node Arr[(2*i)+1] Returns the left child node Arr[(2*i)+2]
 *         Returns the right child node The traversal method use to achieve
 *         Array representation is Level Order
 */

public class HeapMin {

	private int capacity;
	private int size ;

	int items[] ;

	public HeapMin(int capacity) {
		this.capacity = capacity;
		this.size =0;
		items = new int[capacity]; 
	}
	
	
	public int getParentIndex(int i) {
		return i / 2;
	}

	public int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	public int getRightChildIndex(int i) {
		return 2 * i + 2;
	}

	public int getParent(int i) {
		return items[getParentIndex(i)];
	}

	public int getLeftChild(int i) {
		return items[getLeftChildIndex(i)];
	}

	public int getRightChild(int i) {
		return items[getRightChildIndex(i)];
	}

	public boolean hasLeftChild(int i) {
		return getLeftChildIndex(i) < size;
	}

	public boolean hasRightChild(int i) {
		return getRightChildIndex(i) < size;
	}

	public boolean hasParent(int i) {
		return getParentIndex(i) >= 0;
	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	private void swap(int i, int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalArgumentException();
		}
		return items[0];
	}
	
	public int poll() {
		if(size ==0) {throw new IllegalArgumentException();}
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}

	
	
	public void add(int item) {
		ensureExtraCapacity();
		items[size]= item;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && getParent(index)> items[index]) {
			swap(index , getParentIndex(index));
			index = getParentIndex(index);
		}
		
	}

	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			
			int smallChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
				smallChildIndex = getRightChildIndex(index);
			}
			
			if(items[index]< items[smallChildIndex]) {
				break;
			}
			else {
				swap(index, smallChildIndex);
			}
			index = smallChildIndex; 
		}
	}
	
	public  void heapSort() {
		
		while(size>1) {
			swap(0, size-1);
			size--;
			heapifyDown();
			
		}
		
	}
}

