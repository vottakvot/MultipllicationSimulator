package ru.multiplication.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class MyCustomAwesomeTaskJPane extends JPanel {

	private static final long serialVersionUID = 1L;
	//----- BUTTONS
	private JButton taskBtnOk;
	private JButton taskBtnCancel;

	//----- RADIO BUTTONS
	private ButtonGroup group[] = new ButtonGroup[7];

	//----- RG1
	protected JRadioButton taskRadioBtnLeft1 = new JRadioButton();
	protected JRadioButton taskRadioBtnRight1 = new JRadioButton();
	protected JRadioButton taskRadioBtnNone1 = new JRadioButton();
	//----- RG2
	protected JRadioButton taskRadioBtnLeft2_Shift = new JRadioButton();
	protected JRadioButton taskRadioBtnRight2_Shift = new JRadioButton();
	protected JRadioButton taskRadioBtnNone2 = new JRadioButton();

	protected JRadioButton taskRadioBtnLeft2_typeReg = new JRadioButton();
	protected JRadioButton taskRadioBtnRight2_typeReg = new JRadioButton();
	protected JRadioButton taskRadioBtnNone3 = new JRadioButton();

	protected JRadioButton taskRadioBtnLeft2_sizeReg = new JRadioButton();
	protected JRadioButton taskRadioBtnRight2_sizeReg = new JRadioButton();
	protected JRadioButton taskRadioBtnNone4 = new JRadioButton();

	protected JRadioButton taskRadioBtnLeft2_oldBit = new JRadioButton();
	protected JRadioButton taskRadioBtnRight2_oldBit = new JRadioButton();
	protected JRadioButton taskRadioBtnNone5 = new JRadioButton();

	//----- RG3
	protected JRadioButton taskRadioBtnLeft3_typeReg = new JRadioButton();
	protected JRadioButton taskRadioBtnRight3_typeReg = new JRadioButton();
	protected JRadioButton taskRadioBtnNone6 = new JRadioButton();
	protected JRadioButton taskRadioBtnLeft3_Shift = new JRadioButton();
	protected JRadioButton taskRadioBtnRight3_Shift = new JRadioButton();
	protected JRadioButton taskRadioBtnNone7 = new JRadioButton();

	//----- CONSTRUCTOR
	MyCustomAwesomeTaskJPane(String methodName)  throws ParseException {

		setBorder(new CompoundBorder(	new SoftBevelBorder( BevelBorder.RAISED, null, null, null, null), new CompoundBorder(UIManager.getBorder("TitledBorder.border"),
										new EmptyBorder(10, 10, 10, 10))));
		GridBagLayout gbl_Task = new GridBagLayout();
		gbl_Task.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gbl_Task.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0, 30, 0 };
		gbl_Task.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0 };
		gbl_Task.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0 };
		setLayout(gbl_Task);

		for (int i = 0; i < group.length; i++)
			group[i] = new ButtonGroup();

		// Main label of this window
		setHeadLabelPane("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0443 \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0430 \u0434\u043b\u044f \u0443\u043c\u043d\u043e\u0436\u0435\u043d\u0438\u044f " +
						methodName +
						" \u0441\u043f\u043e\u0441\u043e\u0431\u043e\u043c");
		// First multiplier
		setFirstMultiplierPane("\u0440\u0435\u0433\u0438\u0441\u0442\u0440 \u043C\u043D\u043E\u0436\u0438\u0442\u0435\u043B\u044F");
		// Second multiplier
		setSecondMultiplierPane("\u0440\u0435\u0433\u0438\u0441\u0442\u0440 \u043c\u043d\u043e\u0436\u0438\u043c\u043e\u0433\u043e");
		// Result
		setResultMultiplierPane("\u0440\u0435\u0433\u0438\u0441\u0442\u0440 \u0441\u0443\u043c\u043c\u044b \u0447\u0430\u0441\u0442\u0438\u0447\u043d\u044b\u0445 \u043f\u0440\u043e\u0438\u0437\u0432\u0435\u0434\u0435\u043d\u0438\u0439");

		Component verticalStrut_2 = Box.createVerticalStrut(0);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 0);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 13;
		add(verticalStrut_2, gbc_verticalStrut_2);

		// Two button OK and Cancel
		setBtnOkAndCancel();

		Component verticalStrut_3 = Box.createVerticalStrut(0);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 0);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 15;
		add(verticalStrut_3, gbc_verticalStrut_3);

		setVisible(true);
		setEnabled(true);
	}

	//----- HEAD LABEL
	private void setHeadLabelPane(String strHead) {
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 20;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		panel.setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel_1 = new JLabel(strHead);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		add(panel, gbc_panel);
	}

	//----- RG1 PANE
	private void setFirstMultiplierPane(String strFirst) {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"<html><p align='center'><font size='6'><b>RG1</b></font><br>" + strFirst +"</p>",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.gridheight = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		panel_1.add(verticalStrut_1);
		JPanel pan1 = new JPanel();
		createCustomPane(pan1,
						"\u041d\u0430\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0441\u0434\u0432\u0438\u0433\u0430",
						taskRadioBtnRight1, "\u0412\u043f\u0440\u0430\u0432\u043e",
						taskRadioBtnLeft1, "\u0412\u043b\u0435\u0432\u043e",
						taskRadioBtnNone1, "\u041d\u0435\u0442",
						0);
		panel_1.add(pan1);
	}

	//----- RG2 PANE
	private void setSecondMultiplierPane(String strSecond) {
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"<html><p align='center'><font size='6'><b>RG2</b></font><br>" + strSecond +"</p>",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 6;
		gbc_panel_2.gridheight = 10;
		gbc_panel_2.insets = new Insets(0, 0, 0, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 8;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		JPanel pan2_shift = new JPanel();
		JPanel pan2_typeReg = new JPanel();
		JPanel pan2_sizeReg = new JPanel();
		JPanel pan2_oldBit = new JPanel();
		createCustomPane(
				pan2_shift,
				"\u041d\u0430\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0441\u0434\u0432\u0438\u0433\u0430",
				taskRadioBtnRight2_Shift,
				"\u0412\u043f\u0440\u0430\u0432\u043e",
				taskRadioBtnLeft2_Shift, "\u0412\u043b\u0435\u0432\u043e",
				taskRadioBtnNone2, "\u041d\u0435\u0442",
				1);
		createCustomPane(pan2_typeReg,
				"\u0420\u0435\u0433\u0438\u0441\u0442\u0440",
				taskRadioBtnRight2_typeReg,
				"\u0421\u0434\u0432\u0438\u0433\u043e\u0432\u044b\u0439",
				taskRadioBtnLeft2_typeReg,
				"\u041d\u0435 \u0441\u0434\u0432\u0438\u0433\u043e\u0432\u044b\u0439",
				taskRadioBtnNone3, "\u041d\u0435\u0442",
				2);
		createCustomPane(
				pan2_sizeReg,
				"\u0420\u0430\u0437\u0440\u044f\u0434\u043d\u043e\u0441\u0442\u044c \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430",
				taskRadioBtnRight2_sizeReg,
				"n - \u0440\u0430\u0437\u0440\u044f\u0434\u043d\u044b\u0439",
				taskRadioBtnLeft2_sizeReg,
				"2n - \u0440\u0430\u0437\u0440\u044f\u0434\u043d\u044b\u0439",
				taskRadioBtnNone4, "\u041d\u0435\u0442",
				3);
		createCustomPane(
				pan2_oldBit,
				"\u0417\u0430\u043d\u0435\u0441\u0435\u043d\u0438\u0435 \u0432",
				taskRadioBtnRight2_oldBit,
				"\u0421\u0442\u0430\u0440\u0448\u0438\u0435 \u0440\u0430\u0437\u0440\u044f\u0434\u044b",
				taskRadioBtnLeft2_oldBit,
				"\u041c\u043b\u0430\u0434\u0448\u0438\u0435 \u0440\u0430\u0437\u0440\u044f\u0434\u044b",
				taskRadioBtnNone5, "\u041d\u0435\u0442",
				4);
		panel_2.add(pan2_shift);
		panel_2.add(pan2_typeReg);
		panel_2.add(pan2_sizeReg);
		panel_2.add(pan2_oldBit);
	}

	//----- RESULT PANE
	private void setResultMultiplierPane(String strResult) {
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"<html><p align='center'><font size='6'><b>RG3</b></font><br>" + strResult + "</p>",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JPanel pan3_typeReg = new JPanel();
		JPanel pan3_shift = new JPanel();
		createCustomPane(
				pan3_shift,
				"\u041d\u0430\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0441\u0434\u0432\u0438\u0433\u0430",
				taskRadioBtnRight3_Shift,
				"\u0412\u043f\u0440\u0430\u0432\u043e",
				taskRadioBtnLeft3_Shift, "\u0412\u043b\u0435\u0432\u043e",
				taskRadioBtnNone6, "\u041d\u0435\u0442",
				5);
		createCustomPane(pan3_typeReg, "\u0420\u0435\u0433\u0438\u0441\u0442\u0440", taskRadioBtnRight3_typeReg,
				"\u0421\u0434\u0432\u0438\u0433\u043e\u0432\u044b\u0439",
				taskRadioBtnLeft3_typeReg,
				"\u041d\u0435 \u0441\u0434\u0432\u0438\u0433\u043e\u0432\u044b\u0439",
				taskRadioBtnNone7, "\u041d\u0435\u0442",
				6);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.add(pan3_shift);
		panel_3.add(pan3_typeReg);

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 5;
		gbc_panel_3.gridheight = 6;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 16;
		gbc_panel_3.gridy = 4;
		add(panel_3, gbc_panel_3);
	}

	//----- CUSTOM PANE FOR 2 ITEMS, FOR TASK PANE
	private void createCustomPane(	JPanel panel, String panelLabel,
									JRadioButton radioBtnRight, String radioBtnRLabel,
									JRadioButton radioBtnLeft, String radioBtnLLabel,
									JRadioButton radioBtnNone, String radioBtnNLabel,
									int i){
		panel.setBorder(new TitledBorder(new CompoundBorder(new EmptyBorder(5,10, 5, 10), new CompoundBorder(UIManager.getBorder("TitledBorder.border"), new EmptyBorder(5, 10, 5, 10))),
				"<html><p align='center'><font size='4'>" + panelLabel + "</font></p>", TitledBorder.LEFT, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Component verticalStrut = Box.createVerticalStrut(7);
		panel.add(verticalStrut);
		Component verticalGlue_3 = Box.createVerticalGlue();

		panel.add(verticalGlue_3);
		radioBtnRight.setText(radioBtnRLabel);
		radioBtnRight.setHorizontalAlignment(SwingConstants.CENTER);
		radioBtnRight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		group[i].add(radioBtnRight);
		panel.add(radioBtnRight);

		panel.add(Box.createGlue());

		radioBtnLeft.setText(radioBtnLLabel);
		radioBtnLeft.setHorizontalAlignment(SwingConstants.CENTER);
		radioBtnLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		group[i].add(radioBtnLeft);
		panel.add(radioBtnLeft);

		panel.add(Box.createGlue());

		radioBtnNone.setText(radioBtnNLabel);
		radioBtnNone.setHorizontalAlignment(SwingConstants.CENTER);
		radioBtnNone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		group[i].add(radioBtnNone);
		panel.add(radioBtnNone);

		Component verticalGlue = Box.createVerticalGlue();
		panel.add(verticalGlue);
	}

	//----- OK & CANCEL
	private void setBtnOkAndCancel() {
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 0);
		gbc_panel_4.gridheight = 2;
		gbc_panel_4.gridwidth = 22;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 14;
		gbc_panel_4.anchor = GridBagConstraints.CENTER;
		add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		taskBtnOk = new JButton("  \u041E\u041A     ");
		taskBtnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taskBtnOk.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("ok.png")));
		taskBtnOk.setAlignmentX(Component.CENTER_ALIGNMENT);
		taskBtnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		taskBtnOk.setFocusPainted(false);

		panel_4.add(taskBtnOk);

		Component horizontalStrut = Box.createHorizontalStrut(50);

		panel_4.add(horizontalStrut);
		taskBtnCancel = new JButton("\u041E\u0422\u041C\u0415\u041D\u0410");
		taskBtnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taskBtnCancel.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("cancel.png")));
		taskBtnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		taskBtnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		taskBtnCancel.setFocusPainted(false);
		panel_4.add(taskBtnCancel);
	}

	public JButton getTaskBtnOk() {
		return taskBtnOk;
	}

	public JButton getTaskBtnCancel() {
		return taskBtnCancel;
	}

	public ButtonGroup[] getGroup() {
		return group;
	}

	public ButtonGroup getGroup(int i) {
		return group[i];
	}

} //-----//

