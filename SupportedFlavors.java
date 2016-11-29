import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.io.*;
import java.util.*;

class SupportedFlavors {

  static String label = "HP DeskJet 5810 series";

  public static void main (String [] args) throws Exception
  {
    PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
    if (ps.length == 0) {
      throw new IllegalStateException("No Printer found");
    }

    for (PrintService printService : ps) {
      if (printService.getName().equals(label)) {
        for(DocFlavor flavor : printService.getSupportedDocFlavors()) {
          System.out.println(flavor);
        }
        break;
      }
    }
  }
}
