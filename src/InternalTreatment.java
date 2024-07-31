
import java.util.ArrayList;

public class InternalTreatment extends Treatment {

    private int departmentNumber;
    private ArrayList<Doctor> doctorsList = new ArrayList<>();

    public InternalTreatment() {
        super();
    }

    public InternalTreatment(String treatmentDate, float treatmentCost, int departmentNumber, ArrayList<Doctor> doctorsList) {
        super(treatmentDate, treatmentCost);
        this.departmentNumber = departmentNumber;
        this.doctorsList = doctorsList;

        for (Doctor tD : doctorsList) {
            for (ContractedDoctor d : ContractedDoctor.cdList) {
                if (d.equals(tD)) {
                    d.doctorTreatment.add(this);
                }
            }
        }

    }

    public int getDepartmentNumber() {
        return this.departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public ArrayList<Doctor> getDoctorsList() {
        return  this.doctorsList;
    }

    public void setDoctorsList(ArrayList<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }
    @Override
    public String toString() {
        return "InternalTreatment{" +
                "\ndepartmentNumber=" + departmentNumber +
                "\n, doctorsList=" + doctorsList +
                "\n, treatmentNumber=" + treatmentNumber +
                "\n, treatmentDate=" + treatmentDate +
                "\n, treatmentCost=" + treatmentCost +
                '}';
    }
}
