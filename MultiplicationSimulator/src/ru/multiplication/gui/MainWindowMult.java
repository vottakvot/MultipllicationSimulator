package ru.multiplication.gui;

import ru.multiplication.methods.*;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import ru.multiplication.gui.MyCustomAwesomeListeners.MyTaskJPaneAction;
import ru.multiplication.methods.CommonData;

public class MainWindowMult extends JFrame {

	private MyCustomAwesomeListeners mainActionType = null;
	private AboutDlg aboutDlg = null;
	private RegistrationDlg regDlg = null;
	private MyCustomAwesomeTaskJPane taskPane1 = null;
	private MyCustomAwesomeTaskJPane taskPane2 = null;
	private MyCustomAwesomeTaskJPane taskPane3 = null;
	private MyCustomAwesomeTaskJPane taskPane4 = null;
	private InputDataDlg inputData = null;
	private MyCustomCommonAwesomeJPanel [] doShit = new MyCustomCommonAwesomeJPanel[4];
	private ArrayList<CommonMethods> allMethod = new ArrayList<CommonMethods>();

	private JLabel greatingHello = null;
	private CardLayout mainLayout = null;

	private JPanel contentPane;
	private JPanel helloPane = null;
	private MyCustomAwesomeJMenu menu = null;

	//----- CONSTRUCTOR
	//Window viewer
	public MainWindowMult() {

		setEnabled(false);
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(10, 10, 1366, 768);
		setMinimumSize(new Dimension(1366, 768));
		setPreferredSize(new Dimension(1366, 768));
		setTitle(	"\u041b\u0430\u0431\u043e\u0440\u0430\u0442\u043e\u0440\u043d\u044b\u0439 \u0441\u0442\u0435\u043d\u0434 " +
				"\u043f\u043e \u0441\u043f\u043e\u0441\u043e\u0431\u0430\u043c \u0443\u0441\u043a\u043e\u0440\u0435\u043d\u043d\u043e\u0433\u043e " +
				"\u0443\u043c\u043d\u043e\u0436\u0435\u043d\u0438\u044f");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		mainLayout = new CardLayout();
		contentPane.setLayout(mainLayout);

		try {
			mainActionType = new MyCustomAwesomeListeners(this, contentPane);
			menu = new MyCustomAwesomeJMenu();
			aboutDlg = new AboutDlg(this);
			taskPane1 = new MyCustomAwesomeTaskJPane("œ≈–¬€Ã");
			taskPane2 = new MyCustomAwesomeTaskJPane("¬“Œ–€Ã");
			taskPane3 = new MyCustomAwesomeTaskJPane("“–≈“»Ã");
			taskPane4 = new MyCustomAwesomeTaskJPane("◊≈“¬®–“€Ã");
			inputData = new InputDataDlg(9);

			doShit[0] = new MyCustomCommonAwesomeJPanel(200, 9, 1);
			doShit[1] = new MyCustomCommonAwesomeJPanel(200, 9, 2);
			doShit[2] = new MyCustomCommonAwesomeJPanel(200, 8, 3);
			doShit[3] = new MyCustomCommonAwesomeJPanel(200, 8, 4);
			regDlg = new RegistrationDlg();

			allMethod.add(new MethodOne());
			allMethod.add(new MethodTwo());
			allMethod.add(new MethodThree());
			allMethod.add(new MethodFour());

		} catch(Exception exception) {
            exception.printStackTrace();
        }

		//Create menu
		setJMenuBar(menu);
		//Create panes
		createAllPane();

		//All listeners
		addListenersForAllObjects();

		regDlg.setVisible(true);

		pack();
	}

	//----- LISTENERS
	private void addListenersForAllObjects() {
		addWindowListener(mainActionType.new AllWindowAction().new ExitWindow());

		menu.getExitProga().addActionListener(mainActionType.new MyJMenuAction(doShit, allMethod).new exitMenu());
		menu.getAboutProg().addMouseListener(mainActionType.new MyJMenuAction(doShit, allMethod).new AboutProg(aboutDlg));
		menu.getFirstWay().addActionListener(mainActionType.new MyJMenuAction(doShit, allMethod).new firstMethod());
		menu.getSecondWay().addActionListener(mainActionType.new MyJMenuAction(doShit, allMethod).new secondMethod());
		menu.getThirdWay().addActionListener(mainActionType.new MyJMenuAction(doShit, allMethod).new thirdMethod());
		menu.getFourthWay().addActionListener(mainActionType.new MyJMenuAction(doShit, allMethod).new fourthMethod());

		MyCustomAwesomeListeners.MyJMenuAction commonDo = mainActionType.new MyJMenuAction(doShit, allMethod);
		menu.getOneStep().addActionListener(commonDo.new oneStep());
		menu.getExecMp().addActionListener(commonDo.new execMp());

		taskPane1.getTaskBtnOk().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane1, MyTaskJPaneAction.FIRST, inputData).new OkAction());
		taskPane2.getTaskBtnOk().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane2, MyTaskJPaneAction.SECOND, inputData).new OkAction());
		taskPane3.getTaskBtnOk().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane3, MyTaskJPaneAction.THIRD, inputData).new OkAction());
		taskPane4.getTaskBtnOk().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane4, MyTaskJPaneAction.FOURTH, inputData).new OkAction());
		taskPane1.getTaskBtnCancel().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane1).new CancelAction());
		taskPane2.getTaskBtnCancel().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane2).new CancelAction());
		taskPane3.getTaskBtnCancel().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane3).new CancelAction());
		taskPane4.getTaskBtnCancel().addActionListener(mainActionType.new MyTaskJPaneAction(taskPane4).new CancelAction());

		regDlg.addWindowListener(mainActionType.new AllWindowAction().new DefaultClose());
		regDlg.getOkButton().addActionListener(mainActionType.new AllWindowAction().new OkRegisterDlg(regDlg));
		regDlg.getCancelButton().addActionListener(mainActionType.new AllWindowAction().new Cancel());

		inputData.getOkButton().addActionListener(mainActionType.new InputDlgAction(inputData, menu.getMicroProg(), menu.getTypeMult(), doShit, allMethod).new OkInputDlg());
		inputData.getCancelButton().addActionListener(mainActionType.new InputDlgAction(inputData, menu.getMicroProg(), menu.getTypeMult(), doShit, allMethod).new CancelInputDlg());
		inputData.addWindowListener(mainActionType.new InputDlgAction(inputData, menu.getMicroProg(), menu.getTypeMult(), doShit, allMethod).new CloseInputDlg());

		for(JTextField item : inputData.getInputTextFiels()) {
			item.addKeyListener(mainActionType.new InputDlgAction(inputData, menu.getMicroProg(), menu.getTypeMult(), doShit, allMethod).new PressToTextField());
		};

		for(MyCustomCommonAwesomeJPanel item : doShit) {
			item.getCancelButton().addActionListener(mainActionType.new StructureOfAutomat(menu.getMicroProg(), menu.getTypeMult(), doShit, commonDo, allMethod).new CancelInputDlg());
		}
	}

	//----- HELLO PANE
	private void createHelloPane(boolean visibleJPane) {
		helloPane = new JPanel() {
			  Image img = new ImageIcon(MyCustomAwesomeListeners.getIconsPath("background_1.png")).getImage();
			  public void paintComponent(Graphics g) {
				super.paintComponent(g);
			    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			  }
		};
		helloPane.setLayout(new BorderLayout(0, 0));
		helloPane.setBorder(new CompoundBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null),
							new CompoundBorder(UIManager.getBorder("TitledBorder.border"), new EmptyBorder(10, 10, 10, 10))));
		greatingHello = new JLabel();
		greatingHello.setText("<html><p align='center'><font size='7' color='red'>" +
								regDlg.getLogin() +
								",</font><br> <font color='#9460D3'>\u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043e\u0434\u0438\u043d \u0438\u0437 \u0441\u043f\u043e\u0441\u043e\u0431\u043e\u0432 \u0443\u043c\u043d\u043e\u0436\u0435\u043d\u0438\u044f...</font></p></html>");
		greatingHello.setIcon(null);
		greatingHello.setAutoscrolls(true);
		greatingHello.setFont(new Font("Tahoma", Font.ITALIC, 24));
		greatingHello.setHorizontalAlignment(SwingConstants.CENTER);
		helloPane.add(greatingHello);
		helloPane.setVisible(visibleJPane);
		helloPane.setEnabled(visibleJPane);
		contentPane.add(helloPane, "helloPane");
	}

	//----- ALL PANES
	//Create panes with 1-4 methods
	private void createAllPane(){
		createHelloPane(true);
		contentPane.add(taskPane1, "taskPane1");
		contentPane.add(taskPane2, "taskPane2");
		contentPane.add(taskPane3, "taskPane3");
		contentPane.add(taskPane4, "taskPane4");
		for(int i = 0; i < doShit.length; i++){
			contentPane.add(doShit[i], "Method" + (i + 1));
		}
	}

	public JLabel getGreatingHello() {
		return greatingHello;
	}

	public CardLayout getMainLayout() {
		return mainLayout;
	}
}



