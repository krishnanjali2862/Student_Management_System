import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    int age;
    double marks;
    int totalClasses;
    int attendedClasses;
    String username;
    String password;

    Student(int id,
            String name,
            int age,
            double marks,
            int totalClasses,
            int attendedClasses,
            String username,
            String password) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
        this.username = username;
        this.password = password;
    }

    String getGrade() {

        if(marks >= 90)
            return "A";

        else if(marks >= 75)
            return "B";

        else if(marks >= 50)
            return "C";

        else
            return "Fail";
    }

    double getAttendancePercentage() {

        return ((double) attendedClasses / totalClasses) * 100;
    }

    String getStatus() {

        if(marks >= 50)
            return "PASS";

        else
            return "FAIL";
    }

    void display() {

        System.out.println("\n================================");
        System.out.println("ID              : " + id);
        System.out.println("Name            : " + name);
        System.out.println("Age             : " + age);
        System.out.println("Marks           : " + marks);
        System.out.println("Grade           : " + getGrade());
        System.out.println("Status          : " + getStatus());
        System.out.println("Attendance      : "
                + getAttendancePercentage() + "%");
        System.out.println("Username        : " + username);
        System.out.println("================================");
    }
}

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int mainChoice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Register");
            System.out.println("3. Student Login");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch(mainChoice) {

                // ADMIN LOGIN

                case 1:

                    System.out.print("Enter Admin Username: ");
                    String adminUser = sc.nextLine();

                    System.out.print("Enter Admin Password: ");
                    String adminPass = sc.nextLine();

                    if(adminUser.equals("anju")
                            && adminPass.equals("2862")) {

                        System.out.println(
                                "Admin Login Successful!"
                        );

                        int adminChoice;

                        do {

                            System.out.println(
                                    "\n===== ADMIN MENU ====="
                            );

                            System.out.println(
                                    "1. Add Student"
                            );

                            System.out.println(
                                    "2. View All Students"
                            );

                            System.out.println(
                                    "3. Search Student"
                            );

                            System.out.println(
                                    "4. Delete Student"
                            );

                            System.out.println(
                                    "5. Update Student"
                            );

                            System.out.println(
                                    "6. Total Students"
                            );

                            System.out.println(
                                    "7. Logout"
                            );

                            System.out.print(
                                    "Enter your choice: "
                            );

                            adminChoice = sc.nextInt();
                            sc.nextLine();

                            switch(adminChoice) {

                                case 1:

                                    System.out.print("Enter ID: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Enter Name: ");
                                    String name = sc.nextLine();

                                    System.out.print("Enter Age: ");
                                    int age = sc.nextInt();

                                    System.out.print("Enter Marks: ");
                                    double marks = sc.nextDouble();

                                    System.out.print(
                                            "Enter Total Classes: "
                                    );

                                    int totalClasses = sc.nextInt();

                                    System.out.print(
                                            "Enter Attended Classes: "
                                    );

                                    int attendedClasses = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print(
                                            "Create Username: "
                                    );

                                    String username = sc.nextLine();

                                    System.out.print(
                                            "Create Password: "
                                    );

                                    String password = sc.nextLine();

                                    students.add(
                                            new Student(
                                                    id,
                                                    name,
                                                    age,
                                                    marks,
                                                    totalClasses,
                                                    attendedClasses,
                                                    username,
                                                    password
                                            )
                                    );

                                    System.out.println(
                                            "Student Added Successfully!"
                                    );

                                    break;

                                case 2:

                                    if(students.isEmpty()) {

                                        System.out.println(
                                                "No students found."
                                        );
                                    }

                                    else {

                                        for(Student s : students) {

                                            s.display();
                                        }
                                    }

                                    break;

                                case 3:

                                    System.out.print(
                                            "Enter Student ID: "
                                    );

                                    int searchId = sc.nextInt();

                                    boolean found = false;

                                    for(Student s : students) {

                                        if(s.id == searchId) {

                                            s.display();
                                            found = true;
                                            break;
                                        }
                                    }

                                    if(!found) {

                                        System.out.println(
                                                "Student not found."
                                        );
                                    }

                                    break;

                                case 4:

                                    System.out.print(
                                            "Enter Student ID: "
                                    );

                                    int deleteId = sc.nextInt();

                                    boolean removed = false;

                                    for(int i = 0;
                                        i < students.size();
                                        i++) {

                                        if(students.get(i).id
                                                == deleteId) {

                                            students.remove(i);

                                            removed = true;

                                            System.out.println(
                                                    "Student Deleted Successfully!"
                                            );

                                            break;
                                        }
                                    }

                                    if(!removed) {

                                        System.out.println(
                                                "Student not found."
                                        );
                                    }

                                    break;

                                case 5:

                                    System.out.print(
                                            "Enter Student ID: "
                                    );

                                    int updateId = sc.nextInt();
                                    sc.nextLine();

                                    boolean updated = false;

                                    for(Student s : students) {

                                        if(s.id == updateId) {

                                            int adminUpdateChoice;

                                            do {

                                                System.out.println(
                                                        "\n===== ADMIN UPDATE MENU ====="
                                                );

                                                System.out.println(
                                                        "1. Update Name"
                                                );

                                                System.out.println(
                                                        "2. Update Age"
                                                );

                                                System.out.println(
                                                        "3. Update Marks"
                                                );

                                                System.out.println(
                                                        "4. Update Attendance"
                                                );

                                                System.out.println(
                                                        "5. Update Username"
                                                );

                                                System.out.println(
                                                        "6. Update Password"
                                                );

                                                System.out.println(
                                                        "7. Back"
                                                );

                                                System.out.print(
                                                        "Enter your choice: "
                                                );

                                                adminUpdateChoice
                                                        = sc.nextInt();

                                                sc.nextLine();

                                                switch(adminUpdateChoice) {

                                                    case 1:

                                                        System.out.print(
                                                                "Enter New Name: "
                                                        );

                                                        s.name
                                                                = sc.nextLine();

                                                        System.out.println(
                                                                "Name Updated Successfully!"
                                                        );

                                                        break;

                                                    case 2:

                                                        System.out.print(
                                                                "Enter New Age: "
                                                        );

                                                        s.age
                                                                = sc.nextInt();

                                                        System.out.println(
                                                                "Age Updated Successfully!"
                                                        );

                                                        break;

                                                    case 3:

                                                        System.out.print(
                                                                "Enter New Marks: "
                                                        );

                                                        s.marks
                                                                = sc.nextDouble();

                                                        System.out.println(
                                                                "Marks Updated Successfully!"
                                                        );

                                                        break;

                                                    case 4:

                                                        System.out.print(
                                                                "Enter Total Classes: "
                                                        );

                                                        s.totalClasses
                                                                = sc.nextInt();

                                                        System.out.print(
                                                                "Enter Attended Classes: "
                                                        );

                                                        s.attendedClasses
                                                                = sc.nextInt();

                                                        System.out.println(
                                                                "Attendance Updated Successfully!"
                                                        );

                                                        break;

                                                    case 5:

                                                        System.out.print(
                                                                "Enter New Username: "
                                                        );

                                                        s.username
                                                                = sc.nextLine();

                                                        System.out.println(
                                                                "Username Updated Successfully!"
                                                        );

                                                        break;

                                                    case 6:

                                                        System.out.print(
                                                                "Enter New Password: "
                                                        );

                                                        s.password
                                                                = sc.nextLine();

                                                        System.out.println(
                                                                "Password Updated Successfully!"
                                                        );

                                                        break;

                                                    case 7:

                                                        System.out.println(
                                                                "Returning..."
                                                        );

                                                        break;

                                                    default:

                                                        System.out.println(
                                                                "Invalid choice."
                                                        );
                                                }

                                            } while(adminUpdateChoice != 7);

                                            updated = true;
                                            break;
                                        }
                                    }

                                    if(!updated) {

                                        System.out.println(
                                                "Student not found."
                                        );
                                    }

                                    break;

                                case 6:

                                    System.out.println(
                                            "Total Students = "
                                            + students.size()
                                    );

                                    break;

                                case 7:

                                    System.out.println(
                                            "Admin Logout Successful."
                                    );

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid choice."
                                    );
                            }

                        } while(adminChoice != 7);
                    }

                    else {

                        System.out.println(
                                "Invalid Admin Login!"
                        );
                    }

                    break;

                // STUDENT REGISTER

                case 2:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.print(
                            "Enter Total Classes: "
                    );

                    int totalClasses = sc.nextInt();

                    System.out.print(
                            "Enter Attended Classes: "
                    );

                    int attendedClasses = sc.nextInt();
                    sc.nextLine();

                    System.out.print(
                            "Create Username: "
                    );

                    String username = sc.nextLine();

                    System.out.print(
                            "Create Password: "
                    );

                    String password = sc.nextLine();

                    students.add(
                            new Student(
                                    id,
                                    name,
                                    age,
                                    marks,
                                    totalClasses,
                                    attendedClasses,
                                    username,
                                    password
                            )
                    );

                    System.out.println(
                            "Registration Successful!"
                    );

                    break;

                // STUDENT LOGIN

                case 3:

                    System.out.print("Enter Username: ");
                    String loginUser = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPass = sc.nextLine();

                    Student loggedInStudent = null;

                    for(Student s : students) {

                        if(s.username.equals(loginUser)
                                && s.password.equals(loginPass)) {

                            loggedInStudent = s;
                            break;
                        }
                    }

                    if(loggedInStudent != null) {

                        System.out.println(
                                "Student Login Successful!"
                        );

                        int studentChoice;

                        do {

                            System.out.println(
                                    "\n===== STUDENT MENU ====="
                            );

                            System.out.println(
                                    "1. View My Details"
                            );

                            System.out.println(
                                    "2. Update My Details"
                            );

                            System.out.println(
                                    "3. Logout"
                            );

                            System.out.print(
                                    "Enter your choice: "
                            );

                            studentChoice = sc.nextInt();
                            sc.nextLine();

                            switch(studentChoice) {

                                case 1:

                                    loggedInStudent.display();
                                    break;

                                case 2:

                                    int updateChoice;

                                    do {

                                        System.out.println(
                                                "\n===== UPDATE MENU ====="
                                        );

                                        System.out.println(
                                                "1. Update Name"
                                        );

                                        System.out.println(
                                                "2. Update Age"
                                        );

                                        System.out.println(
                                                "3. Update Marks"
                                        );

                                        System.out.println(
                                                "4. Update Attendance"
                                        );

                                        System.out.println(
                                                "5. Update Password"
                                        );

                                        System.out.println(
                                                "6. Back"
                                        );

                                        System.out.print(
                                                "Enter your choice: "
                                        );

                                        updateChoice = sc.nextInt();
                                        sc.nextLine();

                                        switch(updateChoice) {

                                            case 1:

                                                System.out.print(
                                                        "Enter New Name: "
                                                );

                                                loggedInStudent.name
                                                        = sc.nextLine();

                                                System.out.println(
                                                        "Name Updated Successfully!"
                                                );

                                                break;

                                            case 2:

                                                System.out.print(
                                                        "Enter New Age: "
                                                );

                                                loggedInStudent.age
                                                        = sc.nextInt();

                                                System.out.println(
                                                        "Age Updated Successfully!"
                                                );

                                                break;

                                            case 3:

                                                System.out.print(
                                                        "Enter New Marks: "
                                                );

                                                loggedInStudent.marks
                                                        = sc.nextDouble();

                                                System.out.println(
                                                        "Marks Updated Successfully!"
                                                );

                                                break;

                                            case 4:

                                                System.out.print(
                                                        "Enter Total Classes: "
                                                );

                                                loggedInStudent.totalClasses
                                                        = sc.nextInt();

                                                System.out.print(
                                                        "Enter Attended Classes: "
                                                );

                                                loggedInStudent.attendedClasses
                                                        = sc.nextInt();

                                                System.out.println(
                                                        "Attendance Updated Successfully!"
                                                );

                                                break;

                                            case 5:

                                                System.out.print(
                                                        "Enter New Password: "
                                                );

                                                loggedInStudent.password
                                                        = sc.nextLine();

                                                System.out.println(
                                                        "Password Updated Successfully!"
                                                );

                                                break;

                                            case 6:

                                                System.out.println(
                                                        "Returning..."
                                                );

                                                break;

                                            default:

                                                System.out.println(
                                                        "Invalid choice."
                                                );
                                        }

                                    } while(updateChoice != 6);

                                    break;

                                case 3:

                                    System.out.println(
                                            "Student Logout Successful."
                                    );

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid choice."
                                    );
                            }

                        } while(studentChoice != 3);
                    }

                    else {

                        System.out.println(
                                "Invalid Student Login!"
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                            "Exiting Program..."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while(mainChoice != 4);

        sc.close();
    }
}