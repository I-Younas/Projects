
public class Staff extends IncomeTaxPayer {

    private int salaryPerHour;
    final private int incomeTaxPercentage = 25;

    public Staff(String name, boolean isCook) {
        super(name);
        if(isCook == true) {
            salaryPerHour=20;
        }
        else {
            salaryPerHour=10;
        }
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public int getIncomeTaxPercentage() {
        return incomeTaxPercentage;
    }

    public double workHours(int numHours) {

        double pay = numHours * this.salaryPerHour;

        pay  += getIncome();

        this.setIncome(pay);

        return numHours * this.salaryPerHour;
    }


    public double calculateIncomeTax() {

        double income_Tax=getIncome() * (incomeTaxPercentage/100.0);

        return income_Tax;
    }

}