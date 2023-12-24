//Kuvaev Maksim(2020a)
//11a(Factorial)
//111219
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NewNumber {
	static final int base = 10;
	static final int lbase = 1;
	static Number h;
	static Number l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		long m = 1;
		h = new Number(sc.next());
		l = new Number(sc.next());
//		for(int i = 1;i<n+1;i++) {
//			m = m*i;
//			if (m*(i+1)>Integer.MAX_VALUE) {
//				h.equals(h.multyDigit(m));
//				m = 1;
//				h.normilize();
//			}
//		}
//		long t  = System.currentTimeMillis();
//		h.normilize();
		PrintWriter out = new PrintWriter(System.out);
//		for (int i = 1000000000-100000000;i<Integer.MAX_VALUE;i++) {
//			for (int j = 100000000-100000000;j<Integer.MAX_VALUE;j++) {
//				Number t = new Number(i);
//				Number v = new Number(j);
//				System.out.println("+");
//				if (Long.parseLong(t.minus(v).toString())!=i-j) {
//					System.out.println(i+" "+j);
//					System.exit(0);
//				}
//			}
//		}
		out.println(h.minus(l));
		out.flush();
		out.close();

	}

//	public static Number pow(long n) {
//		Number newNumber = new Number("");
//		if (n == 0) {
//			newNumber.digits.add((long) 1);
//			return newNumber;
//		}
//		if (n == 1) {
//			newNumber.digits.add((long) 2);
//			return newNumber;
//		}
//		newNumber.digits.addAll(pow(n / 2).multy(pow(n / 2)).multyDigit(n % 2 + 1).digits);
//		return newNumber;
//	}

}

class Number {
	ArrayList<Long> digits = new ArrayList<>();

	Number(long n) {
		while (n >= NewNumber.base) {
			digits.add((n % NewNumber.base));
			n = n / NewNumber.base;
		}
		digits.add(n);
	}

	Number(String num) {
		while (num.length() >= NewNumber.lbase) {
			digits.add(Long.parseLong(num.substring(num.length() - NewNumber.lbase)));
			num = num.substring(0, num.length() - NewNumber.lbase);
		}
		if (num.length() > 0) {
			digits.add(Long.parseLong(num));
		}
	}

	public void normilize() {
		while (digits.get(digits.size() - 1) == 0) {
			digits.remove(digits.size() - 1);
			if (digits.size() == 0) {
				digits.add((long) 0);
				break;
			}
		}
//		for (int i = digits.size()-1;i>=0;i--) {
//			System.out.println(digits.get(i));
//		}
		for (int i = 0; i < digits.size(); i++) {
			if (Math.abs(digits.get(i)) >= NewNumber.base) {
				long digit = digits.get(i);
				digits.set(i, (digit % NewNumber.base));
				if (i == digits.size() - 1) {
					digits.add((long) 0);
				}
				digits.set(i + 1, (digit / NewNumber.base + digits.get(i + 1)));
			}
		}
		while (digits.get(digits.size() - 1) == 0) {
			digits.remove(digits.size() - 1);
			if (digits.size() == 0) {
				digits.add((long) 0);
				break;
			}
		}
		if (digits.get(digits.size() - 1) > 0) {
			for (int i = 0; i < digits.size(); i++) {
				if (digits.get(i) < 0) {
					long digit = digits.get(i);
					digits.set(i, (digit +NewNumber.base));
					digits.set(i + 1, (digits.get(i + 1) -1));
				}
			}
		} else if (digits.get(digits.size() - 1) < 0) {
			for (int i = 0; i < digits.size(); i++) {
				if (digits.get(i) > 0) {
					long digit = digits.get(i);
					digits.set(i, (digit - NewNumber.base));
					digits.set(i + 1, (digits.get(i + 1) + 1));
				}
			}
		}
		while (digits.get(digits.size() - 1) == 0) {
			digits.remove(digits.size() - 1);
			if (digits.size() == 0) {
				digits.add((long) 0);
				break;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = digits.size() - 1; i >= 0; i--) {
			if (i != digits.size() - 1) {
				sb.append(returnDigit(i));
			} else {
				sb.append(digits.get(i));
			}
		}
		return sb.toString();
	}

	public Number sum(Number that) {
		Number newNumber = new Number("");
		for (int i = 0; i < Math.max(digits.size(), that.digits.size()); i++) {
			newNumber.digits.add(getDigit(i) + that.getDigit(i));
		}
		return newNumber;
	}

	public Number minus(Number that) {
		Number newNumber = new Number("");
		for (int i = 0; i < Math.max(digits.size(), that.digits.size()); i++) {
			newNumber.digits.add(getDigit(i) - that.getDigit(i));
		}
		newNumber.normilize();
		return newNumber;
	}

	public Number multy(Number that) {
		Number newNumber1 = new Number("");
		Number newNumber2 = new Number("");
		Number A = new Number("");
		Number B = new Number("");
		Number C = new Number("");
		normilize();
		that.normilize();
		if (digits.size() == 1) {
			return that.multyDigit(digits.get(0));
		}
		if (that.digits.size() == 1) {
			return multyDigit(that.digits.get(0));
		}
		int n = (Math.max(digits.size(), that.digits.size()) - 1) / 2 * 2 + 2;
		newNumber1.digits.addAll(addNulls(n - digits.size()).digits);
		newNumber2.digits.addAll(that.addNulls(n - that.digits.size()).digits);
		A.digits.addAll(newNumber1.leftDigits(n / 2).multy(newNumber2.leftDigits(n / 2)).digits);
		C.digits.addAll(newNumber1.rightDigits(n / 2).multy(newNumber2.rightDigits(n / 2)).digits);
		B.digits.addAll((newNumber1.leftDigits(n / 2).sum(newNumber1.rightDigits(n / 2)))
				.multy((newNumber2.leftDigits(n / 2)).sum(newNumber2.rightDigits(n / 2))).digits);
		A.normilize();
		B.normilize();
		C.normilize();
		return A.addNulesRight(n)
				.sum(B.minus(A).minus(C).addNulesRight(n / 2).sum(C));
	}

	public Number division(Number that) {
		Number newNumber = new Number("0");
		Number answer = new Number("0");
		for (int i = digits.size() - 1; i >= 0; i--) {
			newNumber.digits.set(0, digits.get(i));
			int left = 0;
			int right = NewNumber.base;
			if (newNumber.compare(that) < 0) {
				answer.equals(answer.addNulesRight(1));
				answer.digits.set(0, (long) 0);
			} else if (newNumber.compare(that) == 0) {
				answer.equals(answer.addNulesRight(1));
				answer.digits.set(0, (long) 1);
				left = 1;
			} else {
				while (right - left > 1) {
					int n = (right + left) / 2;
					if (that.multyDigit(n).compare(newNumber) == 1) {
						right = n;
					} else if (that.multyDigit(n).compare(newNumber) == -1) {
						left = n;
					} else {
						left = n;
						break;
					}
				}
				answer.equals(answer.addNulesRight(1));
				answer.digits.set(0, (long) left);
			}
			newNumber.equals(newNumber.minus(that.multyDigit(left)));
			newNumber.equals(newNumber.addNulesRight(1));
		}
		answer.normilize();
		return answer;

	}
	public Number mod(Number that) {
		Number newNumber = new Number("0");
		Number answer = new Number("0");
		for (int i = digits.size() - 1; i >= 0; i--) {
			newNumber.equals(newNumber.addNulesRight(1));
			newNumber.digits.set(0, digits.get(i));
			int left = 0;
			int right = NewNumber.base;
			if (newNumber.compare(that) < 0) {
				answer.equals(answer.addNulesRight(1));
				answer.digits.set(0, (long) 0);
			} else if (newNumber.compare(that) == 0) {
				answer.equals(answer.addNulesRight(1));
				answer.digits.set(0, (long) 1);
				left = 1;
			} else {
				while (right - left > 1) {
					int n = (right + left) / 2;
					if (that.multyDigit(n).compare(newNumber) == 1) {
						right = n;
					} else if (that.multyDigit(n).compare(newNumber) == -1) {
						left = n;
					} else {
						left = n;
						break;
					}
				}
				answer.equals(answer.addNulesRight(1));
				answer.digits.set(0, (long) left);
			}
			newNumber.equals(newNumber.minus(that.multyDigit(left)));
		}
		newNumber.normilize();
		return newNumber;

	}

	public Number leftDigits(int l) {
		Number newNumber = new Number("");
		for (int i = digits.size() - l; i < digits.size(); i++) {
			newNumber.digits.add(digits.get(i));
		}
		return newNumber;
	}

	public Number addNulls(int k) {
		Number newNumber = new Number("");
		newNumber.digits.addAll(digits);
		for (int i = 0; i < k; i++) {
			newNumber.digits.add((long) 0);
		}
		return newNumber;
	}

	public Number addNulesRight(int k) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString());
		for (int i = 0; i < k*NewNumber.lbase; i++) {
			sb.append(0);
		}
		Number newNumber = new Number(sb.toString());
		return newNumber;
	}

	public Number rightDigits(int l) {
		Number newNumber = new Number("");
		for (int i = 0; i < l; i++) {
			newNumber.digits.add(digits.get(i));
		}
		return newNumber;
	}

	public Number multyDigit(long digit) {
		Number newNumber = new Number("");
		for (int i = 0; i < digits.size(); i++) {
			newNumber.digits.add(digits.get(i) * digit);
		}
		return newNumber;
	}

	public int compare(Number that) {
		normilize();
		that.normilize();
		if (digits.size() > that.digits.size()) {
			return 1;
		} else if (digits.size() < that.digits.size()) {
			return -1;
		} else {
			int counter = digits.size() - 1;
			while (counter >= 0) {
				if (digits.get(counter) > that.digits.get(counter)) {
					return 1;
				} else if (digits.get(counter) < that.digits.get(counter)) {
					return -1;
				}
				counter--;
			}
		}
		return 0;
	}

	public void equals(Number that) {
		for (int i = 0; i < Math.max(digits.size(), that.digits.size()); i++) {
			if (i < digits.size()) {
				digits.set(i, that.getDigit(i));
			} else {
				digits.add(that.getDigit(i));
			}
		}
		
	}

	public long getDigit(int i) {
		if (digits.size() > i) {
			return digits.get(i);
		}
		return 0;
	}

	public String returnDigit(int i) {
		String str2 = "";
		str2 += Math.abs(digits.get(i));
		if (str2.length() < NewNumber.lbase) {
			String str = "";
			for (int j = 0; j < NewNumber.lbase - str2.length(); j++) {
				str += "0";
			}
			str += Math.abs(digits.get(i));
			return str;
		}

		return str2;
	}
}