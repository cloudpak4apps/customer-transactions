package application.domain;

import java.io.Serializable;

public class Transaction implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	private int id;
	private float amount;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public Transaction(int id, float amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	public Transaction() {
		super();
		this.amount = 0f;
		this.id = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [getId()=");
		builder.append(getId());
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
