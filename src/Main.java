import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final ArrayList<Arrayproduct> arrayProductList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenyValSorted();
/*
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> hanteraVarorMeny();//printarraylist();
                case "2" -> hanteraPrisMeny();//searchProduct();
                case "3" -> printRemoveAproduct();
                case "4" -> printaddproduct();
                case "5" -> MenyVal();
                case "6" -> sortByPrice();
                case "7" -> searchKategori();
                case "8" -> priceIntervall();
                case "e" -> System.exit(0);

            }
        }
*/
    }

    private static void  MenyValSorted(){
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


    private static void hanteraVarorMeny(){
        System.out.println("""
                Välj ett alternativ
                ========
                1. Lägg till en produkt
                2. Ta bort en produkt
                3. Visa alla produkter
                4. Meny
                e. Avsluta""");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
             switch (input) {
            case "1" -> printaddproduct();
            case "2" -> printRemoveAproduct();
            case "3" -> distinctSaldo();
            case "4" -> MenyValSorted();
            case "e" -> System.exit(0);

        }

        }


    }

    private static void hanteraPrisMeny(){
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

    private static void hanteraSökMeny(){
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

   /* private static void MenyVal() {
        System.out.println("""
                Välj en kategori
                ========
                1. Visa alla produkter
                2. Sök efter en vara
                3. Ta bort produkt
                4. Lägg till en ny produkt
                5. Visa menyval
                6. Sortera med pris
                7. Sök kategori
                8. Sök prisintervall
                e. Avsluta""");
    }*/


    private static void printaddproduct() {
        Arrayproduct nyprodukter = nyvara();
        addproduct(nyprodukter);
        hanteraVarorMeny();
        //MenyVal();
    }

    private static void printRemoveAproduct() {
        printarraylist();
        Scanner scans = new Scanner(System.in);
        System.out.print("Skriv numret på varan du vill ta bort: \n ");
        arrayProductList.remove(scans.nextInt());
        printarraylist();

    }

    private static void printarraylist() {
        System.out.println("Du har " + arrayProductList.size() + " produkter");
        for (int i = 0; i < arrayProductList.size(); i++) {
            System.out.println((i) +":  " + arrayProductList.get(i).getKategori() +
                    ": " + arrayProductList.get(i).getProdukt() + " "
                    + arrayProductList.get(i).getPris() + ":-"
                    + " " + arrayProductList.get(i).getEan());


        }
    }

    private static void distinctSaldo(){
        for(Object number: arrayProductList.stream().distinct().collect(Collectors.toList()))
            System.out.println(number +" Du har "+Collections.frequency(arrayProductList, number) + "st i Saldo");

       // List<Arrayproduct> duplicateList =  arrayProductList.stream().distinct().collect(Collectors.toList());
        //duplicateList.forEach(System.out::println);

        }
    private static void alltheproducts() {
        arrayProductList.add(new Arrayproduct("Verktyg", "Hammare", 250, 123345));
        arrayProductList.add(new Arrayproduct("Verktyg", "Spade", 100, 443323));
        arrayProductList.add(new Arrayproduct("Verktyg", "såg", 150, 56789));
        arrayProductList.add(new Arrayproduct("Trä", "Planka", 400, 131517));
        arrayProductList.add(new Arrayproduct("Trä", "Reglar", 450, 118192));
        arrayProductList.add(new Arrayproduct("Trä", "Lister", 230, 21222));
    }

    private static void priceIntervall (){
        System.out.println("Skriv in prisintervall");
        Scanner input = new Scanner(System.in);
        int inputLow = input.nextInt();
        int inputHigh = input.nextInt();
        arrayProductList.stream().filter(p -> p.getPris() > inputLow && p.getPris() < inputHigh).
                forEach(System.out::println);


    }

    private static void addproduct(Arrayproduct arrayprodukt) {
        arrayProductList.add(arrayprodukt);
    }
    public static void search (){
        System.out.println("Sök efter en vara");
        Scanner searchInput = new Scanner(System.in);
        String i = searchInput.nextLine();
        arrayProductList.stream().
                filter(arrayproduct -> arrayproduct.getProdukt().toLowerCase().startsWith(i)).
                forEach(System.out::println);
    }



    private static Arrayproduct nyvara() {
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
    }


    private static void removeproduct() {
        System.out.println("skriv en vara du vill ta bort");
        Scanner removeScanner = new Scanner(System.in);
        String product = removeScanner.nextLine();
        boolean correctremove = false;
        for (Arrayproduct arrayproduct : arrayProductList) {
            if (arrayproduct.getProdukt().equals(product)) {
                arrayProductList.remove(arrayproduct);
                correctremove = true;
            }
        }
        if (!correctremove){
            System.out.println("Varan du vill ta bort finns inte");
        }
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
        for (Arrayproduct arrayproduct : arrayProductList){
            if (arrayproduct.getProdukt().equals(name)) {
                System.out.println("Om varan:" + "\n" + "Kategori: " + arrayproduct.getKategori() + "\n" + "PRIS:" + arrayproduct.getPris() + "\n" + "EAN: " + arrayproduct.getEan());
                finns = true;
            }
            }
        if(!finns){
            System.out.println("Varan finns ej");
        }
            }

    private static void searchKategori(){
        System.out.println("Skriv in en kategori du vill söka efter: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean finns = false;
        for (Arrayproduct arrayproduct : arrayProductList){
            if (arrayproduct.getKategori().equals(name)) {
                System.out.println("Kategori: " + arrayproduct.getKategori() + "\n" + arrayproduct.getProdukt() + "\n" + "PRIS:" + arrayproduct.getPris() + "\n" + "EAN: " + arrayproduct.getEan());
                finns = true;
            }
        }
        if(!finns){
            System.out.println("Varan finns ej");
        }
    }









        }