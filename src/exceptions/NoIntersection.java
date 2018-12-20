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
    String message;
    
    public NoIntersection()
    {
        this.message = "The given Graphs do not intersect!";
    }
    
    public NoIntersection(Edge a, Edge b)
    {
        this.message = String.format("Graph a: %S and Graph B: %S do not intersect!", a.toString(), b.toString());
    }
    
    @Override 
    public String toString()
    {
        return this.message;
    }
}
