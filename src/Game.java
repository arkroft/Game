

import java.io.IOException;

import javax.swing.JOptionPane;

public class Game {
	static Window w;
	
	public static  void start() throws IOException{
		JOptionPane.showMessageDialog(null,"Помогите обезьяне собрать 15 бананов!");
		boolean chek=true; // поверка на корректность введенных данных
		while(chek) {
		try {
		String res = JOptionPane.showInputDialog("Выберите сложность игры от 1 до 3");
		int slogn = Integer.parseInt(res);
		if(slogn>=1 && slogn<=3) {
			w = new Window(slogn); // создаем игровое окно
			w.setVisible(true);
			chek=false;
		}
		else {
			 JOptionPane.showMessageDialog(null,"Некорректный ввод сложности");
			 chek=true;
		}
	}
		catch(java.lang.NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Введите цифры!");
			chek=true;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		 start();

	}

}