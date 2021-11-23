import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int slogn;
	Panel panel;
	int height = 380;
	int width = 700;
	
	class MyKey extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key==39) {
				panel.x+=30;
				if(panel.x > width*0.9)
				{
					panel.x = 0;
				}
			}
			if(key==37) {
				panel.x-=30;
				if(panel.x < -width*0.2)
				{
					panel.x = (int)(width * 0.85);
				}
			}
			
		}
	}
	
	public Window(int s) throws IOException {
		addKeyListener(new MyKey());
		setBounds(200,200,width,height);
		setTitle("Помогите обезьяне собрать 15 бананов!");
		
		Container c = getContentPane();
		panel = new Panel(s);
		c.add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}



