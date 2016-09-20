package ru.multiplication.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.text.ParseException;

import javax.swing.BoxLayout;

public class RegistrationDlg extends JDialog {

	private JPanel contentPanel = null;
	private JButton okButton = null;
	private JButton cancelButton = null;
	private JTextField textField = null;
	private JTextField textField_1 = null;

	//----- REGISTRATION DATA
	private String login = "Anonymus";
	private String group = "Unknow";

	/**
	 * Create and config registration dialog.
	 * @throws ParseException
	 */
	public RegistrationDlg() throws ParseException {

		setAutoRequestFocus(true);
		setTitle("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 170);

		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel textPanel = new JPanel();
			textPanel.setLayout(new GridLayout(4, 1, 0, 0));
			{
				JLabel lblNewLabel = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F \u0418\u043C\u044F:");
				textPanel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setDocument(new MyCustomAwesomeListeners.FilterForReg(30));
				textPanel.add(textField);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("\u0413\u0440\u0443\u043F\u043F\u0430:");
				textPanel.add(lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setDocument(new MyCustomAwesomeListeners.FilterForReg(30));
				textPanel.add(textField_1);
			}
			contentPanel.add(textPanel);
		}

		{
			JPanel buttonPane = new JPanel();
			GridLayout gridBtn = new GridLayout(1, 2, 0, 0);
			gridBtn.setHgap(10);
			gridBtn.setVgap(1);
			buttonPane.setLayout(gridBtn);
			buttonPane.setBorder(new EmptyBorder(5, 0, 0, 0));

			{
				//-----------------------------------
				//--- OK
				okButton = new JButton("Ok");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("ok.png")));
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				okButton.setSize(100, 50);
				okButton.setFocusPainted(false);
				buttonPane.add(okButton);
			}
			{
				//-----------------------------------
				//--- Cancel
				cancelButton = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("cancel.png")));
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				cancelButton.setFocusPainted(false);
				buttonPane.add(cancelButton);
			}

			contentPanel.add(buttonPane);
		}

		setVisible(false);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}
}
