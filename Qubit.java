
import java.util.concurrent.ThreadLocalRandom;

public class Qubit {
    private double amplitude0; // Probability amplitude of |0> state
    private double amplitude1; // Probability amplitude of |1> state
    private boolean collapsed; // Flag to check if the qubit has been measured
    private int value; // The result of measurement, 0 or 1

    public Qubit() {
        this.amplitude0 = 1.0; // Initially in |0> state
        this.amplitude1 = 0.0; // Initially not in |1> state
        this.collapsed = false;
    }

    public void applyHadamard() {
        if (!this.collapsed) {
            double sqrt2Inverse = 1 / Math.sqrt(2);
            double newAmplitude0 = sqrt2Inverse * (this.amplitude0 + this.amplitude1);
            double newAmplitude1 = sqrt2Inverse * (this.amplitude0 - this.amplitude1);
            this.amplitude0 = newAmplitude0;
            this.amplitude1 = newAmplitude1;
        }
    }

    public void applyPauliX() {
        if (!this.collapsed) {
            double temp = this.amplitude0;
            this.amplitude0 = this.amplitude1;
            this.amplitude1 = temp;
        }
    }

    public void applyPauliZ() {
        if (!this.collapsed) {
            this.amplitude1 = -this.amplitude1;
        }
    }

    public int measure() {
        if (!this.collapsed) {
            double probability0 = Math.pow(Math.abs(this.amplitude0), 2);
            double randomNumber = ThreadLocalRandom.current().nextDouble();
            this.value = (randomNumber < probability0) ? 0 : 1;
            this.collapsed = true;
        }
        return this.value;
    }
} 