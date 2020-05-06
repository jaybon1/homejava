package Test5;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	
	JLabel idLabel;
	JLabel pwLabel;
	
	JTextField idField;
	JPasswordField pwField;
	
	JButton loginBtn;
	JButton signBtn;
	
	ImageIcon loginIc = new ImageIcon("img/out/intro.png");
	private AlphaComposite alphaComposite;
	
	public LoginPanel(Object o) {
		idLabel = new JLabel("ID : ");
		Font f1 = new Font("Arial", Font.PLAIN, 20);
		idLabel.setFont(f1);
		idLabel.setBounds(550, 50, 100, 20);
		add(idLabel);
		
		pwLabel = new JLabel("PW : ");
		pwLabel.setFont(f1);
		pwLabel.setBounds(550, 80, 100, 20);
		add(pwLabel);
		
		idField = new JTextField();
		idField.setBounds(650, 50, 110, 20);
		add(idField);
		
		pwField = new JPasswordField();
		pwField.setBounds(650, 80, 110, 20);
		add(pwField);
		
		loginBtn = new JButton("login");
		loginBtn.setName("loginBtn");
		loginBtn.addMouseListener((MouseListener)o);
		loginBtn.setBounds(660, 110, 100, 20);
		add(loginBtn);
		
		signBtn = new JButton("sign");
		signBtn.setName("signBtn");
		signBtn.setBounds(550, 110, 100, 20);
		signBtn.addMouseListener((MouseListener)o);
		add(signBtn);
	}
	
	public String getId(){
		return idField.getText();
	}
	
	public String getPw(){
		return pwField.getText();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)100/255);
		g2.setComposite(alphaComposite);
		
		g.drawImage(loginIc.getImage(), -60, 0,/* this.getWidth(), this.getHeight(),*/ null);
		
		alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)255/255);
		g2.setComposite(alphaComposite);
		
	}
}
