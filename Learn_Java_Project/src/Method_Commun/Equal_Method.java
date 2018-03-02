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
public class Equal_Method {

    private short lineNumber;
    private short prefix;
    private short areaCode;
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Equal_Method)) {
            return false;
        }
        Equal_Method pn = (Equal_Method) o;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

}
