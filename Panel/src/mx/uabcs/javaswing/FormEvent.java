package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	private String occupation;
	private int ageCatogory;
	

	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent(Object source, String name, String occupation,int ageCatogory){
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCatogory=ageCatogory;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public int getAgeCatogory() {
		return ageCatogory;
	}

	public void setAgeCatogory(int ageCatogory) {
		this.ageCatogory = ageCatogory;
	}
}
