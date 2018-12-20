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
public class InfiniteGradient extends Exception
{
    String error;
    Edge a;
    
    public InfiniteGradient(Edge a)
    {
        this.a = a;
        this.error = String.format("The Gradient of Edge %S is infinite", a.toString());
    }
}
