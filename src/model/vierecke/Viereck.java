package model.vierecke;

import exceptions.viereckExceptions.KeinViereck;
import exceptions.NoIntersection;
import model.Edge;
import model.Face;
import model.Vertex;
import utilities.EdgeCalculator;

public abstract class Viereck extends Face
{
    private final Edge a;
    private final Edge b;
    private final Edge c;
    private final Edge d;
    private final float alpha;
    private final float beta;
    private final float gamma;
    private final float delta;
    
    public Viereck(Edge a, Edge b, Edge c, Edge d) throws KeinViereck
    {        
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        
        try
        {
            this.alpha = EdgeCalculator.berechneWinkel(this.d, this.a);
            this.beta = EdgeCalculator.berechneWinkel(this.a, this.b);
            this.gamma = EdgeCalculator.berechneWinkel(this.b, this.c);
            this.delta = EdgeCalculator.berechneWinkel(this.c, this.d);  
        }
        catch(NoIntersection e)
        {
            throw new KeinViereck();
        }
    }
    
    public Viereck(Vertex a, Vertex b, Vertex c, Vertex d) throws KeinViereck
    {
        this.a = new Edge(a,b);
        this.b = new Edge(b,c);
        this.c = new Edge(c,d);
        this.d = new Edge(d,a);
        
        try
        {
            this.alpha = EdgeCalculator.berechneWinkel(this.a, this.b);
            this.beta = EdgeCalculator.berechneWinkel(this.b, this.c);
            this.gamma = EdgeCalculator.berechneWinkel(this.c, this.d);
            this.delta = EdgeCalculator.berechneWinkel(this.d, this.a);  
        }
        catch(NoIntersection e)
        {
            throw new KeinViereck();
        }
    }
    
    public Edge getA()
    {
        return this.a;
    }
    
    public Edge getB()
    {
        return b;
    }
    
    public Edge getC()
    {
        return c;
    }
    
    public Edge getD()
    {
        return this.d;
    }
    
    public Vertex getP1()
    {
        return this.a.getP1();
    }
    
    public Vertex getP2()
    {
        return this.b.getP1();
    }
    
    public Vertex getP3()
    {
        return this.c.getP1();
    }
    
    public Vertex getP4()
    {
        return this.d.getP1();
    }

    public float getAlpha()
    {
        return this.alpha;
    }

    public float getBeta()
    {
        return this.beta;
    }

    public float getGamma()
    {
        return this.gamma;
    }

    public float getDelta()
    {
        return this.delta;
    }
    
    @Override 
    public String getTyp()
    {
        return this.getClass().getSimpleName();
    }
}
