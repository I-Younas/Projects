
import java.util.ArrayList;
import java.util.List;

public class TaxCollector {

    private List<FoodPlace> foodPlaces = new ArrayList<>();

    private double incomeTaxCollected;
    private double salesTaxCollected;

    public TaxCollector(List<FoodPlace> foodPlaces) {
        this.foodPlaces=foodPlaces;
    }

    public List<FoodPlace> getFoodPlaces() {
        return foodPlaces;
    }

    public double getIncomeTaxCollected() {
        return incomeTaxCollected;
    }

    public double getSalesTaxCollected() {
        return salesTaxCollected;
    }

    public void collectTax() {

        for (FoodPlace foodPlace : foodPlaces) {
            this.salesTaxCollected += foodPlace.getTotalSalesTax();

            for (IncomeTaxPayer income_Tax_Payers: foodPlace.getIncomeTaxPayers()) {
                this.incomeTaxCollected += income_Tax_Payers.calculateIncomeTax();

            }
        }


    }

    public String toString() {
        return "TaxCollector: income tax collected: " + incomeTaxCollected + ", sales tax collected: " + salesTaxCollected;
    }

}