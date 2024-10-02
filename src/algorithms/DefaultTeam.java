package algorithms;

import java.awt.Point;
import java.util.ArrayList;
import supportGUI.Circle;
import supportGUI.Line;

public class DefaultTeam {

    // calculTSP: ArrayList<Point> --> ArrayList<Point>
    //   renvoie une permutation P de points telle que la visite
    //   de ces points selon l'ordre défini par P est de distance
    //   totale minimum.
    public ArrayList<Point> calculTSP(ArrayList<Point> points) {
        if (points.size()<4) {
            return points;
        }

        ArrayList<Point> p=new ArrayList<Point>();
        p.addAll(points);

        /*******************
         * PARTIE A ECRIRE *
         *******************/
        return p;
    }

    // calculTSPOpt: ArrayList<Point> --> ArrayList<Point>
    //   renvoie une permutation P de points telle que la visite
    //   de ces points selon l'ordre défini par P est de distance
    //   totale minimum.
    public ArrayList<Point> calculTSPOpt(ArrayList<Point> points) {
        if (points.size()<4) {
            return points;
        }

        ArrayList<Point> p=new ArrayList<Point>();
        p.addAll(points);

        /*******************
         * PARTIE A ECRIRE *
         *******************/
        return p;
    }

    // calculDiametre: ArrayList<Point> --> Line
    //   renvoie une paire de points de la liste, de distance maximum.
    public Line calculDiametre(ArrayList<Point> points) {
        if (points.size()<3) {
            return null;
        }

        Point p=points.get(0);
        Point q=points.get(1);

        /*******************
         * PARTIE A ECRIRE *
         *******************/
        return new Line(p,q);
    }

    // calculDiametreOptimise: ArrayList<Point> --> Line
    //   renvoie une paire de points de la liste, de distance maximum.
    public Line calculDiametreOptimise(ArrayList<Point> points) {
        if (points.size()<3) {
            return null;
        }

        Point p=points.get(1);
        Point q=points.get(2);

        /*******************
         * PARTIE A ECRIRE *
         *******************/
        return new Line(p,q);
    }

    // calculCercleMin: ArrayList<Point> --> Circle
    //   renvoie un cercle couvrant tout point de la liste, de rayon minimum.
    public Circle calculCercleMin(ArrayList<Point> points) {
        if (points.isEmpty()) {
            return null;
        }

        Point center=points.get(0);
        int radius=100;

        /*******************
         * PARTIE A ECRIRE *
         *******************/
        return new Circle(center,radius);
    }

    // enveloppeConvexe: ArrayList<Point> --> ArrayList<Point>
    //   renvoie l'enveloppe convexe de la liste.
    public ArrayList<Point> enveloppeConvexe(ArrayList<Point> points){
        if (points.size()<3) {
            return null;
        }

        ArrayList<Point> enveloppe = new ArrayList<Point>();

        enveloppe.add(points.get(0));
        enveloppe.add(points.get(1));
        enveloppe.add(points.get(2));


        /*******************
         * PARTIE A ECRIRE *
         *******************/
        return points;
    }
}
