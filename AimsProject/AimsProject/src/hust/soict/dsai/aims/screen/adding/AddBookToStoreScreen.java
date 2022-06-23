package hust.soict.dsai.aims.screen.adding;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.store.Store;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfContent;
    public AddBookToStoreScreen(StoreManagerScreen screen, Store store){
        super("Book");
        d.add(new JLabel("Enter book content: "));
        tfContent = new JTextField(10);
        d.add(tfContent);


        JFrame frame = this;

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                String content = tfContent.getText();
                String result = store.addMedia(new Book(title, category, cost, content));
				JOptionPane.showMessageDialog(frame, result);
                reset();
                screen.viewStore();

            }
        });

        
        // public void actionPerformed(ActionEvent e) {
        //     String title = tfTitle.getText();
        //     String category = tfCategory.getText();
        //     float cost = Float.parseFloat(tfCost.getText());
        //     int length = Integer.parseInt(tfLength.getText());
        //     String director = tfDirector.getText();
        //     String result = store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        //     JOptionPane.showMessageDialog(frame, result);
        //     reset();
        //     scr.viewStore();
        // }

    }
    @Override
	protected void reset() {
		tfTitle.setText("");
		tfCategory.setText("");
		tfCost.setText("");
		tfContent.setText("");
	}
}
