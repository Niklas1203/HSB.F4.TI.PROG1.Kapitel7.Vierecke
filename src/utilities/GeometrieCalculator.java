package utilities;

import model.vierecke.Trapez;
import model.vierecke.Rechteck;
import model.vierecke.Parallelogramm;
import model.vierecke.Rhombus;
import model.vierecke.KonvexesViereck;
import exceptions.NoIntersection;
import model.Edge;

public class GeometrieCalculator
{  
   public static float berechneUmfang(KonvexesViereck c)
   {
       return EdgeCalculator.berechneLaenge(c.getA()) + EdgeCalculator.berechneLaenge(c.getB()) 
               + EdgeCalculator.berechneLaenge(c.getC()) + EdgeCalculator.berechneLaenge(c.getD());
   }
   public static float berechneFlaecheninhalt(Trapez t)
   {
       float height = 0.0f;
       float zaehler = 0.0f;
       
       if(bestimmeParallelen(t) == 'y')
       {
           height = t.getC().getP1().getY() - t.getA().getP1().getY();
           zaehler = EdgeCalculator.berechneLaenge(t.getA()) + EdgeCalculator.berechneLaenge(t.getC());
       }
       else
       {
           height = t.getB().getP1().getX() - t.getD().getP1().getX();
       }
       return (zaehler / 2) * height;
   }
   
       
    private static char bestimmeParallelen(Trapez a)
    {
        if(EdgeCalculator.berechneSteigung(a.getA()) == EdgeCalculator.berechneSteigung(a.getC()))
        {
            return 'y';
        }
        else
        {
            return 'x';
        }
    }
   
   public static float berechneFlaecheninhalt(Parallelogramm p)
   {    
       float angle = 0.0f;
       try
       {
           angle = EdgeCalculator.berechneWinkel(p.getA(), p.getB());
       } catch(NoIntersection e) //kann theoretisch nicht vorkommen, muss trotzdem sein: evtl gesonderte Methode
       {
       
       }
       return (float) (Math.sin(Math.toRadians(angle)) * EdgeCalculator.berechneLaenge(p.getA()) * EdgeCalculator.berechneLaenge(p.getB()));
   }
   
   public static float berechneFlaecheninhalt(Rhombus r)
   {
       Edge a = new Edge(r.getP1(), r.getP3());
       Edge b = new Edge(r.getP2(), r.getP4());
       
       return EdgeCalculator.berechneLaenge(a) * EdgeCalculator.berechneLaenge(b) * 0.5f;
   }
   
   public static float berechneFlaecheninhalt(Rechteck r)
   {
       return EdgeCalculator.berechneLaenge(r.getA()) * EdgeCalculator.berechneLaenge(r.getB());
   }
}