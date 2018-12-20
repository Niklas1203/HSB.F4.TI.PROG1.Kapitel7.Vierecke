/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vierecke;

import control.Verifier;;
import exceptions.NoIntersection;
import model.Vertex;
/**
 *
 * @author nikla
 */
public class Rectangle extends Parallelogramm
{
    public Rectangle(Vertex a, Vertex b, Vertex c, Vertex d)
    {
        super(a,b,c,d);
        this.verify();
    }
    
    private void verify()
    {
        if(!Verifier.isRectangular(this))
        {
            System.out.println("Kein Rechteck");
        }
    }
}
