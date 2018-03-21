/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces;

/**
 *
 * @author El Mouatassim Billah
 */
public final class ComplexImmutableClass {
    
    private final double re;
    private final double im;

    public static final ComplexImmutableClass ZERO = new ComplexImmutableClass(0, 0);
    public static final ComplexImmutableClass ONE = new ComplexImmutableClass(1, 0);
    public static final ComplexImmutableClass I = new ComplexImmutableClass(0, 1);
    
    private ComplexImmutableClass(double re, double im) {
        this.re = re;
        this.im = im;
    }
     public static ComplexImmutableClass valueOf(double re, double im) {
        return new ComplexImmutableClass( re, im);
    }
    public static ComplexImmutableClass valueOfPolar(double r, double theta) {
        return new ComplexImmutableClass(r * Math.cos(theta),
                r * Math.sin(theta));
    }
    public static  ComplexImmutableClass zero()
    {
    return ZERO;
    }
    public static  ComplexImmutableClass One()
    {
    return ONE;
    }
    public static  ComplexImmutableClass I()
    {
    return I;
    }
    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public ComplexImmutableClass add(ComplexImmutableClass c) {
        return new ComplexImmutableClass(re + c.re, im + c.im);
    }

    public ComplexImmutableClass subtract(ComplexImmutableClass c) {
        return new ComplexImmutableClass(re - c.re, im - c.im);
    }

    public ComplexImmutableClass multiply(ComplexImmutableClass c) {
        return new ComplexImmutableClass(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public ComplexImmutableClass divide(ComplexImmutableClass c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ComplexImmutableClass((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ComplexImmutableClass)) {
            return false;
        }
        ComplexImmutableClass c = (ComplexImmutableClass) o;
// See page 43 to find out why we use compare instead of ==
        return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(re);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
