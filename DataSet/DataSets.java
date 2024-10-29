package DataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSets {

    private List<DataPoint> dataPoints = new ArrayList<>();
    String csvFile = "DataSet/KNNAlgorithmDataset.csv";

    public void loadDataSet() {

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                if (values.length >= 8) {
                    DataPoint dataPoint = new DataPoint(
                        Double.parseDouble(values[2]), // radiusMean
                        Double.parseDouble(values[3]), // textureMean
                        Double.parseDouble(values[4]), // perimeterMean
                        Double.parseDouble(values[5]), // areaMean
                        Double.parseDouble(values[6]), // smoothnessMean
                        Double.parseDouble(values[7]),  // compactnessMean
                        values[1] // diagnosis
                    );
                    
                    dataPoints.add(dataPoint);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en el archivo CSV: " + e.getMessage());
        }
    }

    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }
    
}