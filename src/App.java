
import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void printAll() {
        System.out.println("-------------- Doctor -------------");
        for (Doctor D : Doctor.dList) {
            if (!D.isRemoved) {
                System.out.println(D.doctorNumber + " " + D.doctorName);
            }
        }

        System.out.println("-------------- ContractedDoctor -------------");
        for (ContractedDoctor D : ContractedDoctor.cdList) {
            if (!D.isRemoved) {
                System.out.println(D.doctorNumber + " " + D.doctorName);
            }
        }

        System.out.println("-------------- InsideDoctor -------------");
        for (InsideDoctor D : InsideDoctor.idList) {
            if (!D.isRemoved) {
                System.out.println(D.doctorNumber + " " + D.doctorName);
            }
        }

        System.out.println("-------------- TraineeDoctor -------------");
        for (TraineeDoctor D : TraineeDoctor.tdList) {
            if (!D.isRemoved) {
                System.out.println(D.doctorNumber + " " + D.doctorName);
            }
        }

        System.out.println("----------------------------------------");

        System.out.println("-------------- patient -------------");
        for (Patient patient : Patient.pList) {
            if (!patient.isRemoved) {
                System.out.println(patient.patientNumber + " " + patient.patientName);
            }
        }
        System.out.println("-------------- Internal Patient -------------");
        for (InternalPatient patient : InternalPatient.ipList) {
            if (!patient.isRemoved) {
                System.out.println(patient.patientNumber + " " + patient.patientName);
            }
        }
        System.out.println("-------------- Out Patient -------------");
        for (OutPatient patient : OutPatient.opList) {
            if (!patient.isRemoved) {
                System.out.println(patient.patientNumber + " " + patient.patientName);
            }
        }
    }

    // add doctor
    public static void addDoctor() {
        System.out.println("press 1 to add inside doctor\npress 2 to add trainee doctor\npress 3 to add contracted doctor ");
        switch (scan.nextInt()) {
            case 1:
                InsideDoctor.addInsideDoctor();
                break;
            case 2:
                TraineeDoctor.addTraineeDoctor();
                break;
            case 3:
                ContractedDoctor.addContractedDoctor();
                break;
            default:
                System.out.println("Wrong number!");
        }
    }

    // remove doctor
    public static void removeDoctor() {
        System.out.println("press 1 to remove doctor by name\n press 2 to remove doctor by number");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("enter the name");
                Doctor.removeDoctorByName(scan.next());
                break;
            case 2:
                System.out.println("enter the number");
                Doctor.removeDoctorByNumber(scan.nextInt());
                break;
            default:
                System.out.println("Wrong number!");
        }
    }

    // convert trainee doctor to inside doctor
    public static void convertToInsideDoctor() {
        System.out.println("press 1 to convert doctor by name\n press 2 to convert doctor by number");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("enter the name");
                TraineeDoctor.findTraineeDoctorByName(scan.next()).convertToInside();
                break;
            case 2:
                System.out.println("enter the number");
                TraineeDoctor.findTraineeDoctorByNumber(scan.nextInt()).convertToInside();
                break;
            default:
                System.out.println("Wrong number!");
        }
    }

    // count contracted doctors
    public static void countContractedDoctors() {
        int count = 0;
        for (ContractedDoctor cd : ContractedDoctor.cdList) {
            if (!cd.isRemoved) {
                count++;
            }
        }
        System.out.println("currently contracted doctros number is : " + count);
    }

    // print Doctors In Certain Time
    public static void printDoctorsInCertainTime() {
        System.out.println("Enter Start date:");
        String start = scan.next();
        System.out.println("Enter end date:");
        String end = scan.next();
        for (Doctor D : Doctor.getDoctorsInCertainTerm(start, end)) {
            System.out.println(D.doctorNumber + " " + D.doctorName);
        }
        // Doctor.getDoctorsInCertainTerm(start, end);
    }

    // add patient
    public static void addPatient() {
        System.out.println("press 1 to add internal patient\npress 2 to add outer patient");
        switch (scan.nextInt()) {
            case 1:
                InternalPatient.addInternalPatient();
                break;
            case 2:
                OutPatient.addOutPatient();
                break;
            default:
                System.out.println("wrong number!");
        }
    }

    // remove patient
    public static void removePatient() {
        System.out.println("press 1 to remove patient by name\n press 2 to remove patient by number");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("enter the name");
                Patient.removePatientByName(scan.next());
                break;
            case 2:
                System.out.println("enter the number");
                Patient.removePatientByNumber(scan.nextInt());
                break;
            default:
                System.out.println("Wrong number!");
        }
    }

    // print Patient In Certain Time
    public static void printPatientsInCertainTime() {
        System.out.println("Enter Start date:");
        String start = scan.next();
        System.out.println("Enter end date:");
        String end = scan.next();
        for (Patient D : Patient.getPatientsInCertainTerm(start, end)) {
            System.out.println(D.patientName + " " + D.patientNumber);
        }
        // Patient.getPatientsInCertainTerm(start, end);
    }

    // count Patient In Certain Time
    public static void countPatientsInCertainTime() {
        System.out.println("Enter Start date:");
        String start = scan.next();
        System.out.println("Enter end date:");
        String end = scan.next();
        System.out.println("Patint number is : " + Patient.getPatientsInCertainTerm(start, end).size());
    }

    public static void main(String[] args) {
        InsideDoctor id1 = new InsideDoctor("c", "c", "1990-12-22", 3, "2020-11-11");
        InsideDoctor id2 = new InsideDoctor("d", "d", "1990-12-22", 3, "2022-11-11");

        TraineeDoctor td1 = new TraineeDoctor("e", "e", "2000-11-11", "2023-06-08");
        TraineeDoctor td2 = new TraineeDoctor("f", "f", "2000-11-11", "2022-06-08");

        ContractedDoctor cd1 = new ContractedDoctor("a", "a", "2000-11-11", "2022-01-01");
        ContractedDoctor cd2 = new ContractedDoctor("b", "b", "2000-11-11", "2024-01-01");

        OutTreatment ot1 = new OutTreatment("2022-01-01", 2000, 2, cd1);
        OutTreatment ot2 = new OutTreatment("2022-01-01", 1000, 2, cd1);

        InternalPatient ip1 = new InternalPatient("q", "q", "1999-11-11", false, "2023-02-02");
        InternalPatient ip2 = new InternalPatient("w", "w", "2000-11-11", false, "2024-02-02");
    

        OutPatient op1 = new OutPatient("r", "r", "1988-12-12", false);
        OutPatient op2 = new OutPatient("t", "t", "1988-12-12", false);
       
        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Print All the doctors and patients in the hospital");
            System.out.println("2. Add a new Doctor");
            System.out.println("3. Remove Doctor");
            System.out.println("4. Convert a trainee To Inside Doctor");
            System.out.println("5. Count how many Contracted Doctors in the hospital");
            System.out.println("6. Print Doctors In Certain Time");
            System.out.println("7. Add Patient");
            System.out.println("8. Remove Patient");
            System.out.println("9. Print Patients In Certain Time");
            System.out.println("10. Count Patients In Certain Time");
            System.out.println("11. Exit");

            try {
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        printAll();
                        break;
                    case 2:
                        addDoctor();
                        break;
                    case 3:
                        removeDoctor();
                        break;
                    case 4:
                        convertToInsideDoctor();
                        break;
                    case 5:
                        countContractedDoctors();
                        break;
                    case 6:
                        printDoctorsInCertainTime();
                        break;
                    case 7:
                        addPatient();
                        break;
                    case 8:
                        removePatient();
                        break;
                    case 9:
                        printPatientsInCertainTime();
                        break;
                    case 10:
                        countPatientsInCertainTime();
                        break;
                    case 11:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scan.next(); // Clear the invalid input
            }
        }

        scan.close();
    }
}

