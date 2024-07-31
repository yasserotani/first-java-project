
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class OutPatient extends Patient {

    private ArrayList<OutTreatment> OutTreatmentList = new ArrayList<>();
    private boolean isAccepted;
    private LocalDate acceptDate;
    protected LocalDate enterDate = LocalDate.MAX;

    public static ArrayList<OutPatient> opList = new ArrayList<>();

    public OutPatient() {
        super();
    }
    // date in String
    public OutPatient(String patientName, String patientAdress, LocalDate patientBirthDate, boolean isAccepted , String enterDate) {
        super(patientAdress, patientBirthDate, patientName);
        
        if (isAccepted) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter  accept Date in this form (yyyy-mm-dd)  example (2000-01-01) ");
            this.acceptDate = LocalDate.parse(scan.next());
        }
        
        this.isAccepted = isAccepted;
        this.enterDate = LocalDate.parse(enterDate);
        OutPatient.opList.add(this);
    }

    // date in LocalDate
    public OutPatient(String patientName, String patientAdress, String patientBirthDate, boolean isAccepted) {
        super(patientAdress, patientBirthDate, patientName);
        
        if (isAccepted) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter  accept Date to patient '"+ this.patientName +"' in this form (yyyy-mm-dd)  example (2000-01-01) ");
            this.acceptDate = LocalDate.parse(scan.next());
        }

        this.isAccepted = isAccepted;
        this.enterDate = LocalDate.now();
        OutPatient.opList.add(this);
    }

    public ArrayList<OutTreatment> getOutTreatmentList() {
        return OutTreatmentList;
    }

    public void setOutTreatmentList(ArrayList<OutTreatment> OutTreatmentList) {
        this.OutTreatmentList = OutTreatmentList;
    }

    public boolean isIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public LocalDate getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(LocalDate acceptDate) {
        this.acceptDate = acceptDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }

    public static ArrayList<OutPatient> getOpList() {
        return opList;
    }

    public static void setOpList(ArrayList<OutPatient> opList) {
        OutPatient.opList = opList;
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
        outTreatment.setClinicNumber(scan.nextInt());

        System.out.println("Enter doctor name ");
        for (Doctor d : Doctor.dList) {
            if (d.doctorName.equals(scan.next())) {
                outTreatment.setTreatmentDoctor(d);

                // check of doctor treatment is contracted to add the treatment 
                for (ContractedDoctor cd : ContractedDoctor.cdList) {
                    if (cd.equals(d)) {
                        cd.doctorTreatment.add(outTreatment);
                    }
                    break;
                }
                break;
            }
        }
        this.OutTreatmentList.add(outTreatment);
        return outTreatment;
    }

    // add pateint
    public static OutPatient addOutPatient() {
        OutPatient patient = new OutPatient();
        Scanner scan = new Scanner(System.in);

        System.out.println("enter patient name ");
        patient.patientName = scan.next();

        System.out.println("enter patient Adress ");
        patient.patientAdress = scan.next();

        System.out.println("Enter patient Birth Date in this form (yyyy-mm-dd) example (2000-01-01) ");
        patient.patientBirthDate = LocalDate.parse(scan.next());

        System.out.println("Enter 1 if the patient is accepted to the hospital \n Enter 2 if is not accepted to the hospital");
        int a = scan.nextInt();
        switch (a) {
            case 1:
                patient.isAccepted = true;
                System.out.println("enter  accept Date in this form (yyyy-mm-dd)  example (2000-01-01) ");
                patient.acceptDate = LocalDate.parse(scan.next());
                break;
            case 2:
                patient.isAccepted = false;
                break;
            default:
                System.out.println(" wrong number");
                break;
        }

        System.out.println("enter patient entry date in this form (yyyy-mm-dd)  example (2000-01-01) ");
        patient.enterDate = LocalDate.parse(scan.next());
        
        OutPatient.opList.add(patient);
        Patient.pList.add(patient);
        return patient;

    }
    public void printAllTreatment(){
        System.out.println("---------- outer treatment for Patent: " + this.patientName + "----------");
        System.out.println(this.OutTreatmentList);
    }
    @Override
    public String toString() {
        return "OutPatient{" +
                "\nOutTreatmentList=" + OutTreatmentList +
                "\n, isAccepted=" + isAccepted +
                "\n, acceptDate=" + acceptDate +
                "\n, patientNumber=" + patientNumber +
                "\n, patientName='" + patientName + '\'' +
                "\n, patientAdress='" + patientAdress + '\'' +
                "\n, patientBirthDate=" + patientBirthDate +
                '}';
    }
}
