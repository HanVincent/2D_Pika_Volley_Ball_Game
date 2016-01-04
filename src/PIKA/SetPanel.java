package PIKA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetPanel extends JPanel {
	SetPanel(){
		setLayout(null);
		setBounds(0,0,960,560);
		setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
		
		JButton back = new JButton("Back");
		back.setBounds(390, 250, 70, 30);
		back.addActionListener(new Back());
		add(back);
		
		// label for background
		JLabel epPic = new JLabel(new ImageIcon("說明圖.jpg"));
		epPic.setBounds(0, 0, 800, 600);
		add(epPic);
	}

	private class Back implements ActionListener{
		  @Override
		  public void actionPerformed(ActionEvent e){
			  FP.GotoHome();
		  }
	}//Back end
}
