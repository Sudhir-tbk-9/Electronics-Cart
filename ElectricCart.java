package ExceptionHandling;

public class ElectricCart {
		private int id ;
		private String category ;
		private String brand ; 
		private int price ;
		private String chargingType ;
		
		
		
	public ElectricCart(int id ,String category, String brand, int price, String chargingType ) {
			
			this.id = id;
			this.category = category;
			this.brand = brand;
			this.price = price;
			this.chargingType = chargingType;
		}
		
	public int revertPrice() {
		
		return this.price;
	}

	public int revertID() {
		
		return this.id ;
	}

	public String toString() {
		
		return "~~~> " + this.category + " with ID: " + this.id + " of brand " + this.brand + " amounting " + this.price + " supporting " + this.chargingType ;
	}

	}

//===============================================================================================================

class DuplicateException extends Exception {
	public DuplicateException(String textToAppear) {
		super(textToAppear);
		System.out.println();
	}
}

//================================================================================================================




