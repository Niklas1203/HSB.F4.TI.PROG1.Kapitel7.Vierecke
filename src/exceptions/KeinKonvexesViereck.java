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
public class KeinKonvexesViereck extends IllegalArgumentException
{
    private String err = "";
    
    public KeinKonvexesViereck()
    {
        this.err = "Das Viereck ist nicht konvex!";
    }
    
    @Override
    public String toString()
    {
        return this.err;
    }
}
