package PIKA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball extends JPanel implements Runnable {
	private int bx = 50, by = 0;
	private double dx = 1, dy = 1;

	Ball() {
		//Ball settings
		JLabel ballpic = new JLabel(new ImageIcon("楓葉.gif"));
		// ballpic.setOpaque(true);
		// setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setBounds(bx, by, 100, 100);
		add(ballpic);
	}

	//run for thread
	public void run() {
		Timer timer = new Timer(1, new TimerListener());// new a timer to
														// control the moving
														// button
		timer.start();// start
	}

	//time listener for ball
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// if touch the left or right then bounce
			if (bx < 0 || bx > 880) {
				dx = dx * (-1);
			}
			
			// if touch the top or bottom then bounce
			if (by < 0 || by > 440) {
				dy = dy * (-1);
			}
			
			// Touch player1 top
			if (by + 80 > PlayingPanel.player1.getY() && 
					(bx > PlayingPanel.player1.getX() - 80 && bx < PlayingPanel.player1
							.getX() + 80)) {
				dy = dy * (-1);
			}
			
			// Touch player1 right or left
			else if ((bx == PlayingPanel.player1.getX()+100 || bx +80 == PlayingPanel.player1.getX()) && 
					(by + 80 > PlayingPanel.player1.getY())) {
				dx = dx * (-1);
			}
			
			// Touch player2 top
			if (by + 80 > PlayingPanel.player2.getY() && 
					(bx > PlayingPanel.player2.getX() - 80 && bx < PlayingPanel.player2.getX() + 80)) {
				dy = dy * (-1);
			}
			
			// Touch player2 right or left
			else if ((bx == PlayingPanel.player2.getX()+100 || bx +80 == PlayingPanel.player2.getX()) && 
					(by + 80 > PlayingPanel.player2.getY())) {
				dx = dx * (-1);
			}
			
			//Touch the poll top
			if (by + 100 == PlayingPanel.poll.getY() + 6 &&
			   (bx + 80 > PlayingPanel.poll.getX() && bx < PlayingPanel.poll.getX() + 20)) {
				dy = dy * (-1);
				
			//Touch the poll left and right
			} else if ((bx + 80 > PlayingPanel.poll.getX() && bx < PlayingPanel.poll.getX() + 20)
					&& (by + 80 > PlayingPanel.poll.getY() && by + 80 < PlayingPanel.poll
							.getY() + 230)) {
				dx = dx * (-1);
			}
			
			//new it location
			bx = (int) (bx + dx);
			by = (int) (by + dy);
			//change it location
			setLocation(bx, by);
		}
	}
}
