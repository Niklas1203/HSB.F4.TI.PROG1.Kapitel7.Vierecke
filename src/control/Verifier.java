/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.NoIntersection;
import model.vierecke.ConvexQuadrangle;
import model.Edge;
import model.vierecke.Parallelogramm;
import model.vierecke.Rhombus;
import model.vierecke.Square;
import model.vierecke.Trapezoid;
import utilities.EdgeCalculator;

/**
 *
 * @author Niklas
 */
public class Verifier 
{
    /**
    * This method tests, if a Quadrangle is convex
    * @param v the Quadrangle that is to be investigated
    * @return true if the Quadrangle is convex, false if it is not
    */
   public static boolean isConvex(ConvexQuadrangle v)
   {
       Edge a = new Edge(v.getP1(), v.getP3());
       Edge b = new Edge(v.getP4(), v.getP2());
       
       return EdgeCalculator.intersects(a,b) && !EdgeCalculator.contains(a, v.getP2()) 
               && !EdgeCalculator.contains(a, v.getP4()) && !EdgeCalculator.contains(b, v.getP1())
               && !EdgeCalculator.contains(a, v.getP3());
   }
   
   public static boolean isParallelogramm(Parallelogramm p)
    {
        return EdgeCalculator.calculateGradient(p.getA()) == EdgeCalculator.calculateGradient(p.getC())
               && EdgeCalculator.calculateGradient(p.getB()) == EdgeCalculator.calculateGradient(p.getD());
    }
   
   public static boolean isRectangular(ConvexQuadrangle c)
    {
        return c.getAlpha() == c.getBeta() && c.getBeta() == c.getGamma() && c.getGamma() == c.getDelta() && c.getAlpha() == 90.0f;
    }
   
   public static boolean isRhombus(Rhombus r)
    {
        float a = EdgeCalculator.calculateLength(r.getA());
        float b = EdgeCalculator.calculateLength(r.getB());
        float c = EdgeCalculator.calculateLength(r.getC());
        float d = EdgeCalculator.calculateLength(r.getD());
        
        return a == b && b == c && c == d;
    }
   
   public static boolean isSquare(Square s)
    {
        return isRhombus(s) && isRectangular(s);
    }
   
   public static boolean isTrapezoid(Trapezoid a)
    {
        return EdgeCalculator.calculateGradient(a.getA()) == EdgeCalculator.calculateGradient(a.getC())
               || EdgeCalculator.calculateGradient(a.getB()) == EdgeCalculator.calculateGradient(a.getD());
    }
}
