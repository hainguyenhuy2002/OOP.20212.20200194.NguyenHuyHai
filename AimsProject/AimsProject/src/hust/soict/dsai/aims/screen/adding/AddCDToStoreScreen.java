package hust.soict.dsai.aims.screen.adding;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;


    public AddCDToStoreScreen(StoreManagerScreen screen, Store store){
        super("CD");
        
        container.setLayout(new GridLayout(6, 3,10,10));
        container.add(new JLabel("Enter CD's director: "));
        tfDirector = new JTextField();
        container.add(tfDirector);
        
        container.add(new JLabel("Enter CD's length: "));
        tfLength = new JTextField();
        container.add(tfLength);

        container.add(new JLabel("Enter CD's artist"));
        tfArtist = new JTextField();
        container.add(tfArtist);

        JFrame frame = this;

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                String artist = tfArtist.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());
                String result = store.addMedia(new CompactDisc(title, category, director, length, cost, artist));
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
		tfDirector.setText("");
        tfLength.setText("");
        tfArtist.setText("");
	}
}
