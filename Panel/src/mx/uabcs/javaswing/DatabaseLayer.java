package mx.uabcs.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseLayer {
	private String sql;
	private Connection conn;
	private Statement stm;
	private ResultSet rs;
	
	private String server="localhost:3306";
	private String db= "bdtrabajador";
	private String user="root";
	private String pwd="root";
	
	public DatabaseLayer(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://"+server+"/"+db,user,pwd);
			stm=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean isConnected(){
		
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
	}
	
	public void queryExec(String sql){
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<FormEvent> resultQueryExec(String sql){
		ArrayList<FormEvent> list=new ArrayList<FormEvent>();
		try {
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormEvent item=new FormEvent(this);
				
				item.setName(rs.getString("nombre"));
				item.setOccupation(rs.getString("ocupacion"));
				item.setAgeCatogory(rs.getString("edad"));
				item.setIdCombo(rs.getString("contrato"));
				item.setGender(rs.getString("genero"));
				item.setPais1(rs.getString("pais"));
				item.setId(rs.getInt("id"));
				list.add(item);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void borrar(String sql){
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actQuery(FormEvent fe, String indice){
		try {
				String sql = "UPDATE trabajador "+ "SET "+"nombre ="+"'"+fe.getName()+"',"+
				"ocupacion ="+"'"+fe.getOccupation()+"',"+
				"edad="+fe.getAgeCatogory()+","+
				"contrato="+"'"+fe.getIdCombo()+"',"+
				"genero="+"'"+fe.getGender()+"',"+
				"pais="+"'"+fe.getPais1()+"'"+
				" where id="+indice+";";
				System.out.println(sql);
				stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
