//John
//did not finish, could not get past the case where the exponent input was larger than 999999999
//tried to get around the brute force fib by using the formula from the ICPC book, but ran into problems with BigDecimal.pow(int exp), where the exp function only supported int arguments up to 999999999
//worked up to 6th test case


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class ProblemC {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		while(sc.hasNext())
		{
			int k = sc.nextInt();
			String y = sc.next();
			
			BigInteger years = new BigInteger(y);
			
			System.out.println(k + " " + (fib(new BigInteger(y))).mod(new BigInteger("1000000000")).intValue());
		}
	}
	
	
	public static BigInteger fib(BigInteger n)
	{
		//BigDecimal ret = (new BigDecimal("1")).divide(new BigDecimal(Math.sqrt(5)), 32, RoundingMode.HALF_UP).multiply( ((new BigDecimal(1.0 + Math.sqrt(5)).divide(new BigDecimal(2.0), 32, RoundingMode.HALF_UP).pow(n.intValue())).subtract((new BigDecimal(1.0 - Math.sqrt(5)).divide(new BigDecimal(2.0), 16, RoundingMode.HALF_UP)).pow(n.intValue())) ));
		BigDecimal first = (new BigDecimal("1")).divide(new BigDecimal(Math.sqrt(5)), 32, RoundingMode.HALF_UP);
		BigDecimal plus = ((new BigDecimal(1.0 + Math.sqrt(5)).divide(new BigDecimal(2.0), 32, RoundingMode.HALF_UP)));
		BigDecimal minus = ((new BigDecimal(1.0 - Math.sqrt(5)).divide(new BigDecimal(2.0), 32, RoundingMode.HALF_UP)));
		BigDecimal plusn, minusn;
		try	{
			plusn = plus.pow(n.intValue());
		}	catch(Exception e)	{
			long exp = n.longValue();
			/*long newexp = exp / 2;
			long newexp2 = exp / 2;
			if(exp % 2 == 1)	{
				newexp2++;
			}//*/
//			plusn = plus.pow((int)newexp);
//			plusn = plusn.pow((int)newexp2);
			
			long newexpp = exp / 999999999l;
			long div = (long)Math.ceil(newexpp);
			
			
			plusn = plus;
			for(long a = 0; a < div; a++)	{
				plusn = plusn.pow((int)999999999);
			}
			
			
				/*
			long exp = n.longValue();
			plusn = plus;
			for(long i = 0; i < exp; i++)	{
				plusn = plusn.multiply(plus);
			}
			
			//*/
		}
		try	{
			minusn = minus.pow(n.intValue());
		}	catch(Exception e)	{
			long exp = n.longValue();
//			long newexp = exp / 2;
//			long newexp2 = exp / 2;
//			if(exp % 2 == 1)	{
//				newexp2++;
//			}
//			minusn = minus.pow((int)newexp);
//			minusn = minusn.pow((int)newexp2);
				/*
			long exp = n.longValue();
			minusn = minus;
			for(long i = 0; i < exp; i++)	{
				minusn = minusn.multiply(plus);
			}
			//*/
			
			long newexpp = exp / 999999999l;
			long div = (long)Math.ceil(newexpp);
			
			
			minusn = minus;
			for(long a = 0; a < div; a++)	{
				minusn = minusn.pow((int)999999999);
			}
		}
		BigDecimal ret = first.multiply(plusn.subtract(minusn));
		
		//double ret = (1.0 / Math.sqrt(5)) * (Math.pow(((1.0 + Math.sqrt(5)) / 2.0), n) - Math.pow(((1.0 - Math.sqrt(5)) / 2.0), n));
		
		
//		System.out.println("ret = " + ret.toString());
//		System.out.println("ret.round = " + ret.setScale(0, RoundingMode.HALF_UP));
		return ret.setScale(0, RoundingMode.HALF_UP).toBigInteger();//ret.round(new MathContext(0, RoundingMode.HALF_UP)).toBigInteger();
	}
}
