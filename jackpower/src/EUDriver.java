

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EUDriver {

    private Scanner input = new Scanner(System.in);
    private static ArrayList<Country> euCountries;
    private PartyList partyList;


    public EUDriver() throws Exception {
        euCountries = new ArrayList<Country>();
        runMenu();

    }

    public EUDriver(int i) {
        euCountries = new ArrayList<Country>();
    }


    public static void main(String[] args) throws Exception {
        new EUDriver();
    }

    private int mainMenu() {
        System.out.println("Eu Menu");
        System.out.println("---------");
        System.out.println("  1) Add a country to EU");
        System.out.println("  2) Remove a country from the EU");
        System.out.println("  3) Update a EU country's information");
        System.out.println("  4) List all the EU Countries");
        System.out.println("---------------------------------");
        System.out.println("  5) Add Mep to a European Country");
        System.out.println("  6) Remove an MEP from a Country");
        System.out.println("  7) Update an MEP's information");
        System.out.println("  8) List MEP's of searched country");
        System.out.println("  -------------------------------");
        System.out.println("  9) Add a party");
        System.out.println("  10) List all Parties");
        System.out.println("  11) Remove Party");
        System.out.println("  12) Update Party");
        System.out.println("  --------------------------------");
        System.out.println("  13) Print Party with most Local Representatives");
        System.out.println("  14) List all parties of a given Genre");
        System.out.println("  15) Calculate and print the party with the most MEPs");
        System.out.println("  16) Save");
        System.out.println("  17) Load");

        //        System.out.println("  --------------------");
        System.out.println("  0) Exit");
        return ScannerInput.readNextInt("==>>");
    }

    private void runMenu() throws Exception {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    deleteCountry();
                    break;
                case 3:
                    updateCountry();
                    break;
                case 4:
                    System.out.println(listOfCountries());
                    break;
                case 5:
                    addMep();
                    break;
                case 6:
                    deleteMEP();
                    break;
                case 7:
                    updateMEP();
                    break;
                case 8:
                    listMEPSOfCountry();
                    break;
                case 9:
                    addNewParty();
                    break;
                case 10:
                    System.out.println(listOfParties());
                    break;
                case 11:
                    deleteParty();
                    break;
                case 12:
                    updateParty();
                    break;
                case 13:
                    System.out.println(PartyList.largestParty().toString());
                    break;
                case 14:
                    listPartyByGenre();
                    break;
                case 15:
                    System.out.println(PartyList.mostMEPs());
                    break;
                case 16:
                    save();
                    break;
                case 17:
                    load();
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

    public void addCountry() {

        System.out.print("Enter the Country Name:  ");
        String countryName = input.nextLine();

        int numberOfMeps = ScannerInput.readNextInt("Enter the Number of MEPs from this country: ");

        euCountries.add(new Country(countryName, numberOfMeps));
    }

    public void deleteCountry() {


        if (!euCountries.isEmpty()) {
            System.out.println(listOfCountries());
            int indexToDelete = ScannerInput.readNextInt("Enter the index of the Country you wish to remove from the EU: ");

            euCountries.remove(indexToDelete);
            System.out.println("Country has been Removed from EU.");

        } else {
            System.out.println("There are no Countries currently stored as EU Countries");
            mainMenu();
        }
    }

    public void updateCountry() {

        if (!euCountries.isEmpty()) {
            System.out.println(listOfCountries());
            int indexToUpdate = ScannerInput.readNextInt("Enter the index of the Country you wish to update: ");
            Country temp = euCountries.get(indexToUpdate);

            System.out.println(temp.toString());


            int newSeatsNum = ScannerInput.readNextInt("Enter new value for number of seats: ");
            temp.setNoMEPs(newSeatsNum);
            System.out.println("The Countries Number of Seats has been updated: ");
        } else {
            System.out.println("This Country is not Recognized");
        }

    }

    public String listOfCountries() {

        if (euCountries.size() == 0) {
            return "No countries";
        } else {
            String listOfCountries = "";
            for (int i = 0; i < euCountries.size(); i++) {
                listOfCountries = listOfCountries + i + ": " + euCountries.get(i) + "\n";
            }
            return listOfCountries;
        }
    }

    public void addMep() {

        if (!euCountries.isEmpty()) {
            System.out.println(listOfCountries());
            int indexToUse = ScannerInput.readNextInt("Enter the index of the Country you wish to add MEP to: ");
            Country country = euCountries.get(indexToUse);

            if (indexToUse >= 0)
                System.out.print("Enter the MEP's Name:  ");
            String mepName = input.nextLine();
            System.out.print("Enter the MEP's Number:  ");
            String mepNumber = input.nextLine();
            System.out.print("Enter the MEP's Email:  ");
            String mepEmail = input.nextLine();

            System.out.print("Enter the MEP's Party:  ");
            String mepParty = input.nextLine();

            System.out.println("3");
            if (mepName.length() <= 30 && mepEmail.contains("@") && mepNumber.matches("[0-9]+")) {

                MEP TEMP = new MEP(mepName, mepEmail, mepNumber, mepParty);
                country.addMEP(TEMP);
                System.out.println("The Mep has been added. ");
            } else {
                System.out.println("Ensure 1) Name is less than 30 letters 2) Email contains '@' symbol 3) Number contains only numbers. ");
            }
        } else {
            System.out.println("There are no Countries: ");
        }
    }

    public void deleteMEP() {

        if (!euCountries.isEmpty()) {
            System.out.println(listOfCountries());
            int indexToUse = ScannerInput.readNextInt("Enter the index of the Country you wish to delete MEP from: ");
            Country country = euCountries.get(indexToUse);

            if (!country.listOfMEPs().isEmpty()) {
                System.out.println(country.listOfMEPs());
                int indexToRemove = ScannerInput.readNextInt("Enter the index of the MEP you wish to delete: ");

                if (indexToRemove <= country.listOfMEPs().length() && indexToRemove >= 0) {
                    country.removeMEP(indexToRemove);
                    System.out.println("MEP has been removed Succesfully. ");
                } else {
                    System.out.println("Invalid Index. ");
                }
            } else {
                System.out.println("There is no MEPs for this country");
            }
        } else {
            System.out.println("There are no Countries. ");
        }
    }

    public void updateMEP() {

        if (!euCountries.isEmpty()) {
            System.out.println(listOfCountries());
            int indexToUse = ScannerInput.readNextInt("Enter the index of the Country you wish to update MEP from: ");
            Country country = euCountries.get(indexToUse);

            if (indexToUse >= 0) {

                if (!country.listOfMEPs().isEmpty()) {
                    System.out.println(country.listOfMEPs());
                    int indexToUpdate = ScannerInput.readNextInt("Enter the index of the MEP you wish to update: ");

                    if (indexToUpdate <= country.listOfMEPs().length() && indexToUpdate >= 0) {

                        MEP mepToUpdate = country.getMEP(indexToUpdate);
                        System.out.println(mepToUpdate);


                        System.out.print("Enter new name for [" + mepToUpdate.getMEPName() + "] :  ");
                        String mepName = input.nextLine();

                        if (mepName.length() >= 30) {
                            mepToUpdate.setMEPName(mepName);
                        } else {
                            System.out.println("Name must be less than 31 Letters");
                        }


                        System.out.print("Enter new number for [" + mepToUpdate.getMEPPhone() + "] :  ");
                        String mepNumber = input.nextLine();

                        if (mepNumber.matches("[0-9]+")) {
                            mepToUpdate.setMEPPhone(mepNumber);
                        } else {
                            mepToUpdate.setMEPPhone("Unknown");
                        }


                        System.out.print("Enter new Email for [" + mepToUpdate.getMEPEmail() + "] :  ");
                        String mepEmail = input.nextLine();

                        if (mepEmail.contains("@")) {
                            mepToUpdate.setMEPEmail(mepEmail);
                        } else {
                            System.out.println("Email must contain @ symbol");
                        }


//                    System.out.print("Enter new Party for [" +mepToUpdate.getMEPParty() + "] :  ");
//                    String mepParty = input.nextLine();

//                    if(partyList.contains mepParty){
//                        mepToUpdate.setMEPParty(mepParty);
//                    }
                        System.out.println("MEP information has been updated");


                    } else {
                        System.out.println("Invalid Index. ");
                    }
                } else {
                    System.out.println("There is no MEPs for this country");
                }
            } else {
                System.out.println("choose a valid index. ");
            }
        } else {
            System.out.println("There are no Countries. ");
        }
    }

    public void listMEPSOfCountry() {

        ArrayList<Country> searched = new ArrayList<>();
        ArrayList<MEP> mepsToReturn = new ArrayList<>();


        listOfCountries();

        System.out.println("Enter Country you wish to see MEPS of: ");
        String country = input.nextLine();

        for (Country euCountry : euCountries) {

            if (euCountry.getName().equals(country)) {

                searched.add(euCountry);

            }
        }

        for (Country searchedCountry : searched) {
            mepsToReturn = searchedCountry.getMeps();
        }

//        String listOfMeps = "";
//        for (int x = 0; x < searched.size(); x++) {
//
//            listOfMeps = listOfMeps + x + ": " + searched.get(x) + "\n";

        System.out.println(mepsToReturn);
    }


    public void addNewParty() {

        System.out.println("Enter the party's name: ");
        String partyName = input.nextLine();

        System.out.println("Enter the name of the party leader: ");
        String partyLeader = input.nextLine();

        System.out.println("Enter the genre of the party: (RIGHT, LEFT, EXTREME, RIGHT, EXTREME LEFT, CENTRE, UNCATEGORISED)");
        String partyGenre = input.nextLine();

        int num = ScannerInput.readNextInt("Enter the number of local representatives the party has: ");

        Party party = new Party(partyName, partyLeader, partyGenre, num);

        PartyList.addParty(party);
    }

    public String listOfParties() {
        if (PartyList.numberOfParties() == 0) {
            return "No parties";
        } else {
            String listOfPa = "";
            for (int i = 0; i < PartyList.numberOfParties(); i++) {
                listOfPa = listOfPa + i + ": " + PartyList.getParty(i) + "\n";
            }
            return listOfPa;
        }
    }

    public void listPartyByGenre() {
        System.out.println("Enter Genre of Party your searching for: ");
        String gen = input.nextLine();

        System.out.println("1");
        String toPrint = PartyList.listPartiesBySpecifiedGenre(gen);
        System.out.println(toPrint);

    }

    public void deleteParty() {


        System.out.println(listOfParties());
        int index = ScannerInput.readNextInt("Enter index of party you wish to delete: ");

        if (index >= 0 && index <= PartyList.numberOfParties()) {
            if (PartyList.removeParty(index)) {
                System.out.println("Party Removed");
            }
        } else {
            System.out.println("Enter a Valid Index");
        }
    }

    public void updateParty() {
        if (!PartyList.parties.isEmpty()) {
            System.out.println(listOfParties());
            int index = ScannerInput.readNextInt("Enter index of party you wish to update: ");

            if (index >= 0 && index <= PartyList.numberOfParties()) {

                Party party = PartyList.getParty(index);

                System.out.print("Enter new Name for [" + party.getPartyName() + "] :  ");
                String newName = input.nextLine();
                party.setPartyName(newName);

                System.out.print("Enter new Leader for [" + party.getPartyLeader() + "] :  ");
                String newLeader = input.nextLine();
                party.setPartyLeader(newLeader);

                System.out.print("Enter new Genre for [" + party.getPartyGenre() + "] :  ");
                String newGenre = input.nextLine();
                party.setPartyGenre(newGenre);

                int newNum = ScannerInput.readNextInt("Enter new total local reps for [" + party.getNumLocalReps() + "] :  ");
                party.setNumLocalReps(newNum);

                System.out.println("The Party Details have been updated");

            } else {
                System.out.println("Choose a valid index. ");
            }

        } else {
            System.out.println("There are currently no parties. ");
        }


    }

    public Country findCountry(String country) {
        for (Country searchedCountry : euCountries) {
            if(searchedCountry.getName().equals(country)){
                return searchedCountry;
            }
        }
        return null;
    }

    public String listMEPsBySpecificParty(String party) {
        Party searchedParty = null;
        for(Party party_ : PartyList.parties){
            if(party_.getPartyName().equals(party)){
                searchedParty = party_;
            }
        }

        ArrayList<MEP> list = new ArrayList<>();

        for (Country country : euCountries) {
            ArrayList<MEP> listMeps = country.getMeps();
            for ( MEP mep : listMeps){
                if(mep.getMEPParty().equals(searchedParty.getPartyName())){
                    list.add(mep);
                }
            }
        }
        String listOfMEPsByPartyString = "";
        for (int i = 0; i < list.size(); i++) {
            listOfMEPsByPartyString = listOfMEPsByPartyString + i + ": " + list.get(i) + "\n";
        }
        return listOfMEPsByPartyString;
    }

    public int noMEPsBySpecificParty(String party) {

        Party searchedParty = null;
        for (Party party_ : PartyList.parties) {
            if (party_.getPartyName().equals(party)) {
                searchedParty = party_;
            }
        }

        ArrayList<MEP> list = new ArrayList<>();

        for (Country country : euCountries) {
            ArrayList<MEP> listMeps = country.getMeps();
            for (MEP mep : listMeps) {
                if (mep.getMEPParty().equals(searchedParty.getPartyName())) {
                    list.add(mep);
                }
            }
        }
        return list.size();
    }


   public void largestParty(){

       Party largestParty = PartyList.largestParty();
       String largest = largestParty.getPartyName();
       System.out.println(largest);

    }
    public static ArrayList<Country> getEuCountries() {
        return euCountries;
    }


    public void setEuCountries(ArrayList<Country> euCountries) {
        this.euCountries = euCountries;
    }

    public PartyList getPartyList() {
        return partyList;
    }

    public void setPartyList(PartyList partyList) {
        this.partyList = partyList;
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("parties.xml"));
        PartyList.parties = (ArrayList<Party>) is.readObject();
        is.close();
        XStream x = new XStream(new DomDriver());
        ObjectInputStream xt = x.createObjectInputStream(new FileReader("countries.xml"));
        euCountries = (ArrayList<Country>) xt.readObject();
        xt.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("parties.xml"));
        out.writeObject(PartyList.parties);
        out.close();
        XStream xst = new XStream(new DomDriver());
        ObjectOutputStream outo = xst.createObjectOutputStream(new FileWriter("countries.xml"));
        outo.writeObject(euCountries);
        outo.close();


    }
}
