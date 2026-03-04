package services;

import core.Analyzer;
import core.DigitalUser;
import core.UsageProfile;
import core.UsageProfile.DominantCategory;

public class ClassificationService extends Analyzer {

    public ClassificationService() {
        super("Post-5G Behavior Classifier v1.0");
    }

    @Override
    public void analyze(DigitalUser user) {
        printHeader(user);

        UsageProfile p       = user.getUsageProfile();
        double score         = p.getProductivityScore();
        DominantCategory dom = p.getDominantCategory();

        System.out.println();
        printBar("Productive   ", p.getProductiveHours(),    p.getTotalHours());
        printBar("Social Media ", p.getSocialMediaHours(),   p.getTotalHours());
        printBar("Entertainment", p.getEntertainmentHours(), p.getTotalHours());
        printBar("Communication", p.getCommunicationHours(), p.getTotalHours());

        System.out.printf("%nProductivity Score : %.1f%%%n", score);

        String type   = classifyBehavior(dom, score);
        String advice = getAdvice(type, user.getAgeGroup());
        String risk   = assessRisk(p);

        System.out.println("Behavior Type      : " + type);
        System.out.println("Insight            : " + advice);
        System.out.println("Risk Level         : " + risk);
    }

    private void printBar(String label, double hours, double total) {
        int filled = total > 0 ? (int)((hours / total) * 25) : 0;
        String bar = "#".repeat(filled) + "-".repeat(25 - filled);
        System.out.printf("%-14s [%s] %.1fh%n", label, bar, hours);
    }

    private String classifyBehavior(DominantCategory dom, double score) {
        switch (dom) {
            case PRODUCTIVE:    return score > 60 ? "Digital Achiever" : "Moderate Productive";
            case SOCIAL_MEDIA:  return score < 20 ? "Social Overuser"  : "Social-Leaning";
            case ENTERTAINMENT: return "Entertainment-Hooked";
            case COMMUNICATION: return "Connector";
            default:            return "Digitally Balanced";
        }
    }

    private String getAdvice(String type, String ageGroup) {
        String base;
        switch (type) {
            case "Digital Achiever":
                base = "Excellent - keep using AI and learning tools!"; break;
            case "Moderate Productive":
                base = "Good - shift 30 min/day to skill-building apps."; break;
            case "Social Overuser":
                base = "High social usage - schedule screen-free hours."; break;
            case "Entertainment-Hooked":
                base = "Entertainment dominates - balance with learning."; break;
            case "Connector":
                base = "Strong communicator - try professional networking!"; break;
            default:
                base = "Well-rounded digital citizen!";
        }
        if (ageGroup.equals("Teenager") && type.equals("Entertainment-Hooked")) {
            return base + " [Teenager Alert: parental guidance suggested]";
        }
        return base;
    }

    private String assessRisk(UsageProfile p) {
        double harmful = p.getSocialMediaHours() + p.getEntertainmentHours();
        double total   = p.getTotalHours();
        double ratio   = total > 0 ? harmful / total : 0;

        if (ratio > 0.75)      return "HIGH   - Digital detox recommended";
        else if (ratio > 0.50) return "MEDIUM - Monitor and balance usage";
        else if (ratio > 0.30) return "LOW    - Healthy usage pattern";
        else                   return "VERY LOW - Excellent digital discipline";
    }
}
