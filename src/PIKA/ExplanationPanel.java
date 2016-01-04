package PIKA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExplanationPanel extends JPanel {

	// Explanation construction
	ExplanationPanel() {
		// panel settings
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

		// back button to home panel
		JButton back = new JButton("Back");
		back.setBounds(390, 250, 70, 30);
		back.setOpaque(true);
		// button action listener
		back.addActionListener(new Back());
		add(back);

		// label for background
		JLabel epPic = new JLabel(new ImageIcon("說明圖.jpg"));
		epPic.setBounds(0, 0, 800, 600);
		add(epPic);
	}

	// ExplanationPanel constructor ends

	// Back button ends
	private class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// back to home panel
			FP.GotoHome();
		}
	}
	// Back end
}
