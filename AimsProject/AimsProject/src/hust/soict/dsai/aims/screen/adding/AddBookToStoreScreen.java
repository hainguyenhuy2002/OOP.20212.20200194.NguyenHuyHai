package hust.soict.dsai.aims.screen.adding;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.store.Store;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfContent;
    public AddBookToStoreScreen(StoreManagerScreen screen, Store store){
        super("Book");
        container.add(new JLabel("Enter book content: "));
        tfContent = new JTextField(10);
        container.add(tfContent);

        container.setLayout(new GridLayout(4, 3,5,5));

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
		tfContent.setText("");
	}
}
