package Clasifiacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import DataSet.DataPoint;

public class Clasification {

    private List<DataPoint> trainingData;
    private int k;

    public Clasification(List<DataPoint> trainingData, int k) {
        this.trainingData = trainingData;
        this.k = k;
    }

    private double CalculateDistance(DataPoint p1, DataPoint p2) {
        return Math.sqrt(
            Math.pow(p1.getRadiusMean() - p2.getRadiusMean(), 2) +
            Math.pow(p1.getTextureMean() - p2.getTextureMean(), 2) +
            Math.pow(p1.getPerimeterMean() - p2.getPerimeterMean(), 2) +
            Math.pow(p1.getAreaMean() - p2.getAreaMean(), 2) +
            Math.pow(p1.getSmoothnessMean() - p2.getSmoothnessMean(), 2) +
            Math.pow(p1.getCompactnessMean() - p2.getCompactnessMean(), 2)
        );
    }

    //Calculos de distancia entre los puntos
    public String Predict(DataPoint newPoint) {
        List<Neighbor> neighbors = new ArrayList<>();

        for (DataPoint point : trainingData) {
            double distance = CalculateDistance(newPoint, point);
            neighbors.add(new Neighbor(point, distance));
        }

        //Ordenar los vecionos por distancia
        Collections.sort(neighbors, Comparator.comparingDouble(Neighbor::getDistance));
        List<Neighbor> kNeighbors = neighbors.subList(0, k);

        int benignCount = 0; //B
        int malignantCount = 0; //M
       
        //Clasiicar los puntos entre benignos y malignos
        for (Neighbor neighbor : kNeighbors) {
            if ("B".equals(neighbor.getPoint().getDiagnosis())) {
                benignCount++;
            } else if ("M".equals(neighbor.getPoint().getDiagnosis())) {
                malignantCount++;
            }
        }

        //Dar su clasificacion
        if (benignCount > malignantCount) {
            return "B";
        } else if (malignantCount > benignCount) {
            return "M";
        } else {
            return "Desconocido";
        }
    }

    private static class Neighbor {
        private DataPoint point;
        private double distance;

        public Neighbor(DataPoint point, double distance) {
            this.point = point;
            this.distance = distance;
        }

        public DataPoint getPoint() {
            return point;
        }

        public double getDistance() {
            return distance;
        }
    }
}
