/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.vierecke.Square;
import model.*;
import exceptions.NoIntersection;
import utilities.*;
/**
 *
 * @author nikla
 */
public class Main
{
    public static void main(String[] args) throws NoIntersection
    {
        Square s = new Square(new Vertex(0,1), new Vertex(1,1), new Vertex(1,0), new Vertex(0,0));
    }
}
