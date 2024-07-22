
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomQbitSystem {
    private QuantumSystem quantumSystem;
    private int numQubits;

    public ThreadLocalRandomQbitSystem(int numQubits) {
        this.numQubits = numQubits;
        this.quantumSystem = new QuantumSystem();
        initializeQubits();
    }

    private void initializeQubits() {
        for (int i = 0; i < numQubits; i++) {
            Qubit qubit = new Qubit();
            applyRandomOperations(qubit);
            quantumSystem.addQubit(qubit);
        }
    }

    private void applyRandomOperations(Qubit qubit) {
        int numOperations = ThreadLocalRandom.current().nextInt(1, 4); // Randomly choose between 1 to 3 operations
        for (int i = 0; i < numOperations; i++) {
            int operation = ThreadLocalRandom.current().nextInt(3); // 0 for Hadamard, 1 for Pauli X, 2 for Pauli Z
            switch (operation) {
                case 0:
                    qubit.applyHadamard();
                    break;
                case 1:
                    qubit.applyPauliX();
                    break;
                case 2:
                    qubit.applyPauliZ();
                    break;
            }
        }
    }
} 