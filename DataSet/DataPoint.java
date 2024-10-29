package DataSet;

public class DataPoint {

    private double radiusMean;
    private double textureMean;
    private double perimeterMean;
    private double areaMean;
    private double smoothnessMean;
    private double compactnessMean;
    private String diagnosis;

    public DataPoint(double radiusMean, double textureMean, double perimeterMean,
        double areaMean, double smoothnessMean, double compactnessMean, String diagnosis) {
            
        this.diagnosis = diagnosis;
        this.radiusMean = radiusMean;
        this.textureMean = textureMean;
        this.perimeterMean = perimeterMean;
        this.areaMean = areaMean;
        this.smoothnessMean = smoothnessMean;
        this.compactnessMean = compactnessMean;
    }

    public double getRadiusMean() { return radiusMean; }
    public double getTextureMean() { return textureMean; }
    public double getPerimeterMean() { return perimeterMean; }
    public double getAreaMean() { return areaMean; }
    public double getSmoothnessMean() { return smoothnessMean; }
    public double getCompactnessMean() { return compactnessMean; }
    public String getDiagnosis() { return diagnosis; }
}