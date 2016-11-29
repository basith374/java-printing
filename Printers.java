import javax.print.*;
import javax.print.attribute.*;

class Printers {

    public static void main (String [] args)
    {
        PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
        DocFlavor flavor = new DocFlavor.INPUT_STREAM("application/octet-stream");
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, attr);
        System.out.println("Number of print services: " + printServices.length);

        for (PrintService printer : printServices)
            System.out.println("Printer: " + printer.getName());
    }
}
