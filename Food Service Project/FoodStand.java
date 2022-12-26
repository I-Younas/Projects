
import java.util.ArrayList;
import java.util.List;

public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {
        super(name,fixedCosts,owner);
    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        List<IncomeTaxPayer> tax_Payers_list=new ArrayList<IncomeTaxPayer>();

        tax_Payers_list.add(getOwner());

        return tax_Payers_list;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {

        this.getOwner().setIncome(check.getMenuPrice() + check.getTip() + this.getOwner().getIncome());

        setTotalSalesTax(check.getSalesTax() + this.getTotalSalesTax());//the total sales tax is accumulated as well

    }

    @Override
    public double getTipPercentage() {
        return ((WorkingOwner)this.getOwner()).getTargetTipPct();


    }
}