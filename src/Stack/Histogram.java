package Stack;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };

		int maxAreaUnderHistogram = maxAreaUnderHistogram(arr);
		System.out.println(maxAreaUnderHistogram);
	}

	private static int maxAreaUnderHistogram(int[] arr) {
		int maxArea = 0;
		int area = 0;
		Stack<Integer> stack = new Stack<>();
		int i=0;
		while ( i < arr.length) {

			if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int top = stack.pop();

				if (stack.isEmpty()) {
					area = arr[top] * i;
				} else {
					area = arr[top] * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}

			} else {
				stack.push(i);
				i++;
			}

		}
		
		while(!stack.isEmpty()) {
			int top = 	stack.pop();
			if(stack.isEmpty()) {
				area = arr[top] *i;
			}
			else {
				area = arr[top] *(i-stack.peek()-1);
			}
			
			if(area> maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;

	}

}
