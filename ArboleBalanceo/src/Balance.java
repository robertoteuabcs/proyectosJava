import javax.swing.JOptionPane;


public class Balance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pisos=Integer.parseInt(JOptionPane.showInputDialog("Dame un número de pisos: ")); 
	       pisos=pisos*2-1; 
	        
	       for(int i=0; i<pisos; i+=2){ 
	           for(int j=0; j<pisos-i ; j+=2){ 
	               System.out.print(" "); 
	           } 
	           for(int k=0; k<=i; k++){ 
	               System.out.print("*"); 
	           } 
	           System.out.println(); 
	}


	}
}
