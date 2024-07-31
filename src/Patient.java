
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Patient {

    protected int patientNumber;
    protected String patientName;
    protected String patientAdress;
    protected LocalDate patientBirthDate;
    protected LocalDate removeDate = LocalDate.MAX;
    protected boolean isRemoved = false;
    protected static int count = 0;
    public static ArrayList<Patient> pList = new ArrayList<>();

    public Patient() {
        Patient.count++;
        this.patientNumber = Patient.count;
    }

    public Patient(String patientAdress, String patientBirthDate, String patientName) {
        this.patientAdress = patientAdress;
        this.patientBirthDate = LocalDate.parse(patientBirthDate);
        this.patientName = patientName;

        Patient.count++;
        this.patientNumber = Patient.count;
        Patient.pList.add(this);

    }

    // date in LocalDate 
    public Patient(String patientAdress, LocalDate patientBirthDate, String patientName) {
        this.patientAdress = patientAdress;
        this.patientBirthDate = patientBirthDate;
        this.patientName = patientName;
        Patient.count++;
        this.patientNumber = Patient.count;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    // public void setPatientNumber(int patientNumber) {
    //     this.patientNumber = patientNumber;
    // }
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAdress() {
        return patientAdress;
    }

    public void setPatientAdress(String patientAdress) {
        this.patientAdress = patientAdress;
    }

    public LocalDate getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(LocalDate patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }

    public LocalDate getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(LocalDate removeDate) {
        this.removeDate = removeDate;
    }

    public static ArrayList<Patient> getpList() {
        return pList;
    }

    public static void setpList(ArrayList<Patient> pList) {
        Patient.pList = pList;
    }

    // remove Patient
    public static void removePatient(Patient patient) {
        Patient.pList.remove(patient);
        patient.removeDate = LocalDate.now();
        patient.isRemoved = true;
        // if (patient instanceof InternalPatient) {
        //     InternalPatient.ipList.remove(patient);
        // }
        // if (patient instanceof OutPatient) {
        //     InternalPatient.ipList.remove(patient);
        // }
    }

    // remove Patient By name
    public static void removePatientByName(String patient) {
        // Patient.dList.removeIf(d -> d.PatientName.equals(Patient));
        Patient p = findPatientByName(patient);
        if (p != null) {
            removePatient(p);
        }
        
    }

    // find patient by name
    public static Patient findPatientByName(String patientName) {
        for (Patient patient : Patient.pList) {
            if (patient.getPatientName().equals(patientName)) {
                return patient;
            }
        }
        return null;
    }

    // remove Doctor By Number
    public static void removePatientByNumber(int PatientNumber) {
        // Patient.dList.removeIf(d -> d.PatientName.equals(PatientNumber));
        Patient d = findPatientByNumber(PatientNumber);
        if (d != null) {
            removePatient(d);
        }
    }

// find Doctor By Number
    public static Patient findPatientByNumber(int patientNumber) {
        for (Patient Patient : Patient.pList) {
            if (Patient.getPatientNumber() == patientNumber) {
                return Patient;
            }
        }
        return null;
    }

    // add patient
    public static Patient addPatient() {
        Patient patient = new Patient();
        Scanner scan = new Scanner(System.in);
        System.out.println("enter patient name ");
        patient.patientName = scan.next();

        System.out.println("enter patient Adress ");
        patient.patientAdress = scan.next();

        System.out.println("enter patient Birth Date in this form (yyyy-mm-dd) \n example (2000-01-01) ");
        patient.patientBirthDate = LocalDate.parse(scan.next());

        return patient;
    }

    // get doctors in certain period
    public static ArrayList<Patient> getPatientsInCertainTerm(String startTerm, String endTerm) {

        LocalDate startDate = LocalDate.parse(startTerm);
        LocalDate endDate = LocalDate.parse(endTerm);
        ArrayList<Patient> countPatient = new ArrayList<>();

        // to get Out Patient (using Enter Date as start)
        for (OutPatient d : OutPatient.opList) {
            if (d.getEnterDate().isBefore(endDate)) {
                if (d.removeDate.isAfter(startDate) || d.removeDate.equals(LocalDate.MAX)) {
                    countPatient.add(d);
                }
            }
        }

        // to get Internal Patient (using Enter Date as start and discharge date as end)
        for (InternalPatient d : InternalPatient.ipList) {
            if (d.getEnterDate().isBefore(endDate)) {
                if (d.getDischargeDate().isAfter(startDate) || d.getDischargeDate().equals(LocalDate.MAX)) {
                    countPatient.add(d);
                }
            }
        }
        return countPatient;
    }

    @Override
    public String toString() {
        return "Patient{"
                + "\npatientNumber=" + patientNumber
                + "\n, patientName='" + patientName + '\''
                + "\n, patientAdress='" + patientAdress + '\''
                + "\n, patientBirthDate=" + patientBirthDate
                + '}';
    }

}
