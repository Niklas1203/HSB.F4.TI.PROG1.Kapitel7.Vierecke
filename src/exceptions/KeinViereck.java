/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author nikla
 */
public class KeinViereck extends IllegalArgumentException
{
    private String err = "";
    
    public KeinViereck()
    {
        this.err = "Das Viereck ist kein Viereck!";
    }
    
    @Override
    public String toString()
    {
        return this.err;
    }
}
