import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

public class EX_1 implements ActionListener 
{
	JPanel content;
	JButton button;
	JLabel rollLabel;
	JLabel instruction;
	private JTextField text;
	
	public EX_1()
	{
		text = new JTextField(3);
		
		content = new JPanel(new GridLayout(1,1));
		button = new JButton("Roll Dice");
		rollLabel = new JLabel("");
		instruction = new JLabel("	Input Dice Range: ");
		
		//Set up the Action Listener
		button.addActionListener(this);//this instance will handle the actions
		
		content.add(instruction);
		content.add(text);
		content.add(button);
		content.add(rollLabel);	
	}
	
	public Component getContent()
	{
		return(content);
	}
	
	public void noSides(int sides){
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		String input = text.getText();
		int max = Integer.parseInt(input);
		
		Random rand = new Random();
		int dice = rand.nextInt((max - 1) + 1) + 1;
		String rolled = Integer.toString(dice);
		rollLabel.setText(rolled);
	}
	
	
}