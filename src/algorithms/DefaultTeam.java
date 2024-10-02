package algorithms;

import java.awt.Point;
import java.util.ArrayList;

import supportGUI.Circle;
import supportGUI.Line;

public class DefaultTeam {
    // calculTSP: ArrayList<Point> --> ArrayList<Point>
    // on input a list named 'points' of 2D-points in an
    // Euclidean space, output a permutation of 'points' where
    // the sum of distance between consecutive points in this
    // circular permutation is minimum (this include the distance
    // between the first and the last point.

    public ArrayList<Point> calculTSP(ArrayList<Point> points) {
        ArrayList<Point> p = glouton(points); // glouton pour obtenir un chemin initial
        boolean improved;
        do {
            improved = false;

            ArrayList<Point> newP = improve(p);
            if (score(newP) < score(p)) {
                p = newP; // maj
                improved = true;
            }
            newP = improveG4(p);
            if (score(newP) < score(p)) {
                p = newP; // maj
                improved = true;
            }
        } while (improved); // continu si possible

        return p;
    }

    public Point closest(Point p, ArrayList<Point> points) {
        int iMin = 0;
        double minDistance = points.get(0).distance(p);

        for (int i = 1; i < points.size(); i++) {
            double currentDistance = points.get(i).distance(p);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                iMin = i;
            }
        }

        return points.remove(iMin);
    }

    public ArrayList<Point> glouton(ArrayList<Point> points) {
        ArrayList<Point> res = new ArrayList<Point>();
        res.add(points.remove(0));

        while (!points.isEmpty()) {
            res.add(closest(res.get(res.size() - 1), points));
        }

        return res;
    }

    private ArrayList<Point> init(ArrayList<Point> points) {
        ArrayList<Point> p = new ArrayList<Point>();
        ArrayList<Point> rest = (ArrayList<Point>) points.clone();
        p.add(rest.remove(0));
        while (!rest.isEmpty())
            p.add(nearest(p.get(p.size() - 1), rest));
        return p;
    }

    private Point nearest(Point p, ArrayList<Point> points) {
        int iMax = 0;
        for (int i = 0; i < points.size(); i++)
            if (p.distance(points.get(i)) < p.distance(points.get(iMax)))
                iMax = i;
        return points.remove(iMax);
    }

    private ArrayList<Point> improve(ArrayList<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 2; j < points.size(); j++) {
                double a = points.get(i).distance(points.get((i + 1) % points.size()));
                double b = points.get(j % points.size()).distance(points.get((j + 1) % points.size()));
                double c = points.get(i).distance(points.get(j % points.size()));
                double d = points.get((i + 1) % points.size()).distance(points.get((j + 1) % points.size()));
                if (a + b > c + d) {
                    ArrayList<Point> p = new ArrayList<Point>();
                    for (int k = 0; k <= i; k++)
                        p.add(points.get(k));
                    for (int k = j; k > i; k--)
                        p.add(points.get(k));
                    for (int k = j + 1; k < points.size(); k++)
                        p.add(points.get(k));
                    return p;
                }
            }
        }
        return points;
    }

    private ArrayList<Point> improveG3(ArrayList<Point> points) {
        for (int i = 0; i < points.size() - 3; i++) {
            Point a = points.get((i + 1) % points.size());
            Point b = points.get((i + 2) % points.size());
            Point c = points.get((i + 3) % points.size());

            ArrayList<Point> test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(a);
            test.add(c);
            test.add(b);
            for (int j = i + 4; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(b);
            test.add(a);
            test.add(c);
            for (int j = i + 4; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(b);
            test.add(c);
            test.add(a);
            for (int j = i + 4; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(c);
            test.add(a);
            test.add(b);
            for (int j = i + 4; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(c);
            test.add(b);
            test.add(a);
            for (int j = i + 4; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

        }
        return points;
    }

    private ArrayList<Point> improveG4(ArrayList<Point> points) {
        for (int i = 0; i < points.size() - 4; i++) {
            Point a = points.get((i + 1) % points.size());
            Point b = points.get((i + 2) % points.size());
            Point c = points.get((i + 3) % points.size());
            Point d = points.get((i + 4) % points.size());

            ArrayList<Point> test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(a);
            test.add(d);
            test.add(c);
            test.add(b);
            for (int j = i + 5; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(b);
            test.add(a);
            test.add(d);
            test.add(c);
            for (int j = i + 5; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(c);
            test.add(b);
            test.add(a);
            test.add(d);
            for (int j = i + 5; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(d);
            test.add(c);
            test.add(b);
            test.add(a);
            for (int j = i + 5; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;

            test = new ArrayList<Point>();
            for (int j = 0; j <= i; j++)
                test.add(points.get(j));
            test.add(c);
            test.add(d);
            test.add(b);
            test.add(a);
            for (int j = i + 5; j < points.size(); j++)
                test.add(points.get(j));
            if (score(test) < score(points))
                return test;
        }
        return points;
    }

    private double score(ArrayList<Point> points) {
        double s = 0;
        for (int i = 0; i < points.size(); i++)
            s += points.get(i).distance(points.get((i + 1) % points.size()));
        return s;
    }

    // calculTSPOpt: ArrayList<Point> --> ArrayList<Point>
    // on input a list named 'points' of 2D-points in an
    // Euclidean space, output a permutation of 'points' where
    // the sum of distance between consecutive points in this
    // circular permutation is minimum (this include the distance
    // between the first and the last point.

    public ArrayList<Point> calculTSPOpt(ArrayList<Point> points) {
        if (points.size() < 4) {
            return points;
        }

        ArrayList<Point> p = new ArrayList<>(points);
        boolean improvement = true;

        while (improvement) {
            improvement = false;
            for (int i = 1; i < p.size() - 2; i++) {
                for (int j = i + 1; j < p.size() - 1; j++) {
                    // compare les distances avant et après
                    double originalDistance = p.get(i - 1).distance(p.get(i)) + p.get(j).distance(p.get(j + 1));
                    double newDistance = p.get(i - 1).distance(p.get(j)) + p.get(i).distance(p.get(j + 1));

                    // si c'est mieux, on fait le swap
                    if (newDistance < originalDistance) {
                        ArrayList<Point> newPath = new ArrayList<>(p.subList(0, i));
                        for (int k = j; k >= i; k--) {
                            newPath.add(p.get(k)); // inverse les points
                        }
                        newPath.addAll(p.subList(j + 1, p.size())); // ajoute le reste
                        p = newPath;
                        improvement = true; // pour continuer si il y a mieux
                    }
                }
            }
        }

        return p;
    }
}
