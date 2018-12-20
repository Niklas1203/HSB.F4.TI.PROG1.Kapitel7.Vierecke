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
public class Vertex
{
   private final float x;
   private final float y;
   
    public Vertex()
   {
       this.x = 0;
       this.y = 0;
   }
   
   public Vertex(float x, float y)
   {
       this.x = x;
       this.y = y;
   }
   
   public float getX()
   {
       return this.x;
   }
   
   public float getY()
   {
       return this.y;
   }
   
   @Override public String toString()
   {
       return String.format("(%S|%S)", this.getX(), this.getY());
   }
}