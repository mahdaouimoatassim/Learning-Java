/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

/**
 *
 * @author El Mouatassim Billah
 */
public class RawType_Stamp {
    
    private final String Name;
    private final String Description; 

    
    /**
     * Public Constructor with name and description parameter
     * 
     * 
    */
    public RawType_Stamp(String Name,String Description)  
    {
    this.Name=Name;
    this.Description=Description;
    }
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
     /*   this.Name = Name;*/
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
      /*  this.Description = Description;*/
    }
    
    
}
