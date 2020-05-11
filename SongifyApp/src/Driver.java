import java.util.Scanner;

public class Driver {

        private Scanner input = new Scanner(System.in);
        private ArtistList artistList;
        private SongList songList;


        public Driver() {

            artistList = new ArtistList();
            songList = new SongList();

            mainMenu();
            runMenu();
        }

        public static void main(String[] args) {
            new Driver();
        }


    /**
     * mainMenu() - This method displays the menu for the application,
         * reads the menu option that the user entered and returns it.
         *
         * @return the users menu choice
         */
        private int mainMenu() {
            System.out.println("Songify Menu");
            System.out.println("---------");
            System.out.println("  1) Add an Artist");
            System.out.println("  2) List all Artists");
            System.out.println("  3) Remove an Artist(by index)");
            System.out.println("  --------------------");
            System.out.println("  4) Add a Song");
            System.out.println("  5) List all Songs");
            System.out.println("  6) List all Songs in a Genre");
            System.out.println("  7) List all Songs by Artist");
            System.out.println("  8) List Song Statistics");
            System.out.println("  9) Remove a Song (by index)");
            System.out.println("  10) Save to XML");
            System.out.println("  10) Load from XML");
            System.out.println("  --------------------");
            System.out.println("  0) Exit");
            int option = input.nextInt();
            return option;
        }

        private void runMenu() {
            int option = mainMenu();
            while (option != 0) {

                switch (option) {
                    case 1:
                        addArtist();
                        break;
                    case 2:
                        getArtist();
                        break;
                    case 3:
                        deleteArtist();
                        break;
                    case 4:
                        addSong();
                        break;
                    case 5:
                        listOfSongs();
                        break;
                    case 6:
                        printAverageProductPrice();
                        break;
                    case 7:
                        printCheapestProduct();
                        break;
                    case 8:
                        printProductsAboveAPrice();
                        break;
                    case 9:
                        try{
                            store.save();
                        }
                        catch(Exception e){
                            System.err.println("Error writing to file: " + e);
                        }
                        break;
                    case 10:
                        try{
                            store.load();
                        }
                        catch(Exception e){
                            System.err.println("Error reading from file: " + e);
                        }
                        break;
                    default:
                        System.out.println("Invalid option entered: " + option);
                        break;
                }

                //pause the program so that the user can read what we just printed to the terminal window
                System.out.println("\nPress any key to continue...");
                input.nextLine();

                //display the main menu again
                option = mainMenu();
            }

            //the user chose option 0, so exit the program
            System.out.println("Exiting... bye");
            System.exit(0);
        }
}
