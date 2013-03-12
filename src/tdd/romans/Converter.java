package tdd.romans;


public class Converter {

	public static String toRoman(int numeral) {
		if (numeral <= 0 || numeral > 3000) {
			throw new NotAvailableValue();
		}
		
		int[] splittedNumber = split(numeral);
		
		StringBuilder sb = new StringBuilder();
		sb.append(functionM(splittedNumber[0]));
		sb.append(functionC(splittedNumber[1]));
		sb.append(functionX(splittedNumber[2]));
		sb.append(functionI(splittedNumber[3]));
		
		return sb.toString();
	}
	
	static String functionM(int m) {
		if (m == 1) {
			return "M";
		}
		return "";
	}
	
	static String functionC(int c) {
		if (c == 1) {
			return "C";
		} else if (c == 5) {
			return "D";
		}
		return "";
	}
	
	static String functionX(int x) {
		if (x == 1) {
			return "X";
		} else if (x == 5) {
			return "L";
		}
		return "";
	}
	
	static String functionI(int i) {
		StringBuilder sb = new StringBuilder();
		if (i > 0 && i <= 3) {
			for (int j = 0; j < i; ++j) {
				sb.append("I");
			}
		}
		if (i == 4) {
			sb.append("I");
		}
		if (i >= 4 && i <= 8) {
			sb.append("V");
		}
		if (i > 5 && i <= 8) {
			for (int j = 0; j < 3-(8-i); ++j) {
				sb.append("I");
			}
		}
		if (i == 9) {
			sb.append("IX");
		}
		return sb.toString();
	}
	
	static int[] split(int numeral) {
		int[] splittedValues = new int[4];

		String numeralAsStr = String.format("%04d", numeral);//Integer.toString(numeral);
		int current;
		for (int i = 0 ; i < 4; ++i) {
			current = Integer.valueOf(numeralAsStr.substring(i, i+1));
			splittedValues[i] = current > 0 && current < 10 ? current : 0;
		}
		
		return splittedValues;
	}
}
