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
import utilities.EdgeCalculator;
import model.vierecke.Rechtwinklig;

/**
 *
 * @author Niklas
 */
public class Verifizierer 
{
    /**
    * This method tests, if a Quadrangle is convex
    * @param v the Quadrangle that is to be investigated
    * @return true if the Quadrangle is convex, false if it is not
    */
   public static boolean verifiziere(KonvexesViereck v)
   {
       Edge a = new Edge(v.getP1(), v.getP3());
       Edge b = new Edge(v.getP4(), v.getP2());
       
       return EdgeCalculator.pruefeObGeradenSichSchneiden(a,b) && !EdgeCalculator.pruefeObGeradePunktEnthaelt(a, v.getP2()) 
               && !EdgeCalculator.pruefeObGeradePunktEnthaelt(a, v.getP4()) && !EdgeCalculator.pruefeObGeradePunktEnthaelt(b, v.getP1())
               && !EdgeCalculator.pruefeObGeradePunktEnthaelt(b, v.getP3());
   }
   
   public static boolean verifiziere(Parallelogramm p)
    {
        return EdgeCalculator.berechneSteigung(p.getA()) == EdgeCalculator.berechneSteigung(p.getC())
               && EdgeCalculator.berechneSteigung(p.getB()) == EdgeCalculator.berechneSteigung(p.getD());
    }
   
   private static boolean istRechtwinklig(Rechtwinklig r)
    {
        return r.getAlpha() == r.getBeta() && r.getBeta() == r.getGamma() && r.getGamma() == r.getDelta() && r.getAlpha() == 90.0f;
    }
   
   public static boolean verifiziere(Rhombus r)
    {
        float a = EdgeCalculator.berechneLaenge(r.getA());
        float b = EdgeCalculator.berechneLaenge(r.getB());
        float c = EdgeCalculator.berechneLaenge(r.getC());
        float d = EdgeCalculator.berechneLaenge(r.getD());
        
        return a == b && b == c && c == d;
    }
   
   public static boolean verifiziere(Quadrat s)
    {
        return Verifizierer.verifiziere(s) && istRechtwinklig(s);
    }
   
   public static boolean verifiziere(Trapez a)
    {
        return EdgeCalculator.berechneSteigung(a.getA()) == EdgeCalculator.berechneSteigung(a.getC())
               || EdgeCalculator.berechneSteigung(a.getB()) == EdgeCalculator.berechneSteigung(a.getD());
    }
}
