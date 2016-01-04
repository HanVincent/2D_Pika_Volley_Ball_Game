package PIKA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	Clip clip;

	HomePanel() {
		// the HomePanel settings
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		// login(start) button
		JButton start = new JButton(new ImageIcon("登入.png"));
		start.setBounds(455, 280, 48, 48);
		// button action listener
		start.addActionListener(new startBtn());
		add(start);

		// explain button
		JButton explain = new JButton(new ImageIcon("說明.png"));
		explain.setBounds(292, 353, 67, 28);
		// button action listener
		explain.addActionListener(new explainBtn());
		add(explain);

		// settings button
		JButton settings = new JButton(new ImageIcon("設定.png"));
		settings.setBounds(364, 353, 67, 28);
		// button action listener
		settings.addActionListener(new setBtn());
		add(settings);

		// end button
		JButton end = new JButton(new ImageIcon("結束.png"));
		end.setBounds(436, 353, 67, 28);
		// button action listener
		end.addActionListener(new End());
		add(end);

		// Label to put picture(background)
		JLabel BG = new JLabel(new ImageIcon("楓之谷.png"));
		BG.setBounds(0, 0, 800, 600);
		add(BG);
	}

	// HomePanel constructor ends

	// start button action listener
	private class startBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setBounds(0, 0, 960, 560);
			Thread t1 = new Thread(PlayingPanel.ball);
			t1.start();
			FP.GotoPlay();
		}
	}

	// startBtn end

	// explain button action listener
	private class explainBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			FP.GotoExplain();
		}
	}

	// explainBtn ends

	// set button action listener
	private class setBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			FP.GotoSet();
		}
	}

	// setBtn ends

	// end button action listener
	private class End implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	}
	// endBtn ends
}
