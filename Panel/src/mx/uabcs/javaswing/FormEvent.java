package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	private String occupation;
	private String ageCatogory;
	private String idCombo;
	private String gender;
	private String pais1;
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent(Object source, String name, String occupation,String id,String idCombo,String gender,String pais1){
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCatogory=id;
		this.idCombo=idCombo;
		this.gender=gender;
		this.pais1=pais1;
		
	}

	public String getPais1() {
		return pais1;
	}

	public void setPais1(String pais1) {
		this.pais1 = pais1;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(String idCombo) {
		this.idCombo = idCombo;
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
	
	public String getAgeCatogory() {
		return ageCatogory;
	}

	public void setAgeCatogory(String ageCatogory) {
		this.ageCatogory = ageCatogory;
	}
}
