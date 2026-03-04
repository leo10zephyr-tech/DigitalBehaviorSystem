package services;

import core.DigitalUser;
import core.UsageProfile;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileService {

    private static final String OUTPUT_DIR  = "output";
    private static final String OUTPUT_FILE = "output/report.txt";

    public static void saveReport(List<DigitalUser> users) {
        try {
            File dir = new File(OUTPUT_DIR);
            if (!dir.exists()) dir.mkdirs();

            PrintWriter writer = new PrintWriter(
                new FileWriter(OUTPUT_FILE, false)
            );

            writer.println("DIGITAL BEHAVIOR REPORT - Post 5G Era");
            writer.println("Generated : " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")
            ));
            writer.println("Total Users Analyzed : " + DigitalUser.getTotalUsers());
            writer.println("=".repeat(50));

            for (DigitalUser u : users) {
                UsageProfile p = u.getUsageProfile();
                writer.println("\nName          : " + u.getName());
                writer.println("Age           : " + u.getAge()
                               + " (" + u.getAgeGroup() + ")");
                writer.println("Email         : " + u.getEmail());
                writer.printf("Total Screen  : %.1f hrs/day%n",
                              u.getTotalScreenTime());
                writer.printf("Productive    : %.1f hrs%n", p.getProductiveHours());
                writer.printf("Social Media  : %.1f hrs%n", p.getSocialMediaHours());
                writer.printf("Entertainment : %.1f hrs%n", p.getEntertainmentHours());
                writer.printf("Communication : %.1f hrs%n", p.getCommunicationHours());
                writer.printf("Productivity  : %.1f%%%n",   p.getProductivityScore());
                writer.println("Dominant      : " + p.getDominantCategory());
                writer.println("-".repeat(50));
            }

            writer.println("\n[DigitalBehaviorSystem - Java OOP by leo10zephyr-tech]");
            writer.close();

        } catch (IOException e) {
            System.out.println("File save failed: " + e.getMessage());
        }
    }
}
