package ru.multiplication.gui;

import ru.multiplication.gui.MyCustomAwesomeListeners.MyTaskJPaneAction;
import ru.multiplication.gui.MyCustomAwesomeListeners.MyTaskJPaneAction.CancelAction;

public class MainMult {

	//Точка входа в наше приложение
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new MainWindowMult().setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
