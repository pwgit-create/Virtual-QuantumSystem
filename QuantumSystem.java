
import java.util.*;

public class QuantumSystem {
    private List<Qubit> qubits;

    public QuantumSystem() {
        this.qubits = new ArrayList<>();
    }

    public void addQubit(Qubit q) {
        this.qubits.add(q);
    }

    public void applyHadamardToAllQubits() {
        for (Qubit q : qubits) {
            q.applyHadamard();
        }
    }

    public void applyPauliXToAllQubits() {
        for (Qubit q : qubits) {
            q.applyPauliX();
        }
    }

    public void applyPauliZToAllQubits() {
        for (Qubit q : qubits) {
            q.applyPauliZ();
        }
    }

    public int[] measureAllQubits() {
        int[] measurements = new int[qubits.size()];
        for (int i = 0; i < qubits.size(); i++) {
            measurements[i] = qubits.get(i).measure();
        }
        return measurements;
    }
} 