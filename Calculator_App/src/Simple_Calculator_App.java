/*
 * Author:Jonathan Moreno
 * Date of Completion: 5/30/2014
 *  
 * This calculator application 1.0 is a simple application that does basic arithmetic; 
 * addition, subtraction, multiplication, and division. The program does include damage control (Error Handling). 
 * This is in the case of the user inputs and/or press the unspecified commands. 
 * Once an error has occurred the CLR button will remove the error messages in either the JTextField and JTextArea
 * This program was created to show case my programming skills with Java Object Oriented Programming. 
 * 
 */


/*
 * import classes that are used with the program
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Simple_Calculator_App extends JFrame implements ActionListener {

/*
 * Instance classes with variables 
 */
		JButton jb1;
		JButton jb2;
		JButton jb3;
		JButton jb4;
		JButton jb5;
		
		JPanel mainpanel;
		JPanel panel1 ;
		JPanel panel2 ;
		JPanel panel3;
		 
		JLabel label1;
		JLabel label2;
		 
		JTextArea areatext;
		JTextField inputnum;
		JTextField inputnum2;
	
/*
 * Main Class that implements the JFrame
 */
public Simple_Calculator_App(){
	System.out.println("The Method Calculator");
	setLocation(100,100); 
	setSize(300, 200);
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	setTitle("Calculator Application");
	
		    jb1 = new JButton("+");
			jb1.addActionListener(this);
			jb1.setBackground(Color.GRAY);
			jb2 = new JButton("-");
			jb2.addActionListener(this);
			jb2.setBackground(Color.GRAY);
			jb3 = new JButton("*");
			jb3.addActionListener(this);
			jb3.setBackground(Color.GRAY);
			jb4 = new JButton("/");
			jb4.addActionListener(this);
			jb4.setBackground(Color.GRAY);
			jb5 = new JButton("CLR");
			jb5.addActionListener(this);
			jb5.setBackground(Color.GRAY);
			
			 inputnum = new JTextField(6);
			 inputnum.setForeground(Color.BLUE); 
			 inputnum2 = new JTextField(6);
			 inputnum2.setForeground(Color.BLUE); 
			 
			 label1= new JLabel("arithmetical value X", JLabel.CENTER);
			 label2= new JLabel("arithmetical value Y",JLabel.CENTER);
			 
			 areatext = new JTextArea(5,20);
			 areatext.setForeground(Color.BLUE); 
			 
			 mainpanel = new JPanel(new BorderLayout());
			 panel1 = new JPanel(new GridLayout(2,2, 10, 5));
			 panel2 = new JPanel();
			 panel3= new JPanel();
			 
			 System.out.println("At mainpanel");
			 add(mainpanel);
			 mainpanel.add(panel1, BorderLayout.NORTH);
			  mainpanel.add(panel2, BorderLayout.CENTER);
			  mainpanel.add(panel3, BorderLayout.SOUTH);
			  panel1.setBackground(Color.black);
			  panel2.setBackground(Color.black);
			  panel3.setBackground(Color.black);
			  
			  panel1.add(label1);
			  panel1.add(inputnum);
			  panel1.add(label2);
			  panel1.add(inputnum2);
			  
			  panel2.add(areatext);
			  
			  panel3.add(jb1);
			  panel3.add(jb2);
			  panel3.add(jb3);
			  panel3.add(jb4);
			  panel3.add(jb5);
			  setVisible(true);
			
		
}
	
/*
 * This is the main method
 */
public static void main(String [] args){
	System.out.println("This is my calculator project");
	 new Simple_Calculator_App();
	 
}
/*
 * This is the controls that gives the conditions for the JButtons
 * The controls also have the model/computations involved for the arithmetic within 
 * the conditionals
 */
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("at Action Performed");
	Object source=e.getSource();
	double x1, y1;
	String value;
	String value2;
	double answer;
			try{
				value= inputnum.getText();
				x1=Double.parseDouble(value);
				value2= inputnum2.getText();
				y1=Double.parseDouble(value2);
				System.out.println("at computations");
						if(source==jb1){
							answer= x1+y1;
							areatext.setText("X+Y ="+ answer );
						}else if(source==jb2){
							answer= x1-y1;
							areatext.setText("X-Y ="+ answer );	
						}else if(source==jb3){
							answer= x1*y1;
							areatext.setText("X*Y ="+ answer );
						}else if(source==jb4){
							if(y1==0){
							areatext.setText("Invalid Operation"); 
							areatext.setForeground(Color.RED);  
							inputnum2.setText("Invalid Operation");
							inputnum2.setForeground(Color.RED); 
							}else{
							 answer= x1/y1;
							areatext.setText("X/Y ="+ answer );
							}	
						}else if(source==jb5){
							areatext.setText("");
							inputnum.setText("");
							inputnum2.setText("");
						}
						
			}catch(NumberFormatException e1){
							areatext.setText("Illegal Input");
							areatext.setForeground(Color.RED);  
							inputnum.setText("Illegal Input");
							inputnum.setForeground(Color.RED);  
							inputnum2.setText("Illegal Input");
							inputnum2.setForeground(Color.RED); 
		   	}
						if(source==jb5){
							areatext.setText("");
							areatext.setForeground(Color.BLUE); 
							inputnum.setText("");
							inputnum.setForeground(Color.BLUE);  
							inputnum2.setText("");
							inputnum2.setForeground(Color.BLUE); 
						}
			

	}

/*
 * Another way to do the computations is a method
 * public void method(double x, double y)
 * the computations/conditionals 
 * returns computations to the controls for each conditional
 * once that conditional has been performed
 */
}
