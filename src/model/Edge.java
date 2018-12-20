/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nikla
 */
public class Edge
{
    private final Vertex p1;
    private final Vertex p2;
    
    public Edge(Vertex a, Vertex b)
    {
        this.p1 = a;
        this.p2 = b;
    }
    
    public Vertex getP1()
    {
        return this.p1;
    }
    
    public Vertex getP2()
    {
        return this.p2;
    }
    
    @Override public String toString()
    {
        return String.format("p1: %S | p2: %S", this.getP1(), this.getP2());
    }
}
