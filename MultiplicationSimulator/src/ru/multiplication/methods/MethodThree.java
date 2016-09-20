package ru.multiplication.methods;
/*
 * ПЕРВЫЙ МЕТОД УСКОРЕННОГО УМНОЖЕНИЯ С ФЗ
 */

import java.util.ArrayList;

public class MethodThree extends CommonMethods {

	public MethodThree(String A, String B) {
		this.A = Mask_9Bits & Integer.parseInt(A, 2);
		this.B = Mask_9Bits & Integer.parseInt(B, 2);
	}

	public MethodThree() { }

	// Управляющие сигналы
	protected void y0 () {
		mainData.RG1_8 = 0;
		mainData.RG2_9 = 0;
		mainData.RG4_18 = 0;
		mainData.SM1_A_18 = 0;
		mainData.SM1_B_18 = 0;
		mainData.SM1_S_18 = 0;
		mainData.MS1_A_10 = 0;
		mainData.MS1_B_10 = 0;
		mainData.MS1_S_10 = 0;
		mainData.Result = 0;
		mainData.CT1 = 0;
		mainData.P0 = false;
		mainData.P1 = false;
		mainData.P2 = false;
		mainData.P3 = false;
		mainData.P4 = false;
		mainData.P5 = false;
		mainData.P6 = false;
		mainData.P7 = false;
		mainData.P8 = false;
		mainData.P9 = false;
		mainData.T1 = false;
		mainData.T2 = false;

		this.isEnd = false;
	};

	protected void y1 () {
		mainData.RG1_8 = A & Mask_8Bits;
		mainData.RG2_9 = B;
		p1();
		p2();
		mainData.T1 = p3();
		mainData.MS1_A_10 = Mask_8Bits & mainData.RG2_9;
		mainData.MS1_B_10 = mainData.RG2_9;
		mainData.MS1_B_10 <<= 1;
		mainData.MS1_B_10 &= Mask_18Bits;
		p4();
		p5();
		p6();
		p7();
		p8();

		DebugOutCust(mainData, 1);
	};

	protected void y2 () {
		mainData.CT1 += 1;
		p0();
		DebugOutCust(mainData, 2);
	};

	protected void y3 () {
		mainData.MS1_S_10 = mainData.MS1_A_10;
		mainData.SM1_B_18 = mainData.MS1_S_10;
		mainData.SM1_A_18 = mainData.RG4_18;

		DebugOutCust(mainData, 3);
	};

	protected void y4 () {
		mainData.MS1_S_10 = mainData.MS1_B_10;
		mainData.SM1_B_18 = mainData.MS1_S_10;
		mainData.SM1_A_18 = mainData.RG4_18;

		DebugOutCust(mainData, 4);
	};

	protected void y5 () {
		mainData.SM1_S_18 = mainData.SM1_A_18 + mainData.SM1_B_18;
		mainData.SM1_S_18 &= Mask_18Bits;
		mainData.RG4_18 = mainData.SM1_S_18;

		DebugOutCust(mainData, 5);
	};

	protected void y6 () {
		mainData.SM1_B_18 = mainData.MS1_S_10;
		mainData.SM1_B_18 = ~mainData.SM1_B_18 & Mask_18Bits;
		mainData.SM1_B_18 += 1;
		mainData.SM1_B_18 &= Mask_18Bits;

		DebugOutCust(mainData, 6);

	};

	protected void y7 () {
		mainData.RG1_8 <<= 2;
		mainData.RG1_8 &= Mask_10Bits;
		mainData.RG4_18 <<= 2;
		mainData.RG4_18 &= Mask_18Bits;

		p4();
		p5();
		p6();
		p7();
		p8();

		DebugOutCust(mainData, 7);
	};
	protected void y8 () {

	};

	protected void y11 () {}

	// Установка сигналов для условных переходов
	protected boolean p0 () {
		if(mainData.CT1 == 0b101)
			mainData.P0 = true;
		else
			mainData.P0 = false;

		return mainData.P0;
	};

	protected boolean p1 () {
		mainData.P1 = ((A & Mask_Get_9Bit) != 0);

		return mainData.P1;
	};

	protected boolean p2 () {
		mainData.P2 = ((B & Mask_Get_9Bit) != 0);

		return mainData.P2;
	};

	protected boolean p3 () {
		if(mainData.P1 != mainData.P2)
			mainData.P3 = true;
		else
			mainData.P3 = false;

		return mainData.P3;
	};

	protected boolean p4 () {

		if((((mainData.RG1_8 & Mask_Get_8Bit) == 0) && ((mainData.RG1_8 & Mask_Get_9Bit) != 0) && (mainData.RG1_8 & Mask_Get_7Bit) == 0))
			mainData.P4 = true;
		else
			mainData.P4 = false;

		return mainData.P4;
	};

	protected boolean p5 () {
		if((((mainData.RG1_8 & Mask_Get_8Bit) != 0) && ((mainData.RG1_8 & Mask_Get_9Bit) != 0) && (mainData.RG1_8 & Mask_Get_7Bit) != 0) ||
			(((mainData.RG1_8 & Mask_Get_8Bit) == 0) && ((mainData.RG1_8 & Mask_Get_9Bit) == 0) && (mainData.RG1_8 & Mask_Get_7Bit) == 0))
			mainData.P5 = true;
		else
			mainData.P5 = false;

		return mainData.P5;
	};

	protected boolean p6 () {
		if((((mainData.RG1_8 & Mask_Get_8Bit) != 0) && ((mainData.RG1_8 & Mask_Get_9Bit) == 0) && (mainData.RG1_8 & Mask_Get_7Bit) == 0) ||
				(((mainData.RG1_8 & Mask_Get_8Bit) == 0) && ((mainData.RG1_8 & Mask_Get_9Bit) == 0) && (mainData.RG1_8 & Mask_Get_7Bit) != 0))
			mainData.P6 = true;
		else
			mainData.P6 = false;

		return mainData.P6;
	};

	protected boolean p7 () {
		if(((mainData.RG1_8 & Mask_Get_8Bit) != 0) && ((mainData.RG1_8 & Mask_Get_9Bit) == 0) && (mainData.RG1_8 & Mask_Get_7Bit) != 0)
			mainData.P7 = true;
		else
			mainData.P7 = false;

		return mainData.P7;
	};

	protected boolean p8 () {
		if((((mainData.RG1_8 & Mask_Get_8Bit) != 0) && ((mainData.RG1_8 & Mask_Get_9Bit) != 0) && (mainData.RG1_8 & Mask_Get_7Bit) == 0) ||
				(((mainData.RG1_8 & Mask_Get_8Bit) == 0) && ((mainData.RG1_8 & Mask_Get_9Bit) != 0) && (mainData.RG1_8 & Mask_Get_7Bit) != 0))
			mainData.P8 = true;
		else
			mainData.P8 = false;

		return mainData.P8;
	};

	protected boolean p9(){
		return true;
	};


	// ----------------------------------------------------------------
	public void AutoComputing() {
		// ----------
		y0();
		allSteps.add(new CommonData(mainData));
		// ----------
		y1();
		allSteps.add(new CommonData(mainData));
		// ----------

		do {
				if(!mainData.P5) {
					if(mainData.P6) {
						y3();
						y5();
						allSteps.add(new CommonData(mainData));
					} else {
						if(mainData.P7) {
							y4();
							y5();
							allSteps.add(new CommonData(mainData));
						} else {
							if(mainData.P8) {
								y3();
								y6();
								y5();
								allSteps.add(new CommonData(mainData));
							} else {
								y4();
								y6();
								y5();
							}
						}
					}
				}

				y2();
				allSteps.add(new CommonData(mainData));
				// ----------

				if(p0())
					break;
				else
					y7();

				allSteps.add(new CommonData(mainData));
		} while(true);

		y0();
		countSteps = allSteps.size();
	}

	// Выполняем нужный сигнал
	public boolean HandComputing_Y(int NumY) {
		switch(NumY) {
			case 0: y0(); break;
			case 1: y1(); break;
			case 2: y2(); break;
			case 3: y3(); break;
			case 4: y4(); break;
			case 5: y5(); break;
			case 6: y6(); break;
			case 7: y7(); break;
			case 8: y8(); break;
			default: System.err.println("\u041d\u0435\u0442 \u0442\u0430\u043a\u043e\u0433\u043e \u0443\u043f\u0440\u0430\u0432\u043b\u044f\u044e\u0449\u0435\u0433\u043e \u0441\u0438\u0433\u043d\u0430\u043b\u0430!");
		}

		return isThisEnd();
	}
}
