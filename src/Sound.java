import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player; // используем библиотеку jlayer для работы с mp3 файлами

public class Sound implements Runnable{ // используем второй поток, чтобы игра не висла, пока играет музыка
	String path;
	public Sound(String path) {
		this.path=path;
	}
	
	@Override
	public void run() { // функция проиграывания звуков 
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        Player playMP3 = null;
		try {
			playMP3 = new Player(fis);
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
        try {
			playMP3.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		
	}

	
}