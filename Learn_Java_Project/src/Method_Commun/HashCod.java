/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method_Commun;

/**
 *
 * @author El Mouatassim Billah
 */
public class HashCod {

    private boolean B = true;
    private char C='M';
    private short S = 12;
    private byte b = 12;
    private long L = 1234564798;
    private float F=0.21f;
    private volatile int hashcodee;
    private Boolean immutable; 
    /**
     *
     * @return
     */
    
    
    
   
    
    @Override 
    public boolean equals(Object o)
    {
    return true;
    }
    
    
     @Override 
     public int hashCode() 
            {
                
                int result;
                
                if ( (getImmutable() && getHashcodee()==0) || !getImmutable() )
                {
                result=17;
                
                result = result*31+ (this.isB() ? 1 : 0);
                result = result*31+(int) this.getC();
                result = result*31+(int) this.getS();
                result = result*31+(int) this.getB() ;
                result = result*31+(int) (this.getL()^(this.getL()>>>16));
                result = result*31+ Float.floatToIntBits(getF());
                }
                else {
                    result=getHashcodee();
                }
                
            return result;
            }

     @Override public String toString()
     {
         String Object_Affichage;
     
          Object_Affichage=String.format(" ( %03d + %03d)", S,C);
         
     return Object_Affichage;
     }
     
    /**
     * @return the B
     */
    public boolean isB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(boolean B) {
        this.B = B;
    }

    /**
     * @return the C
     */
    public char getC() {
        return C;
    }

    /**
     * @param C the C to set
     */
    public void setC(char C) {
        this.C = C;
    }

    /**
     * @return the S
     */
    public short getS() {
        return S;
    }

    /**
     * @param S the S to set
     */
    public void setS(short S) {
        this.S = S;
    }

    /**
     * @return the b
     */
    public byte getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(byte b) {
        this.b = b;
    }

    /**
     * @return the L
     */
    public long getL() {
        return L;
    }

    /**
     * @param L the L to set
     */
    public void setL(long L) {
        this.L = L;
    }

    /**
     * @return the F
     */
    public float getF() {
        return F;
    }

    /**
     * @param F the F to set
     */
    public void setF(float F) {
        this.F = F;
    }

    /**
     * @return the hashcodee
     */
    public int getHashcodee() {
        return hashcodee;
    }

    /**
     * @param hashcodee the hashcodee to set
     */
    public void setHashcodee(int hashcodee) {
        this.hashcodee = hashcodee;
    }

    /**
     * @return the immutable
     */
    public Boolean getImmutable() {
        return immutable;
    }

    /**
     * @param immutable the immutable to set
     */
    public void setImmutable(Boolean immutable) {
        this.immutable = immutable;
    }
  
    
}
