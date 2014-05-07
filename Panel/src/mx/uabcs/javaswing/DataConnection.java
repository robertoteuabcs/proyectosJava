package mx.uabcs.javaswing;


import java.sql.*;
import java.util.ArrayList;


public class DataConnection {
	/**
     * atributs de la clase
     */
	private static Connection con;
    private static DataConnection INSTANCE = null;
    
    /**
     * constructor
     */
    private DataConnection(){
    	
    }
	
	/**
	 * dades de la conexio
	 */
	public static void performConnection() {
		String host = "127.0.0.1";
		String user = "root";
		String pass = "root";
		String dtbs = "bdtrabajador";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs
					+ "?" + "user=" + user + "&password=" + pass;
					con = DriverManager.getConnection(newConnectionURL);
		}catch (Exception e) {
			System.out.println("Error en la Conexion");
		}
		
	}
	
	 /**
	 * crea una instancia de conexio
	 */
	private synchronized static void createInstance() {
	        if (INSTANCE == null) { 
	            INSTANCE = new DataConnection();
	            performConnection();
	        }
	    }
	 
	    /**
	     * metode per obtenir una instancia, si ya hi existeix te la retorna sino la crea
	     * @return instancia si existeix
	     */
	    public static DataConnection getInstance() {
	        if (INSTANCE == null) createInstance();
	        return INSTANCE;
	    }
	
	/**
	 * metode per tancar la conexio
	 */
	public void closeConnection() {
		try {
			con.close();
			//System.out.println("Conexion correcta");
		}catch (Exception e) {
			System.out.println("Error en la Conexion.");
		}
	}
	
	public ResultSet getQuery(String _query)
	 {
	  Statement state = null;
	  ResultSet resultado = null;
	  try{
	   state = (Statement) con.createStatement();
	   resultado = state.executeQuery(_query);
	  }
	  catch(SQLException e)
	  {
	   e.printStackTrace();
	   
	  }
	  return resultado;
	 }
	
	public void inserta(String nom, String ocu,String edad,String cont,String gen,String pais) throws SQLException {
		String seleccion = "INSERT INTO `trabajador`(`nombre`,`ocupacion`,`edad`,`contrato`,`genero`,`pais`)VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(seleccion);
		//ps.setInt(1, w); 
		ps.setString(1, nom); 
		ps.setString(2, ocu); 
		ps.setString(3, edad);
		ps.setString(4, cont); 
		ps.setString(5, gen); 
		ps.setString(6, pais);
		
		ps.executeUpdate();
	}
}