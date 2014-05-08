package mx.uabcs.javaswing;

public class Empleado {
	
	private int id;
	private String empleado;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	
	public Empleado(int id, String empleado) {
		this.id = id;
		this.empleado = empleado;
	}
	
	public Empleado(Object source){
		
	}
	

}
