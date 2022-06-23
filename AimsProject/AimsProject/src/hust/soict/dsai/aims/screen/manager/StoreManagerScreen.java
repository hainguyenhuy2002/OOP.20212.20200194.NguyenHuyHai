package hust.soict.dsai.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.adding.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.adding.AddCDToStoreScreen;
import hust.soict.dsai.aims.screen.adding.AddDVDToStoreScreen;

import java.awt.event.*;
import hust.soict.dsai.aims.store.Store;



public class StoreManagerScreen extends JFrame{
    private Store store ;   



    public StoreManagerScreen(Store store){
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(false), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;

    }

    JMenuBar createMenuBar(){
        StoreManagerScreen screen = this;

        AddBookToStoreScreen AddingBook = new AddBookToStoreScreen(this, store);
        
        AddDVDToStoreScreen AddingDVD = new AddDVDToStoreScreen(this, store);
        
        AddCDToStoreScreen AddingCD = new AddCDToStoreScreen(this, store);

        JMenu menu = new JMenu("Options");


        JMenuItem viewstore = new JMenuItem("View store");
        viewstore.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                screen.viewStore();
            }
        });
        menu.add(viewstore);

        JMenu smUpdateStore = new JMenu("Update Store");
        

		JMenuItem Book = new JMenuItem("Add Book");
		Book.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddingBook.On();
			}
			
		});
		smUpdateStore.add(Book);
		
		
		
		JMenuItem CD = new JMenuItem("Add CD");
		CD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddingCD.On();
			}
			
		});
		smUpdateStore.add(CD);
		
		
		
		JMenuItem DVD = new JMenuItem("Add DVD");
		DVD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddingDVD.On();
			}
			
		});
        smUpdateStore.add(DVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    
    JPanel createCenter(Boolean isStore){

        JPanel center = new JPanel();
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), false);
			center.add(cell);	
		}


		return center;
    }

    JPanel StoreCenter(){
        JPanel center = new JPanel();
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        center.setLayout(new GridLayout(mediaInStore.size(), 1,1,1));
        for (int i =0; i < mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), true);
            center.add(cell);

        }
        return center;
    }

    public void viewStore() {
		Container cp = getContentPane();
		cp.removeAll();
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(StoreCenter(), BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(this);
	}


    
}
