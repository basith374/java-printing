import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.io.*;
import java.util.*;

class PrintPdf {

  static String label = "HP DeskJet 5810 series"; // change this to your printer name

  public static void main (String [] args) throws Exception
  {
    // DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF; // not working
    // DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE; // not working
    // DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE; // not working
    DocFlavor flavor = new DocFlavor.INPUT_STREAM("application/octet-stream");
    PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
    // attr.add(Sides.DUPLEX); // not working
    // attr.add(MediaSize.ISO.A4); // not working
    PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, attr);
    if (ps.length == 0) {
      throw new IllegalStateException("No Printer found");
    }
    System.out.println("Available printers: " + Arrays.asList(ps));

    PrintService myService = null;
    for (PrintService printService : ps) {
      if (printService.getName().equals(label)) {
          myService = printService;
        break;
      }
    }

    if (myService == null) {
        throw new IllegalStateException("Printer not found");
    }

    FileInputStream fis = new FileInputStream("./example.pdf");
    System.out.println("doc flavour applied to printing");
    Doc pdfDoc = new SimpleDoc(fis, flavor, null);
    DocPrintJob printJob = myService.createPrintJob();
    printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
    fis.close();
  }
}
