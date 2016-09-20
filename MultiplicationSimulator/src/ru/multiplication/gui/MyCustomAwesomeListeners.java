package ru.multiplication.gui;

import ru.multiplication.methods.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;;

public class MyCustomAwesomeListeners {

	private MainWindowMult mainWindow = null;
	private JPanel mainPane = null;

	MyCustomAwesomeListeners(MainWindowMult mainWindow, JPanel mainPanel)  throws ParseException {
		this.mainWindow = mainWindow;
		this.mainPane = mainPanel;
	};

	//----- ICONS PATH
	public static final String getIconsPath(String str){
		return System.getProperty("user.dir") + "\\icons\\" + str;
	}

	//----- FILTERS FOR TEXT FIELDS
	public static class FilterForInput extends PlainDocument {

		private static final long serialVersionUID = 1L;
		//Store maximum characters permitted
		private int maxChars;

		FilterForInput (int max) {
			super();
			maxChars = max;
		}

		@Override
		public void insertString(int offs, String string, AttributeSet a)
				throws BadLocationException {
			if(string != null && (getLength() + string.length() < maxChars)){
		    	for (int n = string.length(); n > 0; n--) {//an inserted string may be more than a single character i.e a copy and paste of 'aaa123d', also we iterate from the back as super.XX implementation will put last insterted string first and so on thus 'aa123d' would be 'daa', but because we iterate from the back its 'aad' like we want
		            char c = string.charAt(n - 1);//get a single character of the string
		            System.out.println(c);
		            if (Character.isDigit(c) && (c == '1' || c =='0'))  {//if its an alphabetic character or white space
		                super.insertString(offs, String.valueOf(c), a);//allow update to take place for the given character
		            } else {//it was not an alphabetic character or white space
		                System.out.println("Not allowed");
		            }
		        }
			}
		}
	}

	//----- FILTERS FOR TEXT FIELDS
	public static class FilterForReg extends PlainDocument {

		private static final long serialVersionUID = 1L;
		//Store maximum characters permitted
		private int maxChars;

		FilterForReg (int max) {
			super();
			maxChars = max;
		}

		@Override
		public void insertString(int offs, String string, AttributeSet a)
				throws BadLocationException {
			if(string != null && (getLength() + string.length() < maxChars)){
		    	for (int n = string.length(); n > 0; n--) {//an inserted string may be more than a single character i.e a copy and paste of 'aaa123d', also we iterate from the back as super.XX implementation will put last insterted string first and so on thus 'aa123d' would be 'daa', but because we iterate from the back its 'aad' like we want
		            char c = string.charAt(n - 1);//get a single character of the string
		            System.out.println(c);
		            if (Character.isDigit(c) || Character.isAlphabetic(c) || c == ' ' || c =='-')  {//if its an alphabetic character or white space
		                super.insertString(offs, String.valueOf(c), a);//allow update to take place for the given character
		            } else {//it was not an alphabetic character or white space
		                System.out.println("Not allowed");
		            }
		        }
			}
		}
	}

	//----- HYPERLINKS LISTENER
	public static class ActivatedHyperlinkListener implements HyperlinkListener {

		public ActivatedHyperlinkListener() {
			super();
		};

		public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
			HyperlinkEvent.EventType type = hyperlinkEvent.getEventType();
			final URL url = hyperlinkEvent.getURL();

			if (type == HyperlinkEvent.EventType.ENTERED) {
				System.out.println("URL: " + url);
			} else if (type == HyperlinkEvent.EventType.ACTIVATED) {
				System.out.println("Activated");

				try {
					if (System.getProperty("os.name").substring(0, 3)
							.equals("Win"))
						Runtime.getRuntime().exec(
								"rundll32 url.dll,FileProtocolHandler "
										+ url.toExternalForm());
				} catch (Exception e) {
					System.err.println("Failed to call a browser");
				}
			}
		}
	}

	//----- CONFIRM CLOSE THIS WINDOW
	private void closers80lvl(){
		 Object[] options = { "\u0414\u0430", "\u041d\u0435\u0442!" };
         int n = JOptionPane.showOptionDialog(mainWindow, "\u0417\u0430\u043a\u0440\u044b\u0442\u044c \u043e\u043a\u043d\u043e?",
                         "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435", JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE, null, options,
                         options[0]);
         if (n == 0) {
        	 mainWindow.setVisible(false);
             System.exit(0);
         }
	}

	//----- CONTROLLERS FOR AWESOME PANE
	class MyTaskJPaneAction {

		//----- RIGHT ANSWERS FOR 4 METHODS
		private final String [] rightAnswer1 = {"2","3","3","2","3","2","2"};
		private final String [] rightAnswer2 = {"2","1","2","1","1","3","3"};
		private final String [] rightAnswer3 = {"1","3","3","2","3","1","2"};
		private final String [] rightAnswer4 = {"1","2","2","1","2","3","3"};
		//----- NUMBER OF METHOD
		public final static int FIRST = 1;
		public final static int SECOND = 2;
		public final static int THIRD = 3;
		public final static int FOURTH = 4;
		private int numMethod = 0;

		private MyCustomAwesomeTaskJPane taskPane = null;
		private InputDataDlg inputDlg = null;

		MyTaskJPaneAction(MyCustomAwesomeTaskJPane taskPane) {
			this.taskPane = taskPane;
		};

		MyTaskJPaneAction(MyCustomAwesomeTaskJPane taskPane, int numMethod, InputDataDlg inputDlg) {
			this.numMethod = numMethod;
			this.taskPane = taskPane;
			this.inputDlg = inputDlg;
				if(numMethod < 1 && numMethod > 4)
					System.out.println("\u0412\u0441\u0435\u0433\u043e 4 \u0442\u0438\u043f\u0430 \u0437\u0430\u0434\u0430\u043d\u0438\u0439, \u0432\u0435\u0440\u043e\u044f\u0442\u043d\u043e \u043d\u0435 \u043f\u043e\u043f\u0430\u043b\u0438 \u0432 \u0434\u0438\u0430\u043f\u0430\u0437\u043e\u043d [1:4]");
		};

		private void clearSelectBtn() {
			for(int i = 0; i < taskPane.getGroup().length; i++)
				taskPane.getGroup(i).clearSelection();
		}

		//----- COMPARE ARRAY OF ANSWER STRINGS
		private boolean compareAnswerTask(int typeOfMult) {

			String [] answer = new String[7];

			//First pane
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft1, taskPane.taskRadioBtnRight1, taskPane.taskRadioBtnNone1, 0);
			//Second pane
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft2_Shift, taskPane.taskRadioBtnRight2_Shift, taskPane.taskRadioBtnNone2, 1);
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft2_typeReg, taskPane.taskRadioBtnRight2_typeReg, taskPane.taskRadioBtnNone3, 2);
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft2_sizeReg, taskPane.taskRadioBtnRight2_sizeReg, taskPane.taskRadioBtnNone4, 3);
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft2_oldBit, taskPane.taskRadioBtnRight2_oldBit, taskPane.taskRadioBtnNone5, 4);
			//Third pane
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft3_Shift, taskPane.taskRadioBtnRight3_Shift, taskPane.taskRadioBtnNone6, 5);
			setStringAnswerByRadioBtn(answer, taskPane.taskRadioBtnLeft3_typeReg, taskPane.taskRadioBtnRight3_typeReg, taskPane.taskRadioBtnNone7, 6);

			switch(typeOfMult){
				case 1: return compareAnswerTaskCircle(rightAnswer1, answer);
				case 2: return compareAnswerTaskCircle(rightAnswer2, answer);
				case 3: return compareAnswerTaskCircle(rightAnswer3, answer);
				case 4: return compareAnswerTaskCircle(rightAnswer4, answer);
				default: return false;
			}
		}

		//----- FORMING STRING OF ANSWER
		private void setStringAnswerByRadioBtn(String [] str, JRadioButton btn1, JRadioButton btn2, JRadioButton btn3, int numPane) {
			if ((btn1.isSelected() == false) && (btn2.isSelected()== false) && (btn3.isSelected()== false))
				str[numPane] = "-1";
			else {
					if(btn1.isSelected() == true)
						str[numPane] = "1";
					if(btn2.isSelected() == true)
						str[numPane] = "2";
					if(btn3.isSelected() == true)
						str[numPane] = "3";
			}
		}

		//------ SUB METHOD FOR COMPARE
		private boolean compareAnswerTaskCircle(String [] str1, String [] str2) {
			for (int i = 0; i < str2.length; i++ ) {
				if(str2[i].intern() == "-1".intern())
					return false;
				else if(str1[i].intern() == str2[i].intern())
						continue;
					else
						return false;
			}
			return true;
		}


		//----- OK ACTION
		class OkAction implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	if (!compareAnswerTask(numMethod))
					JOptionPane.showMessageDialog( 	null, "\u041d\u0435\u0432\u0435\u0440\u043d\u0430\u044f \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0430",
													"\u041e\u0448\u0438\u0431\u043a\u0430",
													JOptionPane.ERROR_MESSAGE);
		    	else {
		    		clearSelectBtn();
		    		inputDlg.setNumberOfMethod(numMethod);
			    	inputDlg.setEnabled(true);
			    	inputDlg.setVisible(true);
		    	}
		    }
	    }

		//----- OK ACTION
		class CancelAction implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	mainWindow.getMainLayout().show(mainPane, "helloPane");
		    	clearSelectBtn();
		    }
	    }
	} //-----//


	//----- CONTROLLERS FOR AWESOME MENU
	class MyJMenuAction {

		private MyCustomCommonAwesomeJPanel [] doShit = null;
		private int numPanel = 0;
		private int numStep = 0;
		private int row = -1;
		private int col = -1;
		private ArrayList<CommonMethods> allMethods = null;

		MyJMenuAction(MyCustomCommonAwesomeJPanel [] doShit, ArrayList<CommonMethods> allMethods) {
			this.doShit = doShit;
			this.allMethods = allMethods;
		}

		//----- EXIT ACTION
		class exitMenu implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	closers80lvl();
		    }
	    }

		//----- FIRST METHOD ACTION
		class firstMethod implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	mainWindow.getMainLayout().show(mainPane, "taskPane1");
		    }
		}

		//----- SECOND METHOD ACTION
		class secondMethod implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				mainWindow.getMainLayout().show(mainPane, "taskPane2");
			}
	    }

		//----- THIRD METHOD ACTION
		class thirdMethod implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				mainWindow.getMainLayout().show(mainPane, "taskPane3");
			}
	    }

		//----- FOURTH METHOD ACTION
		class fourthMethod implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				mainWindow.getMainLayout().show(mainPane, "taskPane4");
			}
	    }

		//----- EXEC MP ACTION
		class execMp implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				numPanel = 0;

				for(MyCustomCommonAwesomeJPanel item : doShit) {

					if (item.isShowing()) {
						for(int i = numStep; i < item.getRow(); i++)
							if(!getDataFromTable(item, false))
								break;

						item.getAllPanels().setAllLabels(allMethods.get(numPanel).getMainData());
						doShit[numPanel].updateTextOfLabels();
						doShit[numPanel].repaint();
						item.getAllPanels().getCustomPane().repaint();
					}

					++numPanel;
				}
			}
	    }

		//----- ONE STEP ACTION
		class oneStep implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				numPanel = 0;

				for(MyCustomCommonAwesomeJPanel item : doShit) {

					if (item.isShowing()) {
						getDataFromTable(item, true);
						item.getAllPanels().setAllLabels(allMethods.get(numPanel).getMainData());
						doShit[numPanel].updateTextOfLabels();
						doShit[numPanel].repaint();
						item.getAllPanels().getCustomPane().repaint();
					}

					++numPanel;
				}
			}
	    }

		//----- MANAGE SIGNAL HELP ACTION
		class manageSign implements ActionListener {
			public void actionPerformed(ActionEvent e) {

			}
	    }

		//----- ABOUT PROGRAM ACTION
		class AboutProg extends MouseAdapter {

			private AboutDlg dlg = null;

			AboutProg(AboutDlg dlg) {
				this.dlg = dlg;
			}

			public void mouseClicked(MouseEvent e) {
				dlg.setEnabled(true);
				dlg.setVisible(true);
			}
	    }

		//----- AWESOME SETTER DATA FROM DATA<SHIT>
		private boolean getDataFromTable(MyCustomCommonAwesomeJPanel item, boolean who) {

			String getColumn;
			Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
			row = item.getRow();
			col = item.getCol();

			// ≈сли каким-то чудесным образом у нас вышло 200 шагов, то выводим сообщение
			if(row != numStep) {

				// ѕровер€ем решили все или нет
				if(!allMethods.get(numPanel).isEnd()){

					// »дем по всей строке, запоминаем не нулевые сигналы, если есть пустое значение то выходим
					for(int i = 0; i < col; i++) {
						getColumn = item.getDataTable().getValueAt(numStep, i).toString();

						if (getColumn.intern() == "".intern()) {
							choiceMessage(who);
							return false;
						}
						else {
								if(getColumn.intern() != "0".intern())
									map.put(Integer.parseInt(getColumn), i);
							}
					}

					// —охран€ем текущую верную дату, мало-ли неправильно введЄм решение
					allMethods.get(numPanel).SaveMainData();

					// ¬ычисл€ем каждый отдельный у, в зависимости от приоритета
					for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
						if(allMethods.get(numPanel).HandComputing_Y(entry.getValue()))
							break;
					}

					if(allMethods.get(numPanel).CompareAnswers(numStep)){
						++numStep;
						item.getDataTable().getRightRenderer().setRowSelect(numStep);
						item.getDataTable().repaint();

						if(allMethods.get(numPanel).isEnd()){
							MyCustomCommonAwesomeJPanel.setResult(CommonData.getBinaryString(allMethods.get(numPanel).getMainData().Result, 17));

							JOptionPane.showMessageDialog( 	null, 	"\u0412\u044b \u0437\u0430\u0432\u0435\u0440\u0448\u0438\u043b\u0438 \u0440\u0435\u0448\u0435\u043d\u0438\u0435 \u0434\u0430\u043d\u043d\u044b\u043c \u043c\u0435\u0442\u043e\u0434\u043e\u043c.\n" +
																	"\u0412\u0430\u0448\u0430 \u043e\u0446\u0435\u043d\u043a\u0430: " + allMethods.get(numPanel).getMark(),
																	"\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c!",
																	JOptionPane.INFORMATION_MESSAGE);
							return false;
						}

						// ¬озвращаем единственный тру дл€ продолжени€ цикла выполнени€ алгоритма в автоматическом режиме
						return true;

					} else
							{
								JOptionPane.showMessageDialog( 	null, 	"\u041d\u0435\u0432\u0435\u0440\u043d\u043e \u0437\u0430\u0434\u0430\u043d\u044b \u0443\u043f\u0440\u0430\u0432\u043b\u044f\u044e\u0449\u0438\u0435 \u0441\u0438\u0433\u043d\u0430\u043b\u044b",
																		"\u041e\u0448\u0438\u0431\u043a\u0430",
																		JOptionPane.WARNING_MESSAGE);
								MyCustomCommonAwesomeJPanel.setMistakes(allMethods.get(numPanel).getCountMistakes());

								return false;
							}

				} else
						{
							JOptionPane.showMessageDialog( 	null, 	"\u0412\u044b \u0437\u0430\u0432\u0435\u0440\u0448\u0438\u043b\u0438 \u0440\u0435\u0448\u0435\u043d\u0438\u0435 \u0434\u0430\u043d\u043d\u044b\u043c \u043c\u0435\u0442\u043e\u0434\u043e\u043c.\n" +
																	"\u0412\u0430\u0448\u0430 \u043e\u0446\u0435\u043d\u043a\u0430: " + allMethods.get(numPanel).getMark(),
																	"\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c!",
																	JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
			} else
					{
						item.getDataTable().getRightRenderer().setRowSelect(-1);
						JOptionPane.showMessageDialog( 	null, 	"\u041d\u0435 \u043c\u043e\u0436\u0435\u0442 \u0431\u044b\u0442\u044c, \u0447\u0442\u043e \u0437\u0430 \u0445\u0443\u0439\u043d\u044f",
																"\u0412\u043d\u0438\u043c\u0430\u043d\u0438\u0435",
																JOptionPane.WARNING_MESSAGE);
						return false;
					}
		}

		private void choiceMessage(boolean who) {
			if(who)
				JOptionPane.showMessageDialog( 	null, "\u0417\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u0435 \u0432\u0441\u044e \u0441\u0442\u0440\u043e\u043a\u0443",
						"\u041e\u0448\u0438\u0431\u043a\u0430",
						JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog( 	null, "\u0417\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u0435 \u0432\u0435\u0441\u044c \u0430\u043b\u0433\u043e\u0440\u0438\u0442\u043c!",
						"\u041e\u0448\u0438\u0431\u043a\u0430",
						JOptionPane.INFORMATION_MESSAGE);
		}

		public void resetData() {
			MyCustomCommonAwesomeJPanel.setMistakes(0);
			MyCustomCommonAwesomeJPanel.setResult("none");
			numStep = 0;
		}

	} //-----//


	//----- CONTROLLERS FOR WINDOW
	class AllWindowAction{

		class ExitWindow extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				closers80lvl();
			}
	    }

		class DefaultClose extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		}

		class Cancel implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
	    }

		class OkRegisterDlg implements ActionListener {
			private RegistrationDlg dlg = null;
			OkRegisterDlg(RegistrationDlg dlg) {
				this.dlg = dlg;
			}

			public void actionPerformed(ActionEvent e) {

				if(dlg.getTextField().getText().toString().length() != 0){
					dlg.setLogin(dlg.getTextField().getText().toString());
					mainWindow.getGreatingHello().setText("<html><p align='center'><font size='7' color='#5E42FB'>" +
															dlg.getLogin() +
															",</font><br> <font color='#9460D3'>\u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043e\u0434\u0438\u043d \u0438\u0437 \u0441\u043f\u043e\u0441\u043e\u0431\u043e\u0432 \u0443\u043c\u043d\u043e\u0436\u0435\u043d\u0438\u044f...</font></p></html>");
				}

				if(dlg.getTextField_1().getText().toString().length() != 0){
					dlg.setGroup(dlg.getTextField_1().getText().toString());
				}

				dlg.setVisible(false);
				dlg.setEnabled(false);
				mainWindow.setEnabled(true);
				mainWindow.setVisible(true);
			}
	    }
	}//-----//

	public class InputDlgAction {

		private InputDataDlg inputDlg = null;
		private JTextField [] inputData = new JTextField[4];
		private boolean [] checkFill = {false, false, false, false};
		private String buf1, buf2;
		private JMenu menuMcr = null;
		private JMenu menuTask = null;
		private MyCustomCommonAwesomeJPanel [] mainShit = null;
		private ArrayList<CommonMethods> allMethods = null;

		InputDlgAction(InputDataDlg inputDlg, JMenu menuMcr, JMenu menuTask, MyCustomCommonAwesomeJPanel [] mainShit, ArrayList<CommonMethods> allMethods) {
			this.mainShit = mainShit;
			this.inputDlg = inputDlg;
			this.menuMcr = menuMcr;
			this.menuTask = menuTask;
			inputData = inputDlg.getInputTextFiels();

			this.allMethods = allMethods;
		}

		private void textFieldsClear() {
			for(JTextField item : inputDlg.getInputTextFiels()) {
				item.setText("");
			};
		}

		class OkInputDlg implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				buf1 = inputData[0].getText().toString();
				buf1 += inputData[1].getText().toString();
				MyCustomCommonAwesomeJPanel.setMultiplier1(buf1);
				inputDlg.setFirstMult(buf1);
				buf2 = inputData[2].getText().toString();
				buf2 += inputData[3].getText().toString();
				MyCustomCommonAwesomeJPanel.setMultiplier2(buf2);
				inputDlg.setSecondMult(buf2);

				for(CommonMethods item : allMethods){
					item.setMultipliers(MyCustomCommonAwesomeJPanel.getMultiplier1(), MyCustomCommonAwesomeJPanel.getMultiplier2());
					item.AutoComputing();
				}

				textFieldsClear();
				inputDlg.setEnabled(false);
				inputDlg.setVisible(false);

				switch(inputDlg.getNumberOfMethod()) {
					case 1: mainWindow.getMainLayout().show(mainPane, "Method1"); break;
					case 2: mainWindow.getMainLayout().show(mainPane, "Method2"); break;
					case 3: mainWindow.getMainLayout().show(mainPane, "Method3"); break;
					case 4: mainWindow.getMainLayout().show(mainPane, "Method4"); break;
				}

				menuMcr.setEnabled(true);
				menuTask.setEnabled(false);
				for (MyCustomCommonAwesomeJPanel item : mainShit) {
					item.updateTextOfLabels();
				}
			}
	    }

		class CancelInputDlg implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				inputDlg.setEnabled(false);
				inputDlg.setVisible(false);
				textFieldsClear();
				mainWindow.getMainLayout().show(mainPane, "helloPane");
			}
	    }

		class CloseInputDlg extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				inputDlg.setEnabled(false);
				inputDlg.setVisible(false);
				textFieldsClear();
				mainWindow.getMainLayout().show(mainPane, "helloPane");
			}
		}

		class PressToTextField extends KeyAdapter {
		      public void keyReleased(KeyEvent e) {
		    	  for(int i = 0; i < inputData.length; i++) {
		    		  switch(i){
			    		  case 0: {
			    			  if(inputData[0].getText().length() == 1)
			    				  checkFill[0] = true;
			    			  else
			    				  checkFill[0] = false;
			    			break;
			    		  }
			    		  case 1:{
			    			  if(inputData[1].getText().length() == (inputDlg.getSizeData() - 1))
			    				  checkFill[1] = true;
			    			  else
			    				  checkFill[1] = false;
			    			break;
			    		  }
			    		  case 2: {
			    			  if(inputData[2].getText().length() == 1)
			    				  checkFill[2] = true;
			    			  else
			    				  checkFill[2] = false;
			    			break;
			    		  }
			    		  case 3: {
			    			  if(inputData[3].getText().length() == (inputDlg.getSizeData() - 1))
			    				  checkFill[3] = true;
			    			  else
			    				  checkFill[3] = false;
			    			break;
			    		  }
		    		  }
		    	  }

		    	  if(checkFill[0] && checkFill[1] && checkFill[2] && checkFill[3])
		    		  inputDlg.getOkButton().setEnabled(true);
		    	  else
		    		  inputDlg.getOkButton().setEnabled(false);
		      }
	    }
	}//-----//

	public class StructureOfAutomat {

		private JMenu menuMcr = null;
		private JMenu menuTask = null;
		private MyCustomCommonAwesomeJPanel [] doShit = null;
		private MyJMenuAction jmenuAction = null;
		private ArrayList<CommonMethods> allMethods = null;

		StructureOfAutomat(JMenu menuMcr, JMenu menuTask, MyCustomCommonAwesomeJPanel [] doShit, MyJMenuAction jmenuAction, ArrayList<CommonMethods> allMethods) {
			this.menuMcr = menuMcr;
			this.menuTask = menuTask;
			this.doShit = doShit;
			this.jmenuAction = jmenuAction;
			this.allMethods = allMethods;
		}

		class CancelInputDlg implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				menuMcr.setEnabled(false);
				menuTask.setEnabled(true);
				mainWindow.getMainLayout().show(mainPane, "helloPane");
				jmenuAction.resetData();

				for(CommonMethods item : allMethods)
					item.ClearAllData();

				for(MyCustomCommonAwesomeJPanel item : doShit) {
					item.getDataTable().getCustomModel().resetData();
					item.getDataTable().getRightRenderer().setRowSelect(-1);
					item.getDataTable().repaint();
				}
			}
	    }
	}//-----//
}
