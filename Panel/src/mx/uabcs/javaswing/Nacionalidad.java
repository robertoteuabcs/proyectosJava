package mx.uabcs.javaswing;

public class Nacionalidad {
	
	private int id;
	private String nacion;
	
	public Nacionalidad(Object source){
		//super(source);
		// TODO Auto-generated constructor stub
	}
	public Nacionalidad(int id, String nacion) {
		this.id = id;
		this.nacion = nacion;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNacion() {
		return nacion;
	}

	public void setNacion(String nacion) {
		this.nacion = nacion;
	}
	
	
	

}
