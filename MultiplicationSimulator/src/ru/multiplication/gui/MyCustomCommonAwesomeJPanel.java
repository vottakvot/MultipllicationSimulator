package ru.multiplication.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.font.TextMeasurer;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.DefaultStyledDocument;

public class MyCustomCommonAwesomeJPanel extends JPanel {

	private MyCustomAwesomeJTable dataTable = null;
	private JPanel panel_6 = null;
	private Dimension tableDim = null;
	private JButton cancelButton = null;
	private JPanel customMethod = null;
	private JPanel textMults = null;
	private JLabel firstMult = null;
	private JLabel secondMult = null;
	private JLabel resultMult = null;
	private JLabel mistakesMult = null;
	private PanelsForAllMethods allPanels = null;

	private int row = 0;
	private int col = 0;
	private int numberOfMethod = 0;

	private static String multiplier1 = "00000000";
	private static String multiplier2 = "111111111";
	private static String result = "none";
	private static int mistakes = 0;

	public MyCustomCommonAwesomeJPanel(int row, int col, int numberOfMethod) throws ParseException {

		this.row = row;
		this.col = col;
		this.numberOfMethod = numberOfMethod;

		switch(numberOfMethod) {
			case 1: {
				allPanels = new PanelsForAllMethods(1);
				customMethod = allPanels.getCustomPane();
				break;
			}
			case 2:{
				allPanels = new PanelsForAllMethods(2);
				customMethod = allPanels.getCustomPane();
				break;
			}
			case 3:{
				allPanels = new PanelsForAllMethods(3);
				customMethod = allPanels.getCustomPane();
				break;
			}
			case 4: {
				allPanels = new PanelsForAllMethods(4);
				customMethod = allPanels.getCustomPane();
				break;
			}

			default: {
				System.err.println("\u0423 \u043a\u043e\u043d\u0441\u0442\u0440\u0443\u043a\u0442\u043e\u0440\u0430 MyCustomCommonAwesomeJPanel 3 \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440 \u0442\u043e\u043b\u044c\u043a\u043e \u043e\u0442 1 \u0434\u043e 4");
				throw new Error();
			}
		}

		setBorder(	new CompoundBorder(new SoftBevelBorder(BevelBorder.RAISED,null, null, null, null),
					new CompoundBorder(UIManager.getBorder("TitledBorder.border"), new EmptyBorder(10, 10, 10, 10))));

		GridBagLayout gbl_firstMethodPane = new GridBagLayout();
		gbl_firstMethodPane.columnWidths = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		gbl_firstMethodPane.rowHeights = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		gbl_firstMethodPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_firstMethodPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gbl_firstMethodPane);

		paneWithStructure();
		paneWithTable(row, col);
		paneWithManageSigns(numberOfMethod);
		paneWithLabels();
		paneWithButton();

		setVisible(true);
	}

	// ----- MAIN PANE WITH STRUCTURE
	private void paneWithStructure() {
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new CompoundBorder( new EmptyBorder(10, 10, 10, 10),
						new TitledBorder(	null, "<html><p align='center'><font size='6' color='#696969'><b><i>" +
											"\u0421\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0430 \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0430</i></b></font></p>",
											TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null))));
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 20;
		gbc_panel_5.gridwidth = 21;
		gbc_panel_5.insets = new Insets(0, 0, 0, 10);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_5.add(customMethod);
		add(panel_5, gbc_panel_5);
	}

	// ----- PANE WITH TABLE
	private void paneWithTable(int row, int col) {
		panel_6 = new JPanel();
		panel_6.setBorder(new CompoundBorder(
				new TitledBorder(
						null,
						"<html><p align='center'><font size='4' color='#696969'><b><i>" +
						"Таблица управляющих<br>" + "сигналов</i></b></font></p>",
						TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null),
				new EmptyBorder(10, 10, 10, 10)));
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 6;
		gbc_panel_6.gridheight = 20;
		gbc_panel_6.insets = new Insets(0, 0, 0, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 21;
		gbc_panel_6.gridy = 0;

		dataTable = new MyCustomAwesomeJTable(row, col);
		tableDim = new Dimension(dataTable.getPreferredSize());

		JScrollPane scrollTable = new JScrollPane(dataTable);
		JTable rowTable = new RowNumberTable(dataTable, 25);
		scrollTable.setRowHeaderView(rowTable);

		scrollTable.setAlignmentX(LEFT_ALIGNMENT);
		scrollTable.setPreferredSize(new Dimension(tableDim.width + 44, tableDim.height));
//		scrollTable.setMaximumSize(new Dimension(tableDim.width + 44, tableDim.height));
//		scrollTable.setMinimumSize(new Dimension(tableDim.width + 44, tableDim.height));

		panel_6.add(dataTable.getTableHeader(), BorderLayout.CENTER);
		panel_6.add(scrollTable, BorderLayout.WEST);
		Component glue = Box.createGlue();
		Dimension dimPanel_6 = new Dimension(panel_6.getPreferredSize());
		panel_6.setMinimumSize(dimPanel_6);
		panel_6.setMaximumSize(dimPanel_6);
		panel_6.setAlignmentX(LEFT_ALIGNMENT);
		panel_6.add(glue);

		add(panel_6, gbc_panel_6);
	}

	private void paneWithManageSigns(int numMethod) {

		String signalsForMethod = "";
		switch(numMethod) {
			case 1: signalsForMethod = "<html>" + "<ul style=margin-left:20;margin-top:10;margin-bottom:10>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04430 \u2013 \u0441\u0431\u0440\u043e\u0441 RG1, RG2, RG3, RG4 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0441\u0447\u0435\u0442\u0447\u0438\u043a\u0430 \u0432 '0';</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04431 \u2013 \u0437\u0430\u043d\u0435\u0441\u0435\u043d\u0438\u0435 \u043c\u043d\u043e\u0436\u0438\u0442\u0435\u043b\u044f \u0432  RG1, \u043c\u043d\u043e\u0436\u0438\u043c\u043e\u0433\u043e \u0432 RG2, \u0437\u0430\u043f\u0438\u0441\u044c \u0437\u043d\u0430\u043a\u0430 \u0432 \u0442\u0440\u0438\u0433\u0433\u0435\u0440 \u04221;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04432 \u2013 \u0421\u0422:=\u0421\u0422+1;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y3 \u2013 \u0437\u0430\u043f\u0438\u0441\u044c \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u0432 \u0442\u0440\u0438\u0433\u0433\u0435\u0440 T2;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y4 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0438\u043d\u0432\u0435\u0440\u0442\u043e\u0440\u043e\u043c, \u043f\u043e\u0434\u0430\u0447\u0430 \u0435\u0434\u0438\u043d\u0438\u0446\u044b \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u043d\u0430 \u043f\u043b\u0435\u0447\u043e B \u0441\u0443\u043c\u043c\u0430\u0442\u043e\u0440\u0430;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y5 \u2013\u0437\u0430\u043f\u0438\u0441\u044c \u0421\u0427\u041f \u0432 RG4;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y6 \u2013 \u0441\u0434\u0432\u0438\u0433 RG4, RG1 \u043d\u0430 2 \u0440\u0430\u0437\u0440\u044f\u0434\u0430 \u0432\u043f\u0440\u0430\u0432\u043e;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y7 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e A;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y8 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e B.</i></font></li>" +
	                "</ul>";
					break;
			case 2: signalsForMethod = "<html>" + "<ul style=margin-left:20;margin-top:10;margin-bottom:10>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04430 \u2013 \u0441\u0431\u0440\u043e\u0441 RG1, RG2, RG3, RG4 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0441\u0447\u0435\u0442\u0447\u0438\u043a\u0430 \u0432 '0';</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04431 \u2013 \u0437\u0430\u043d\u0435\u0441\u0435\u043d\u0438\u0435 \u043c\u043d\u043e\u0436\u0438\u0442\u0435\u043b\u044f \u0432  RG1, \u043c\u043d\u043e\u0436\u0438\u043c\u043e\u0433\u043e \u0432 RG2, \u0437\u0430\u043f\u0438\u0441\u044c \u0437\u043d\u0430\u043a\u0430 \u0432 \u0442\u0440\u0438\u0433\u0433\u0435\u0440 \u04221;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04432 \u2013 \u0421\u0422:=\u0421\u0422+1;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y3 \u2013 \u0437\u0430\u043f\u0438\u0441\u044c \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u0432 \u0442\u0440\u0438\u0433\u0433\u0435\u0440 T2;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y4 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0438\u043d\u0432\u0435\u0440\u0442\u043e\u0440\u043e\u043c, \u043f\u043e\u0434\u0430\u0447\u0430 \u0435\u0434\u0438\u043d\u0438\u0446\u044b \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u043d\u0430 \u043f\u043b\u0435\u0447\u043e B \u0441\u0443\u043c\u043c\u0430\u0442\u043e\u0440\u0430;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y5 \u2013 \u0437\u0430\u043f\u0438\u0441\u044c \u0421\u0427\u041f \u0432 RG4;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y6 \u2013 \u0441\u0434\u0432\u0438\u0433 RG2 \u043d\u0430 2 \u0440\u0430\u0437\u0440\u044f\u0434 \u0432\u043b\u0435\u0432\u043e, \u0441\u0434\u0432\u0438\u0433 RG1 \u043d\u0430 2 \u0440\u0430\u0437\u0440\u044f\u0434\u0430 \u0432\u043f\u0440\u0430\u0432\u043e;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y7 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e A;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y8 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e B.</i></font></li>" +
					"</ul>";
					break;
			case 3: signalsForMethod = "<html>" + "<ul style=margin-left:20;margin-top:10;margin-bottom:10>" +
					"<li type=circle><font size='3' color=#4D4D4D><i>\u04430 \u2013 \u0441\u0431\u0440\u043e\u0441 RG1, RG2, RG3, RG4 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0441\u0447\u0435\u0442\u0447\u0438\u043a\u0430 \u0432 '0';</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04431 \u2013 \u0437\u0430\u043d\u0435\u0441\u0435\u043d\u0438\u0435 \u043c\u043d\u043e\u0436\u0438\u0442\u0435\u043b\u044f \u0432  RG1, \u043c\u043d\u043e\u0436\u0438\u043c\u043e\u0433\u043e \u0432 RG2, \u0437\u0430\u043f\u0438\u0441\u044c \u0437\u043d\u0430\u043a\u0430 \u0432 \u0442\u0440\u0438\u0433\u0433\u0435\u0440 \u04221;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04432 \u2013 \u0421\u0422:=\u0421\u0422+1;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y3 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e \u0410;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y4 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e B;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y5 \u2013 \u0437\u0430\u043f\u0438\u0441\u044c \u0421\u0427\u041f \u0432 RG4;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y6 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0438\u043d\u0432\u0435\u0440\u0442\u043e\u0440\u043e\u043c, \u043f\u043e\u0434\u0430\u0447\u0430 \u0435\u0434\u0438\u043d\u0438\u0446\u044b \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u043d\u0430 \u043f\u043b\u0435\u0447\u043e B \u0441\u0443\u043c\u043c\u0430\u0442\u043e\u0440\u0430;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y7 \u2013 \u0441\u0434\u0432\u0438\u0433 RG4, RG1 \u043d\u0430 2 \u0440\u0430\u0437\u0440\u044f\u0434\u0430 \u0432\u043b\u0435\u0432\u043e;</i></font></li>" +
					"</ul>";
					break;
			case 4: signalsForMethod = "<html>" + "<ul style=margin-left:20;margin-top:10;margin-bottom:10>" +
					"<li type=circle><font size='3' color=#4D4D4D><i>\u04430 \u2013 \u0441\u0431\u0440\u043e\u0441 RG1, RG2, RG3, RG4 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0441\u0447\u0435\u0442\u0447\u0438\u043a\u0430 \u0432 '0';</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04431 \u2013 \u0437\u0430\u043d\u0435\u0441\u0435\u043d\u0438\u0435 \u043c\u043d\u043e\u0436\u0438\u0442\u0435\u043b\u044f \u0432  RG1, \u043c\u043d\u043e\u0436\u0438\u043c\u043e\u0433\u043e \u0432 RG2, \u0437\u0430\u043f\u0438\u0441\u044c \u0437\u043d\u0430\u043a\u0430 \u0432 \u0442\u0440\u0438\u0433\u0433\u0435\u0440 \u04221;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>\u04432 \u2013 \u0421\u0422:=\u0421\u0422+1;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y3 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e \u0410;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y4 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043d\u0430 \u043c\u0443\u043b\u044c\u0442\u0438\u043f\u043b\u0435\u043a\u0441\u043e\u0440\u0435 \u043f\u043b\u0435\u0447\u043e B;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y5 \u2013 \u0437\u0430\u043f\u0438\u0441\u044c \u0421\u0427\u041f \u0432 RG4;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y6 \u2013 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0438\u043d\u0432\u0435\u0440\u0442\u043e\u0440\u043e\u043c, \u043f\u043e\u0434\u0430\u0447\u0430 \u0435\u0434\u0438\u043d\u0438\u0446\u044b \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u043d\u0430 \u043f\u043b\u0435\u0447\u043e B \u0441\u0443\u043c\u043c\u0430\u0442\u043e\u0440\u0430;</i></font></li>" +
	                "<li type=circle><font size='3' color=#4D4D4D><i>y7 \u2013 \u0441\u0434\u0432\u0438\u0433 RG1 \u043d\u0430 2 \u0440\u0430\u0437\u0440\u044f\u0434\u0430 \u0432\u043b\u0435\u0432\u043e, \u0441\u0434\u0432\u0438\u0433 RG2 \u043d\u0430 2 \u0440\u0430\u0437\u0440\u044f\u0434\u0430 \u0432\u043f\u0440\u0430\u0432\u043e.;</i></font></li>" +
					"</ul>";
					break;
			default : System.err.println("\u0425\u0443\u0439\u043d\u044f \u043a\u0430\u043a\u0430\u044f-\u0442\u043e :(");
		}

		JTextPane textPane = new JTextPane();
		textPane.setBorder(	new TitledBorder(
							null,
							"<html><font size='4' color='#696969'><b><i>" +
							"\u0423\u043f\u0440\u0430\u0432\u043b\u044f\u044e\u0449\u0438\u0435 \u0441\u0438\u0433\u043d\u0430\u043b\u044b: </i></b></font>",
							TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
		textPane.setContentType("text/html");
		textPane.setText(signalsForMethod);
		textPane.setEditable(false);
		textPane.setOpaque(false);
		textPane.setAlignmentX(LEFT_ALIGNMENT);
		textPane.setPreferredSize(new Dimension(tableDim.width + 44, textPane.getPreferredSize().height + 30));
		textPane.setMaximumSize(new Dimension(tableDim.width + 44, textPane.getPreferredSize().height + 30));
		textPane.setMinimumSize(new Dimension(tableDim.width + 44, textPane.getPreferredSize().height + 30));

//		StyledDocument doc = textPane.getStyledDocument();
//		SimpleAttributeSet style = new SimpleAttributeSet();
//			StyleConstants.setLeftIndent(style, -20);
//			StyleConstants.setFirstLineIndent(style, -20);
//			StyleConstants.setForeground(style, Color.BLUE);
//		doc.setParagraphAttributes(0, doc.getLength(), style, true);

		panel_6.add(textPane);
		panel_6.add(Box.createGlue());
	}

	//----- PANE WITH 2 LABELS OF MULTIPLIERS
	private void paneWithLabels() {
		textMults = new JPanel();
		textMults.setBorder(new CompoundBorder(
				new TitledBorder(
						null,
						"<html><p align='center'><font size='4' color='#696969'><b><i>" +
						"\u0418\u0441\u0445\u043e\u0434\u043d\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435</i></b></font></p>",
						TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
						null, null), new EmptyBorder(0, 5, 0, 0)));
		textMults.setLayout(new BoxLayout(textMults, BoxLayout.Y_AXIS));
		firstMult = new JLabel( "<html><p align='center'><font size='3' color='blue'><b><i>" +
								"Множитель: </i></b>" +
								multiplier1);
		secondMult = new JLabel("<html><p align='center'><font size='3' color='blue'><b><i>" +
								"Множимое: </i></b>" +
								multiplier2);
		resultMult = new JLabel("<html><p align='center'><font size='3' color='green'><b><i>" +
								"Произведение: </i></b>" +
								result);
		mistakesMult = new JLabel("<html><p align='center'><font size='3' color='red'><b><i>" +
								"Кол-во ошибок: </i></b>" +
								mistakes);
		textMults.add(firstMult, BorderLayout.CENTER);
		textMults.add(secondMult, BorderLayout.CENTER);
		textMults.add(resultMult, BorderLayout.CENTER);
		textMults.add(mistakesMult, BorderLayout.CENTER);
		textMults.setPreferredSize(new Dimension(tableDim.width + 44, textMults.getPreferredSize().height));
		textMults.setMaximumSize(new Dimension(tableDim.width + 44, textMults.getPreferredSize().height));
		textMults.setMinimumSize(new Dimension(tableDim.width + 44, textMults.getPreferredSize().height));
		textMults.setAlignmentX(LEFT_ALIGNMENT);
		panel_6.add(textMults);
		Component verticalStrut = Box.createVerticalStrut(10);
		panel_6.add(verticalStrut);
	}

	//----- PANE WITH BUTTON CANCEL
	private void paneWithButton() {

		Dimension forButtons = new Dimension(dataTable.getPreferredSize().width + 44, 30);

		cancelButton = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("cancel.png")));
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		cancelButton.setPreferredSize(forButtons);
		cancelButton.setMaximumSize(forButtons);
		cancelButton.setMinimumSize(forButtons);
		cancelButton.setFocusPainted(false);

		panel_6.add(cancelButton);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public MyCustomAwesomeJTable getDataTable() {
		return dataTable;
	}

	public static String getMultiplier1() {
		return multiplier1;
	}

	public static void setMultiplier1(String multiplier1) {
		MyCustomCommonAwesomeJPanel.multiplier1 = multiplier1;
	}

	public static String getMultiplier2() {
		return multiplier2;
	}

	public String getResult() {
		return result;
	}

	public int getMistakes() {
		return mistakes;
	}

	public static void setMultiplier2(String multiplier2) {
		MyCustomCommonAwesomeJPanel.multiplier2 = multiplier2;
	}

	public static void setResult(String result) {
		MyCustomCommonAwesomeJPanel.result = result;
	}

	public static void setMistakes(int mistakes) {
		MyCustomCommonAwesomeJPanel.mistakes = mistakes;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}


	public JPanel getCustomMethod() {
		return customMethod;
	}

	public int getNumberOfMethod() {
		return numberOfMethod;
	}

	public JLabel getFirstMult() {
		return firstMult;
	}

	public PanelsForAllMethods getAllPanels() {
		return allPanels;
	}

	public void updateTextOfLabels() {
		firstMult.setText( 	"<html><p align='center'><font size='3' color='blue'><b><i>" +
							"\u041c\u043d\u043e\u0436\u0438\u0442\u0435\u043b\u044c: </i></b>" +
							multiplier1);
		secondMult.setText(	"<html><p align='center'><font size='3' color='blue'><b><i>" +
							"\u041c\u043d\u043e\u0436\u0438\u043c\u043e\u0435: </i></b>" +
							multiplier2);
		resultMult.setText("<html><p align='center'><font size='3' color='green'><b><i>" +
							"\u041f\u0440\u043e\u0438\u0437\u0432\u0435\u0434\u0435\u043d\u0438\u0435: </i></b>" +
							result);
		mistakesMult.setText("<html><p align='center'><font size='3' color='red'><b><i>" +
							"\u041a\u043e\u043b-\u0432\u043e \u043e\u0448\u0438\u0431\u043e\u043a: </i></b>" +
							mistakes);
	}

	public JLabel getSecondMult() {
		return secondMult;
	}

}
