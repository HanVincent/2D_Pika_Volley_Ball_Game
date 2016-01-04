package PIKA;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class FP extends JFrame {
	static HomePanel hpanel;
	static PlayingPanel panel;
	static ExplanationPanel epanel;
	static SetPanel spanel;
	static FP frame;
	static Clip clip ;
	
	public static void main(String[] args) {
		frame = new FP();
	}

	FP() {
		//settings of frame
		setLayout(null);
		setBounds(140, 30, 815, 635);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//play the background music
		playSound("登入音樂.wav");

		//new a panel for playing surroundings
		panel = new PlayingPanel();
		panel.setVisible(false);
		add(panel);

		//new a panel for main panel, which the first panel we see
		hpanel = new HomePanel();
		hpanel.setVisible(true);
		add(hpanel);

		//new a panel for explanation
		epanel = new ExplanationPanel();
		epanel.setVisible(false);
		add(epanel);

		//new a panel for setting the game 
		spanel = new SetPanel();
		spanel.setVisible(false);
		add(spanel);

		setVisible(true);
	}// FP constructor ends

	// for pressing login button
	public static void GotoPlay() {
		frame.setBounds(140, 30, 980, 600);
		//show playing panel, the others disappear
		panel.setVisible(true);
		hpanel.setVisible(false);
		epanel.setVisible(false);
		spanel.setVisible(false);
		
		//stop the beginning music
		clip.stop();
		//start a new music
		playSound("弓箭手村.wav");
	}
	
	// for pressing back button
	public static void GotoHome() {
		panel.setVisible(false);
		hpanel.setVisible(true);
		epanel.setVisible(false);
		spanel.setVisible(false);
	}

	// for pressing explain button
	public static void GotoExplain() {
		hpanel.setVisible(false);
		epanel.setVisible(true);
		spanel.setVisible(false);
		panel.setVisible(false);
	}

	// for pressing set button
	public static void GotoSet() {
		hpanel.setVisible(false);
		epanel.setVisible(false);
		spanel.setVisible(true);
		panel.setVisible(false);
	}

	//start music
	public static void playSound(String name) {
		try {
			//new a AudioInputStream
			AudioInputStream audioInputStream =
					AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
			clip = AudioSystem.getClip();
			//open the music file
			clip.open(audioInputStream);
			//play the music continuously
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			//if no file
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}
