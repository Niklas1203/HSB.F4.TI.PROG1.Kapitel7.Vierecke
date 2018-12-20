/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vierecke;

import control.Verifizierer;
import exceptions.viereckExceptions.KeinKonvexesViereck;
import model.Vertex;

/**
 *
 * @author nikla
 */
public class KonvexesViereck extends Viereck
{
    
    public KonvexesViereck(Vertex a, Vertex b, Vertex c, Vertex d) throws KeinKonvexesViereck
    {
        super(a,b,c,d);
        if(!Verifizierer.verifiziere(this))
        {
            throw new KeinKonvexesViereck();
        }
    }
}
