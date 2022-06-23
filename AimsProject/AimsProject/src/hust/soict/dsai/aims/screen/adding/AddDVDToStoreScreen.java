package hust.soict.dsai.aims.screen.adding;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen{
    private static JDialog d; 

	private JTextField tfDirector;
	private JTextField tfLength;
	
	public AddDVDToStoreScreen(StoreManagerScreen screen, Store store) {
		super("DVD");
		
		container.add(new JLabel("Enter a DVD Director: "));
		tfDirector =  new JTextField();
        container.add(tfDirector);
		container.add(new JLabel("Enter a DVD Length: "));
        tfLength = new JTextField();
		container.add(tfLength);
		
        container.setLayout(new GridLayout(5, 3,5,5));
		JFrame frame = this;
        
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = tfTitle.getText();
				String category = tfCategory.getText();
				String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());
				String result = store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				JOptionPane.showMessageDialog(frame, result);
				Clear();
				screen.viewStore();
			}
		});
	}

	@Override
	protected void Clear() {
		tfTitle.setText("");
		tfCategory.setText("");
		tfCost.setText("");
		tfLength.setText("");
		tfDirector.setText("");
	}
	
}
