package ru.multiplication.methods;
/* ФОРМАТ ДАННЫХ ДЛЯ ХРАНЕНИЯ ИНФОРМАЦИИ ДЛЯ ВСЕХ МЕТОДОВ
 * ДОПОЛНЯЕТСЯ ДЛЯ КАЖДОГО МЕТОДА ИНДИВУДУАЛЬНО
 * */

public class CommonData {

	// Хранение данных
	public int RG1_8 = 0;
	public int RG2_9 = 0;
	public int RG4_18 = 0;
	public int SM1_A_18 = 0;
	public int SM1_B_18 = 0;
	public int SM1_S_18 = 0;
	public int MS1_A_10 = 0;
	public int MS1_B_10 = 0;
	public int MS1_S_10 = 0;
	public int Result 	= 0;
	public int CT1 = 0;

	// Флаги условий переходов
	public boolean P0 = false;
	public boolean P1 = false;
	public boolean P2 = false;
	public boolean P3 = false;
	public boolean P4 = false;
	public boolean P5 = false;
	public boolean P6 = false;
	public boolean P7 = false;
	public boolean P8 = false;
	public boolean P9 = false;

	// Триггеры
	public boolean T1 = false;
	public boolean T2 = false;

	CommonData() {

	};

	CommonData(CommonData forCopy) {
		this.RG1_8 = forCopy.RG1_8;
		this.RG2_9 = forCopy.RG2_9;
		this.RG4_18 = forCopy.RG4_18;
		this.SM1_A_18 = forCopy.SM1_A_18;
		this.SM1_B_18 = forCopy.SM1_B_18;
		this.SM1_S_18 = forCopy.SM1_S_18;
		this.MS1_A_10 = forCopy.MS1_A_10;
		this.MS1_B_10 = forCopy.MS1_B_10;
		this.MS1_S_10 = forCopy.MS1_S_10;
		this.Result = forCopy.Result;
		this.CT1 = forCopy.CT1;
		this.P0 = forCopy.P0;
		this.P1 = forCopy.P1;
		this.P2 = forCopy.P2;
		this.P3 = forCopy.P3;
		this.P4 = forCopy.P4;
		this.P5 = forCopy.P5;
		this.P6 = forCopy.P6;
		this.P7 = forCopy.P7;
		this.P8 = forCopy.P8;
		this.P9 = forCopy.P9;
		this.T1 = forCopy.T1;
		this.T2 = forCopy.T2;
	}


    // Дополнение числа 0, до нужного разряда
    static public String getBinaryString(int i, int NumBits) {
        String binaryPart = Integer.toBinaryString(i);
        String zeros = "";
        if (binaryPart.length() < NumBits ) {
            zeros = String.format("%1$0"+ (NumBits - binaryPart.length()) + "d", 0);
        }
        return zeros + binaryPart;
    }

    // Это впринципе не нужно, но пусть будет, если что-то нужно будет модифицировать
	// Циклический сдвиг влево
	static public String rol(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(sb.charAt(0));
        sb.deleteCharAt(0);
        return sb.toString();
    }

    // Циклический сдвиг вправо
    static public String ror(String s) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(s.length() - 1);
        sb.deleteCharAt(s.length() - 1);
        sb.insert(0, c);
        return sb.toString();
    }

	// Логический сдвиг влево
    static public String shl(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.append("0");
        sb.deleteCharAt(0);
        return sb.toString();
    }

	// Логический сдвиг вправо
    static public String shr(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(s.length() - 1);
        sb.insert(0, "0");
        return sb.toString();
    }


}