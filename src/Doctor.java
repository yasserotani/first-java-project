
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctor {

    protected int doctorNumber;
    protected String doctorName;
    protected String doctorAdress;
    protected LocalDate doctorBirthDate;
    protected LocalDate removeDate = LocalDate.MAX;
    protected boolean isRemoved = false;
    protected static int count = 0;
    public static ArrayList<Doctor> dList = new ArrayList<>();

    public Doctor() {
        // check if doctor is not inside or conracted or traniee to give him number

        if (!(this instanceof ContractedDoctor || this instanceof InsideDoctor || this instanceof TraineeDoctor)) {
            Doctor.count++;
            this.doctorNumber = Doctor.count;
        }
    }

    // date in string 
    public Doctor(String doctorAdress, String doctorBirthDate, String doctorName) {
        this.doctorAdress = doctorAdress;
        this.doctorBirthDate = LocalDate.parse(doctorBirthDate);
        this.doctorName = doctorName;

        // check if doctor is not inside or conracted or traniee to give him number
        if (!(this instanceof ContractedDoctor || this instanceof InsideDoctor || this instanceof TraineeDoctor)) {
            Doctor.count++;
            this.doctorNumber = Doctor.count;
        }
        Doctor.dList.add(this);
    }

    //date in LocalDate
    public Doctor(String doctorAdress, LocalDate doctorBirthDate, String doctorName) {
        this.doctorAdress = doctorAdress;
        this.doctorBirthDate = doctorBirthDate;
        this.doctorName = doctorName;
        // this.doctorNumber = Doctor.count;
    }

    public int getDoctorNumber() {
        return doctorNumber;
    }

    // public void setDoctorNumber(int doctorNumber) {
    //     this.doctorNumber = doctorNumber;
    // }
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorAdress() {
        return doctorAdress;
    }

    public void setDoctorAdress(String doctorAdress) {
        this.doctorAdress = doctorAdress;
    }

    public LocalDate getDoctorBirthDate() {
        return doctorBirthDate;
    }

    public void setDoctorBirthDate(LocalDate doctorBirthDate) {
        this.doctorBirthDate = doctorBirthDate;
    }

    // add doctor
    public static Doctor addDoctor() {
        Scanner scan = new Scanner(System.in);
        Doctor doctor = new Doctor();
        System.out.println("enter doctor name: ");
        doctor.doctorName = scan.next();

        System.out.println("enter doctor Address: ");
        doctor.doctorAdress = scan.next();
        System.out.println("enter doctor Birth Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        doctor.doctorBirthDate = LocalDate.parse(scan.next());
        return doctor;
    }

    // remove doctor 
    public static void removeDoctor(Doctor doctor) {
        Doctor.dList.remove(doctor);
        doctor.removeDate = LocalDate.now();
        doctor.isRemoved = true;
    }

    // remove Doctor By Name
    public static void removeDoctorByName(String doctor) {
        // Doctor.dList.removeIf(d -> d.doctorName.equals(doctor));
        Doctor d = findDoctorByName(doctor);
        if (d != null) {
            removeDoctor(d);
        }
    }   
    // find Doctor By Name
    public static Doctor findDoctorByName(String doctorName) {
        for (Doctor doctor : Doctor.dList) {
            if (doctor.getDoctorName().equals(doctorName)) {
                return doctor;
            }
        }
        return null;
    }

    // remove Doctor By Number
    public static void removeDoctorByNumber(int doctorNumber) {
        // Doctor.dList.removeIf(d -> d.doctorName.equals(doctorNumber));
        Doctor d = findDoctorByNumber(doctorNumber);
        if (d != null) {
            removeDoctor(d);
        }
    }   
    
    // find Doctor By Number
    public static Doctor findDoctorByNumber(int Number) {
        for (Doctor doctor : Doctor.dList) {
            if (doctor.getDoctorNumber() == Number) {
                return doctor;
            }
        }
        return null;
    }

    // get doctors in certain period
    public static ArrayList<Doctor> getDoctorsInCertainTerm(String startTerm, String endTerm) {

        LocalDate startDate = LocalDate.parse(startTerm);
        LocalDate endDate = LocalDate.parse(endTerm);
        ArrayList<Doctor> countDoctors = new ArrayList<>();
        // to get contracted doctors (using contract date as start)
        for (ContractedDoctor d : ContractedDoctor.cdList) {
            if (d.getContractDate().isBefore(endDate)) {
                if (d.removeDate.isAfter(startDate) || d.removeDate.equals(LocalDate.MAX)) {
                    countDoctors.add(d);
                }
            }
        }
        // to get trainee doctors (using Start Training Date as start)
        for (TraineeDoctor d : TraineeDoctor.tdList) {
            if (d.getStartTrainingDate().isBefore(endDate)) {
                if (d.removeDate.isAfter(startDate) || d.removeDate.equals(LocalDate.MAX)) {
                    countDoctors.add(d);
                }
            }
        }
        // to get inside doctors (using Start Start Date as start)
        for (InsideDoctor d : InsideDoctor.idList) {
            if (d.getStartDate().isBefore(endDate)) {
                if (d.removeDate.isAfter(startDate) || d.removeDate.equals(LocalDate.MAX)) {
                    countDoctors.add(d);
                }       
            }
        }
        return countDoctors;
    }

    @Override
    public String toString() {
        return "Doctor{"
                + "doctorNumber=" + doctorNumber
                + ", doctorName='" + doctorName + '\''
                + ", doctorAdress='" + doctorAdress + '\''
                + ", doctorBirthDate=" + doctorBirthDate
                + '}'
                + '\n';
    }
}
