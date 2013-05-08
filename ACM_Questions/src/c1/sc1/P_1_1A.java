package c1.sc1;

import utils.CommonMultiple;
import utils.FractionForAdd;
import utils.FractionRightVersion;


/**
 * 一共有n种不同的coupons，每种coupons的概率相同。问期望多少次可以得到n种coupons，以带分数形式输出。
 *  1<=n<=33
 *  
 *  
 *  难点  long型内存溢出，-》1.乘法提出.2.分子去除整数部分
 *       分数约分问题
 * @author jimmy
 *
 *
 */
public class P_1_1A {
	
	
	public P_1_1A(long couponStyleNumber){
		this.couponStyleNumber = couponStyleNumber;
	}
	
	private long couponStyleNumber =20; 
	
	FractionRightVersion getExpectedNextCouponStepLength(long noNeedStyleNumber) throws Exception{
		if(couponStyleNumber-noNeedStyleNumber==0){
			throw new Exception("The denominator of the fraction cannot be zero!");
		}
		return new FractionRightVersion(couponStyleNumber,couponStyleNumber-noNeedStyleNumber);
	}
	
	String memoryproblemversion_calExpetionForAllStepsForSelection0() throws Exception{
		FractionRightVersion result = new FractionRightVersion(0,1);
		for(long i=0;i<couponStyleNumber;i++){
//			System.out.print(i+"-"+getExpectedNextCouponStepLength(i)+":");
			System.out.print(i+":");
			result = result.add(getExpectedNextCouponStepLength(i));
			System.out.println(result.toString());
		}
		
		return result.toString();
	}
	
	//--------------------------------------------------------------------------------------------------
	String calExpetionForAllStepsForSelection1() throws Exception{
		FractionForAdd result = new FractionForAdd(0,1,0);

		for(long i=0;i<couponStyleNumber;i++){
//			System.out.print(i+"-"+getExpectedNextCouponStepLength(i)+":");
			System.out.print(i+":");
			result = result.add(new FractionForAdd(1,couponStyleNumber-i,0));
			System.out.println(result.toString());
		}

		result = result.multiply(couponStyleNumber);
		return result.toString();
	}
	
	
	String memoryproblemversion_calExpetionForAllStepsForSelection2() throws Exception{
		long denominator=1;
		for(long i=2;i<couponStyleNumber;i++){
			denominator = CommonMultiple.getMinCommonMultiple(i, denominator);
		}
		long numerator=0;

		for(long i=1;i<=couponStyleNumber;i++){
			long temp = denominator/i;
			System.out.println(i+"-"+temp);
			numerator+= temp;
		}

		return numerator+"/"+denominator;

	}
	
	
	public static void main(String[] args) throws Exception{

		System.out.println(Long.MAX_VALUE + ":"+Long.MIN_VALUE);
		
		P_1_1A p1= new P_1_1A(33);


		
		//正确版本
		System.out.println("finalResult:"+p1.calExpetionForAllStepsForSelection1());

		
//		System.out.println("finalResult:"+p1.memoryproblemversion_calExpetionForAllStepsForSelection0());
//		System.out.println("finalResult:"+p1.memoryproblemversion_calExpetionForAllStepsForSelection2());
	}
	
	
	
}