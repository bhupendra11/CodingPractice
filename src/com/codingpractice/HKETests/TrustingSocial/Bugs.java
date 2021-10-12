package com.codingpractice.HKETests.TrustingSocial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**

Bugs
You are developer at XYZ company. You like to call the bugs in your code as enemies. You maintain an array A of the list of enemies in decreasing order of their difficulty i.e., the most difficult bug will be the first element of the array. Initally, there is no bugs in the code. You are given N tasks. Each task contains one of the following two types of operations:

1. 1 P: Add a bug with difficulty P into the array A.

2. 2: Sort the array in decreasing order and print the difficulty of (n / 3)th bug in the sorted array, where n is the size of the array A. If the number of bugs is less than 3, print Not enough enemies.

 

Input Format

First line contains an integer N, denoting the number of tasks.

The next N lines contain one of the two types of operations mentioned above.

 

Output Format

For every operation of type 2, print the difficulty of (n / 3)th bug in the sorted array, where n is the size of the array A. If the number of bugs is less than 3, print Not enough enemies.


Sample input
10
1 1
1 7
2
1 9
1 21
1 8
1 5
2
1 9
2


Sample output 
Not enough enemies
9
9


 */
public class Bugs {

	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();sc.nextLine();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N ;i++) {
			String line[] = sc.nextLine().split(" ");
			if(line.length==2) {
				list.add(Integer.parseInt(line[1]));
			}
			else {
				Collections.sort(list, Collections.reverseOrder());
				if(list.size()<3) {
					System.out.println("Not enough enemies");
				}
				else {

					int pos = list.size()/3;
					if(pos !=0)
					System.out.println(list.get(pos-1));
					else
						System.out.println(list.get(pos));
				}
				
			}
			
			
		}
		
	}
	
	
	
}


























