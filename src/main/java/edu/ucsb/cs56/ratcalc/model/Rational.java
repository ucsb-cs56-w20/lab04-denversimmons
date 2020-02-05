
/**
 * A class to represent a rational number with a numerator and denominator
 *
 * @author P. Conrad for CS56 F16
 *
 */

package edu.ucsb.cs56.ratcalc.model;

public class Rational {

    private int num;
    private int denom;

    /**
     * greatest common divisor of a and b
     *
     * @param a first number
     * @param b second number
     * @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else
            return gcd(b % a, a);
    }
    public static int lcm(int a, int b){
	int max = 0;
	int negative = 0;
	if(a == 0 || b == 0){
	    return 0;
	}
	if(a * b < 0){
	    negative = 1;
	}
	if(a < 0 && b < 0){
	    a *= -1;
	    b *= -1;
	}
	if(a > b){
	    max = a;
	}
	else{
	    max = b;
	}
	while(true){
	    if(max%a == 0 && max%b == 0){
		if(negative == 1){
		    max *= -1;
		}
		return max;
	    }
	    else{
		max++;
	    }
	}
    }
    public Rational() {
        this.num = 1;
        this.denom = 1;
    }

    public Rational(int num, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("denominator may not be zero");
        }
        this.num = num;
        this.denom = denom;
        if (num != 0) {
            int gcd = Rational.gcd(num, denom);
            this.num /= gcd;
            this.denom /= gcd;
        }
    }

    public String toString() {
        if (denom == 1 || num == 0)
            return "" + num;
        if(denom < 0)
	{
	    denom *= -1;
	    num *= -1;
	}
        return num + "/" + denom;
    }

    public int getNumerator() {
        return this.num;
    }

    public int getDenominator() {
        return this.denom;
    }

    public Rational times(Rational r) {
        return new Rational(this.num * r.num, this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
        return new Rational(a.num * b.num, a.denom * b.denom);
    }

    public Rational plus(Rational r){
	return Rational.sum(this, r);
    }

    public static Rational sum(Rational a, Rational b){
	int aNeg = 0;
	int bNeg = 0;
	int aNum = a.num;
	int aDenom = a.denom;
	int bNum = b.num;
	int bDenom = b.denom;
	if(aNum < 0 && a.denom < 0)
        {
            aNum *= -1;
            aDenom *= -1;
        }
	if(aNum < 0 && aDenom > 0)
	{
	    aNum *= -1;
	    aNeg = 1;    
	}
	if(aDenom < 0 && aNum > 0)
	{
	    aDenom *= -1;
	    aNeg = 1;
	}
	if(bNum < 0 && bDenom < 0)
        {
            bNum *= -1;
            bDenom *= -1;
        }
	if(bNum < 0 && bDenom > 0)
	{
	    bNum *= -1;
	    bNeg = 1;
	}
	if(bDenom < 0 && bNum > 0)
	{
	    bDenom *= -1;
	    bNeg = 1;
	}
	int denom = Rational.lcm(aDenom, bDenom);
	if(denom < 0)
	{
	    denom *= -1;
	}
	aNum *=(denom / aDenom);
	bNum *=(denom / bDenom);
	int num = aNum + (aNum * -2 * aNeg) + bNum + (bNum * -2 * bNeg);
	int gcd = Rational.gcd(num, denom);
	if(gcd < 0)
	{
	    gcd *= -1;
	}
	Rational f = new Rational(num / gcd, denom / gcd);
	return f;
    }
    
    public Rational minus(Rational r){
	return Rational.difference(this, r);
    }

    public static Rational difference(Rational a, Rational b){
	Rational minusOne = new Rational(-1,1);
	return Rational.sum(a, Rational.product(minusOne, b));
    }

    public Rational reciprocalOf(){
	if(this.getNumerator() == 0){
	 throw new ArithmeticException("denominator may not be zero");   
	}
	return new Rational(this.denom, this.num);
    }

    public Rational dividedBy(Rational r){
	return Rational.quotient(this, r);
    }

    public static Rational quotient(Rational a, Rational b){
	return Rational.product(a,b.reciprocalOf());
    }

    /**
     * For testing getters.
     *
     * @param args unused
     */

    public static void main(String[] args) {
        Rational r = new Rational(5, 7);
        System.out.println("r.getNumerator()=" + r.getNumerator());
        System.out.println("r.getDenominator()=" + r.getDenominator());
    }
}
