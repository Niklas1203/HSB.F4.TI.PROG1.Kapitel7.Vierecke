/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vierecke;

import control.Verifier;
import model.Vertex;
/**
 *
 * @author nikla
 */
public class Parallelogramm extends Trapezoid
{
    public Parallelogramm(Vertex a, Vertex b, Vertex c, Vertex d)
    {
        super(a,b,c,d);
        Verifier.isParallelogramm(this);
    }
}
