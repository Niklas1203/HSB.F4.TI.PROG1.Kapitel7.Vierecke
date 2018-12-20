/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import model.Edge;
import model.Vertex;
import exceptions.NoIntersection;

/**
 *
 * @author Niklas
 */
public class EdgeCalculator {
    
    public static boolean between(float border1, float border2, float toTest)
   {
       return toTest >= border1 && toTest <= border2 
               || toTest <= border1 && toTest >= border2;
   }
   
   public static boolean contains(Edge a, Vertex x)
   {
       float m = calculateGradient(a);
       float b = calculateYIntersection(a, m);
       
       if(Float.isInfinite(m))
       {
           return a.getP1().getX() == x.getX() && between(a.getP1().getY(), a.getP2().getY(), x.getY());
       }
       else
       {
           float intersection = m * x.getX() + b;
           return intersection == x.getY() && between(a.getP1().getX(), a.getP2().getX(), intersection);
       }
   }
    
    public static boolean intersects(Edge a, Edge b)
   {
       float x = 0.0f;
       try
       {
           x = calculateIntersection(a,b);
       } 
       catch (NoIntersection e)
       {
           return false;
       }
       
       /* in our case, we have to make sure, that the calculated x-value lies somewhere between the minimal and maximal x-value of the two edges. */
       return between(a.getP1().getX(), a.getP2().getX(), x) && between(b.getP1().getX(), b.getP2().getX(), x); 
   }
   
    public static float calculateLength(Edge e)
   {
       return calculateLength(e.getP1(), e.getP2());
   }
   
   public static float calculateLength(Vertex a, Vertex b)
   {
       double differenceX = b.getX() - a.getX();
       double differenceY = b.getY() - a.getY();
       
       return (float) Math.pow(differenceX * differenceX + differenceY * differenceY, 0.5);
   }
   
   public static float calculateGradient(Edge a)
   {
       if(a.getP1().getX() == a.getP2().getX())
       {
           return Float.POSITIVE_INFINITY;
       }
       else
       {
           return ((a.getP2().getY()-a.getP1().getY()) / (a.getP2().getX()-a.getP1().getX()));
       }
   }
   
   public static float calculateYIntersection(Edge a, float m)
   {
       return (a.getP1().getY() - m * a.getP1().getX());
   }
   
      public static float calculateIntersection(Edge a, Edge b) throws NoIntersection
   {
       float m1 = EdgeCalculator.calculateGradient(a);
       float m2 = EdgeCalculator.calculateGradient(b);
       
       
       if(Float.isInfinite(m1) && Float.isInfinite(m2))
       {
           throw new NoIntersection();
       }
       else if(Float.isInfinite(m1) && Float.isFinite(m2))
       {
           return a.getP1().getX();
       }
       else if(Float.isFinite(m1) && Float.isInfinite(m2))
       {
           return b.getP1().getX();
       }
       else if(m1 != m2)
       {
           return (((calculateYIntersection(b, m2)) - (calculateYIntersection(a, m1))) / (m1 - m2));
       }
       else
       {
           throw new NoIntersection();
       } 
   }
      
   public static Vertex getDirectionalVector(Edge a)
   {
       return new Vertex(a.getP2().getX() - a.getP1().getX(), a.getP2().getY() - a.getP1().getY());
   }
   
   public static float calculateScalar(Edge a, Edge b)
   {    
       Vertex c = getDirectionalVector(a);
       Vertex d = getDirectionalVector(b);
       
       return (c.getX() * d.getX() + c.getY() * d.getY());
   }
   
   public static float calculateAngle(Edge a, Edge b) throws NoIntersection
   {
       if(intersects(a, b))
       {
           float cosAngle = calculateScalar(a,b) / (calculateLength(a) * calculateLength(b));
           
           return 180.0f + (-1.0f * (float) Math.abs(Math.toDegrees(Math.acos(cosAngle))));
       }
       else
       {
           throw new NoIntersection();
       }
    }
}
