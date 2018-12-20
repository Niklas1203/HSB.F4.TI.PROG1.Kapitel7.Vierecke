/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vierecke;

import model.vierecke.ConvexQuadrangle;
import exceptions.*;
import control.Verifier;import model.Vertex;
;

/**
 *
 * @author nikla
 */
public class Trapezoid extends ConvexQuadrangle
{
    public Trapezoid(Vertex a, Vertex b, Vertex c, Vertex d)
    {
        super(a,b,c,d);
        this.verify();
    }
    
    private void verify()
    {
        if(!Verifier.isTrapezoid(this))
        {
            System.out.println("Kein Trapez");
        }
    }
}