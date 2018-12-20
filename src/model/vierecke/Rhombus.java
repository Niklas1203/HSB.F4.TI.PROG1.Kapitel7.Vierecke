/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vierecke;

import control.Verifizierer;
import exceptions.viereckExceptions.KeinRhombus;
import model.Vertex;
/**
 *
 * @author nikla
 */
public class Rhombus extends Parallelogramm
{
    public Rhombus(Vertex a, Vertex b, Vertex c, Vertex d) throws KeinRhombus
    {
        super(a,b,c,d);
        if(!Verifizierer.verifiziere(this))
        {
            throw new KeinRhombus();
        }
    }
}
