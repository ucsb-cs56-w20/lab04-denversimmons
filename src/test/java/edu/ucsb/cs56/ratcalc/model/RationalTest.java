package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1;

    @Before
    public void setUp() {
        r_5_15 = new Rational(5, 15);
        r_24_6 = new Rational(24, 6);
        r_3_7 = new Rational(3, 7);
        r_13_4 = new Rational(13, 4);
        r_20_25 = new Rational(20, 25);
        r_0_1 = new Rational(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
        Rational r = new Rational(1, 0);
    }

    @Test
    public void test_getNumerator_20_25() {
        assertEquals(4, r_20_25.getNumerator());
    }

    @Test
    public void test_getNumerator_13_4() {
        assertEquals(13, r_13_4.getNumerator());
    }

    @Test
    public void test_getDenominator_20_25() {
        assertEquals(5, r_20_25.getDenominator());
    }

    @Test
    public void test_getDenominator_13_4() {
        assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
        assertEquals("1/3", r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
        assertEquals("4", r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
        assertEquals("3/7", r_3_7.toString());
    }

    @Test
    public void test_toString_20_25() {
        assertEquals("4/5", r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
        assertEquals("0", r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
        assertEquals(5, Rational.gcd(5, 15));
    }

    @Test
    public void test_gcd_15_5() {
        assertEquals(5, Rational.gcd(15, 5));
    }

    @Test
    public void test_gcd_24_6() {
        assertEquals(6, Rational.gcd(24, 6));
    }

    @Test
    public void test_gcd_17_5() {
        assertEquals(1, Rational.gcd(17, 5));
    }

    @Test
    public void test_gcd_1_1() {
        assertEquals(1, Rational.gcd(1, 1));
    }

    @Test
    public void test_gcd_20_25() {
        assertEquals(5, Rational.gcd(20, 25));
    }

    @Test
    public void test_rational_m10_m5() {
        Rational r = new Rational(-10, -5);
        assertEquals("2", r.toString());
    }

    @Test
    public void test_rational_m5_6() {
        Rational r = new Rational(-5, 6);
        assertEquals("-5/6", r.toString());
    }

    @Test
    public void test_rational_7_m8() {
        Rational r = new Rational(7, -8);
        assertEquals("-7/8", r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
        Rational r = r_5_15.times(r_3_7);
        assertEquals("1/7", r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
        Rational r = r_3_7.times(r_13_4);
        assertEquals("39/28", r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
        Rational r_m3_1 = new Rational(-3, 1);
        Rational r_1_m3 = new Rational(1, -3);
        Rational r = r_m3_1.times(r_1_m3);
        assertEquals("1", r.toString());
    }

    @Test
    public void test_product_of_r_5_15_and_r_3_7() {
        Rational r = Rational.product(r_5_15, r_3_7);
        assertEquals("1/7", r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
        Rational r = Rational.product(r_3_7, r_13_4);
        assertEquals("39/28", r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3, 1);
        Rational r_1_m3 = new Rational(1, -3);
        Rational r = Rational.product(r_m3_1, r_1_m3);
        assertEquals("1", r.toString());
    }

    @Test
    public void test_rational_m3_n7(){
	Rational r = new Rational(3, -7);
	assertEquals("-3/7", r.toString());
    }

    @Test
    public void test_rational_mn3_7(){
        Rational r = new Rational(-3, 7);
        assertEquals("-3/7", r.toString());
    }

    @Test
    public void test_rational_mn3_n7(){
        Rational r = new Rational(-3, -7);
        assertEquals("3/7", r.toString());
    }

    @Test
    public void test_lcm_3_7(){
	assertEquals(21, Rational.lcm(3,7));
    }

    @Test
    public void test_lcm_n3_1()
    {
	assertEquals(-3, Rational.lcm(-3,1));
    }

    @Test
    public void test_lcm_0_1()
    {
	assertEquals(0, Rational.lcm(0,1));
    }

    @Test
    public void test_lcm_9_3()
    {
	assertEquals(9, Rational.lcm(9,3));
    }

    @Test
    public void test_plus_n3_7_m1_9()
    {
	Rational n = new Rational(3,7);
	Rational m = new Rational(1,9);
	Rational r = n.plus(m);
	assertEquals("34/63", r.toString());
    }

    @Test
    public void test_plus_nn4_5_m2_3()
    {
        Rational n = new Rational(-4,5);
        Rational m = new Rational(2,3);
        Rational r = n.plus(m);
        assertEquals("-2/15", r.toString());
    }

    @Test
    public void test_plus_n0_7_m1_9()
    {
        Rational n = new Rational(0,7);
        Rational m = new Rational(1,9);
        Rational r = n.plus(m);
        assertEquals("1/9", r.toString());
    }

    @Test
    public void test_plus_nn3_7_mn1_9()
    {
        Rational n = new Rational(-3,7);
        Rational m = new Rational(-1,9);
        Rational r = n.plus(m);
        assertEquals("-34/63", r.toString());
    }

    @Test
    public void test_sum_n3_7_m1_9()
    {
        Rational n = new Rational(3,7);
        Rational m = new Rational(1,9);
        Rational r = Rational.sum(n,m);
        assertEquals("34/63", r.toString());
    }

    @Test
    public void test_sum_nn4_5_m2_3()
    {
        Rational n = new Rational(-4,5);
        Rational m = new Rational(2,3);
        Rational r = Rational.sum(n,m);
        assertEquals("-2/15", r.toString());
    }

    @Test
    public void test_sum_n0_7_m1_9()
    {
        Rational n = new Rational(-0,7);
        Rational m = new Rational(1,9);
        Rational r = Rational.sum(n,m);
        assertEquals("1/9", r.toString());
    }

    @Test
    public void test_sum_nn3_7_mn1_9()
    {
        Rational n = new Rational(-3,7);
        Rational m = new Rational(-1,9);
        Rational r = Rational.sum(n,m);
        assertEquals("-34/63", r.toString());
    }

    @Test
    public void test_minus_n3_7_m1_9()
    {
        Rational n = new Rational(3,7);
        Rational m = new Rational(1,9);
        Rational r = n.minus(m);
        assertEquals("20/63", r.toString());
    }

    @Test
    public void test_minus_nn4_5_m2_3()
    {
        Rational n = new Rational(-4,5);
        Rational m = new Rational(2,3);
        Rational r = n.minus(m);
        assertEquals("-22/15", r.toString());
    }

    @Test
    public void test_minus_n0_7_m1_9()
    {
        Rational n = new Rational(-0,7);
        Rational m = new Rational(1,9);
        Rational r = n.minus(m);
        assertEquals("-1/9", r.toString());
    }

    @Test
    public void test_minus_nn3_7_mn1_9()
    {
        Rational n = new Rational(-3,7);
        Rational m = new Rational(-1,9);
        Rational r = n.minus(m);
        assertEquals("-20/63", r.toString());
    }
     @Test
    public void test_difference_n3_7_m1_9()
    {
        Rational n = new Rational(3,7);
        Rational m = new Rational(1,9);
        Rational r = Rational.difference(n,m);
        assertEquals("20/63", r.toString());
    }

    @Test
    public void test_difference_nn4_5_m2_3()
    {
        Rational n = new Rational(-4,5);
        Rational m = new Rational(2,3);
        Rational r = Rational.difference(n,m);
        assertEquals("-22/15", r.toString());
    }

    @Test
    public void test_difference__n0_7_m1_9()
    {
        Rational n = new Rational(-0,7);
        Rational m = new Rational(1,9);
        Rational r = Rational.difference(n,m);
        assertEquals("-1/9", r.toString());
    }

    @Test
    public void test_diference__nn3_7_mn1_9()
    {
        Rational n = new Rational(-3,7);
        Rational m = new Rational(-1,9);
        Rational r = Rational.difference(n,m);
        assertEquals("-20/63", r.toString());
    }

    @Test
    public void test_reciprocalOf_n1_5()
    {
	Rational n = new Rational(1,5);
	assertEquals("5", n.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocalOf_nn3_8()
    {
        Rational n = new Rational(-3,8);
        assertEquals("-8/3", n.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocalOf_nn9_nn5()
    {
        Rational n = new Rational(-9,-5);
        assertEquals("5/9", n.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocalOf_n1_nn5()
    {
        Rational n = new Rational(1,-5);
        assertEquals("-5", n.reciprocalOf().toString());
    }

    @Test
    public void test_dividedBy_nn3_7_mn1_9()
    {
        Rational n = new Rational(-3,7);
        Rational m = new Rational(-1,9);
        Rational r = n.dividedBy(m);
        assertEquals("27/7", r.toString());
    }

    @Test
    public void test_dividedBy_n5_9_mn1_3()
    {
        Rational n = new Rational(5,9);
        Rational m = new Rational(-1,3);
        Rational r = n.dividedBy(m);
        assertEquals("-5/3", r.toString());
    }

    @Test
    public void test_dividedBy_n_0_7_mn1_9()
    {
        Rational n = new Rational(0,7);
        Rational m = new Rational(1,-9);
        Rational r = n.dividedBy(m);
        assertEquals("0", r.toString());
    }

    @Test
    public void test_dividedBy_n_6_n7_mn1_9()
    {
        Rational n = new Rational(6,-7);
        Rational m = new Rational(-1,9);
        Rational r = n.dividedBy(m);
        assertEquals("54/7", r.toString());
    }

    @Test
    public void test_quotient_nn3_7_mn1_9()
    {
        Rational n = new Rational(-3,7);
        Rational m = new Rational(-1,9);
        Rational r = Rational.quotient(n,m);
        assertEquals("27/7", r.toString());
    }

    @Test
    public void test_quotient_n5_9_mn1_3()
    {
        Rational n = new Rational(5,9);
        Rational m = new Rational(-1,3);
        Rational r = Rational.quotient(n,m);
        assertEquals("-5/3", r.toString());
    }

    @Test
    public void test_quotient_n_0_7_mn1_9()
    {
        Rational n = new Rational(0,7);
        Rational m = new Rational(1,-9);
        Rational r = Rational.quotient(n,m);
        assertEquals("0", r.toString());
    }

    @Test
    public void test_quotient_n_6_n7_mn1_9()
    {
        Rational n = new Rational(6,-7);
        Rational m = new Rational(-1,9);
        Rational r = Rational.quotient(n,m);
        assertEquals("54/7", r.toString());
    }

}
