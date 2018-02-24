/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creating_Destroying_Objects;

/**
 *
 * @author El Mouatassim Billah
 */
public class Test {
    
    private Test()
    {};
    
   
    public static void main (String[] args)
    {
  Static_Factory_Method mes_information=Static_Factory_Method.GetInstance();
        System.out.println(mes_information.getnom());
        System.out.println(mes_information.getprenom());
        
       
    }
    
}
