### 🧠 Perceptron Implementation

This project implements a Perceptron, which is a fundamental algorithm used in machine learning for binary classification tasks. The Perceptron learns from a set of training data and adjusts its weights to classify new data points.
It was made for the NAI (tools of AI) class at Pjait.

#### 📋 Perceptron Class

- **Functionality**: The `Perceptron` class provides methods for training the Perceptron using training data, adjusting weights, classifying vectors, and testing the Perceptron's accuracy.
- **Training**: The `trainPerceptron()` method iteratively adjusts weights until the Perceptron is trained for the given training data.
- **Classification**: The `classifyVector()` method predicts the class of a data vector based on learned weights.
- **Testing**: The `testPerceptronForListOfData()` method evaluates the Perceptron's accuracy on a test dataset.

#### 🚀 Main Class

- **Initialization**: The `Main` class initializes the Perceptron with training data and trains it.
- **Testing**: It then tests the trained Perceptron on a test dataset and prints the number of correctly classified examples and the experiment's accuracy.
- **User Input**: The `getVectorInput()` method allows users to input their own data vectors and see the predicted class label.

#### 📁 Project Structure

- `Perceptron.java`: Contains the implementation of the Perceptron algorithm.
- `Main.java`: Entry point of the application, responsible for initializing, training, testing, and user interaction.
- `DataReader.java`: Utility class for reading data from files.
- `Data.java`: Class representing individual data instances.
- `DataInput.java`: Utility class for user input.

#### 🛠️ Dependencies

- Java 8 or higher


