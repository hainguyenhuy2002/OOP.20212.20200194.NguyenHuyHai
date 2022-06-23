package hust.soict.dsai.aims.screen.adding;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public abstract class AddItemToStoreScreen extends JFrame {
    protected static JDialog d; 
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost; 
    protected JButton btn;
    protected abstract void Clear();
 
    protected JPanel container =   new JPanel();
    public AddItemToStoreScreen(String Name){
        Container cp = getContentPane();
        setSize(700, 400 );

        JFrame f= new JFrame();  
        d = new JDialog(f , "Adding "+ Name, true);  
        
        container.add(new JLabel("Enter "+ Name+ " title: "));
        tfTitle = new JTextField(10);
        container.add(tfTitle);

        container.add(new JLabel("Enter " + Name + " Category: "));
		tfCategory = new JTextField();
		container.add(tfCategory);
		
		container.add(new JLabel("Enter " + Name + " Cost: "));
		tfCost = new JTextField();
		container.add(tfCost);

        btn = new JButton("Add");
        cp.add(btn, BorderLayout.SOUTH);
        cp.add(container, BorderLayout.LINE_START);
        cp.setVisible(true);

    }
	
	public void On() {
		Clear();
		setVisible(true);
	}


    // public static void main(String[] args){
    //     new AddItemToStoreScreen("Book");

    // }

}
