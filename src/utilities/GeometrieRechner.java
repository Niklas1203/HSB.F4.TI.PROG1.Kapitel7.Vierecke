package utilities;

import model.vierecke.Trapez;
import model.vierecke.Rechteck;
import model.vierecke.Parallelogramm;
import model.vierecke.Rhombus;
import model.vierecke.KonvexesViereck;
import exceptions.NoIntersection;
import model.Edge;

public class GeometrieRechner
{  
   public static float berechneUmfang(KonvexesViereck c)
   {
       return EdgeRechner.berechneLaenge(c.getA()) + EdgeRechner.berechneLaenge(c.getB()) 
               + EdgeRechner.berechneLaenge(c.getC()) + EdgeRechner.berechneLaenge(c.getD());
   }
   public static float berechneFlaecheninhalt(Trapez t)
   {
       float height = 0.0f;
       float zaehler = 0.0f;
       
       if(bestimmeParallelen(t) == 'y')
       {
           height = t.getC().getP1().getY() - t.getA().getP1().getY();
           zaehler = EdgeRechner.berechneLaenge(t.getA()) + EdgeRechner.berechneLaenge(t.getC());
       }
       else
       {
           height = t.getB().getP1().getX() - t.getD().getP1().getX();
       }
       return (zaehler / 2) * height;
   }
   
       
    private static char bestimmeParallelen(Trapez a)
    {
        if(EdgeRechner.berechneSteigung(a.getA()) == EdgeRechner.berechneSteigung(a.getC()))
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
           angle = EdgeRechner.berechneWinkel(p.getA(), p.getB());
       } catch(NoIntersection e) //kann theoretisch nicht vorkommen, muss trotzdem sein: evtl gesonderte Methode
       {
       
       }
       return (float) (Math.sin(Math.toRadians(angle)) * EdgeRechner.berechneLaenge(p.getA()) * EdgeRechner.berechneLaenge(p.getB()));
   }
   
   public static float berechneFlaecheninhalt(Rhombus r)
   {
       Edge a = new Edge(r.getP1(), r.getP3());
       Edge b = new Edge(r.getP2(), r.getP4());
       
       return EdgeRechner.berechneLaenge(a) * EdgeRechner.berechneLaenge(b) * 0.5f;
   }
   
   public static float berechneFlaecheninhalt(Rechteck r)
   {
       return EdgeRechner.berechneLaenge(r.getA()) * EdgeRechner.berechneLaenge(r.getB());
   }
}