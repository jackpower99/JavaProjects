import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class PartyList {

    public static ArrayList<Party> parties = new ArrayList<>();

    public PartyList() {

    }

    public ArrayList<Party> getParties() {
        return parties;
    }

    public void setParties(ArrayList<Party> parties) {
        this.parties = parties;
    }

    public static Party getParty(int partyIndex) {
        if (partyIndex >= 0 && partyIndex <= parties.size()) {
            return parties.get(partyIndex);
        } else {
            return null;
        }
    }

    public static void addParty(Party party) {

        parties.add(party);
    }

    public static boolean removeParty(int partyIndex) {
        parties.remove(partyIndex);
        return true;
    }

    public static int numberOfParties() {
        return parties.size();
    }

    public String listOfParties() {
        if (parties.size() == 0) {
            return "No parties for this country ";
        } else {
            String listOfParties = "";
            for (int i = 0; i < parties.size(); i++) {
                listOfParties = listOfParties + i + ": " + parties.get(i) + "\n";
            }
            return listOfParties;
        }
    }

    public static String listPartiesBySpecifiedGenre(String genre) {

        ArrayList<Party> temp = new ArrayList<>();

        for (Party party : parties) {
  
            if (party.getPartyGenre().equals(genre)) {

                temp.add(party);

            }
        }
        if (temp.size() == 0) {
            return "There are no parties for this genre";
        } else {
            String listOfParties = "";
            for (int i = 0; i < temp.size(); i++) {

                listOfParties = listOfParties + i + ": " + temp.get(i) + "\n";
            }
            return listOfParties;
        }
    }

    public static Party largestParty() {

        ArrayList<Integer> numLocalRepresentatives = new ArrayList<>();
        Party partyToReturn = null;
        for (Party party : parties) {
            numLocalRepresentatives.add(party.getNumLocalReps());
        }
        int large = numLocalRepresentatives.get(0);

        for (int i = 1; i < numLocalRepresentatives.size(); i++) {
            if (large < numLocalRepresentatives.get(i)) {
                large = numLocalRepresentatives.get(i);
            }
        }

        for (Party party : parties) {
            if (party.getNumLocalReps() == large) {

                partyToReturn = party;
            }
        }
        return partyToReturn;
    }

    public static Party mostMEPs() {
        ArrayList<ArrayList<MEP>> mepsToCount = new ArrayList<>();
        ArrayList<String> partyNameList = new ArrayList<>();
        Map<String, Integer> stringsCount = new HashMap<String, Integer>();
        Party partyWithMostMEPs = null;
        String mostCommonParty = null; 

        for (Country country : EUDriver.getEuCountries()) {

            mepsToCount.add(country.getMeps());
        }
        for (ArrayList<MEP> mepo : mepsToCount) {
            for (MEP meop : mepo) {
                partyNameList.add(meop.getMEPParty());
            }
        }
        for (String partyNameFromList : partyNameList) {
            if (partyNameFromList.length() > 0) {

                partyNameFromList = partyNameFromList.toLowerCase();
                Integer count = stringsCount.get(partyNameFromList);
                if (count == null) count = 0;

                count++;
                stringsCount.put(partyNameFromList, count);
            }
        }
        Map.Entry<String, Integer> mostCommon = null;
        for (Map.Entry<String, Integer> e : stringsCount.entrySet()) {
            if (mostCommon == null || mostCommon.getValue() < e.getValue()) {
                mostCommon = e;
            }
            try {
                mostCommonParty = mostCommon.getKey();
            } catch (NullPointerException npe) {
                System.out.println("NullPointer");
            }
        }

        for (Party party : parties) {
            if (party.getPartyName().equals(mostCommonParty)) {
                partyWithMostMEPs = party;
            }
        }

        return partyWithMostMEPs;
    }





}

//        for (ArrayList<MEP> mepsos : mepsToCount) {
//            for (MEP meop : mepsos) {
//                if(meop.getMEPParty().equals(mostCommonParty)){
//                    partyWithMostMEPs=meop;
//                }
//            }
//        }



      //  for(int i =0; i<mepo.size(); i++ ){

//
//    {
//
//        //here we can access each array list with main.get(x).
//        for (int y=0; y<mepsToCount.get(x).size(); y++){
//
//        }
//        //here you can do something with each element inside each nested arraylist :
//        //main.get(x).get(y)
//
//    }

        //    large = number[0];
//    for(int i = 1; i<num.length;i++){
//        if (large < number [i]){
//            large = number[i];
//        }
//    }


//        Party returned = null;
//        for(int i = 0; i <= parties.size(); i++){
//            int o = i+1;
//            assert returned != null;
//            if(parties.get(i).getNumLocalReps()>parties.get(o).getNumLocalReps()&&parties.get(i).getNumLocalReps()>returned.getNumLocalReps()){
//                returned = parties.get(i);
//            }
//        }
//        return returned;
//
//    }
//        System.out.println("3");
//        Party largestParty = null;
//        System.out.println("4");
//        for (int i = 0; i <= parties.size(); i++) {
//
//            System.out.println("4.5");
//            Party iParty = parties.get(i);
//
//            for (int o = 1; o <= parties.size(); o++) {
//                System.out.println("5");
//                Party oParty = parties.get(o);
//
//                if (iParty.getNumLocalReps() > oParty.getNumLocalReps()) {
//                    System.out.println("6");
//                    largestParty = iParty;
//                } else {
//                    System.out.println("7");
//                    largestParty = oParty;
//                }
//            }
//           // return largestParty;
//        }
//        return largestParty;
//    }




//    public Party mostMEPs(ArrayList<Country> euCountries) {
//
//
//        for (int i = 0; i < euCountries.size(); i++) {
//            System.out.println("3");
//            Country iCountry = euCountries.get(i);
//            System.out.println("4");
//
//            ArrayList<MEP> mepps = iCountry.getMeps();
//
//            if (!iCountry.getMeps().isEmpty()) {
//                for (MEP mepo : mepps) {
//                    //if(mepo.getMEPName()
//                }
//            }
//        }
//    }


//            for (int o = 1; o < euCountries.size(); i++) {
//                Country oCountry = euCountries.get(o);
//                System.out.println("5");
//
//                if (iCountry.numberOfMEPs() > oCountry.numberOfMEPs()) {
//                    largestCountry = iCountry;
//                } else {
//                    largestCountry = oCountry;
//                }
//            }
//            largestCountry.

//        Country highestCountry = null;
//        int i = 0;
//        int o = i + 1;
////        for(Country country : euCountries){
//        for (i = 0; i < euCountries.size(); i++)
//            if (euCountries.get(i).numberOfMEPs() > euCountries.get(o).numberOfMEPs()) {
//                highestCountry =
//            }






//    large = number[0];
//    for(int i = 1; i<num.length;i++){
//        if (large < number [i]){
//            large = number[i];
//        }
//    }

