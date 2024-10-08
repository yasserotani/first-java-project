
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ContractedDoctor extends Doctor {

    private LocalDate contractDate;
    protected float contractedDoctorSalary;
    protected ArrayList<Treatment> doctorTreatment = new ArrayList<>();
    public static ArrayList<ContractedDoctor> cdList = new ArrayList<>();

    public ContractedDoctor() {
        this.doctorNumber = Doctor.count;
        Doctor.count++;
    }

    public ContractedDoctor(String doctorName, String doctorAdress, String doctorBirthDate, String contractDate) {
        super(doctorAdress, doctorBirthDate, doctorName);
        this.contractDate = LocalDate.parse(contractDate);

        Doctor.count++;
        this.doctorNumber = Doctor.count;
        cdList.add(this);
    }

    public float getContractedDoctorSalary() {

        for (Treatment t : this.doctorTreatment) {
            contractedDoctorSalary = contractedDoctorSalary + (t.treatmentCost / 2);
        }

        return contractedDoctorSalary;
    }

    // public void setContractedDoctorSalary(float contractedDoctorSalary) {
    //     this.contractedDoctorSalary = contractedDoctorSalary;
    // }
    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public static ContractedDoctor addContractedDoctor() {
        Scanner scan = new Scanner(System.in);
        ContractedDoctor contractedDoctor = new ContractedDoctor();
        System.out.println("enter name: ");
        contractedDoctor.doctorName = scan.next();

        System.out.println("enter doctorAdress: ");
        contractedDoctor.doctorAdress = scan.next();

        System.out.println("enter doctor Birth Date in this form (yyyy-mm-dd) \n example (2024-05-02) ");
        contractedDoctor.doctorBirthDate = LocalDate.parse(scan.next());

        System.out.println("enter doctor contract Date in this form (yyyy-mm-dd) \n example (2024-05-02) ");
        contractedDoctor.contractDate = LocalDate.parse(scan.next());

        cdList.add(contractedDoctor);
        dList.add(contractedDoctor);

        return contractedDoctor;
    }

    // public static void removeDoctor(ContractedDoctor doctor) {
    //     ContractedDoctor.cdList.remove(doctor);
    //     Doctor.dList.remove(doctor);
    //     doctor.removeDate = LocalDate.now();

    // }

    // public static void removeDoctorByName(String doctor) {
    //     for (ContractedDoctor d : cdList) {
    //         if (d.doctorName.equals(doctor)) {
    //             // ContractedDoctor.removeDoctor(d);
    //             ContractedDoctor.cdList.remove(d);
    //             Doctor.dList.remove(d);
    //         }
    //     }

    // }

    @Override
    public String toString() {

        return "ContractedDoctor{"
                + "doctorNumber=" + doctorNumber
                + ", doctorName='" + doctorName + '\''
                + ", doctorAdress='" + doctorAdress + '\''
                + ", doctorBirthDate=" + doctorBirthDate
                + ", contractDate=" + contractDate
                + "contractedDoctorSalary=" + getContractedDoctorSalary()
                + '}'
                + '\n';
    }
}
