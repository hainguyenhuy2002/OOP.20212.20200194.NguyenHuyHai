package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import java.awt.event.*;


public class MediaStore extends JPanel {
    private Media media;
    private static JDialog d; 
    public MediaStore(Media media, Boolean isStore){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+ media.getCost()+ " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();

        if (isStore == false) {
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);
			
		} else if (isStore == true) {
            this.setLayout(new GridLayout(1, 2));
            title.setAlignmentY(CENTER_ALIGNMENT);
            cost.setAlignmentY(CENTER_ALIGNMENT);
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            this.add(title);
            this.add(cost);
            this.add(container);
		}

        if(media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String result;
                    try{
                    result = ((Playable) media).play();
                    JFrame f= new JFrame();  
                    d = new JDialog(f , media.getTitle(), true);  
                    d.setLayout( new FlowLayout() );  
                    d.add( new JLabel (result));  
                    d.setSize(400,100);    
                    d.setVisible(true); 
                    }
                    catch (PlayerException e1) {
						// TODO Auto-generated catch block
						result = e1.getMessage();
					}
    }  
                }
            );
            container.add(playButton);

        }

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
