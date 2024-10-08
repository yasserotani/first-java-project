
import java.time.LocalDate;


public class Treatment {

    protected int treatmentNumber;
    protected LocalDate treatmentDate;
    protected float  treatmentCost ;
    protected static int count = 0;

    public Treatment() {
        Treatment.count++;
        this.treatmentNumber = Treatment.count;
    }

    public Treatment( String treatmentDate, float treatmentCost) {
        this.treatmentDate = LocalDate.parse(treatmentDate);
        this.treatmentCost = treatmentCost;

        Treatment.count++;
        this.treatmentNumber = Treatment.count;

    }

    public int getTreatmentNumber() {
        return treatmentNumber;
    }

    public void setTreatmentNumber(int treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }

    public LocalDate getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public float gettreatmentCost() {
        return treatmentCost;
    }

    public void settreatmentCost(float treatmentCost) {
        this.treatmentCost = treatmentCost;
    }
    @Override
    public String toString() {
        return "Treatment{" +
                "\ntreatmentNumber=" + treatmentNumber +
                "\n, treatmentDate=" + treatmentDate +
                "\n, treatmentCost=" + treatmentCost +
                '}';
    }
}
