package project_soochoonkhong;

public class HouseLoanPaymentCalculator {
    private String name;
    private double housePrice, downPayment, interestRate;
    private int loanPeriod;
    private double interest, principal, monthlyPayment, cumInterest, cumPrincipal;
    private double balance = housePrice - downPayment;
    
    public HouseLoanPaymentCalculator(String name, double housePrice, double downPayment, double interestRate, int loanPeriod)
    {
        this.name = name;
        this.housePrice = housePrice;
        this.downPayment = downPayment;
        this.interestRate = interestRate;
        this.loanPeriod = loanPeriod;
    }

    public void calculateMonthlyPayment()
    {
        int loanPeriodInMonth = loanPeriod * 12;
        double interestRatePerMonth = (interestRate/100) / 12;
        double x = Math.pow((1+interestRatePerMonth),loanPeriodInMonth);
        monthlyPayment = (housePrice - downPayment) * ((interestRatePerMonth * x ) / (x - 1));
    }
    
    public double getMonthlyPayment()
    {
        return monthlyPayment;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getHousePrice()
    {
        return housePrice;
    }
    
    public double getDownPayment()
    {
        return downPayment;
    }
    
    public double getInterestRate()
    {
        return interestRate;
    }
    
    public int getLoanPeriod()
    {
        return loanPeriod;
    }
    
    public void setInitialBalance(double value)
    {
        this.balance = value;
    }
    
    public void setCumInterest(double value)
    {
        this.cumInterest = value;
    }
    
    public void setCumPrincipal(double value)
    {
        this.cumPrincipal = value;
    }
    
    public void calculatePrincipal()
    {
        principal = monthlyPayment - interest;
        cumPrincipal = cumPrincipal + principal;
    }
    
    public void calculateInterest()
    {
        double interestRatePerMonth = (interestRate/100) / 12;
        interest = balance * interestRatePerMonth;
        cumInterest = cumInterest + interest;
    }
    
    public void calculateBalance()
    {
        balance = balance + interest - monthlyPayment;
    }
    
    public String generatePaymentSchedule()
    {
        return String.format("%-17s %-11s %15s", String.format("RM %.2f",cumPrincipal), String.format("RM %.2f",cumInterest) ,String.format("RM %.2f",balance));
    }
     
    public String loanInformationToString()
    {
        return "======================================================="
                + "\nName: " + name 
                + "\n=================== LOAN INFORMATION =================="
                + String.format("\nHouse Price: RM %-15s", String.format("%.2f", housePrice))
                + String.format("Down Payment: RM %.2f", downPayment)
                + String.format("\nLoan Period: %-17s", loanPeriod + " years")
                + String.format("Interest Rate: %.2f", interestRate) + " %";
    }
}
