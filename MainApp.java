import core.*;
import services.*;
import utils.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.println("   DIGITAL BEHAVIOR ANALYZER - Post 5G      ");
        System.out.println("   OOP Java Project | CS Department          ");
        System.out.println("=============================================");
        System.out.println();

        List<DigitalUser> users = new ArrayList<>();
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("--- Enter User Details ---");

            System.out.print("Full Name     : ");
            String name = sc.nextLine().trim();
            if (!InputValidator.isValidName(name)) {
                System.out.println("Invalid name. Try again.\n");
                continue;
            }

            System.out.print("Age           : ");
            String ageInput = sc.nextLine().trim();
            if (!InputValidator.isValidAge(ageInput)) {
                System.out.println("Invalid age. Try again.\n");
                continue;
            }
            int age = Integer.parseInt(ageInput);

            System.out.print("Email         : ");
            String email = sc.nextLine().trim();
            if (!InputValidator.isValidEmail(email)) {
                System.out.println("Invalid email. Try again.\n");
                continue;
            }

            System.out.println("\n--- Daily Screen Time in hours per day ---");
            System.out.print("Productive Apps (AI, Learning, Work)    : ");
            double productive = InputValidator.parseDouble(sc.nextLine());

            System.out.print("Social Media (Instagram, Twitter)       : ");
            double social = InputValidator.parseDouble(sc.nextLine());

            System.out.print("Entertainment (Netflix, YouTube, Games) : ");
            double entertainment = InputValidator.parseDouble(sc.nextLine());

            System.out.print("Communication (WhatsApp, Email, Calls)  : ");
            double communication = InputValidator.parseDouble(sc.nextLine());

            UsageProfile profile = new UsageProfile(
                productive, social, entertainment, communication
            );
            DigitalUser user = new DigitalUser(name, age, email, profile);
            users.add(user);

            System.out.println("\nUser added successfully!");
            System.out.println();
            System.out.print("Add another user? (y/n): ");
            choice = sc.nextLine().trim();
            System.out.println();
        }

        if (users.isEmpty()) {
            System.out.println("No users entered. Exiting.");
            sc.close();
            return;
        }

        ClassificationService classifier = new ClassificationService();
        System.out.println();
        System.out.println("==============================================");
        System.out.println("        ANALYSIS REPORT - ALL USERS          ");
        System.out.println("==============================================");

        for (DigitalUser u : users) {
            classifier.analyze(u);
            System.out.println("----------------------------------------------");
        }

        FileService.saveReport(users);
        System.out.println("\nReport saved to: output/report.txt");
        System.out.println("Total users analyzed: " + DigitalUser.getTotalUsers());
        System.out.println("\nDone! Now push to GitHub.");
        sc.close();
    }
}
