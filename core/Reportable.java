package core;

/**
 * INTERFACE — defines a contract
 * Any class that implements this MUST provide these methods
 * KEY DIFFERENCE from Abstract Class:
 *   - Interface = what to DO (contract)
 *   - Abstract  = what to BE (blueprint)
 */
public interface Reportable {
    String generateSummary();
    String getRiskLabel();
    double getProductivityScore();
}
