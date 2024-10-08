
public class OutTreatment extends Treatment{

    private int clinicNumber;
    private Doctor treatmentDoctor;


    public OutTreatment() {
        super();
    }
    public OutTreatment( String treatmentDate,float treatmentCost,int clinicNumber, Doctor treatmentDoctor) {
        super( treatmentDate, treatmentCost);
        this.clinicNumber = clinicNumber;
        this.treatmentDoctor = treatmentDoctor;
        for (ContractedDoctor d : ContractedDoctor.cdList) {
            if ( d.equals(treatmentDoctor)) {
                d.doctorTreatment.add(this);
            }
        }
    }

    public int getClinicNumber() {
        return this.clinicNumber;
    }

    public void setClinicNumber(int clinicNumber) {
        this.clinicNumber = clinicNumber;
    }

    public Doctor getTreatmentDoctor() {
        return this.treatmentDoctor;
    }

    public void setTreatmentDoctor(Doctor treatmentDoctor) {
        this.treatmentDoctor = treatmentDoctor;
    }
    @Override
    public String toString() {
        return "OutTreatment{" +
                "\nclinicNumber=" + clinicNumber +
                "\n, treatmentDoctor=" + treatmentDoctor +
                "\n, treatmentNumber=" + treatmentNumber +
                "\n, treatmentDate=" + treatmentDate +
                "\n, treatmentCost=" + treatmentCost +
                '}';
    }
}
