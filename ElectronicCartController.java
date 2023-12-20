package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;
import ExceptionHandling.ElectricCart.* ;
import java.util.Scanner;
public class ElectronicCartController {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws DuplicateException , InputMismatchException{
		int size = 0;	
		System.out.println("Enter number of devices you want to save.");
		size = scn.nextInt();
		
		ElectricCart[] array = new ElectricCart[size];
			
		for(int index = 0 ; index<array.length ; index++) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("| Enter asked details to add products in your cart |");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.print("Enter products numeric ID here : ");
			int id = scn.nextInt();
			
			String category = categories();
		
			System.out.println("Enter corresponding Brand of the product.");
			String brand = scn.next();
			
			System.out.println("Enter price of the product.");
			int price = scn.nextInt();
			
			if(price >= 30000) {
				System.out.println("***10% Discount applied as amount is more than 30k***");
				price  = price - (price*10/100);
				System.out.println(" Discounted price is : " + price);
				}
			else {
				System.out.println("***this product is not eligible for any discount***");
			}
			
			String chargingType = selectChargeWay();
			
			array[index] = new ElectricCart(id,category,brand,price,chargingType);
			
			System.out.println("=====================================================================");
			System.out.println(array[index]);
			System.out.println();
			System.out.println("=============above product is added in your cart successfully=============");
			System.out.println();
			System.out.println("select 4 to view your cart");
			int op = scn.nextInt();
			if(op == 4 ) {
				displayWholeCart (array) ;
			}
			
		}
			
			menuForFurtherOperations(array);
			
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println("<<<<<<<<<<<<<<<<<        please visit again       <<<<<<<<<<<<<<<<<");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}

	//===========================Method to select category==================================================
	public static String categories() {
		System.out.println("Select device category from below. ");
		System.out.println("press 1 for Laptop");
		System.out.println("press 2 for Headphone");
		System.out.println("press 3 for Smartwatch");
		System.out.println("press 4 for Powerbank");
		System.out.println("press 5 for Television");
		System.out.println("press 6 for Mobile phone");
		System.out.println("press 7 for Cameras");
		int select = scn.nextInt();
		
		if(select == 1) {
			return "Laptop" ;
		}
		else if(select == 2) {
			return "Headphones" ;
		}
		else if(select == 3) {
			return "Smartwatch" ;
		}
		else if(select == 4) {
			return "Powerbank" ;
		}
		else if(select == 5) {
			return "Television" ;
		}
		else if(select == 6) {
			return "Mobile phone" ;
		}
		else if(select == 7) {
			return "Camera" ;
		}
		else{
			return "Electrical Gadget" ;
		}
		
		}
	//===========================Method to select charging type==================================================

	public static String selectChargeWay() {
		System.out.println("Select charging type from below. ");
		System.out.println("press 1 for Type-A charging");
		System.out.println("press 2 for Type-C charging");
		System.out.println("press 3 for Lightening charging");
		System.out.println("press 4 for Wireless charging");
		int select = scn.nextInt();
		if(select == 1) {
			return "Type-A charging" ;
		}
		else if(select == 2) {
			return "Type-C charging" ;
		}
		else if(select == 3) {
			return "Lightening charging" ;
		}
		else if(select == 4) {
			return "Wireless charging" ;
		}
		else {
			return "Unique, never seen before charging " ;
		}
		

	}
	//===========================================Menu========================================
	public static void menuForFurtherOperations(ElectricCart[] array) {
		System.out.println("////////////////////////////////////////////////////////////////////////");
		System.out.println("// You can examine your cart using following options present to do so //");
		System.out.println("////////////////////////////////////////////////////////////////////////");
		int op=0 ;
		do {
		System.out.println("________________________________________________________________________________________________________________________________________");
		System.out.println("select 1 to get the product with lowest price");
		System.out.println("select 2 to get the products with same price");
		System.out.println("select 3 to get the product added multiple times");
		System.out.println("select 4 to view your cart");
		System.out.println("select 0 if don't want to perform any above operations");
		System.out.println("Note : this menu will appear till the time you select 0");
		op = scn.nextInt();
		
		if(op == 1) {
			printDeviceWithLowestPrice (array);		
		}
		else if(op == 2) {
			printProductWithSamePrice (array);
		}
		else if(op == 3) {
			try {
			checkDuplicateItemsInCart (array);
			}
			catch(DuplicateException exp) {
				System.out.println("Warning: " + exp.getMessage());	
			}
		}
		
		else if(op == 4 ) {
			displayWholeCart (array) ;
		}
		
		else if(op == 0) {

			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println("<<<<             Thank you for using this application          <<<<");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			
			break;
		}
		
		else { 
			System.out.println("NOTE : Invalid choice, please select only from above options only.");
		}
		
		}while(op != 0);
		
	}

	//===========================Method to retrieve product with lowest details========================================

	public static void printDeviceWithLowestPrice (ElectricCart array[]) {
		ElectricCart lowest = array[0] ;

		for(int i = 1 ; i<array.length ; i++) {
			if(lowest.revertPrice() > array[i].revertPrice()) {
				lowest = array[i];
			}
		}
		System.out.println("*************************************************************");
		System.out.println("* Details of product having lowest price is displayed below *");
		System.out.println("*************************************************************");
		System.out.println(lowest + " have lowest prices among all.");

	}

	//===========================Method to retrieve same price product ===========================================================

	public static void printProductWithSamePrice (ElectricCart[] array) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$ Products listed below have same price. $");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		int count = 1 ;
		for(int i = 0 ; i<array.length ; i++) {
			
			for(int j = i+1 ; j<array.length ; j++) {
				
				if(array[i].revertPrice() == array[j].revertPrice()) {
					System.out.println(count + ".) " + array[i]);
					count++ ;	
					System.out.println(count + ".) " + array[j]);
					count ++ ;
					}
				}
		}
		System.out.println("______________________________________________________________________________________________________");
	}

	//==============================Method to check duplicate===========================================================================================================

	public static void checkDuplicateItemsInCart (ElectricCart[] array) throws DuplicateException  {
		int repeat ;
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("^ Products listed below are saved more than once ^");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println();
		boolean [] visited = new boolean[array.length];
		
		for(int i = 0 ; i<array.length ; i++) {
			if(visited[i] == false) {
			repeat = 1 ;
			
			for(int j = i+1 ; j<array.length ; j++) {
				if(array[i].revertID() == array[j].revertID()) {
					repeat++ ;
				}	
			}
			if(repeat>1) {
			System.out.print(array[i]);
			System.out.println(" is added " + repeat + " times in your cart.");
			throw new DuplicateException("Duplicate product found..");
			
			}
		}
		
	}
		System.out.println("______________________________________________________________________________________________________");
	}
	//============================Method to show cart ===================================================================================================
	public static void displayWholeCart(ElectricCart[] array) {
	for(int ind = 0 ; ind < array.length ; ind++) {
		System.out.println(array[ind]);
		
	}	
	System.out.println();
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	//=========================================================================================================================================
	}


