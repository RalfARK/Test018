import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperacjeNaPlikach1 {

    public static void main(String[] args) {
        String patch1 = "D:\\Rafal\\PROGRAMOWANIE\\JAVA\\IdeaProjects\\Test018\\plik1.txt";
        String patch2;
        Scanner in = new Scanner(System.in);
        String linia;
        boolean nadpisywanie = false;
        int iloscLinii = 0;

        //FileWriter fileWriter = null;
        //BufferedReader fileReader = null;

        System.out.println("Podaj sciezke do pliku");
        patch2 = in.nextLine();

        while (true) {
            System.out.println("Podaj linię tekstu: ");
            linia = in.nextLine();

            if (linia.equals("-")) {
                break;
            }
            else {
                try (FileWriter fileWriter = new FileWriter(patch2, nadpisywanie)){
                    fileWriter.write(linia);
                    fileWriter.write(System.lineSeparator());
                    nadpisywanie = true;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }

        System.out.println("Zapisane linie w pliku: ");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(patch2))){

            String l;
            while ((l = fileReader.readLine()) != null) {
                System.out.println(l);
                iloscLinii++;
            }
            System.out.println("Ilosc linii w pliku: " + iloscLinii);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
