import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Again extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String con;
	public Again(String congratulation) throws IOException {
		this.con=congratulation;
		
		
		JLabel congr = new JLabel(con);
		JLabel newGame = new JLabel("Играть снова?");
		 JButton newGameButton = new JButton("Да!");
		 JButton exitButton = new JButton("Нет!");
		 setBounds(500,200,310,180);
		 Container c = getContentPane();
			c.setLayout(new FlowLayout(FlowLayout.LEFT,30,15));
			c.add(congr);
			c.add(newGame);
			c.add(newGameButton);
			c.add(exitButton);
			
			newGameButton.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					try {
						setVisible(false); // убираем диалогово окно
						Game.w.setVisible(false); // убираем окно с предыдущей игрой
						Game.start(); // создаем новое игровое окно
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}
				});
			
			exitButton.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
					}
				});

	}
	
}
