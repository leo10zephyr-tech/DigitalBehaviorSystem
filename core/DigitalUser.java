package core;

public class DigitalUser extends Person {

    private UsageProfile usageProfile;
    private static int totalUsers = 0;

    public DigitalUser(String name, int age, String email,
                       UsageProfile usageProfile) {
        super(name, age, email);
        this.usageProfile = usageProfile;
        totalUsers++;
    }

    public UsageProfile getUsageProfile()  { return usageProfile; }
    public static int   getTotalUsers()    { return totalUsers; }
    public double getTotalScreenTime()     { return usageProfile.getTotalHours(); }

    public String getAgeGroup() {
        int age = getAge();
        if (age <= 12)       return "Child";
        else if (age <= 17)  return "Teenager";
        else if (age <= 24)  return "Young Adult";
        else if (age <= 40)  return "Adult";
        else                 return "Senior";
    }

    @Override
    public String toString() {
        return "DigitalUser[name=" + getName()
             + ", age=" + getAge()
             + " (" + getAgeGroup() + ")"
             + ", screen=" + getTotalScreenTime() + "h]";
    }
}
