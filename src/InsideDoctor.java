
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class InsideDoctor extends Doctor {

    private int departmentNumber;
    protected static float insideDoctorSalary = 0;
    private LocalDate startDate = LocalDate.MAX;
    public static ArrayList<InsideDoctor> idList = new ArrayList<>();

    public InsideDoctor() {
        Doctor.count++;
        this.doctorNumber = Doctor.count;
    }

    // default contructor
    public InsideDoctor(String doctorName, String doctorAdress, String doctorBirthDate, int departmentNumber , String startDate) {
        super(doctorAdress, doctorBirthDate, doctorName);
        this.departmentNumber = departmentNumber;
        Scanner scan = new Scanner(System.in);

        // if (InsideDoctor.insideDoctorSalary == 0) {
        //     System.out.println("enter internal doctor salary");
        //     InsideDoctor.setInsideDoctorSalary(scan.nextFloat());
        // }        

        this.startDate = LocalDate.parse(startDate);
        Doctor.count++;
        this.doctorNumber = Doctor.count;
        idList.add(this);
    }

    // to move trainee doctor auto 
    public InsideDoctor(String doctorName, String doctorAdress, String doctorBirthDate , LocalDate startDate) {
        super(doctorAdress, doctorBirthDate, doctorName);
        this.startDate = startDate;

        Doctor.count++;
        this.doctorNumber = Doctor.count;

        idList.add(this);

    }

    // to move trainee doctor manually
    public InsideDoctor(String doctorName, String doctorAdress, LocalDate doctorBirthDate, int departmentNumber, int doctorNumber , LocalDate startDate) {
        super(doctorAdress, doctorBirthDate, doctorName);
        this.departmentNumber = departmentNumber;
        this.doctorNumber = Doctor.count;
        this.startDate = startDate;

        Doctor.count++;
        this.doctorNumber = doctorNumber;

        idList.add(this);
    }

    public static float getInsideDoctorSalary() {
        return insideDoctorSalary;
    }

    public static void setInsideDoctorSalary(float insideDoctorSalary) {
        InsideDoctor.insideDoctorSalary = insideDoctorSalary;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public static ArrayList<InsideDoctor> getIdList() {
        return idList;
    }

    public static void setIdList(ArrayList<InsideDoctor> idList) {
        InsideDoctor.idList = idList;
    }

    public static InsideDoctor addInsideDoctor() {
        Scanner scan = new Scanner(System.in);
        InsideDoctor insideDoctor = new InsideDoctor();
        System.out.println("enter doctor name: ");
        insideDoctor.doctorName = scan.next();

        System.out.println("enter doctor Address: ");
        insideDoctor.doctorAdress = scan.next();

        System.out.println("enter doctor Birth Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        insideDoctor.doctorBirthDate = LocalDate.parse(scan.next());

        if (InsideDoctor.insideDoctorSalary == 0) {
            System.out.println("enter internal doctor salary");
            InsideDoctor.setInsideDoctorSalary(scan.nextFloat());
        }

        System.out.println(" enter department Number");
        insideDoctor.departmentNumber = scan.nextInt();

        System.out.println("enter start Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        insideDoctor.startDate = LocalDate.parse(scan.next());

        dList.add(insideDoctor);
        idList.add(insideDoctor);

        return insideDoctor;
    }

    @Override
    public String toString() {
        return "InsideDoctor{"
                + "doctorNumber=" + doctorNumber
                + ", doctorName='" + doctorName + '\''
                + ", doctorAdress='" + doctorAdress + '\''
                + ", doctorBirthDate=" + doctorBirthDate
                + ", departmentNumber=" + departmentNumber
                + ", insideDoctorSalary=" + insideDoctorSalary
                + '}'
                + '\n';
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
