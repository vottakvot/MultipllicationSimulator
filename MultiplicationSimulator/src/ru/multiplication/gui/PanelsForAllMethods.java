package ru.multiplication.gui;

import ru.multiplication.methods.*;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

class PanelsForAllMethods {

	// DATA
	private JLabel label_RG1_8 = new JLabel("00000000");
	private JLabel label_RG2_9 = new JLabel("000000000");
	private JLabel label_RG4_18 = new JLabel("000000000000000000");
	private JLabel label_SM1_A_18 = new JLabel("000000000000000000");
	private JLabel label_SM1_B_18 = new JLabel("000000000000000000");
	private JLabel label_SM1_S_18 = new JLabel("000000000000000000");
	private JLabel label_MS1_A_10 = new JLabel("0000000000");
	private JLabel label_MS1_B_10 = new JLabel("0000000000");
    private JLabel label_MS1_S_10 = new JLabel("0000000000");
	private JLabel label_Result = new JLabel("0000000000000000");
    private JLabel label_CT1 = new JLabel("0000");

    // FLAGS
	private JLabel label_P0 = new JLabel("false");
	private JLabel label_P1 = new JLabel("false");
	private JLabel label_P2 = new JLabel("false");
	private JLabel label_P3 = new JLabel("false");
	private JLabel label_P4 = new JLabel("false");
	private JLabel label_P5 = new JLabel("false");
	private JLabel label_P6 = new JLabel("false");
	private JLabel label_P7 = new JLabel("false");
	private JLabel label_P8 = new JLabel("false");
    private JLabel label_P9 = new JLabel("false");

	// TRIGGERS
	private JLabel label_T1 = new JLabel("false");
    private JLabel label_T2 = new JLabel("false");

	private JPanel customPane = null;
	private GridBagLayout gridBagFag = null;
	private GridBagConstraints bagConstr = null;
	private int numMethod = 0;

	PanelsForAllMethods(int numMethod) {

		this.numMethod = numMethod;

		customLayout();

		switch(numMethod) {
			case 1: firstPane(); break;
			case 2: secondPane(); break;
			case 3: thirdPane(); break;
			case 4: fourthPane(); break;
			default: {
				System.err.println("\u0423 \u043a\u043e\u043d\u0441\u0442\u0440\u0443\u043a\u0442\u043e\u0440\u0430 PanelsForAllMethods \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440 \u0442\u043e\u043b\u044c\u043a\u043e \u043e\u0442 1 \u0434\u043e 4");
				throw new Error();
			}
		}
	}

	public void setAllLabels(CommonData mainData) {

		if(numMethod == 2 || numMethod == 4){
			label_RG2_9.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.RG2_9, 16));
			label_MS1_A_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_A_10, 18));
			label_MS1_B_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_B_10, 18));
			label_MS1_S_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_S_10, 18));

		}

		if(numMethod == 3){
			label_RG2_9.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.RG2_9, 9));
	label_MS1_A_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_A_10, 18));
			label_MS1_B_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_B_10, 18));
			label_MS1_S_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_S_10, 18));
		}

		if(numMethod == 1){
			label_RG2_9.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.RG2_9, 9));


			label_MS1_A_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_A_10, 10));
			label_MS1_B_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_B_10, 10));
			label_MS1_S_10.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.MS1_S_10, 10));
		}

		label_RG1_8.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.RG1_8, 8));
		label_RG4_18.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.RG4_18, 18));

		label_SM1_A_18.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.SM1_A_18, 18));
		label_SM1_B_18.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.SM1_B_18, 18));
		label_SM1_S_18.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.SM1_S_18, 18));



		label_Result.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.Result, 16));
		label_CT1.setText("<html><p align='center'><font size='3' color='blue'>" + CommonData.getBinaryString(mainData.CT1, 3));

		label_P0.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P0));
		label_P1.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P1));
		label_P2.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P2));
		label_P3.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P3));
		label_P4.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P4));
		label_P5.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P5));
		label_P6.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P6));
		label_P7.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P7));
		label_P8.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P8));
		label_P9.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.P9));

		label_T1.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.T1));
		label_T2.setText("<html><p align='center'><font size='3' color='blue'>" + Boolean.toString(mainData.T2));
	}


	//----- SET LAYOUT
	private void customLayout() {
		gridBagFag = new GridBagLayout();
		gridBagFag.columnWidths = new int[] { 	1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		gridBagFag.rowHeights = new int[] { 	1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
												1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		gridBagFag.columnWeights = new double[] { 	1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
													1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
													1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
													1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
													1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
													1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
													1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

		gridBagFag.rowWeights = new double[] { 	1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
												1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
												1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
												1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
												1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
												1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	}

	private GridBagConstraints getConstraint(int height, int width, int x, int y) {
		bagConstr = new GridBagConstraints();
		bagConstr.gridheight = height;
		bagConstr.gridwidth = width;
		bagConstr.insets = new Insets(0, 0, 0, 0);
		bagConstr.fill = GridBagConstraints.BOTH;
		bagConstr.gridx = x;
		bagConstr.gridy = y;

		return bagConstr;
	}

	private void firstPane() {

		customPane = new JPanel() {
			Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("11.png")).getImage();
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		customPane.setLayout(gridBagFag);


		customPane.add(label_RG1_8, getConstraint(1, 20, 11, 9));
		customPane.add(label_RG2_9, getConstraint(1, 20, 46, 9));
		customPane.add(label_RG4_18, getConstraint(1, 40, 48, 50));
		customPane.add(label_SM1_A_18, getConstraint(1, 40, 46, 41));
		customPane.add(label_SM1_B_18, getConstraint(1, 40, 59, 41));
		customPane.add(label_SM1_S_18, getConstraint(1, 40, 52, 42));
		customPane.add(label_MS1_A_10, getConstraint(1, 20, 56, 16));
		customPane.add(label_MS1_B_10, getConstraint(1, 20, 63, 16));
		customPane.add(label_MS1_S_10, getConstraint(1, 20, 60, 17));
		customPane.add(label_Result, getConstraint(1, 30, 40, 62));
		customPane.add(label_CT1, getConstraint(1, 10, 26, 48));

		customPane.add(label_P0, getConstraint(1, 10, 36, 55));
		customPane.add(label_P1, getConstraint(1, 10, 4, 8));
		customPane.add(label_P2, getConstraint(1, 10, 43, 14));
		customPane.add(label_P3, getConstraint(1, 10, 28, 55));
		customPane.add(label_P4, getConstraint(1, 10, 17, 13));
		customPane.add(label_P5, getConstraint(1, 10, 18, 25));
		customPane.add(label_P6, getConstraint(1, 10, 18, 40));
		customPane.add(label_P7, getConstraint(1, 10, 18, 48));
		customPane.add(label_P8, getConstraint(1, 10, 18, 56));
		customPane.add(label_P9, getConstraint(1, 10, 24, 16));

		//customPane.add(label_T1, getConstraint(1, 30, 32, 58));
		//customPane.add(label_T2, getConstraint(1, 30, 25, 13));
	}

	private void secondPane() {
		customPane = new JPanel() {
			Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("22.png")).getImage();
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};

		customPane.setLayout(gridBagFag);
		customPane.add(label_RG1_8, getConstraint(1, 20, 9, 9));
		customPane.add(label_RG2_9, getConstraint(1, 20, 50, 9));
		customPane.add(label_RG4_18, getConstraint(1, 40, 49, 49));
		customPane.add(label_SM1_A_18, getConstraint(1, 40, 41, 40));
		customPane.add(label_SM1_B_18, getConstraint(1, 40, 55, 40));
		customPane.add(label_SM1_S_18, getConstraint(1, 40, 48, 41));
		customPane.add(label_MS1_A_10, getConstraint(1, 20, 51, 23));
		customPane.add(label_MS1_B_10, getConstraint(1, 20, 61, 23));
		customPane.add(label_MS1_S_10, getConstraint(1, 20, 56, 24));
		customPane.add(label_Result, getConstraint(1, 30, 40, 63));
		customPane.add(label_CT1, getConstraint(1, 10, 24, 48));

		customPane.add(label_P0, getConstraint(1, 10, 33, 56));
		customPane.add(label_P1, getConstraint(1, 10, 1, 8));
		customPane.add(label_P2, getConstraint(1, 10, 41, 8));
		customPane.add(label_P3, getConstraint(1, 10, 26, 56));
		customPane.add(label_P4, getConstraint(1, 10, 17, 13));
		customPane.add(label_P5, getConstraint(1, 10, 17, 25));
		customPane.add(label_P6, getConstraint(1, 10, 17, 40));
		customPane.add(label_P7, getConstraint(1, 10, 17, 48));
		customPane.add(label_P8, getConstraint(1, 10, 17, 57));
		customPane.add(label_P9, getConstraint(1, 10, 23, 16));

		//customPane.add(label_T1, getConstraint(1, 30, 36, 50));
		//customPane.add(label_T2, getConstraint(1, 30, 24, 13));
	}

	private void thirdPane() {
		customPane = new JPanel() {
			Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("33.png")).getImage();
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};

		customPane.setLayout(gridBagFag);
		customPane.add(label_RG1_8, getConstraint(1, 20, 12, 8));
		customPane.add(label_RG2_9, getConstraint(1, 20, 42, 8));
		customPane.add(label_RG4_18, getConstraint(1, 40, 45, 49));
		customPane.add(label_SM1_A_18, getConstraint(1, 40, 40, 41));
		customPane.add(label_SM1_B_18, getConstraint(1, 40, 53, 41));
		customPane.add(label_SM1_S_18, getConstraint(1, 40, 48, 42));
		customPane.add(label_MS1_A_10, getConstraint(1, 20, 48, 23));
		customPane.add(label_MS1_B_10, getConstraint(1, 20, 57, 23));
		customPane.add(label_MS1_S_10, getConstraint(1, 20, 54, 24));
		customPane.add(label_Result, getConstraint(1, 30, 40, 60));
		customPane.add(label_CT1, getConstraint(1, 10, 23, 48));

		customPane.add(label_P0, getConstraint(1, 30, 33, 55));
		customPane.add(label_P1, getConstraint(1, 30, 6, 7));
		customPane.add(label_P2, getConstraint(1, 30, 40, 13));
		customPane.add(label_P3, getConstraint(1, 30, 27, 55));
		customPane.add(label_P4, getConstraint(1, 30, 15, 40));
		customPane.add(label_P5, getConstraint(1, 30, 18, 21));
		customPane.add(label_P6, getConstraint(1, 30, 18, 31));
		customPane.add(label_P7, getConstraint(1, 30, 15, 43));
		customPane.add(label_P8, getConstraint(1, 30, 15, 49));

		//customPane.add(label_T1, getConstraint(1, 30, 35, 53));
	}

	private void fourthPane() {
		customPane = new JPanel() {
			Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("44.png")).getImage();
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};

		customPane.setLayout(gridBagFag);
		customPane.add(label_RG1_8, getConstraint(1, 20, 12, 8));
		customPane.add(label_RG2_9, getConstraint(1, 20, 46, 8));
		customPane.add(label_RG4_18, getConstraint(1, 40, 46, 53));
		customPane.add(label_SM1_A_18, getConstraint(1, 40, 40, 46));
		customPane.add(label_SM1_B_18, getConstraint(1, 40, 53, 46));
		customPane.add(label_SM1_S_18, getConstraint(1, 40, 48, 47));
		customPane.add(label_MS1_A_10, getConstraint(1, 20, 48, 30));
		customPane.add(label_MS1_B_10, getConstraint(1, 20, 60, 30));
		customPane.add(label_MS1_S_10, getConstraint(1, 20, 54, 31));
		customPane.add(label_Result, getConstraint(1, 30, 40, 60));
		customPane.add(label_CT1, getConstraint(1, 10, 22, 48));

		customPane.add(label_P0, getConstraint(1, 30, 30, 55));
		customPane.add(label_P1, getConstraint(1, 30, 6, 7));
		customPane.add(label_P2, getConstraint(1, 30, 40, 13));
		customPane.add(label_P3, getConstraint(1, 30, 25, 55));
		customPane.add(label_P4, getConstraint(1, 30, 15, 40));
		customPane.add(label_P5, getConstraint(1, 30, 18, 21));
		customPane.add(label_P6, getConstraint(1, 30, 18, 31));
		customPane.add(label_P7, getConstraint(1, 30, 15, 45));
		customPane.add(label_P8, getConstraint(1, 30, 15, 49));

		//getClass().customPane.add(label_T1, getConstraint(1, 30, 34, 52));
	}

	public JPanel getCustomPane() {
		return customPane;
	}
}
