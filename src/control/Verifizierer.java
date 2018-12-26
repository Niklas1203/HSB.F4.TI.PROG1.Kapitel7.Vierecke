/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.vierecke.KonvexesViereck;
import model.Edge;
import model.vierecke.Parallelogramm;
import model.vierecke.Rhombus;
import model.vierecke.Quadrat;
import model.vierecke.Trapez;
import utilities.EdgeRechner;
import model.vierecke.Rechtwinklig;

/**
 *
 * @author Niklas
 */
public class Verifizierer 
{
    /**
    * Diese Methode verifiziert, dass ein Viereck konvex ist
    * @param v das Viereck, dass verifiziert werden soll
    * @return true wenn das Viereck konvex ist
    */
    
   public static boolean verifiziere(KonvexesViereck v)
   {
       Edge a = new Edge(v.getP1(), v.getP3());
       Edge b = new Edge(v.getP4(), v.getP2());
       
       return EdgeRechner.pruefeObGeradenSichSchneiden(a,b) && !EdgeRechner.pruefeObGeradePunktEnthaelt(a, v.getP2()) 
               && !EdgeRechner.pruefeObGeradePunktEnthaelt(a, v.getP4()) && !EdgeRechner.pruefeObGeradePunktEnthaelt(b, v.getP1())
               && !EdgeRechner.pruefeObGeradePunktEnthaelt(b, v.getP3());
   }
   
   /**
    * Diese Methode verifiziert, dass ein Viereck ein Parallelogramm ist
    * @param p Das Parallelogramm, das getestet werden soll
    * @return true, wenn das Viereck ein Parellelogramm ist
    */
   
   public static boolean verifiziere(Parallelogramm p)
    {
        return EdgeRechner.berechneSteigung(p.getA()) == EdgeRechner.berechneSteigung(p.getC())
               && EdgeRechner.berechneSteigung(p.getB()) == EdgeRechner.berechneSteigung(p.getD());
    }
   
   /**
    * Diese Methode verifiziert, dass ein Viereck ein Rhombus ist
    * @param r Der Rhombus, der getetstet werden soll
    * @return true, wenn das Viereck ein Rhombus ist
    */
   
   public static boolean verifiziere(Rhombus r)
    {
        float a = EdgeRechner.berechneLaenge(r.getA());
        float b = EdgeRechner.berechneLaenge(r.getB());
        float c = EdgeRechner.berechneLaenge(r.getC());
        float d = EdgeRechner.berechneLaenge(r.getD());
        
        return a == b && b == c && c == d;
    }
   
   /**
    * Diese Methode verifiziert, dass ein Viereck ein Quadrat ist
    * @param q Das Quadrat, das getestet werden soll
    * @return true, wenn das Viereck ein Quadrat ist
    */
   
    public static boolean verifiziere(Quadrat q)
    {
        return verifiziere((Rhombus) q) && istRechtwinklig(q);
    }
    
    /**
     * Diese Methode testet, ob ein Objekt vom Typen Rechtwinklig tatsächlich rechtwinklig ist
     * @param r Das Objekt, das getestet werden soll
     * @return true, wenn das Objekt rechtwinklig ist
     */
    
   private static boolean istRechtwinklig(Rechtwinklig r)
    {
        return r.getAlpha() == r.getBeta() && r.getBeta() == r.getGamma() && r.getGamma() == r.getDelta() && r.getAlpha() == 90.0f;
    }
   
   /**
    * Diese Methode verifiziert, dass ein Viereck ein Trapez ist
    * @param t Das Trapez, das getestet werden soll
    * @return true, wenn das Viereck ein Trapez ist
    */
   
   public static boolean verifiziere(Trapez t)
    {
        return EdgeRechner.berechneSteigung(t.getA()) == EdgeRechner.berechneSteigung(t.getC())
               || EdgeRechner.berechneSteigung(t.getB()) == EdgeRechner.berechneSteigung(t.getD());
    }
}
