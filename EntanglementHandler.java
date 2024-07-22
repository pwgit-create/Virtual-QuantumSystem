
import java.util.Random;

public class EntanglementHandler {
    private QuantumSystem system;
    private Random random = new Random();

    public EntanglementHandler(QuantumSystem system) {
        this.system = system;
    }

    // Apply entanglement between two qubits using Bell state creation method
    public void applyEntanglement() {
        Qubit q1 = new Qubit();
        Qubit q2 = new Qubit();

        system.addQubit(q1);
        system.addQubit(q2);

        // Apply Hadamard gate to the first qubit
        q1.applyHadamard();

        // Entangle the two qubits using a CNOT gate
        if (random.nextBoolean()) {
            q2.applyPauliX();
        }

        q1.applyPauliZ();
    }
} 