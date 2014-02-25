import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class TextPanel extends JPanel 
{
	private JTextArea textArea;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
	suma,resta,division,multiplicacion,igual;
	double resultado=0,aux=0;
	
	public TextPanel ()
	{
		setLayout(new GridLayout(3, 3, 0, 0));
		//JPanel pg1 = new JPanel(new GridLayout(1, 1, 0, 0)); // Panel de caja de texto
		textArea=new JTextArea();
		textArea.setBorder(new EmptyBorder(4,4,4,4));
		//textArea.setText("0");
		add(new JScrollPane(textArea),BorderLayout.NORTH);	
		
		
		btn1=new JButton("1");
		btn1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("1");
				aux+=1;
			}	
		});
		
		btn2=new JButton("2");
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("2");
				aux+=2;
			}	
		});
		btn3=new JButton("3");
		btn3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("3");
			}	
		});
		btn4=new JButton("4");
		btn4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("4");
			}	
		});
		btn5=new JButton("5");
		btn5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("5");
			}	
		});
		btn6=new JButton("6");
		btn6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("6");
			}	
		});
		btn7=new JButton("7");
		btn7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("7");
			}	
		});
		btn8=new JButton("8");
		btn8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("8");
			}	
		});
		btn9=new JButton("9");
		btn9.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("9");
			}	
		});
		btn0=new JButton("0");
		btn0.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("0");
			}	
		});
		suma=new JButton("+");
		btn0.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				aux+=Integer.parseInt(textArea.getText());
				textArea.append("3");
			}	
		});
		resta=new JButton("-");
		division=new JButton("/");
		multiplicacion=new JButton("*");
		add("Center",btn1);
		add("Center",btn2);
		add("Center",btn3);
		add("Center",btn4);
		add("Center",btn5);
		add("Center",btn6);
		add("Center",btn7);
		add("Center",btn8);
		add("Center",btn9);
		add("Center",btn0);
		add("Center",suma);
		add("Center",multiplicacion);
		add("Center",resta);
		add("Center",division);
		
		
		
	}


}