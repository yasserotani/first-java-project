
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class InternalPatient extends Patient {

    private ArrayList<InternalTreatment> InternalTreatmentList = new ArrayList<>();
    private ArrayList<OutTreatment> OutTreatmentList = new ArrayList<>();
    private boolean isDischarge;
    private LocalDate dischargeDate = LocalDate.MAX;
    protected LocalDate enterDate = LocalDate.MAX;


    public static ArrayList<InternalPatient> ipList = new ArrayList<>();

    public InternalPatient() {
        super();
    }

    public InternalPatient(String patientName, String patientAdress, String patientBirthDate, boolean isDischarge , String enterDate) {
        super(patientAdress, patientBirthDate, patientName);
        if (isDischarge) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter  discharge Date in this form (yyyy-mm-dd)  example (2000-01-01) ");
            this.dischargeDate = LocalDate.parse(scan.next());
        }
        this.isDischarge = isDischarge;
        this.enterDate = LocalDate.parse(enterDate);
        InternalPatient.ipList.add(this);
    }

    public ArrayList<InternalTreatment> getInternalTreatmentList() {
        return InternalTreatmentList;
    }

    public void setInternalTreatmentList(ArrayList<InternalTreatment> InternalTreatmentList) {
        this.InternalTreatmentList = InternalTreatmentList;
    }

    public ArrayList<OutTreatment> getOutTreatmentList() {
        return OutTreatmentList;
    }

    public void setOutTreatmentList(ArrayList<OutTreatment> OutTreatmentList) {
        this.OutTreatmentList = OutTreatmentList;
    }

    public boolean isIsDischarge() {
        return isDischarge;
    }

    public void setIsDischarge(boolean isDischarge) {
        this.isDischarge = isDischarge;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public boolean isDischarge() {
        return isDischarge;
    }

    public void setDischarge(boolean isDischarge) {
        this.isDischarge = isDischarge;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }

    public static ArrayList<InternalPatient> getIpList() {
        return ipList;
    }

    public static void setIpList(ArrayList<InternalPatient> ipList) {
        InternalPatient.ipList = ipList;
    }

    // add out treatment
    public OutTreatment addOutTreatment() {
        OutTreatment outTreatment = new OutTreatment();
        Scanner scan = new Scanner(System.in);

        System.out.println("enter Treatment Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        outTreatment.setTreatmentDate(LocalDate.parse(scan.next()));

        System.out.println("enter treatment cost");
        outTreatment.treatmentCost = scan.nextFloat();

        System.out.println("Enter clinic number ");
        outTreatment.treatmentNumber = scan.nextInt();

        System.out.println("Enter doctor name ");
        for (Doctor d : Doctor.dList) {
            if (d.doctorName.equals(scan.next())) {
                outTreatment.setTreatmentDoctor(d);

                // check of doctor treatment is contracted to add the treatment 
                for (ContractedDoctor cd : ContractedDoctor.cdList) {
                    if (cd.equals(d)) {
                        cd.doctorTreatment.add(outTreatment);
                    }
                }
                break;
            } else {
                System.out.println("doctor not found");
            }
        }
        this.OutTreatmentList.add(outTreatment);
        return outTreatment;
    }

    // add internal treatment
    public InternalTreatment addIntrnalTreatment() {
        InternalTreatment internalTreatment = new InternalTreatment();
        Scanner scan = new Scanner(System.in);

        System.out.println("enter Treatment Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        internalTreatment.setTreatmentDate(LocalDate.parse(scan.next()));

        System.out.println("enter treatment cost");
        internalTreatment.treatmentCost = scan.nextFloat();

        System.out.println("Enter department number ");
        internalTreatment.setDepartmentNumber(scan.nextInt());

        boolean addMoreDoctors = true;
        while (addMoreDoctors) {
            System.out.println("Enter 1 to add a treatment doctor\nEnter 2 to end:");
            int choice = scan.nextInt();
            switch (choice) {
                case 2:
                    addMoreDoctors = false;
                    break;

                case 1:
                    System.out.println("Enter doctor name:");
                    String doctorName = scan.next();
                    Doctor doctor = Doctor.findDoctorByName(doctorName);
                    if (doctor != null) {
                        internalTreatment.getDoctorsList().add(doctor);
                        
                        // check to add treatment to contracted doctor
                        for (ContractedDoctor cd : ContractedDoctor.cdList) {
                            if (cd.equals(cd)) {
                                cd.doctorTreatment.add(internalTreatment);
                            }
                        }
                        
                        System.out.println("Doctor added successfully.");
                    }
                    else {
                        System.out.println("Doctor not found.");
                    }   break;

                default:
                    System.out.println("Wrong number !");
                    break;
            }
        }

        this.InternalTreatmentList.add(internalTreatment);
        return internalTreatment;
    }

    // add Internal Patient
    public static InternalPatient addInternalPatient() {
        InternalPatient patient = new InternalPatient();
        Scanner scan = new Scanner(System.in);

        System.out.println("enter patient name ");
        patient.patientName = scan.next();

        System.out.println("enter patient Adress ");
        patient.patientAdress = scan.next();

        System.out.println("enter patient Birth Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        patient.patientBirthDate = LocalDate.parse(scan.next());
        
        System.out.println("Enter 1 if the patient is discharge from the hospital \n Enter 2 if is not discharged to the hospital");
        int a = scan.nextInt();
        switch (a) {
            case 1:
                patient.isDischarge = true;
                System.out.println("enter discharge date in this form (yyyy-mm-dd)  example (2000-01-01) ");
                patient.dischargeDate = LocalDate.parse(scan.next());
                break;
            case 2:
                patient.isDischarge = false;
                break;
            default:
                System.out.println(" wrong number");
                break;
        }
        System.out.println("enter patient entry date in this form (yyyy-mm-dd)  example (2000-01-01) ");
        patient.enterDate = LocalDate.parse(scan.next());

        InternalPatient.ipList.add(patient);
        Patient.pList.add(patient);
        return patient;
    }
    public void printAllTreatment(){
        System.out.println("---------- internal treatment for Patent: " + this.patientName + "----------");
        System.out.println(this.InternalTreatmentList);
        System.out.println("---------- outer treatment for Patent: " + this.patientName + "----------");
        System.out.println(this.OutTreatmentList);
    }

    @Override
    public String toString() {
        return "InternalPatient{ "
                + "InternalTreatmentList=" + InternalTreatmentList
                + "\n, OutTreatmentList=" + OutTreatmentList
                + "\n, isDischarge=" + isDischarge
                + "\n, dischargeDate=" + dischargeDate
                + "\n, patientNumber=" + patientNumber
                + "\n, patientName='" + patientName + '\''
                + "\n, patientAdress='" + patientAdress + '\''
                + "\n, patientBirthDate=" + patientBirthDate
                + "\n}";
    }
}
