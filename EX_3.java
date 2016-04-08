import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.Component;

public class EX_3 
{
	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JTextField firstname;
	private JTextField secondname;
	private JLabel label;
	private JLabel labelFirst;
	private JLabel labelSecond;
	
	public EX_3()
	{
		panel = new JPanel();
		button1 = new JButton("Jar Jar Binks");
		button2 = new JButton("Donald Duck");
		button3 = new JButton("Big Brother");
		button4 = new JButton("Me!!!, duh");
		
		
		firstname = new JTextField(4);
		secondname = new JTextField(4);
		label = new JLabel("Choose Very Wisely");
		labelFirst = new JLabel("First Name:");
		labelSecond = new JLabel("Second Name:");
		
		//Load the listener
		button1.addActionListener(buttonListener());
		button2.addActionListener(buttonListener());
		button3.addActionListener(buttonListener());
		button4.addActionListener(buttonListener());
		
		//load the panel
		panel.add(labelFirst);
		panel.add(firstname);
		panel.add(labelSecond);
		panel.add(secondname);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
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
				String fName;
				String sName;
				String Candidate = "";
				String newText = "";
				String txtName;
				
				try {
					fName = firstname.getText();
					sName = secondname.getText();
					txtName = fName +"_"+ sName + ".txt";
					
					if(e.getSource() == button1){
						Candidate = "Jar Jar Binks";
					}else if(e.getSource() == button2){
						Candidate = "Donald Duck";
					}else if(e.getSource() == button3){
						Candidate = "Big Brother";
					}else if(e.getSource() == button4){
						Candidate = "Me!!!, duh";
					}
					
					File myFile = new File(txtName);
					
					if (!myFile.exists()) {
						myFile.createNewFile();
						FileWriter writter = new FileWriter(myFile.getAbsoluteFile());
						BufferedWriter buffer = new BufferedWriter(writter);
						buffer.write(Candidate);
						buffer.close();
						newText = "Vote is Good";
					}else{
						newText = "You Already Voted!";
					}
					
				} catch (Exception a) {
					newText = "Invalid Names";
				}
				
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}	
}