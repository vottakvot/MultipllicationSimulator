package ru.multiplication.gui;

import java.awt.Component;
import java.text.ParseException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.text.ParseException;
import javax.swing.Box;

public class AboutDlg extends JDialog {

	private JPanel contentPane;

	/**
	 * Create and config about dialog.
	 * @throws ParseException
	 */
	public AboutDlg(Component mainFrame) throws ParseException {

		setLocationRelativeTo(mainFrame);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setAutoRequestFocus(true);
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("\u041E \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0435");
		setResizable(false);
		setBounds(100, 100, 467, 260);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		{
			JPanel panel = new JPanel() {
					  Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("ava.png")).getImage();
					  public void paintComponent(Graphics g) {
						super.paintComponent(g);
					    g.drawImage(img, 10, 10, (getWidth() - 20), (getHeight() - 20), this);
					  }
			};

			panel.setBorder(new EmptyBorder(10, 10, 10, 10));
			panel.setMinimumSize(new Dimension(200, 200));
			panel.setMaximumSize(new Dimension(200, 200));
			panel.setPreferredSize(new Dimension(200, 200));

			contentPane.add(panel);
		}

		{
			JPanel panel2 = new JPanel() {
				  Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("background.png")).getImage();
				  public void paintComponent(Graphics g) {
					super.paintComponent(g);
				    g.drawImage(img, 10, 10, (getWidth() - 20), (getHeight() - 20), this);
				  }
			};
			panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
			panel2.setMinimumSize(new Dimension(200, 260));
			panel2.setPreferredSize(new Dimension(200, 260));
			panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	        String aboutMeAndMyShit = "<html>\n" +
	                "<b><u>\u042d\u0442\u043e \u0434\u0435\u0440\u044c\u043c\u043e, \u043a\u043e\u0442\u043e\u0440\u043e\u0435 \u043d\u0435 \u0440\u0430\u0437\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043d\u043e:</u></b> \n" +
	                "<ul>\n" +
	                "<li><font color=#4D4D4D><i>\u043c\u043d\u043e\u044e</i></font>\n" +
	                "<li><font color=#4D4D4D><i>\u043c\u043e\u0439 \u0430\u0434\u0440\u0435\u0441: </i></font><a href='http://9gag.com'><i>shit@shit.com</i></a>\n" +
	                "<li><font color=#4D4D4D><i>\u043d\u0435\u043f\u043b\u043e\u0445\u043e \u0432\u044b\u0433\u043b\u044f\u0434\u0438\u0442</i></font>\n" +
	                "<li><font color=#4D4D4D><i>\u043a\u0440\u043e\u0441\u0441\u043f\u043b\u0430\u0442\u0444\u043e\u0440\u043c\u0435\u043d\u043d\u043e\u0435</i></font>\n" +
	                "<li><font color=#4D4D4D><i>\u043d\u0443 \u0447\u0442\u043e \u0435\u0449\u0435</i></font>\n" +
	                "<li><font color=#4D4D4D><i>\u043e\u043a\u043d\u0430 \u0440\u0430\u0441\u0442\u044f\u0433\u0438\u0432\u0430\u044e\u0442\u0441\u044f</i></font>\n" +
	                "<li><font color=#4D4D4D><i>\u0432\u043e\u0442 \u0442\u0430\u043a</i></font>\n" +
	                "<li><font color=#4D4D4D><i>\u0432\u043e\u0442</i></font>\n" +
	                "</ul>\n";

	        {
				JTextPane textPane = new JTextPane();
				textPane.setContentType("text/html");
				textPane.setText(aboutMeAndMyShit);
				textPane.setEditable(false);
				textPane.setOpaque(false);
				textPane.addHyperlinkListener(new MyCustomAwesomeListeners.ActivatedHyperlinkListener());
				panel2.add(textPane);
	        }
			contentPane.add(panel2);
		}

		setEnabled(false);
		setVisible(false);
	}
}
