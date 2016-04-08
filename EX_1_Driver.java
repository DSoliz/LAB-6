import javax.swing.*;

public class EX_1_Driver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Click counter");
		EX_1 demo = new EX_1();
		
		frame.getContentPane().add( demo.getContent() );
		
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}