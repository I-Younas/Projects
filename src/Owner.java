
public class Owner extends IncomeTaxPayer {

    final private int incomeTaxPct = 10;
    private double salaryExpenses;

    private FoodPlace foodPlace;

    public Owner(String name) {
        super(name);
    }

    public int getIncomeTaxPct() {
        return incomeTaxPct;
    }

    public double getSalaryExpenses() {
        return salaryExpenses;
    }

    public FoodPlace getFoodPlace(){
        return foodPlace;
    }

    public void setSalaryExpenses(double salaryExpenses) {
        this.salaryExpenses = salaryExpenses;
    }

    public void setFoodPlace(FoodPlace foodPlace) {
        this.foodPlace = foodPlace;
    }

    @Override
    //returns the amount of tax the owner needs to pay
    //*get back to this after you do Customer
    public double calculateIncomeTax() {
        double owner_Income=getIncome();//did not sum menuPrices on customers' checks
        double owner_Expenses=getSalaryExpenses() + this.foodPlace.getFixedCosts();

        double diff_Income = owner_Income - owner_Expenses;

        if (owner_Income > owner_Expenses) {
            double income_Tax= (incomeTaxPct / 100.0) * diff_Income;

            return income_Tax;
        }
        else {
            return 0;
        }
    }
}