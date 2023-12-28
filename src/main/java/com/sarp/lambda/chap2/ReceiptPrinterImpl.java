package com.sarp.lambda.chap2;


class ReceiptChap2
{
    String item;
    double price;
    double discount;
    double tax;
    public ReceiptChap2(String i, double a, double d, double s)
    {
        item     = i;
        price    = a;
        discount = d;
        tax      = s;
    }
    public ReceiptChap2(ReceiptChap2 r)
    {
        item     = r.item;
        price    = r.price;
        discount = r.discount;
        tax      = r.tax;
    }
}
@FunctionalInterface
interface ReceiptPrinter
{
    void print(ReceiptChap2 receiptChap2);

    default double computeTotal(ReceiptChap2 receiptChap2)
    {
        double discountedPrice = receiptChap2.price
                - (receiptChap2.price * receiptChap2.discount);
        return discountedPrice + (discountedPrice * receiptChap2.tax);
    }
}
public class ReceiptPrinterImpl {
    ReceiptPrinter simpleReceiptPrinter = x -> {
        System.out.println("\nItem :\t"  + x.item);
        System.out.println("Price:\t"    + x.price);
        System.out.println("Disc:\t"     + x.discount);
        System.out.println("Tax:\t"      + x.tax);
    };

//    ReceiptChap2 receiptChap2 = new ReceiptChap2("shirt", 20.00, 0.05, 0.07);
//        simpleReceiptPrinter.print(receiptChap2);
//        System.out.println("Total:\t"
//                + simpleReceiptPrinter.computeTotal(receiptChap2));
}
