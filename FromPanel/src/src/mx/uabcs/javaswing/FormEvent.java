package src.mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject{
	
	private String name;
	private String occupation;

	public FormEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent (Object source,String name,String Occupation){
		super(source);
		this.name=name;
		this.occupation=occupation;
		
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

}