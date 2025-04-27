import java.util.*;

// ===== APPOINTMENT CLASS =====
class Appointment {
    String userId;
    String date;
    String time;
    String description;
    Appointment next;

    Appointment(String userId, String date, String time, String description) {
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.description = description;
        this.next = null;
    }
}

// ===== APPOINTMENT MANAGER (Linked List) =====
class AppointmentManager {
    private Appointment head;

    public void addAppointment(String userId, String date, String time, String description) {
        Appointment newAppt = new Appointment(userId, date, time, description);
        if (head == null) {
            head = newAppt;
        } else {
            Appointment temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newAppt;
        }
        System.out.println("✅ Appointment added successfully.");
    }

    public void viewAppointments() {
        if (head == null) {
            System.out.println("❌ No appointments found.");
            return;
        }
        Appointment temp = head;
        while (temp != null) {
            System.out.printf("[%s %s] %s (User: %s)\n", temp.date, temp.time, temp.description, temp.userId);
            temp = temp.next;
        }
    }

    public void updateAppointment(String date, String time, String newDesc) {
        Appointment temp = head;
        while (temp != null) {
            if (temp.date.equals(date) && temp.time.equals(time)) {
                temp.description = newDesc;
                System.out.println("✅ Appointment updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Appointment not found.");
    }

    public void deleteAppointment(String date, String time) {
        if (head == null) {
            System.out.println("❌ No appointments to delete.");
            return;
        }

        if (head.date.equals(date) && head.time.equals(time)) {
            head = head.next;
            System.out.println("✅ Appointment deleted.");
            return;
        }

        Appointment temp = head;
        while (temp.next != null) {
            if (temp.next.date.equals(date) && temp.next.time.equals(time)) {
                temp.next = temp.next.next;
                System.out.println("✅ Appointment deleted.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Appointment not found.");
    }
}

// ===== USER MANAGER (Queue) =====
class UserManager {
    Queue<String> users = new LinkedList<>();

    public void registerUser(String userId) {
        if (users.contains(userId)) {
            System.out.println("⚠️ User already registered.");
        } else {
            users.add(userId);
            System.out.println("✅ User " + userId + " registered successfully.");
        }
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("❌ No users registered.");
        } else {
            System.out.println("👥 Registered Users:");
            for (String user : users) {
                System.out.println("- " + user);
            }
        }
    }
}

// ===== MAIN APP =====
public class QuickFitApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentManager apptManager = new AppointmentManager();
        UserManager userManager = new UserManager();

        int choice;
        do {
            System.out.println("\n=== QuickFit - Appointment Scheduler ===");
            System.out.println("1. Register User");
            System.out.println("2. View Users");
            System.out.println("3. Add Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Update Appointment");
            System.out.println("6. Delete Appointment");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user ID: ");
                    String userId = sc.nextLine();
                    userManager.registerUser(userId);
                    break;

                case 2:
                    userManager.viewUsers();
                    break;

                case 3:
                    System.out.print("User ID: ");
                    String uid = sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Time (HH:MM): ");
                    String time = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    apptManager.addAppointment(uid, date, time, desc);
                    break;

                case 4:
                    apptManager.viewAppointments();
                    break;

                case 5:
                    System.out.print("Enter appointment date to update: ");
                    String updDate = sc.nextLine();
                    System.out.print("Enter appointment time to update: ");
                    String updTime = sc.nextLine();
                    System.out.print("New Description: ");
                    String newDesc = sc.nextLine();
                    apptManager.updateAppointment(updDate, updTime, newDesc);
                    break;

                case 6:
                    System.out.print("Enter appointment date to delete: ");
                    String delDate = sc.nextLine();
                    System.out.print("Enter appointment time to delete: ");
                    String delTime = sc.nextLine();
                    apptManager.deleteAppointment(delDate, delTime);
                    break;

                case 7:
                    System.out.println("👋 Exiting QuickFit. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
