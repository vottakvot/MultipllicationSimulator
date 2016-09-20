package ru.multiplication.gui;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.awt.Toolkit;
import java.text.ParseException;

public class MyCustomAwesomeJMenu extends JMenuBar {

	//submenu "File"
	private JMenu menuFile = null;
	private JMenuItem exitProga = null;

	//submenu "Type Mult"
	private JMenu typeMult = null;
	private JMenuItem firstWay = null;
	private JMenuItem secondWay = null;
	private JMenuItem thirdWay = null;
	private JMenuItem fourthWay = null;
	//submenu "Microprogrm"
	private JMenu microProg = null;
	private JMenuItem execMp = null;
	private JMenuItem oneStep = null;
	//submenu "About"
	private JMenu aboutProg = null;

	//----- CONSTRUCTOR OF AWESOME MENU
	MyCustomAwesomeJMenu()  throws ParseException {
		menuFile = new JMenu("\u0424\u0430\u0439\u043b");
			exitProga = new JMenuItem("\u0412\u044b\u0445\u043e\u0434");
			exitProga.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("cancel.png")));
			KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
			exitProga.setAccelerator(f1);
			menuFile.add(exitProga);
			add(menuFile);

		typeMult = new JMenu("\u0421\u043f\u043e\u0441\u043e\u0431 \u0443\u043c\u043d\u043e\u0436\u0435\u043d\u0438\u044f");
			firstWay = new JMenuItem("\u041f\u0435\u0440\u0432\u044b\u0439 \u0441\u043e\u043f\u043e\u0441\u043e\u0431");
			firstWay.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("do.png")));
			KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
			firstWay.setAccelerator(f2);

			secondWay = new JMenuItem("\u0412\u0442\u043e\u0440\u043e\u0439 \u0441\u043f\u043e\u0441\u043e\u0431");
			secondWay.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("do.png")));
			KeyStroke f3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
			secondWay.setAccelerator(f3);

			thirdWay = new JMenuItem("\u0422\u0440\u0435\u0442\u0438\u0439 \u0441\u043f\u043e\u0441\u043e\u0431");
			thirdWay.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("do.png")));
			KeyStroke f4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0);
			thirdWay.setAccelerator(f4);

			fourthWay = new JMenuItem("\u0427\u0435\u0442\u0432\u0435\u0440\u0442\u044b\u0439 \u0441\u043f\u043e\u0441\u043e\u0431");
			fourthWay.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("do.png")));
			KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
			fourthWay.setAccelerator(f5);

			typeMult.add(firstWay);
			typeMult.add(secondWay);
			typeMult.add(thirdWay);
			typeMult.add(fourthWay);
			add(typeMult);

		microProg = new JMenu("\u041c\u0438\u043a\u0440\u043e\u043f\u0440\u043e\u0433\u0440\u0430\u043c\u043c\u0430");
		microProg.setEnabled(false);

			execMp = new JMenuItem("\u0412\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435 \u043c\u0438\u043a\u0440\u043e\u043f\u0440\u043e\u0433\u0440\u0430\u043c\u043c\u044b");
			execMp.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("gear.png")));
			KeyStroke f7 = KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0);
			execMp.setAccelerator(f7);

			oneStep = new JMenuItem("\u041e\u0434\u0438\u043d \u0448\u0430\u0433");
			oneStep.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("green_up.png")));
			KeyStroke f8 = KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0);
			oneStep.setAccelerator(f8);

			microProg.add(execMp);
			microProg.add(oneStep);
			add(microProg);

		aboutProg = new JMenu("\u041e \u043f\u0440\u043e\u0433\u0440\u0430\u043c\u043c\u0435");
		aboutProg.setIcon(new ImageIcon(MyCustomAwesomeListeners.getIconsPath("info.png")));
			add(aboutProg);
	}

	public JMenuItem getExitProga() {
		return exitProga;
	}

	public JMenuItem getFirstWay() {
		return firstWay;
	}

	public JMenuItem getSecondWay() {
		return secondWay;
	}

	public JMenuItem getThirdWay() {
		return thirdWay;
	}

	public JMenuItem getFourthWay() {
		return fourthWay;
	}

	public JMenuItem getExecMp() {
		return execMp;
	}

	public JMenuItem getOneStep() {
		return oneStep;
	}

	public JMenu getAboutProg() {
		return aboutProg;
	}

	public JMenu getMicroProg() {
		return microProg;
	}

	public JMenu getTypeMult() {
		return typeMult;
	}
}
