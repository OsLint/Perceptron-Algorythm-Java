import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Perceptron perceptron;

    public static void main(String[] args) {
        initPerceptron();
        testPerceptron();
        getVectorInput();
    }

    public static void initPerceptron() {
        List<Data> trainingData = DataReader.readData("iris_training.txt");
        perceptron = new Perceptron(trainingData);
        perceptron.train();
    }

    public static void testPerceptron() {
        List<Data> testData = DataReader.readData("iris_test.txt");
        int correct = perceptron.testPerceptronForListOfData(testData);
        double accuracy = ((double) correct / testData.size()) * 100;

        System.out.println("Liczba prawidłowo zaklasyfikowanych przykładów: " + correct);
        System.out.println("Dokładność eksperymentu: " + accuracy + "%");
    }

    public static void getVectorInput() {

        DataInput.printPrompt();
        try {
            while (true) {
                String input = DataInput.getInput();
                if (input.equalsIgnoreCase("koniec")) {
                    break;
                }
                String[] tokens = input.split("\t");
                List<Double> attributes = new ArrayList<>();


                for (int i = 0; i < tokens.length; i++) {
                    try {
                        double value = Double.parseDouble(tokens[i].replace(",", "."));
                        attributes.add(value);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing token at index " + i + ": " + tokens[i]);
                    }
                }


                String predictedTag = perceptron.classifyVector(attributes);

                System.out.println("Wektor atrybutów: " + attributes);
                System.out.println("Przewidziana etykieta: " + predictedTag);
                DataInput.printPrompt();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
