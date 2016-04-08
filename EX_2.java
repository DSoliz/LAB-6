import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;

public class EX_2 
{
	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JTextField text;
	private JLabel label;
	
	public EX_2()
	{
		panel = new JPanel();
		button1 = new JButton("F to C");
		button2 = new JButton("F to K");
		button3 = new JButton("C to K");
		button4 = new JButton("C to F");
		button5 = new JButton("K to F");
		button6 = new JButton("K to C");
		
		
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");
		
		//Load the listener
		button1.addActionListener(buttonListener());
		button2.addActionListener(buttonListener());
		button3.addActionListener(buttonListener());
		button4.addActionListener(buttonListener());
		button5.addActionListener(buttonListener());
		button6.addActionListener(buttonListener());
		
		//load the panel
		panel.add(text);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				double tempOut;
				String newText = "";
				
				try {
					double tempIn = Double.parseDouble(input);
					if(e.getSource() == button1){
						//F to C
						tempOut = (tempIn-32)*(5.0/9.0);
						if(tempOut < -273.15){
							newText = "Not a Valid Temperature";
						}else{
							newText = "Temp in C: " + String.format("%.2f",tempOut);
						}
						
					}else if(e.getSource() == button2){
						//F to K
						tempOut = (tempIn-32)*(5.0/9.0) + 273.15;
						if(tempOut < 0){
							newText = "Not a Valid Temperature";
						}else{
							newText = "Temp in K: " + String.format("%.2f",tempOut);
						}
					}else if(e.getSource() == button3){
						//C to K
						tempOut = tempIn + 273.15;
						if(tempOut < 0){
							newText = "Not a Valid Temperature";
						}else{
							newText = "Temp in K: " + String.format("%.2f",tempOut);
						}
					}else if(e.getSource() == button4){
						//C to F
						tempOut = tempIn*(1.8) + 32;
						if(tempOut < -459.67){
							newText = "Not a Valid Temperature";
						}else{
							newText = "Temp in F: " + String.format("%.2f",tempOut);
						}
					}else if(e.getSource() == button5){
						//K to F
						tempOut = tempIn*(1.8) - 459.67;
						if(tempOut < -459.67){
							newText = "Not a Valid Temperature";
						}else{
							newText = "Temp in F: " + String.format("%.2f",tempOut);
						}
					}else if(e.getSource() == button6){
						//K to C
						tempOut = tempIn  - 273.15;
						if(tempOut < -273.157){
							newText = "Not a Valid Temperature";
						}else{
							newText = "Temp in C: " + String.format("%.2f",tempOut);
						}
					}
					
				} catch (Exception a) {
					newText = "Input is not a number!!";
				}
				
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}	
}