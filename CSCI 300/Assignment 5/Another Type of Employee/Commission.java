public class Commission extends Hourly
{
   private double total_sales, commission_rate;
   
   public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double com_rate)
   {
      super (eName, eAddress, ePhone, socSecNumber, rate);
      commission_rate = com_rate;
   }
   
   public void addSales(double totalSales)
   {
      total_sales = totalSales;
   }
   
   public double pay()
   {
      double payment = super.pay() + (total_sales * commission_rate);
      total_sales = 0;
      return payment;
   }
   
   public String toString()
   {
      String result = super.toString();
      result += "\nTotal Sales: " + total_sales;
      return result;
   }
}