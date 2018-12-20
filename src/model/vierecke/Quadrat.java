/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vierecke;

import control.Verifizierer;
import exceptions.viereckExceptions.KeinQuadrat;
import model.Vertex;
/**
 *
 * @author Niklas
 */
public class Quadrat extends Rhombus implements Rechtwinklig
{
    public Quadrat(Vertex a, Vertex b, Vertex c, Vertex d) throws KeinQuadrat
    {
        super(a,b,c,d);
        if(!Verifizierer.verifiziere(this))
        {
            throw new KeinQuadrat();
        }
    }
}
