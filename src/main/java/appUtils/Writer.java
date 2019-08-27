package appUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

    public static void writeListInFile(ArrayList<String> list, String pathToCSVFile) {
        PrintWriter writer;
        try {
            switch (System.getProperty("os.name")) {
                case "Linux":
                    writer = new PrintWriter(pathToCSVFile, "UTF-8");
                    break;
                case "Windows 10":
                    writer = new PrintWriter(pathToCSVFile, "windows-1251");
                    break;
                default:
                    throw new Exception("Unknown OS");
            }
            for (String elem : list) {
                writer.write(elem + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in writing file");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
