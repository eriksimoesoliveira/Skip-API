package br.com.skip.model;

public class Store {

	private int id;
	private String name;
	private String address;
	private Cousine cousine;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the cousine
	 */
	public Cousine getCousine() {
		return cousine;
	}
	/**
	 * @param cousine the cousine to set
	 */
	public void setCousine(Cousine cousine) {
		this.cousine = cousine;
	}
	
	
	
}
