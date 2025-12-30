 // OrderPOJO.java is a POJO class (Plain Old Java Object)

package api.payload;

public class OrderPOJO {

/*
	  Payload :-
	  
	 { 
	   "id": 10, 
	   "petId": 2, 
	   "quantity": 5, 
	   "shipDate":"2025-12-25T09:25:14.778+0000", 
	   "status": "placed", 
	   "complete": true 
	 }
	  
 */

	private int id;
	private int petId;
	private int quantity;
	private String shipDate;
	private String status; // placed | approved | delivered
	private boolean complete; // true | false

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public String setStatus(String status) {
		return this.status = status;
	}

	public boolean isComplete() { // boolean getter → isComplete()
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}


}
