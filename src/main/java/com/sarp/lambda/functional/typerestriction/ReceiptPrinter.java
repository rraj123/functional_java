package com.sarp.lambda.functional.typerestriction;

class Receipt {
    String item;
    double price;
    double discount;
    double tax;

    public Receipt(Receipt r) {
        this.item = r.item;
        this.price = r.price;
        this.discount = r.discount;
        this.tax = r.tax;
    }
    public Receipt(String item, double price, double discount, double tax) {
        this.item = item;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
    }



}

class CountyReceipt extends Receipt
{
    double countyTax;
    public CountyReceipt(Receipt r, double c)
    {
        super(r);
        countyTax = c;
    }
}
@FunctionalInterface
interface ReceiptPrinterType<X extends Receipt>
{
    void print(X receipt);
    private double getDiscountedPrice(X receipt)
    {
        return receipt.price
                - (receipt.price * receipt.discount);
    }
    default double computeTotal(X receipt)
    {
        double discountedPrice = getDiscountedPrice(receipt);
        return discountedPrice + (discountedPrice * receipt.tax);
    }
}

public class ReceiptPrinter {
    public static void main(String[] args) {
        ReceiptPrinterType<Receipt> simpleReceiptPrinter
                = new ReceiptPrinterType<> () {
            @Override
            public void print(Receipt receipt)
            {
                System.out.println("\nItem :\t" + receipt.item);
                System.out.println("Price:\t"   + receipt.price);
                System.out.println("Disc:\t"    + receipt.discount);
                System.out.println("Tax:\t"     + receipt.tax);
                System.out.println("Total:\t"   + computeTotal(receipt));
            }
        };


        ReceiptPrinterType<CountyReceipt> countyReceiptPrinter
                = new ReceiptPrinterType<> () {
            @Override
            public void print(CountyReceipt receipt)
            {
                System.out.println("\nItem :\t" + receipt.item);
                System.out.println("Price:\t"   + receipt.price);
                System.out.println("Disc:\t"    + receipt.discount);
                System.out.println("Tax:\t"     + receipt.tax);
                System.out.println("CnTax:\t"   + receipt.countyTax);
                System.out.println("Total:\t"   + computeTotal(receipt));
            }
            @Override



            public double computeTotal(CountyReceipt receipt)
            {
                double discountedPrice = receipt.price
                        - (receipt.price * receipt.discount);
                return discountedPrice
                        + (discountedPrice * receipt.tax)
                        + (discountedPrice * receipt.countyTax);
            }
        };

        Receipt receipt = new Receipt("shirt", 20.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);
        CountyReceipt countyReceipt = new CountyReceipt(receipt, 0.04);
        countyReceiptPrinter.print(countyReceipt);

    }
}
