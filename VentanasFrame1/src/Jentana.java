	import javax.swing.JButton;
	import javax.swing.JFrame;
	
	
	public class Jentana extends JFrame{
		
	
			private int altura=0;
			private int ancho=0;
			private String titulo="";
			JButton btn;
			
			public Jentana(int ancho, int altura, String titulo){
				this.setSize(ancho, altura);
				this.titulo=titulo;
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				btn = new JButton("Hola mundo");
				this.add(btn);
				this.setVisible(true);
			}
			
			public Jentana(){
				btn = new JButton("Hola mundo");
				this.add(btn);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
			}
			
			
	
	
	}
