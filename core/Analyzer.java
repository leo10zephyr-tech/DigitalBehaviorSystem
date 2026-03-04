package core;

public abstract class Analyzer {

    protected String analyzerName;

    public Analyzer(String analyzerName) {
        this.analyzerName = analyzerName;
    }

    public abstract void analyze(DigitalUser user);

    protected void printHeader(DigitalUser user) {
        System.out.println("\nUser   : " + user.getName());
        System.out.println("Age    : " + user.getAge()
                           + " (" + user.getAgeGroup() + ")");
        System.out.println("Email  : " + user.getEmail());
        System.out.printf("Screen : %.1f hrs/day total%n",
                          user.getTotalScreenTime());
    }

    public String getAnalyzerName() {
        return analyzerName;
    }
}
