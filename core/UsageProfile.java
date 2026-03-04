package core;

public class UsageProfile {

    private double productiveHours;
    private double socialMediaHours;
    private double entertainmentHours;
    private double communicationHours;

    public enum DominantCategory {
        PRODUCTIVE, SOCIAL_MEDIA, ENTERTAINMENT, COMMUNICATION, BALANCED
    }

    public UsageProfile(double productive, double social,
                        double entertainment, double communication) {
        this.productiveHours    = Math.max(0, productive);
        this.socialMediaHours   = Math.max(0, social);
        this.entertainmentHours = Math.max(0, entertainment);
        this.communicationHours = Math.max(0, communication);
    }

    public double getProductiveHours()    { return productiveHours; }
    public double getSocialMediaHours()   { return socialMediaHours; }
    public double getEntertainmentHours() { return entertainmentHours; }
    public double getCommunicationHours() { return communicationHours; }

    public double getTotalHours() {
        return productiveHours + socialMediaHours
             + entertainmentHours + communicationHours;
    }

    public double getProductivityScore() {
        double total = getTotalHours();
        if (total == 0) return 0;
        return (productiveHours / total) * 100;
    }

    public DominantCategory getDominantCategory() {
        double max = Math.max(
            Math.max(productiveHours, socialMediaHours),
            Math.max(entertainmentHours, communicationHours)
        );
        double t = 0.05;
        long tied = 0;
        double[] vals = {productiveHours, socialMediaHours,
                         entertainmentHours, communicationHours};
        for (double v : vals) {
            if (Math.abs(v - max) < t) tied++;
        }
        if (tied >= 2) return DominantCategory.BALANCED;
        if (Math.abs(max - productiveHours) < t)    return DominantCategory.PRODUCTIVE;
        if (Math.abs(max - socialMediaHours) < t)   return DominantCategory.SOCIAL_MEDIA;
        if (Math.abs(max - entertainmentHours) < t) return DominantCategory.ENTERTAINMENT;
        return DominantCategory.COMMUNICATION;
    }

    @Override
    public String toString() {
        return "Usage[P=" + productiveHours + "h | S=" + socialMediaHours
             + "h | E=" + entertainmentHours + "h | C=" + communicationHours + "h]";
    }
}
