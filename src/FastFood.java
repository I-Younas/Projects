
import java.util.ArrayList;
import java.util.List;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
        super(name,fixedCosts,owner);

        //get a shallow copy of the argument list
        for (int i=0; i < staff.size();i++) {
            this.staff.add(staff.get(i));
        }
    }

    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of FastFood: " + this.getName() +
                "\n" + "Owner: " + this.getOwner());
        int index = 1;
        for (Staff staff: staff) {
            builder.append("\n" + "Staff " + index++ + " : " + staff );
        }
        return builder.toString();
    }

    @Override
    public void workShift(int hours) {

        double server_Pay=0;//adds all the wages of the servers in the list
        for (Staff staff: staff) {
            server_Pay += staff.workHours(hours);
        }

        this.getOwner().setSalaryExpenses(server_Pay + this.getOwner().getSalaryExpenses());
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        List<IncomeTaxPayer> tax_Payers_list=new ArrayList<IncomeTaxPayer>();

        tax_Payers_list.add(this.getOwner());

        for (Staff staff: staff) {

            tax_Payers_list.add(staff);


        }


        return tax_Payers_list;
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {

        this.getOwner().setIncome(check.getMenuPrice() + this.getOwner().getIncome());

        //tip is split equally between all the staff
        int list_Size=staff.size();
        for (Staff staff: staff) {

            staff.setIncome(staff.getIncome() + (check.getTip() / list_Size));


        }


        setTotalSalesTax(check.getSalesTax() + this.getTotalSalesTax());
    }

    @Override
    public double getTipPercentage() {
        return 0;
    }
}