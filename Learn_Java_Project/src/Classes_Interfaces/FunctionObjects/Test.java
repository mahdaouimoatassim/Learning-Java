/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces.FunctionObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author El Mouatassim Billah
 */
public class Test {
    
     public static void main(String[] args)
     { 
         
     /*
         Functions Objects
         */            
//     System.out.println(StringLengthComparator.INSTANCE.compare("ksdkj", "hj"));
     
//        String[] StringArray = new String[]{"dc","cd"};
//         Arrays.sort(StringArray, new Comparator<String>() {
//             public int compare(String s1, String s2) {
//                 return s1.length() - s2.length();
//             }
//         });
//     
         
         System.out.println(Host.STRING_LENGTH_COMPARATOR.compare("ksdkj", "hj"));
     }


}
