package ru.multiplication.methods;

import java.util.ArrayList;
/* Œ—ÕŒ¬Õ€≈ Ã≈“Œƒ€ ƒÀﬂ —œŒ—Œ¡Œ¬ ”ÃÕŒ∆≈Õ»ﬂ
 * ¬Œ ¬—≈’ Ã≈“Œƒ¿’ »’  ŒÀ-¬Œ Œƒ»Õ¿ Œ¬Œ
 */

public abstract class CommonMethods {

	protected int A = 0;
	protected int B = 0;
	protected int countMistakes = 0;
	protected int countSteps = 0;
	protected boolean isEnd = false;

	protected CommonData mainData = new CommonData();
	protected CommonData duplicateMainData = new CommonData();
	protected ArrayList<CommonData> allSteps = new ArrayList<CommonData>();

	protected final int Mask_9Bits 				= 0b111111111;
	protected final int Mask_Get_0Bit 			= 0b1;
	protected final int Mask_Get_1Bit 			= 0b10;
	protected final int Mask_Get_2Bit 			= 0b100;
	protected final int Mask_8Bits 				= 0b11111111;
	protected final int Mask_Get_9Bit 			= 0b1000000000;
	protected final int Mask_Get_8Bit 			= 0b100000000;
	protected final int Mask_Get_7Bit 			= 0b10000000;
	protected final int Mask_10Bits 			= 0b1111111111;
	protected final int Mask_9And10_Bits_Null 	= 0b0011111111;
	protected final int Mask_18Bits 			= 0b111111111111111111;
	protected final int Mask_Get_18Bit 			= 0b100000000000000000;
	protected final int Mask_Get_17_18Bits		= 0b110000000000000000;
	protected final int Mask_0_7_Bits_Null		= 0b111111111100000000;
	protected final int Mask_Get_17Bit 			= 0b10000000000000000;
	protected final int Mask_16Bits 			= 0b1111111111111111;

	// ”Ô‡‚Îˇ˛˘ËÂ ÒË„Ì‡Î˚
	abstract protected void y0();
	abstract protected void y1();
	abstract protected void y2();
	abstract protected void y3();
	abstract protected void y4();
	abstract protected void y5();
	abstract protected void y6();
	abstract protected void y7();
	abstract protected void y8();


	// ”ÒÚ‡ÌÓ‚Í‡ ÒË„Ì‡ÎÓ‚ ‰Îˇ ÛÒÎÓ‚Ì˚ı ÔÂÂıÓ‰Ó‚
	abstract protected boolean p0();
	abstract protected boolean p1();
	abstract protected boolean p2();
	abstract protected boolean p3();
	abstract protected boolean p4();
	abstract protected boolean p5();
	abstract protected boolean p6();
	abstract protected boolean p7();
	abstract protected boolean p8();
	abstract protected boolean p9();

	abstract public void AutoComputing();
	abstract public boolean HandComputing_Y(int NumY);

	public void setMultipliers(String A, String B) {
		this.A 		= Mask_9Bits & Integer.parseInt(A, 2);
		this.B 		= Mask_9Bits & Integer.parseInt(B, 2);
		this.isEnd 	= false;
	}

	public CommonData getMainData() {
		return mainData;
	}

	public int getCountSteps() {
		return countSteps;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void ClearAllData(){
		A = 0;
		B = 0;
		countMistakes = 0;
		countSteps = 0;
		isEnd = false;
		allSteps.clear();
	}

	public int getMark(){
		return Math.round((100 - countMistakes * 6) / 20);
	}


	protected boolean isThisEnd(){
		if(mainData.P0){
			isEnd = true;
			mainData.Result = mainData.RG4_18 & Mask_16Bits;
			mainData.Result |= Mask_Get_17Bit;
			return true;
		}
		else
			isEnd = false;
			return false;
	}

	public void SaveMainData() {
		duplicateMainData.RG1_8    = mainData.RG1_8;
		duplicateMainData.RG2_9    = mainData.RG2_9;
		duplicateMainData.RG4_18   = mainData.RG4_18;
		duplicateMainData.SM1_A_18 = mainData.SM1_A_18;
		duplicateMainData.SM1_B_18 = mainData.SM1_B_18;
		duplicateMainData.SM1_S_18 = mainData.SM1_S_18;
		duplicateMainData.MS1_A_10 = mainData.MS1_A_10;
		duplicateMainData.MS1_B_10 = mainData.MS1_B_10;
		duplicateMainData.MS1_S_10 = mainData.MS1_S_10;
		duplicateMainData.Result   = mainData.Result;
		duplicateMainData.CT1      = mainData.CT1;
		duplicateMainData.P0       = mainData.P0;
		duplicateMainData.P1       = mainData.P1;
		duplicateMainData.P2       = mainData.P2;
		duplicateMainData.P3       = mainData.P3;
		duplicateMainData.P4       = mainData.P4;
		duplicateMainData.P5       = mainData.P5;
		duplicateMainData.P6       = mainData.P6;
		duplicateMainData.P7       = mainData.P7;
		duplicateMainData.P8       = mainData.P8;
		duplicateMainData.P9       = mainData.P9;
		duplicateMainData.T1       = mainData.T1;
		duplicateMainData.T2       = mainData.T2;
	}

	public void SetSaveMainData() {
		mainData.RG1_8    = duplicateMainData.RG1_8;
		mainData.RG2_9    = duplicateMainData.RG2_9;
		mainData.RG4_18   = duplicateMainData.RG4_18;
		mainData.SM1_A_18 = duplicateMainData.SM1_A_18;
		mainData.SM1_B_18 = duplicateMainData.SM1_B_18;
		mainData.SM1_S_18 = duplicateMainData.SM1_S_18;
		mainData.MS1_A_10 = duplicateMainData.MS1_A_10;
		mainData.MS1_B_10 = duplicateMainData.MS1_B_10;
		mainData.MS1_S_10 = duplicateMainData.MS1_S_10;
		mainData.Result   = duplicateMainData.Result;
		mainData.CT1      = duplicateMainData.CT1;
		mainData.P0       = duplicateMainData.P0;
		mainData.P1       = duplicateMainData.P1;
		mainData.P2       = duplicateMainData.P2;
		mainData.P3       = duplicateMainData.P3;
		mainData.P4       = duplicateMainData.P4;
		mainData.P5       = duplicateMainData.P5;
		mainData.P6       = duplicateMainData.P6;
		mainData.P7       = duplicateMainData.P7;
		mainData.P8       = duplicateMainData.P8;
		mainData.P9       = duplicateMainData.P9;
		mainData.T1       = duplicateMainData.T1;
		mainData.T2       = duplicateMainData.T2;
	}

	public int getCountMistakes() {
		return countMistakes;
	}

	public void DebugOutCust(CommonData out, int numMeth) {
		System.out.println(	"y" + numMeth + ": " +
							"\nRG1: " + CommonData.getBinaryString(out.RG1_8, 18) +
							"\nRG2: " + CommonData.getBinaryString(out.RG2_9, 18) +
							"\nRG4: " + CommonData.getBinaryString(out.RG4_18, 18) +
							"\nSM1_A: " + CommonData.getBinaryString(out.SM1_A_18, 18) +
							"\nSM1_B: " + CommonData.getBinaryString(out.SM1_B_18, 18) +
							"\nSM1_S: " + CommonData.getBinaryString(out.SM1_S_18, 18) +
							"\nMS1_A: " + CommonData.getBinaryString(out.MS1_A_10, 18) +
							"\nMS1_B: " + CommonData.getBinaryString(out.MS1_B_10, 18) +
							"\nMS1_S: " + CommonData.getBinaryString(out.MS1_S_10, 18) +
							"\nCT1: " + CommonData.getBinaryString(out.CT1, 5) +
							"\nP0: " + out.P0 +
							"\nP1: " + out.P1 +
							"\nP2: " + out.P2 +
							"\nP3: " + out.P3 +
							"\nP4: " + out.P4 +
							"\nP5: " + out.P5 +
							"\nP6: " + out.P6 +
							"\nP7: " + out.P7 +
							"\nP8: " + out.P8 +
							"\nP9: " + out.P9 +
							"\nT1: " + out.T1 +
							"\nT2: " + out.T2 + "\n\n"
				);
	}

	public boolean CompareAnswers(int NumStepOrString) {

		if(NumStepOrString > countSteps){
			System.err.println("CommonMethods.CompareAnswers \u043a\u043e\u043b-\u0432\u043e \u0448\u0430\u0433\u043e\u0432 \u043f\u0440\u0435\u0432\u044b\u0448\u0430\u0435\u0442 \u0434\u043e\u043f\u0443\u0441\u0442\u0438\u043c\u043e\u0435");
			throw new Error();
		}

		if(	(mainData.RG1_8 == allSteps.get(NumStepOrString).RG1_8) &&
			(mainData.RG2_9 == allSteps.get(NumStepOrString).RG2_9) &&
			(mainData.RG4_18 == allSteps.get(NumStepOrString).RG4_18) &&
			(mainData.SM1_A_18 == allSteps.get(NumStepOrString).SM1_A_18) &&
			(mainData.SM1_B_18 == allSteps.get(NumStepOrString).SM1_B_18) &&
			(mainData.SM1_S_18 == allSteps.get(NumStepOrString).SM1_S_18) &&
			(mainData.MS1_A_10 == allSteps.get(NumStepOrString).MS1_A_10) &&
			(mainData.MS1_B_10 == allSteps.get(NumStepOrString).MS1_B_10) &&
			(mainData.MS1_S_10 == allSteps.get(NumStepOrString).MS1_S_10) &&
			(mainData.Result   == allSteps.get(NumStepOrString).Result) &&
			(mainData.CT1 == allSteps.get(NumStepOrString).CT1) &&
			(mainData.P0 == allSteps.get(NumStepOrString).P0) &&
			(mainData.P1 == allSteps.get(NumStepOrString).P1) &&
			(mainData.P2 == allSteps.get(NumStepOrString).P2) &&
			(mainData.P3 == allSteps.get(NumStepOrString).P3) &&
			(mainData.P4 == allSteps.get(NumStepOrString).P4) &&
			(mainData.P5 == allSteps.get(NumStepOrString).P5) &&
			(mainData.P6 == allSteps.get(NumStepOrString).P6) &&
			(mainData.P7 == allSteps.get(NumStepOrString).P7) &&
			(mainData.P8 == allSteps.get(NumStepOrString).P8) &&
			(mainData.P9 == allSteps.get(NumStepOrString).P9) &&
			(mainData.T1 == allSteps.get(NumStepOrString).T1) &&
			(mainData.T2 == allSteps.get(NumStepOrString).T2))

			return true;
		else
			{
				SetSaveMainData();
				++countMistakes;
				return false;
			}

	}
}
