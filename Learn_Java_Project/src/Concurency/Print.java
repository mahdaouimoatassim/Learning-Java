/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;

/**
 *
 * @author El Mouatassim Billah
 */
public class Print {
    
   private String Texte="Helle";
   private volatile int time=0;
   private volatile int conteur=0;
    
    public synchronized int gettime()
    {
    return this.time;
    }
    public synchronized void settime(int time)
    {
    this.time=time;
    }
     public synchronized int getconteur()
    {
    return this.conteur;
    }
    public synchronized void setconteur(int conteur)
    {
    this.conteur=conteur;
    }
    public synchronized String getTexte()
    {
    return this.Texte;
    }
    public synchronized void SetTexte(String texte)
    {
    this.Texte=texte;
    }
}
