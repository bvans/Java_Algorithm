package towardOffer;

public class PowerWithUnsignedExponent {
	
	public static void main(String[] args) throws Exception {
		System.out.println(power(1.2, 3));
	}

	public static double power(double base, int exponent) throws Exception {
		if(exponent < 0) {
			throw new Exception("指数只能为非负");
		}
		
		if (exponent == 0) {
			return 1d;
		}

		if (exponent == 1) {
			return base;
		}

		double result = power(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {
			result *= base;
		}

		return result;
	}
}
