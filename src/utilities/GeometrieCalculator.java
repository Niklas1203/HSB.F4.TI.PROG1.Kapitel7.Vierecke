package utilities;

import model.vierecke.Trapezoid;
import model.vierecke.Rectangle;
import model.vierecke.Parallelogramm;
import model.vierecke.Rhombus;
import model.vierecke.ConvexQuadrangle;
import model.*;
import control.Verifier;
import exceptions.NoIntersection;

public class GeometrieCalculator
{  
   public static float calculatePerimeter(ConvexQuadrangle c)
   {
       return EdgeCalculator.calculateLength(c.getA()) + EdgeCalculator.calculateLength(c.getB()) 
               + EdgeCalculator.calculateLength(c.getC()) + EdgeCalculator.calculateLength(c.getD());
   }
   public static float calculateArea(Trapezoid t)
   {
       float height = 0.0f;
       float zaehler = 0.0f;
       
       if(getParallels(t) == 'y')
       {
           height = t.getC().getP1().getY() - t.getA().getP1().getY();
           zaehler = EdgeCalculator.calculateLength(t.getA()) + EdgeCalculator.calculateLength(t.getC());
       }
       else
       {
           height = t.getB().getP1().getX() - t.getD().getP1().getX();
       }
       return (zaehler / 2) * height;
   }
   
       
    private static char getParallels(Trapezoid a)
    {
        if(EdgeCalculator.calculateGradient(a.getA()) == EdgeCalculator.calculateGradient(a.getC()))
        {
            return 'y';
        }
        else
        {
            return 'x';
        }
    }
   
   public static float calculateArea(Parallelogramm p)
   {    
       float angle = 0.0f;
       try
       {
           angle = EdgeCalculator.calculateAngle(p.getA(), p.getB());
       } catch(NoIntersection e) //kann theoretisch nicht vorkommen, muss trotzdem sein: evtl gesonderte Methode
       {
       
       }
       return (float) (Math.sin(Math.toRadians(angle)) * EdgeCalculator.calculateLength(p.getA()) * EdgeCalculator.calculateLength(p.getB()));
   }
   
   public static float calculateArea(Rhombus r)
   {
       Edge a = new Edge(r.getP1(), r.getP3());
       Edge b = new Edge(r.getP2(), r.getP4());
       
       return EdgeCalculator.calculateLength(a) * EdgeCalculator.calculateLength(b) * 0.5f;
   }
   
   public static float calculateArea(Rectangle r)
   {
       return EdgeCalculator.calculateLength(r.getA()) * EdgeCalculator.calculateLength(r.getB());
   }
}