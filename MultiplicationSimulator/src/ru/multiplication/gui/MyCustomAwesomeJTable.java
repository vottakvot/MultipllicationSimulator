package ru.multiplication.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class MyCustomAwesomeJTable extends JTable {

	private CustomRenderer rightRenderer = null;
	private MyTableModel customModel = null;
	private int forCountColumns = 0;
	private JComboBox comboBoxTable = null;

	MyCustomAwesomeJTable(int row, int col) {

		forCountColumns = col;
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setBorder(new MatteBorder(2, 2, 2, 2, new Color(128, 128, 128)));
		setRowHeight(15);
		setAutoCreateColumnsFromModel(true);
		setShowGrid(true);
		setShowHorizontalLines(true);
		setCellSelectionEnabled(true);
		setFillsViewportHeight(true);
		setAlignmentX(LEFT_ALIGNMENT);
		setAlignmentY(LEFT_ALIGNMENT);
		setFont(new Font(Font.SERIF, Font.BOLD, 12));
		customModel = new MyTableModel(row, col);
		setModel(customModel);
		changeSelection(0, 0, false, false);

		comboBoxTable = new JComboBox();
		comboBoxTable.setMaximumRowCount(col);
		comboBoxTable.setBackground(new Color(224, 255, 255));

		for(int i = 0; i < col; i++)
			comboBoxTable.addItem(Integer.toString(i));

		JTableHeader tHead = null;
		tHead = getTableHeader();
		tHead.setResizingAllowed(false);
		tHead.setFont(new Font(Font.SERIF, Font.BOLD, 12));
		tHead.setEnabled(false);
		tHead.setAlignmentX(LEFT_ALIGNMENT);
		tHead.setAlignmentY(LEFT_ALIGNMENT);
		setTableHeader(tHead);

		rightRenderer = new CustomRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);

		TableColumn column = null;
		for (int i = 0; i < getColumnCount(); i++) {
		    column = getColumnModel().getColumn(i);
		    column.setPreferredWidth(20);
		    column.setResizable(false);
		    column.setMinWidth(24);
		    column.setMaxWidth(24);
		    column.setCellEditor(new DefaultCellEditor(comboBoxTable));
		    column.setCellRenderer(rightRenderer);
		}
	}

	public CustomRenderer getRightRenderer() {
		return rightRenderer;
	}

	public MyTableModel getCustomModel() {
		return customModel;
	}

	//----- REALIZE YOUR DATA MODEL FOR TABLE
	class MyTableModel extends AbstractTableModel {

		private String [] input = {"c", "l", "i", "c", "k", "!"};
		private String[] columnNames;
		private Object[][] data;

		private boolean flag = false;
		private int row = 0;
		private int col = 0;
		private int count = 0;

		private boolean isMatch = false;

		//------ CONSTRUCTOR
		MyTableModel(int row, int col) {
			this.row = row;
			this.col = col;
			tableDataModel(row, col);
			tableHeaders(col);
		}

		public Object[][] getData() {
			return data;
		}

		//----- CREATE STRING FOR TABLE MODEL
		private void tableDataModel(int row, int col) {
			data = new String[row][col];
			resetData();
		}

		public void resetData() {
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					if (i == 0 && j > 0 && j < 7)
						data[i][j] = input[j-1];
					else
						data[i][j] = "";
		}

		//----- CREATE STRING FOR TABLE HEADER
		private void tableHeaders(int col) {
			columnNames = new String[col];
			for(int i = 0; i < col; i++)
				columnNames[i] = "y" + i;
		}

		//----- METHODS FOR OVERLOAD
		public void setValueAt(Object obj, int rowIndex, int columnIndex) {

			isMatch = false;

			if(obj.toString().intern() != "0".intern()) {
				for(int i = 0; i < forCountColumns; i++)
					if(obj.toString().intern() == data[rowIndex][i].toString().intern()){
						JOptionPane.showMessageDialog( 	null, "\u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0443\u0436\u0435 \u0432\u044b\u0431\u0440\u0430\u043d\u043e!",
								"\u041e\u0448\u0438\u0431\u043a\u0430",
								JOptionPane.ERROR_MESSAGE);
						isMatch = true;
						break;
					}

					if(!isMatch)
						data[rowIndex][columnIndex] = obj;

				} else {
						data[rowIndex][columnIndex] = obj;
					}

			// Сбрасываем, чтобы индекс всегда был на 0 элементе, чтобы не вызывало ошибку
			comboBoxTable.setSelectedIndex(0);
			fireTableCellUpdated(rowIndex, columnIndex);
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {

			if(rowIndex > 0) {
				for(int i = 0; i < col; i++) {
					if (data[rowIndex-1][i] == "")
						flag = true;
				}
			}

		  if(rowIndex == 0) {
			  flag = false;
			  return true;
		  }
		  else if(flag) {
			  		flag = false;
			  		if(count == 3) {
			  			JOptionPane.showMessageDialog( 	null, "\u0422\u0430\u0431\u043b\u0438\u0446\u0430 \u0437\u0430\u043f\u043e\u043b\u043d\u044f\u0435\u0442\u0441\u044f \u043f\u043e\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u0435\u043b\u044c\u043d\u043e, \u043d\u0430\u0447\u0438\u043d\u0430\u044f \u0441 \u043f\u0435\u0440\u0432\u043e\u0439 \u0441\u0442\u0440\u043e\u043a\u0438!",
			  											"\u041e\u0448\u0438\u0431\u043a\u0430",
			  											JOptionPane.ERROR_MESSAGE);
			  			count = 0;
			  		} else
			  			++count;

			  		return false;
		  		}
		  		else {
		  			flag = false;
		  			return true;
		  		}
		}

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
	}


	class CustomRenderer extends DefaultTableCellRenderer {

		private int rowSelect = -1;
		private static final long serialVersionUID = 6703872492730589499L;
		private int nextRow = 0;
		private String allRow = "";

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

	    	Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	    	// Рисуем сверху-вниз, обработка происходит для каждой ячейки
	    	// Исходные цвета, бирюзовый фон, первая строка фон активной для заполнения, остальное уже отрисовывается поверх
	    	cellComponent.setBackground(new Color(175, 238, 238));

	    	// Если 0 или любое другое число, то рисуем белый фон и зеленый 0 или синяя цифра
	        if(row == 0)
	        	cellComponent.setBackground(new Color(255, 255, 255));

	    	if("0".intern() == value.toString().intern())
		    	{
	        		cellComponent.setForeground(new Color(255, 20, 147));
	        		cellComponent.setBackground(new Color(255, 255, 255));
	        	}
	    	else if (isStringIsNumber(value.toString())) {
			       		cellComponent.setForeground(Color.BLUE);
			       		cellComponent.setBackground(new Color(255, 255, 255));
			       }

	        // Проверяем, если строка полностью заполнена, то следующую строку для запонения выделяем зелёным цветом
	    	if(getRowAndCompare(table, row))
	    		nextRow = row + 1;

	    	if(nextRow == row) {
	    		// Обновляем строку таблицы
	    		customModel.fireTableRowsUpdated(nextRow, nextRow);
	    		cellComponent.setBackground(new Color(127, 255, 212));
	    	}

	    	// Для отрисовки текущей(выполняемой строки) розового цвета, параметр изменяется в другом месте
	        if(rowSelect == row)
	        	cellComponent.setBackground(new Color(255, 192, 203));

	    	return cellComponent;
	    }

		public void setRowSelect(int rowSelect) {
			this.rowSelect = rowSelect;
		}

		// Проверяем заполнена ли вся строка цифрами
		private boolean getRowAndCompare(JTable jTable, int row){

			allRow = "";
			for(int i = 0; i < forCountColumns; i++){
				if(isStringIsNumber(jTable.getModel().getValueAt(row, i).toString()))
					allRow += jTable.getModel().getValueAt(row, i).toString().charAt(0);
			}

			if(allRow.length() == forCountColumns)
				return true;
			else
				return false;
		}

		// Строка является числом ?
		private boolean isStringIsNumber(String string) {
	        if (string == null)
	        	return false;
	        return string.matches("^-?\\d+$");
	    }
	}
}