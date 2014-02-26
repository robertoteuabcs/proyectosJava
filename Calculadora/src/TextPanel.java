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
	int resultado=0,aux=0;
	TextCal varia;
	JPanel text;
	
	public TextPanel ()
	{
		textArea=new JTextArea();
		textArea.setLayout(new BorderLayout());
		textArea.setLayout(new GridLayout(1, 1, 0, 0));
		//add(textArea);
		
		add(new JScrollPane(textArea),BorderLayout.NORTH);
		setLayout(new BorderLayout());
		setLayout(new GridLayout(5, 5, 0, 0));
		
		//TextCal cajatexto=new TextCal();
	    //int num=Integer.parseInt(cajatexto.getTextArea().getText());
		//JPanel pg1 = new JPanel(new GridLayout(1, 1, 0, 0)); // Panel de caja de texto

		//textArea.setBorder(new EmptyBorder(2,2,2,2));
				//textArea.setLayout(new GridLayout(4, 4, 0, 0));
				//textArea.setText("0");
				//add(new JScrollPane(textArea),BorderLayout.NORTH);	
		//add(new TextCal(),BorderLayout.CENTER);
		btn1=new JButton("1");
		btn1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("1");
				//varia.setTextArea("1");
				//cajatexto.setTextArea("1");
			}	
		});
		
		btn2=new JButton("2");
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("2");
				
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
		suma.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				aux+=Integer.parseInt(textArea.getText());
				
				textArea.setText(null);
			}	
		});
		
		igual=new JButton("=");
		igual.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.setText(null);
				textArea.append(String.valueOf(aux));
			}	
		});
		
		division=new JButton("/");
		division.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int auxd=Integer.parseInt(textArea.getText());
				aux=auxd/aux;
				textArea.setText(null);
			}	
		});
		
		multiplicacion=new JButton("*");
		multiplicacion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int auxm=Integer.parseInt(textArea.getText());
				aux=auxm*aux;
				textArea.setText(null);
			}	
		});
		
		resta=new JButton("-");
		resta.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int aux2=Integer.parseInt(textArea.getText());
				aux=aux2-aux;
				textArea.setText(null);
			}	
		});
		
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
		add("South",igual);
		
		
		
	}


}