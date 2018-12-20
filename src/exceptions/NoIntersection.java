/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;
import model.Edge;

/**
 *
 * @author nikla
 */
public class NoIntersection extends Exception
{
    String err;
    
    public NoIntersection()
    {
        this.err = "Die angegebenen Graphen schneiden sich nicht!";
    }
    
    public NoIntersection(Edge a, Edge b)
    {
        this.err = String.format("Graph a: %S und Graph B: %S schneiden sich nicht!", a.toString(), b.toString());
    }
    
    @Override 
    public String toString()
    {
        return this.err;
    }
}
