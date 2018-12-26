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
public class EdgeRechner {
    
    /**
     * 
     * @param ersteGrenze die erste Grenze
     * @param zweiteGrenze die zweite Grenze
     * @param Wert der Wert, der getestet werden soll
     * @return true, wenn der Wert innerhalb der beiden Grenzen liegt
     */
    
   private static boolean istZwischen(float ersteGrenze, float zweiteGrenze, float Wert)
   {
       return Wert >= ersteGrenze && Wert <= zweiteGrenze 
               || Wert <= ersteGrenze && Wert >= zweiteGrenze;
   }
   
   /**
    * 
    * @param a die Gerade, welche getestet werden soll, ob sie den Punkt x enthält
    * @param x der Punkt, welcher getestet werden soll, ob er auf der Geraden a liegt
    * @return true, wenn der Punkt x auf der Geraden a liegt
    */
   
   public static boolean pruefeObGeradePunktEnthaelt(Edge a, Vertex x)
   {
       float m = berechneSteigung(a);
       float b = berechneYAchsenAbschnitt(a);
       
       if(Float.isInfinite(m))
       {
           return a.getP1().getX() == x.getX() && istZwischen(a.getP1().getY(), a.getP2().getY(), x.getY());
       }
       else
       {
           float intersection = m * x.getX() + b;
           return intersection == x.getY() && istZwischen(a.getP1().getX(), a.getP2().getX(), intersection);
       }
   }
    
   
   /**
    * 
    * @param a die erste Gerade
    * @param b die zweite Gerade
    * @return true, wenn die Geraden sich schneiden
    */
   
   public static boolean pruefeObGeradenSichSchneiden(Edge a, Edge b)
   {
       float x = 0.0f;
       try
       {
           x = berechneSchnittstelle(a,b);
       } 
       catch (NoIntersection e)
       {
           return false;
       }
       
       /* in our case, we have to make sure, that the calculated x-value lies somewhere between the minimal and maximal x-value of the two edges. */
       return istZwischen(a.getP1().getX(), a.getP2().getX(), x) && istZwischen(b.getP1().getX(), b.getP2().getX(), x); 
   }
   
   
   /**
    * 
    * @param e die Gerade
    * @return die Länge der Geraden e
    */
   
   public static float berechneLaenge(Edge e)
   {
       return berechneLaenge(e.getP1(), e.getP2());
   }
   
   
   /**
    * 
    * @param a der erste Punkt 
    * @param b der zweite Punkt
    * @return die Länge zwischen beiden Punkten als float
    */
   
   public static float berechneLaenge(Vertex a, Vertex b)
   {
       double differenceX = b.getX() - a.getX();
       double differenceY = b.getY() - a.getY();
       
       return (float) Math.pow(differenceX * differenceX + differenceY * differenceY, 0.5);
   }
   
   
   /**
    * 
    * @param a die Gerade, von welcher die Steigung berechnet werden soll
    * @return die Steigung als float
    */
   
   public static float berechneSteigung(Edge a)
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
   
   
   /**
    * 
    * @param a die Gerade
    * @return den Y-Achsen-Abschnitt als float
    */
   
   public static float berechneYAchsenAbschnitt(Edge a)
   {
       return (a.getP1().getY() - berechneSteigung(a) * a.getP1().getX());
   }
   
   
   /**
    * 
    * @param a die erste Gerade
    * @param b die zweite Gerade
    * @return die Schnittstelle als float
    * @throws NoIntersection sollten die beiden Geraden keinen Schnittpunkt besitzen
    */
   
   public static float berechneSchnittstelle(Edge a, Edge b) throws NoIntersection
   {
       float m1 = EdgeRechner.berechneSteigung(a);
       float m2 = EdgeRechner.berechneSteigung(b);
       
       
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
           return (((berechneYAchsenAbschnitt(b)) - (berechneYAchsenAbschnitt(a))) / (m1 - m2));
       }
       else
       {
           throw new NoIntersection();
       } 
   }
      
   
   /**
    * 
    * @param a die Gerade
    * @return den Richtungsvektor als Vertex
    */
   
   public static Vertex berechneRichtungsvektor(Edge a)
   {
       return new Vertex(a.getP2().getX() - a.getP1().getX(), a.getP2().getY() - a.getP1().getY());
   }
   
   
   /**
    * 
    * @param a die erste Gerade
    * @param b die zweite Gerade
    * @return das Skalarprodukt als float
    */
   
   public static float berechneSkalarprodukt(Edge a, Edge b)
   {    
       Vertex c = berechneRichtungsvektor(a);
       Vertex d = berechneRichtungsvektor(b);
       
       return (c.getX() * d.getX() + c.getY() * d.getY());
   }
   
   
   /**
    * 
    * @param a die erste Gerade
    * @param b die zweite Gerade
    * @return den Winkel als float
    * @throws NoIntersection wenn kein Schnittpunkt der beiden Geraden existiert
    */
   
   public static float berechneWinkel(Edge a, Edge b) throws NoIntersection
   {
       if(pruefeObGeradenSichSchneiden(a, b))
       {
           float cosAngle = berechneSkalarprodukt(a,b) / (EdgeRechner.berechneLaenge(a) * EdgeRechner.berechneLaenge(b));
           
           return 180.0f + (-1.0f * (float) Math.abs(Math.toDegrees(Math.acos(cosAngle))));
       }
       else
       {
           throw new NoIntersection();
       }
    }
}
