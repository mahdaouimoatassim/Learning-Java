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
public final class ImmutableClass {
    
    private final double re;
    private final double im;

    public ImmutableClass(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public ImmutableClass add(ImmutableClass c) {
        return new ImmutableClass(re + c.re, im + c.im);
    }

    public ImmutableClass subtract(ImmutableClass c) {
        return new ImmutableClass(re - c.re, im - c.im);
    }

    public ImmutableClass multiply(ImmutableClass c) {
        return new ImmutableClass(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public ImmutableClass divide(ImmutableClass c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ImmutableClass((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ImmutableClass)) {
            return false;
        }
        ImmutableClass c = (ImmutableClass) o;
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
