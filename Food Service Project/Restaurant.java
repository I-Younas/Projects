
import java.util.List;
import java.util.ArrayList;

public class Restaurant extends FoodPlace {

    private Staff cook;
    private Server server;

    public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {
        super(name,fixedCosts,owner);
        this.server=server;
        this.cook=cook;
    }

    public Staff getCook() {
        return cook;
    }

    public Server getServer() {
        return server;
    }

    @Override
    public String toString() {
        return "Name of restaurant: " + this.getName() +
                "\n" + "Owner: " + this.getOwner() +
                "\n" + "Cook: " + cook +
                "\n" + "Server: " + server;
    }

    @Override
    public void workShift(int hours) {

        double cook_Pay=cook.workHours(hours);
        double server_Pay=server.workHours(hours);

        server.setIncome(server_Pay);
        cook.setIncome(cook_Pay);

        this.getOwner().setSalaryExpenses(cook_Pay + server_Pay + this.getOwner().getSalaryExpenses());

    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {


        List<IncomeTaxPayer> tax_Payers_list=new ArrayList<IncomeTaxPayer>();

        tax_Payers_list.add(server);
        tax_Payers_list.add(cook);
        tax_Payers_list.add(this.getOwner());


        return tax_Payers_list;
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {


        this.getOwner().setIncome(check.getMenuPrice() +this.getOwner().getIncome());//menuPrice added to
        // the income of the owner

        cook.setIncome(cook.getIncome() + ( (0.20) * check.getTip() ) );
        server.setIncome(server.getIncome() + ( (0.80) * check.getTip() ) );

        setTotalSalesTax(check.getSalesTax() + this.getTotalSalesTax());//the total sales tax is accumulated as well

    }

    @Override
    public double getTipPercentage() {

        return server.getTargetTipPct();
    }

}