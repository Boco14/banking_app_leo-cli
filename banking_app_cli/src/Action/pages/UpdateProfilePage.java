package Action.pages;
import Action.UserDetails;
import java.util.Scanner;
public class UpdateProfilePage {
    private static final Scanner SCAN = new Scanner(System.in);
    public static void updateProfile(UserDetails user) {
        System.out.println("=== Update Profile ===");
        System.out.println("1. Update Name");
        System.out.println("2. Update Email");
        System.out.println("3. Update PIN");
        System.out.println("4. Cancel");
        System.out.print("Choose option: ");
        int choice = SCAN.nextInt();
        SCAN.nextLine(); // clear buffer
        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = SCAN.nextLine();
                user.setNAME(newName);
                System.out.println("Name updated successfully.");
                break;
            case 2:
                System.out.print("Enter new email: ");
                String newEmail = SCAN.nextLine();
                user.setEMAIL(newEmail);
                System.out.println("Email updated successfully.");
                break;
            case 3:
                System.out.print("Enter new PIN: ");
                int newPin = SCAN.nextInt();
                user.setPIN(newPin);
                System.out.println("PIN updated successfully.");
                break;
            default:
                System.out.println("Update cancelled.");
        }
    }
}
