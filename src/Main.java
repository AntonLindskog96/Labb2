

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private final static ArrayList<Arrayproduct> arrayProductList = new ArrayList<>();

    public static void main(String[] args) {

        MenyValSorted();


    }

    private static void MenyValSorted() {
        System.out.println("""
                MENY
                ========
                1. Hantera varor
                2. Hantera priser
                3. Sök
                e. Avsluta""");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> hanteraVarorMeny();
                case "2" -> hanteraPrisMeny();
                case "3" -> hanteraSökMeny();
                case "e" -> System.exit(0);

            }
        }


    }


    private static void hanteraVarorMeny() {
        System.out.println("""
                Välj ett alternativ
                ========
                1. Lägg till en produkt
                2. Ta bort en produkt
                3. Visa alla produkter
                4. Meny
                5. Spara
                6.Läs in varor.
                e. Avsluta""");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> printaddproduct();
                case "2" -> printRemoveAproduct();
                case "3" -> distinctSaldo();
                case "4" -> MenyValSorted();
                case "5" -> gson();
                case "6" -> reader();
                case "e" -> System.exit(0);

            }

        }


    }

    private static void hanteraPrisMeny() {
        System.out.println("""
                Välj ett alternativ
                ========
                1. Sortera priser
                2. Sök prisintervall
                3. Meny
                e. Avsluta""");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> sortByPrice();
                case "2" -> priceIntervall();
                case "3" -> MenyValSorted();
                case "e" -> System.exit(0);

            }
        }

    }

    private static void hanteraSökMeny() {
        System.out.println("""
                Välj ett alternativ
                ========
                1. Sök på en vara
                2. Sök på en kategori
                3. Meny
                e. Avsluta""");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> searchProduct();
                case "2" -> searchKategori();
                case "3" -> MenyValSorted();
                case "e" -> System.exit(0);


            }
        }

    }


    private static void printaddproduct() {
        Arrayproduct nyprodukter = nyvara();
        addproduct(nyprodukter);
        hanteraVarorMeny();

        //MenyVal();
    }

    private static void printRemoveAproduct() {
        try {
            printarraylist();
            Scanner scans = new Scanner(System.in);
            System.out.print("Skriv numret på varan du vill ta bort: \n ");
            arrayProductList.remove(scans.nextInt());
            System.out.println("En vara har tagits bort");
            hanteraVarorMeny();
        } catch (Exception e) {
            System.out.println("Något gick vajsing, försök igen");
            hanteraVarorMeny();
        }
    }

    private static void printarraylist() {
        try {
            System.out.println("Du har " + arrayProductList.size() + " produkter");
            for (int i = 0; i < arrayProductList.size(); i++) {
                System.out.println((i) + ":  " + arrayProductList.get(i).getKategori() +
                        ": " + arrayProductList.get(i).getProdukt() + " "
                        + arrayProductList.get(i).getPris() + ":-"
                        + " " + arrayProductList.get(i).getEan());


            }
        } catch (Exception e) {
            System.out.println("Försök igen");
        }
    }

    private static void distinctSaldo() {
        System.out.println("Du har " + arrayProductList.size() + " produkter");
        for (Object number : arrayProductList.stream().distinct().toList())
            System.out.println(number + " Du har " + Collections.frequency(arrayProductList, number) + "st i Saldo");



    }


    private static void priceIntervall() {
        try {
            System.out.println("Skriv in prisintervall");
            Scanner input = new Scanner(System.in);
            int inputLow = input.nextInt();
            int inputHigh = input.nextInt();
            arrayProductList.stream().filter(p -> p.getPris() > inputLow && p.getPris() < inputHigh).
                    forEach(System.out::println);


        } catch (Exception e) {
            System.out.println("Du har inga varor");
            hanteraPrisMeny();
        }
    }

    private static void addproduct(Arrayproduct arrayprodukt) {
        arrayProductList.add(arrayprodukt);

    }

    private static Arrayproduct nyvara() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Vad skall det vara för kategori?");
            String kategori = scan.next();
            System.out.println("Vad skall det vara för produkt?");
            String produkt = scan.next();
            System.out.println("Vad skall priset vara?");
            int pris = scan.nextInt();
            System.out.println("Vad för ean nummer?");
            int Ean = scan.nextInt();
            return new Arrayproduct(kategori, produkt, pris, Ean);
        } catch (Exception e) {
            System.out.println("Fel inmatning, försök igen");
        }
        return null;
    }


    private static void sortByPrice() {
        arrayProductList.sort(Comparator.comparingInt(o -> o.pris));
        printarraylist();

    }

    private static void searchProduct() {
        System.out.println("Skriv in en produkt du vill söka efter: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean finns = false;
        for (Arrayproduct arrayproduct : arrayProductList) {
            if (arrayproduct.getProdukt().equals(name)) {
                System.out.println("Om varan:" + "\n" + "Kategori: " + arrayproduct.getKategori() + "\n" + "PRIS:" + arrayproduct.getPris() + "\n" + "EAN: " + arrayproduct.getEan());
                finns = true;
            }
        }
        if (!finns) {
            System.out.println("Varan finns ej");
        }
    }

    private static void searchKategori() {
        System.out.println("Skriv in en kategori du vill söka efter: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean finns = false;
        for (Arrayproduct arrayproduct : arrayProductList) {
            if (arrayproduct.getKategori().equals(name)) {
                System.out.println("Kategori: " + arrayproduct.getKategori() + "\n" + arrayproduct.getProdukt() + "\n" + "PRIS:" + arrayproduct.getPris() + "\n" + "EAN: " + arrayproduct.getEan());
                finns = true;
            }
        }
        if (!finns) {
            System.out.println("Kategorin finns ej");
        }
    }


    private static void gson(){
        Gson gson = new Gson();
        String json = gson.toJson(arrayProductList);
        String homeFolder = System.getProperty("user.home");

        try {
            Files.writeString(Path.of(homeFolder, "JSONprodukt.json"), json);
            System.out.println("Du har sparat.");
        }catch(IOException e){

            throw new RuntimeException(e);
        }
    }

    public static void reader(){
  Gson gson = new Gson();
  Path filePath = Path.of(("C:\\Users\\linds\\JSONprodukt.json"));
        readFileAsStream(filePath);


  try{ String fileContent = Files.readString(filePath);
      var objects = gson.fromJson(fileContent, Arrayproduct[].class);
      arrayProductList.clear();
      arrayProductList.addAll(List.of(objects));
  } catch (IOException e) {
            System.out.println(e);
  }

    }
    public static void readFileAsStream(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






    }

