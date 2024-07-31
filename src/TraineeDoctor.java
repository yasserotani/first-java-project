
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class TraineeDoctor extends Doctor {

    private float traineeDoctorSalary;
    private LocalDate startTrainingDate;
    private LocalDate endTrainingDate;
    public static ArrayList<TraineeDoctor> tdList = new ArrayList<>();
    private boolean isMoved = false;

    private LocalDate now = LocalDate.now();

    public TraineeDoctor() {
        Doctor.count++;
        this.doctorNumber = Doctor.count;
    }

    public TraineeDoctor(String doctorName, String doctorAdress, String doctorBirthDate, String startTrainingDate) {
        super(doctorAdress, doctorBirthDate, doctorName);
        this.startTrainingDate = LocalDate.parse(startTrainingDate);
        this.endTrainingDate = this.startTrainingDate.plusYears(2);

        // check if he has been more than 2 years move to inside doctor 
        if (this.now.isAfter(this.endTrainingDate)) {
            Doctor.dList.remove(this);
            InsideDoctor d = new InsideDoctor(this.doctorName, this.doctorAdress, doctorBirthDate, this.startTrainingDate);
            tdList.add(this);
            this.doctorNumber = Doctor.count;
            Doctor.count++;
            this.isMoved = true;
        } else {
            Doctor.count++;
            this.doctorNumber = Doctor.count;
            tdList.add(this);
        }
    }

    public float getTraineeDoctorSalary() {
        long diffrent = ChronoUnit.YEARS.between(this.startTrainingDate, this.now);
        if (diffrent <= 1) {
            traineeDoctorSalary = InsideDoctor.insideDoctorSalary / 2;
        } else if (diffrent < 2) {
            traineeDoctorSalary = (3 * InsideDoctor.insideDoctorSalary) / 4;
        } else {
            traineeDoctorSalary = InsideDoctor.insideDoctorSalary;
        }
        return traineeDoctorSalary;
    }

    // public void setTraineeDoctorSalary(float traineeDoctorSalary) {
    //     this.traineeDoctorSalary = traineeDoctorSalary;
    // }
    public LocalDate getStartTrainingDate() {
        return startTrainingDate;
    }

    public void setStartTrainingDate(LocalDate startTrainingDate) {
        this.startTrainingDate = startTrainingDate;
    }

    public LocalDate getEndTrainingDate() {
        return startTrainingDate.plusYears(2);
    }

    public void setEndTrainingDate(LocalDate endTrainingDate) {
        this.endTrainingDate = endTrainingDate;
    }

    public static TraineeDoctor addTraineeDoctor() {
        LocalDate now = LocalDate.now();
        Scanner scan = new Scanner(System.in);
        TraineeDoctor traineeDoctor = new TraineeDoctor();

        System.out.println("enter doctor name: ");
        traineeDoctor.doctorName = scan.next();

        System.out.println("enter doctor Address: ");
        traineeDoctor.doctorAdress = scan.next();

        System.out.println("enter doctor Birth Date in this form (yyyy-mm-dd) \t example (2000-01-01) ");
        String birth = scan.next();
        traineeDoctor.doctorBirthDate = LocalDate.parse(birth);

        System.out.println("enter doctor Start Training Date in this form (yyyy-mm-dd) \t example (2000-01-01) ");
        traineeDoctor.startTrainingDate = LocalDate.parse(scan.next());

        // to add inside doctor salary  if there is no 
        if (InsideDoctor.insideDoctorSalary == 0) {
            System.out.println("enter internal doctor salary");
            InsideDoctor.setInsideDoctorSalary(scan.nextFloat());
        }

        // if more than 2 years add to inside doctor
        long diffrent = ChronoUnit.YEARS.between(traineeDoctor.startTrainingDate, now);
        if (diffrent >= 2) {
            Doctor.count--;
            InsideDoctor d = new InsideDoctor(traineeDoctor.doctorName, traineeDoctor.doctorAdress, birth, traineeDoctor.startTrainingDate);
            traineeDoctor.isMoved = true;
        }
        tdList.add(traineeDoctor);
        dList.add(traineeDoctor);
        return traineeDoctor;
    }

    // convert to inside doctor method 
    public void convertToInside() {
        Scanner scan = new Scanner(System.in);
        if (this.isMoved) {
            System.out.println("doctor: '" + this.doctorName + "' is already moved");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("enter department number to convert doctor: '" + this.doctorName + "' to it");
            InsideDoctor d = new InsideDoctor(this.doctorName, this.doctorAdress, this.doctorBirthDate, scan.nextInt(), this.doctorNumber, this.startTrainingDate);
            TraineeDoctor.tdList.remove(this);
            System.out.println("doctor: '" + this.doctorName + "' is successfully moved");

        }

        // if (tdList.removeIf(num-> scan.next().equals(this.doctorName))) {
        // }
    }

    // find Trainee Doctor By Name
    public static TraineeDoctor findTraineeDoctorByName(String doctorName) {
        for (TraineeDoctor doctor : TraineeDoctor.tdList) {
            if (doctor.getDoctorName().equals(doctorName)) {
                return doctor;
            }
        }
        return null;
    }

    // find Trainee Doctor By Number
    public static TraineeDoctor findTraineeDoctorByNumber(int Number) {
        for (TraineeDoctor doctor : TraineeDoctor.tdList) {
            if (doctor.getDoctorNumber() == Number) {
                return doctor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TraineeDoctor{"
                + "doctorNumber=" + doctorNumber
                + ", doctorName='" + doctorName + '\''
                + ", doctorAdress='" + doctorAdress + '\''
                + ", doctorBirthDate=" + doctorBirthDate
                + ", traineeDoctorSalary=" + getTraineeDoctorSalary()
                + ", startTrainingDate=" + startTrainingDate
                + ", endTrainingDate=" + getEndTrainingDate()
                + '}'
                + '\n';
    }
}
