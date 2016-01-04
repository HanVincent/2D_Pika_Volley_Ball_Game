package PIKA;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayingPanel extends JPanel implements KeyListener {
	//player1 beginning location
	protected int x1 = 80, y1 = 460;
	//player2 beginning location
	protected int x2 = 840, y2 = 460;
	//the vector, the distance they move
	private int dx = -70, dy = -70;
	static JLabel player1;
	static JLabel player2;
	static JLabel poll;
	static Ball ball;

	PlayingPanel() {
		//PlayingPanel constructor
		setLayout(null);
		setBounds(0, 0, 960, 560);

		//label for poll
		poll = new JLabel(new ImageIcon("排球竿.png"));
		poll.setBounds(465, 330, 20, 230);
		//poll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(poll);

		//label for player1
		player1 = new JLabel(new ImageIcon("綠水靈Right_0.gif"));
		player1.setBounds(x1, y1, 100, 80);
		// player1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(player1);
		
		//player1's Keylistener
		KeyListener p1KeyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			//When the key pressed
			@Override
			public void keyPressed(KeyEvent e) {
				//read the key pressed
				switch (e.getKeyCode()) {
				//up
				case KeyEvent.VK_R:
					//change its location
					player1.setLocation(x1, y1-100);
					break;
				//down
				case KeyEvent.VK_F:
					break;
				//left
				case KeyEvent.VK_D:
					if (x1 > 20) {
						x1 = x1 + dx;
					}
					//change its location
					player1.setLocation(x1, y1);
					break;
				//right
				case KeyEvent.VK_G:
					if (x1 < 320) {
						x1 = x1 - dx;
					}
					//change its location
					player1.setLocation(x1, y1);
					break;
				}
			}//keyPressed ends
		};
		//player1 Keylistener ends
		//add p1KeyListener
		addKeyListener(p1KeyListener);

		//label for player2
		player2 = new JLabel(new ImageIcon("綠水靈Left_0.gif"));
		player2.setBounds(x2, y2, 100, 80);
		// player2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(player2);

		//player2 Keylistener
		KeyListener p2KeyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			//when the key pressed
			@Override
			public void keyPressed(KeyEvent e) {
				//read the key pressed
				switch (e.getKeyCode()) {
				//up
				case KeyEvent.VK_UP:
					player2.setLocation(x2, y2-100);
					break;
				//down
				case KeyEvent.VK_DOWN:
					break;
				//left
				case KeyEvent.VK_LEFT:
					if (x2 > 520) {
						x2 = x2 + dx;
					}
					//change its location
					player2.setLocation(x2, y2);
					break;
				//right
				case KeyEvent.VK_RIGHT:
					if (x2 < 840) {
						x2 = x2 - dx;
					}
					//change its locaton
					player2.setLocation(x2, y2);
					break;
				}//switch ends
			}//pressed key ends
		};
		//player2 key listener ends
		//add player2 key listener
		addKeyListener(p2KeyListener);

		ball = new Ball();
		add(ball);

		//label for background
		JLabel BG = new JLabel(new ImageIcon("弓箭手村.png"));
		BG.setBounds(0, 0, 960, 560);
		add(BG);
		//key focus
		setFocusable(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
