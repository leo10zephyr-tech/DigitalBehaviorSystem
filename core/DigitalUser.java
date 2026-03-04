package core;

/**
 * CHILD CLASS — extends Person, implements Reportable, Comparable
 * Shows: Inheritance + Interface + Comparable all in ONE class
 * Comparable lets us sort users by productivity score automatically
 */
public class DigitalUser extends Person
    implements Reportable, Comparable<DigitalUser> {

    private UsageProfile usageProfile;
    private static int totalUsers = 0;

    public DigitalUser(String name, int age, String email,
                       UsageProfile usageProfile) {
        super(name, age, email);
        this.usageProfile = usageProfile;
        totalUsers++;
    }

    public UsageProfile getUsageProfile() { return usageProfile; }
    public static int   getTotalUsers()   { return totalUsers; }
    public double getTotalScreenTime()    { return usageProfile.getTotalHours(); }

    public String getAgeGroup() {
        int age = getAge();
        if (age <= 12)       return "Child";
        else if (age <= 17)  return "Teenager";
        else if (age <= 24)  return "Young Adult";
        else if (age <= 40)  return "Adult";
        else                 return "Senior";
    }

    // ── Reportable interface methods ──────────────────────────────

    @Override
    public double getProductivityScore() {
        return usageProfile.getProductivityScore();
    }

    @Override
    public String generateSummary() {
        return String.format(
            "[%s | Age: %d | Screen: %.1fh/day | Score: %.1f%%]",
            getName(), getAge(),
            getTotalScreenTime(), getProductivityScore()
        );
    }

    @Override
    public String getRiskLabel() {
        double harmful = usageProfile.getSocialMediaHours()
                       + usageProfile.getEntertainmentHours();
        double total   = usageProfile.getTotalHours();
        double ratio   = total > 0 ? harmful / total : 0;
        if (ratio > 0.75)      return "HIGH RISK";
        else if (ratio > 0.50) return "MEDIUM RISK";
        else if (ratio > 0.30) return "LOW RISK";
        else                   return "SAFE";
    }

    // ── Comparable — sort by productivity score (highest first) ───

    @Override
    public int compareTo(DigitalUser other) {
        return Double.compare(
            other.getProductivityScore(),
            this.getProductivityScore()
        );
    }

    @Override
    public String toString() {
        return "DigitalUser[name=" + getName()
             + ", age=" + getAge()
             + " (" + getAgeGroup() + ")"
             + ", screen=" + getTotalScreenTime() + "h]";
    }
}
