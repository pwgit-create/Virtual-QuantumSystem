public class Main {
    public static void main(String[] args) {
        // Initialize QuantumSystem and add some Qubits to it.
        QuantumSystem quantumSystem = new QuantumSystem();
        for (int i = 0; i < 5; i++) {
            quantumSystem.addQubit(new Qubit());
        }

        // Initialize ThreadLocalRandomQbitSystem and apply entanglement using EntanglementHandler.
        ThreadLocalRandomQbitSystem threadLocalRandomQbitSystem = new ThreadLocalRandomQbitSystem(5);
        EntanglementHandler entanglementHandler = new EntanglementHandler(quantumSystem);

        // Apply some quantum gates to the Qubits in the QuantumSystem.
        //quantumSystem.applyHadamardToAllQubits();
        quantumSystem.applyPauliXToAllQubits();
        //quantumSystem.applyPauliZToAllQubits();
	quantumSystem.applyPauliXToAllQubits();
        //entanglementHandler.applyEntanglement();
// Measure all the Qubits in the QuantumSystem.
        int[] measurements = quantumSystem.measureAllQubits();
        for (int measurement : measurements) {
            System.out.println("Measured state: " + measurement);
        }
    }
}
