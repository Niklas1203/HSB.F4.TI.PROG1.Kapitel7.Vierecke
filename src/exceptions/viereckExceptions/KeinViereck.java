/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions.viereckExceptions;

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
    
    public KeinViereck(String err)
    {
        this.err = err;
    }
    
    public String getError()
    {
        return this.err;
    }
    
    @Override
    public String toString()
    {
        return this.getError();
    }
}
