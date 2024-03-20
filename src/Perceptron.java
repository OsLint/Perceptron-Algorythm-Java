import java.util.Arrays;
import java.util.List;

public class Perceptron {
    private final double[] weights;
    private final List<Data> trainingData;


    public Perceptron(List<Data> trainingData) {
        this.trainingData = trainingData;
        int parametersSize = trainingData.getFirst().getAttributes().size();
        weights = new double[parametersSize];
        Arrays.fill(weights, 1);
        weights[parametersSize - 1] = 0; //treshold
    }

    public void trainPerceptron() {
        while (!isPerceptronTrainedForTrainingData(trainingData)) {
             trainingEpoch();
        }
    }

    private void trainingEpoch() {
        for (Data data : trainingData) {
            data.setPredictedTag(classifyVector(data.getAttributes()));
            if (!hasCorrectPrediction(data)) {
                adjustWeights(data);
            }
        }
    }

    private void adjustWeights(Data trainingData) {
        if (trainingData.getTag().trim().equals("Iris-setosa")) {
            for (int j = 0; j < weights.length; j++)
                weights[j] += trainingData.getAttributes().get(j) * 0.5;
        } else {

            for (int j = 0; j < weights.length; j++)
                weights[j] -= trainingData.getAttributes().get(j) * 0.5;
        }
    }

    private boolean isPerceptronTrainedForTrainingData(List<Data> trainingData) {
        for (Data data : trainingData) {
            if (!hasCorrectPrediction(data)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCorrectPrediction(Data data) {
        if (data.getPredictedTag() == null) {
            return false;
        }

        if (data.getTag().equals("Iris-setosa") && data.getPredictedTag().equals("Iris-setosa")) {
            return true;
        } else return !data.getTag().equals("Iris-setosa") && data.getPredictedTag().equals("Iris-nie-setosa");
    }


    public String classifyVector(List<Double> attributes) {
        double netValue = getNetValue(attributes);
        return netValue >= 0 ? "Iris-setosa" : "Iris-nie-setosa";
    }

    private double getNetValue(List<Double> attributes) {
        double netValue = 0;
        for (int i = 0; i < weights.length; i++) {
            netValue += attributes.get(i) * weights[i];
        }
        return netValue;
    }

    public int testPerceptronForListOfData(List<Data> testData) {
        int correctDataPredictions = 0;
        for (Data data : testData) {
            String predictedTag = classifyVector(data.getAttributes());
            data.setPredictedTag(predictedTag);
            System.out.println(data);

            if (hasCorrectPrediction(data)) {
                correctDataPredictions++;
            }
        }
        return correctDataPredictions;
    }
}
