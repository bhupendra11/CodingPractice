package Sorocco;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArrayRangeCompacting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s =sc.nextLine();
		String sarr[] = s.split(",");
		int arr[] = new int[sarr.length];
		for(int i=0; i<arr.length;i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}
		
		String res = compact(arr);
		System.out.println(res);
		sc.close();
	}

	private static String compact(int[] array) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList();
		StringBuffer sb = new StringBuffer();
		
		int i=0;
		while(i <array.length) {
			int cur = array[i];
			int last = -1;
			sb.append(cur);
			
			while(i +1 < array.length && array[i+1] == array[i]+1) {
				queue.add(array[i+1]);
				i++;
				last = array[i];
			}
			
			if(queue.size() >=2) {  //if its a range
				sb.append("-");
				sb.append(last);
				sb.append(",");
				queue.clear();
				
			}
			else {
				if(!queue.isEmpty()) {
					while(!queue.isEmpty()) {
						sb.append(",");
						sb.append(queue.poll());
						sb.append(",");
					}
				}
				else {
					//sb.append(array[i]);
					sb.append(",");
					
				}
				
			}
			i++;
			
		}
		
		String res = sb.toString().substring(0, sb.length()-1);
		return res;
	}

}
