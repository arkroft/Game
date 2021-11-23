
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 400;
	int y = 205;
	Image fon;
	Image life;
	Image monkey;
	Image fMonkey;
	Image smallbanan;
	int slogn;
	Timer timerDraw;
	Image banan;
	Random r = new Random();
	int time;
	
	int count;//количество жизней
	int ball = 0;// набраны очки 
	int xf[] = new int[6];
	int yf[] = new int[6];
	int col1;
	
	
	public Panel(int slogn) throws IOException {
		
		smallbanan = ImageIO.read(new File("smallbanan.png"));
		monkey = ImageIO.read(new File("monkey.png"));
		fon = ImageIO.read(new File("BabanTree.jpg"));
		life = ImageIO.read(new File("life.png"));
		banan = ImageIO.read(new File("banan.png"));
		
		int col = slogn;
		count = 4 + slogn;
		for(int i=0; i<col; i++) {
			xf[i] = r.nextInt(590);
			yf[i] = -r.nextInt(300);
			
		}
			col1 = col;
			
		
		
		timerDraw = new Timer(50,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<col; i++) {
					yf[i] += 5;
					if(yf[i]>270) {
						Sound sound=new Sound("lostbonus.mp3"); // если банан пропустили -играет музыка
						new Thread(sound).start();
						count--;
						yf[i] = 0;
						xf[i] = r.nextInt(570);
					}
				}
				
				repaint();
				
			}
		});
		
		timerDraw.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) { // рисуем "очки" - маленькие бананы в верхнем правом углу
		g.drawImage(fon, 0, 0, null);
		g.drawImage(monkey, x, y, null);
		if(ball!=0) {
			for(int b = 0;b<ball;b++) {
			g.drawImage(smallbanan, 600-b*15 ,10, null);
			}
		}
		for(int i=0; i<col1; i++) {
			if(xf[i]>x-30 && xf[i]<x+128 && yf[i]>y-40 && yf[i]<270){
				yf[i] = -r.nextInt(300);
				xf[i] = r.nextInt(570);
				Sound sound=new Sound("bonus.mp3"); // если банан поймали
				new Thread(sound).start();
				ball++;


			
			}
		    
			g.drawImage(banan, xf[i] ,yf[i],null);
			
			
		}
		
		for(int i=0; i<count; i++) {
			g.drawImage(life, i*40 ,0, null);
			
		}
		if(count==0){ // если жизни закончились
			try {
				Sound sound=new Sound("loos.mp3");
				new Thread(sound).start();
				timerDraw.stop();

				stop("Вы собрали " + ball +" бананов! Гордитесь!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
				
		else if(ball == 15) { // если собрали 15 бананов
			try {
				g.drawImage(smallbanan, 600-14*15 ,10, null);
				Sound sound=new Sound("win.mp3");
				new Thread(sound).start();
				timerDraw.stop();

				stop("Поздравляем! Вы собрали " + ball +" бананов!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private void stop(String text) throws IOException {
		 Again again=new Again(text);
		 again.setVisible(true);
		 
		 
	}
		

}



