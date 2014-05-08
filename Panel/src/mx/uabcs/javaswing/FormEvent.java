package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	private String occupation;
	private String ageCatogory;
	private int idCombo;
	private String gender;
	private int nacion_id;
	private String pais1;
	private String empleado;
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
	
	public FormEvent(Object source, String name, String occupation,String id,int idempleado,String empleado,int idPais,String gender,String pais1){
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCatogory=id;
		this.idCombo=idempleado;
		this.gender=gender;
		this.nacion_id=idPais;
		this.pais1=pais1;
		this.empleado=empleado;
		
		
	}



	public String getPais1() {
		return pais1;
	}

	public void setPais1(String pais1) {
		this.pais1 = pais1;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public int getNacion_id() {
		return nacion_id;
	}

	public void setNacion_id(int nacion_id) {
		this.nacion_id = nacion_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(int idCombo) {
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
