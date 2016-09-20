package ru.multiplication.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.text.ParseException;

public class InputDataDlg extends JDialog {

	private JButton okButton = null;
	private JButton cancelButton = null;
	private JPanel contentPanel = null;
	private JPanel commonPane = null;
	private JTextField [] inputTextFiels = new JTextField[4];
	private int sizeData = 0;
	private int numberOfMethod = 0;

	private String firstMult = "000000000";
	private String secondMult = "000000000";

	public InputDataDlg(int sizeData)  throws ParseException {
		this.sizeData = sizeData;
		setBounds(100, 100, 235, 290);
		setModal(true);
		setTitle("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u0441\u0445\u043e\u0434\u043d\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435");
		setResizable(false);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		commonPane = new JPanel();
		commonPane.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"\u0418\u0441\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435 \u0432 \u041F\u041A",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		contentPanel.add(commonPane);
		commonPane.setLayout(null);

		firstNum();
		secondNum();
		createButtons();

		setEnabled(false);
		setVisible(false);
	}

	//----- DIGLI DIGLI
	private void firstNum() {
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u041C\u043D\u043E\u0436\u0438\u0442\u0435\u043B\u044C",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(21, 23, 180, 84);
		commonPane.add(panel_2);
		panel_2.setLayout(null);

		JTextField signFirst = new JTextField();
		inputTextFiels[0] = signFirst;
		signFirst.setDocument(new MyCustomAwesomeListeners.FilterForInput(2));
		signFirst.setHorizontalAlignment(JTextField.CENTER);
		signFirst.setBounds(21, 41, 26, 20);
		panel_2.add(signFirst);
		signFirst.setColumns(10);

		JTextField mantissaFirst = new JTextField();
		inputTextFiels[1] = mantissaFirst;
		mantissaFirst.setDocument(new MyCustomAwesomeListeners.FilterForInput(sizeData));
		mantissaFirst.setHorizontalAlignment(JTextField.CENTER);
		mantissaFirst.setBounds(77, 41, 86, 20);
		panel_2.add(mantissaFirst);
		mantissaFirst.setColumns(10);

		JLabel label = new JLabel(
				"\u041C\u0430\u043D\u0442\u0438\u0441\u0441\u0430");
		label.setBounds(89, 23, 69, 14);
		panel_2.add(label);

		JLabel label_1 = new JLabel("\u0417\u043D\u0430\u043A");
		label_1.setBounds(21, 23, 46, 14);
		panel_2.add(label_1);
	}

	//----- BOM BOM
	private void secondNum() {
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u041C\u043D\u043E\u0436\u0438\u043C\u043E\u0435",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(21, 118, 180, 84);
		commonPane.add(panel_1);

		JTextField signSecond = new JTextField();
		inputTextFiels[2] = signSecond;
		signSecond.setDocument(new MyCustomAwesomeListeners.FilterForInput(2));
		signSecond.setHorizontalAlignment(JTextField.CENTER);
		signSecond.setColumns(10);
		signSecond.setBounds(21, 41, 26, 20);
		panel_1.add(signSecond);

		JTextField mantissaSecond = new JTextField();
		inputTextFiels[3] = mantissaSecond;
		mantissaSecond.setDocument(new MyCustomAwesomeListeners.FilterForInput(sizeData));
		mantissaSecond.setHorizontalAlignment(JTextField.CENTER);
		mantissaSecond.setColumns(10);
		mantissaSecond.setBounds(77, 41, 86, 20);
		panel_1.add(mantissaSecond);

		JLabel label_2 = new JLabel(
				"\u041C\u0430\u043D\u0442\u0438\u0441\u0441\u0430");
		label_2.setBounds(89, 23, 69, 14);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("\u0417\u043D\u0430\u043A");
		label_3.setBounds(21, 23, 46, 14);
		panel_1.add(label_3);
	}

	//----- FUCK BUTTONS
	private void createButtons() {
		Dimension forButtons = new Dimension();
		JPanel buttonPane = new JPanel();
		GridLayout gridBtn = new GridLayout(1, 2, 0, 0);
		gridBtn.setHgap(10);
		gridBtn.setVgap(1);
		buttonPane.setLayout(gridBtn);
		buttonPane.setBorder(new EmptyBorder(5, 0, 0, 0));
		forButtons.setSize(235, 35);
		buttonPane.setMaximumSize(forButtons);

		okButton = new JButton("Ok");
		okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		okButton.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("ok.png")));
		okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		okButton.setFocusPainted(false);
		okButton.setEnabled(false);
		buttonPane.add(okButton);

		cancelButton = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("cancel.png")));
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelButton.setFocusPainted(false);
		buttonPane.add(cancelButton);

		contentPanel.add(buttonPane);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField[] getInputTextFiels() {
		return inputTextFiels;
	}

	public int getSizeData() {
		return sizeData;
	}

	public String getFirstMult() {
		return firstMult;
	}

	public void setFirstMult(String firstMult) {
		this.firstMult = firstMult;
	}

	public String getSecondMult() {
		return secondMult;
	}

	public void setSecondMult(String secondMult) {
		this.secondMult = secondMult;
	}

	public int getNumberOfMethod() {
		return numberOfMethod;
	}

	public void setNumberOfMethod(int numberOfMethod) {
		this.numberOfMethod = numberOfMethod;
	}
}
