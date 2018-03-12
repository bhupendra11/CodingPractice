//These comments are my own approach to solution-not related to the question in any manner!!!
//			System.out.println("Here you will enter two polynomials with corresponding powers(max:x^7).\n");
//			System.out.println("********************************************************************************************************************************************************");
//			System.out.println("->The polynomial should be written giving one element at a time.");
//			System.out.println("->You will be needed to give the constant part of each element in the polynomial.");
//			System.out.println("->For the power of x that does not occur in the polynomial input 0.");
//			System.out.println("->Example: -3x^6 will be inputted as - 3 (when asked for constant of x^6)");
//			System.out.println("********************************************************************************************************************************************************\n");
//			System.out.println("Enter the prefixes first Polynomial-");
//			System.out.println("\nThank You,Now enter the prefixes of Second Polynomial-");
package cheggy;

import java.util.Scanner;

public class PolyA extends SingleLinkedList<String> {

	public static void main(String args[]) {
		PolyA a = new PolyA();
		PolyA b = new PolyA();
		PolyA c = new PolyA();
		a.initialization();
		b.initialization();
		c = a.add(b);
		System.out.println(a);

		System.out.println(b);

		System.out.println(c);

	}

	private PolyA add(PolyA b) {
		
		
		return null;
	}

	private void initialization() {
		//Scanner sc = new Scanner(System.in);
		//String s = sc.nextLine();
		
		String elem1 = "3.2,2";
		String elem2 = "-4,1";
		String elem3 ="-5,0";
		
		this.add(elem1);
		this.add(elem2);
		this.add(elem3);
		
		System.out.println(this.toString());
		
		
		//sc.close();
	}
	
	private class E{
		double num;
		int power;
		public E(double num, int pow) {
			this.num = num;
			this.power = pow;
		}
	}
	
	
	/*private static void  polyadd(Node poly1, Node poly2,Node poly)
	{
	while(poly1->next && poly2->next)
	    {
	        // If power of 1st polynomial is greater then 2nd, then store 1st as it is
	        // and move its pointer
	        if(poly1->pow > poly2->pow)
	        {
	            poly->pow = poly1->pow;
	            poly->coeff = poly1->coeff;
	            poly1 = poly1->next;
	        }
	         
	        // If power of 2nd polynomial is greater then 1st, then store 2nd as it is
	        // and move its pointer
	        else if(poly1->pow < poly2->pow)
	        {
	            poly->pow = poly2->pow;
	            poly->coeff = poly2->coeff;
	            poly2 = poly2->next;
	        }
	         
	        // If power of both polynomial numbers is same then add their coefficients
	        else
	        {
	            poly->pow = poly1->pow;
	            poly->coeff = poly1->coeff+poly2->coeff;
	            poly1 = poly1->next;
	            poly2 = poly2->next;
	        }
	         
	        // Dynamically create new node
	        poly->next = (struct Node *)malloc(sizeof(struct Node));
	        poly = poly->next;
	        poly->next = NULL;
	    }
	while(poly1->next || poly2->next)
	    {
	        if(poly1->next)
	        {
	            poly->pow = poly1->pow;
	            poly->coeff = poly1->coeff;
	            poly1 = poly1->next;
	        }
	        if(poly2->next)
	        {
	            poly->pow = poly2->pow;
	            poly->coeff = poly2->coeff;
	            poly2 = poly2->next;
	        }
	        poly->next = (struct Node *)malloc(sizeof(struct Node));
	        poly = poly->next;
	        poly->next = NULL;
	    }
	}
*/
}
