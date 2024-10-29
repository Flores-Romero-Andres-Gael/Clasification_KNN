package Main;

import Clasifiacion.Clasification;
import DataSet.DataPoint;
import DataSet.DataSets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        DataSets dataSets = new DataSets();
        dataSets.loadDataSet();
        List<DataPoint> trainingData = dataSets.getDataPoints();

        Random random = new Random();
        int k = random.nextInt(10) + 1;

        Clasification classifier = new Clasification(trainingData, k);

        List<DataPoint> testPoints = new ArrayList<>();
        testPoints.add(new DataPoint(12.0, 14.0, 75.0, 280.0, 0.09, 0.18, "null"));
        testPoints.add(new DataPoint(15.0, 17.0, 90.0, 350.0, 0.12, 0.24, "null"));
        testPoints.add(new DataPoint(18.0, 20.0, 120.0, 500.0, 0.15, 0.3, "null"));
        testPoints.add(new DataPoint(13.17, 21.81, 85.42, 531.5, 0.09714, 0.0, "null"));
        testPoints.add(new DataPoint(19.02, 24.59, 122.0, 1076.0, 0.09029, 0.0, "null"));
        testPoints.add(new DataPoint(15.46, 19.48, 101.7, 748.9, 0.1092, 0.0, "null"));
        testPoints.add(new DataPoint(11.0, 13.0, 70.0, 270.0, 0.08, 0.16, "null"));
        testPoints.add(new DataPoint(14.0, 16.0, 85.0, 320.0, 0.12, 0.25, "null"));
        testPoints.add(new DataPoint(17.0, 19.0, 110.0, 450.0, 0.14, 0.29, "null"));
        testPoints.add(new DataPoint(17.27,25.42,112.4,928.8 ,0.08331 ,0.1109,"null"));

        System.err.println("--------Classification using KNN Algorithm--------");
        System.out.println("Cantidad de vecinos: " + k);

        for (int i = 0; i < testPoints.size(); i++) {
            String prediction = classifier.Predict(testPoints.get(i));
            System.out.println("Predicción para el punto de prueba " + (i + 1) + ": " + prediction);
        }
    }
}
