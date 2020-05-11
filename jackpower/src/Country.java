import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;

public class Country {

    private String name;
    private ArrayList<MEP> meps = new ArrayList<>();
    private int noMEPs;


    public Country(String name, int noMEPs) {

        this.name = name;
        this.noMEPs = noMEPs;

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoMEPs() {
        return noMEPs;
    }

    public void setNoMEPs(int noMEPs) {
        this.noMEPs = noMEPs;
    }

    public ArrayList<MEP> getMeps() {
        return meps;
    }

    public void setMeps(ArrayList<MEP> meps) {
        this.meps = meps;
    }

    public void addMEP(MEP seatHolder){

        meps.add(seatHolder);

    }

    public String listOfMEPs(){
        if (meps.size() == 0){
            return "No meps for this country ";
        }
        else {
            String listOfMep = "";
            for (int i = 0; i < meps.size(); i++) {
                listOfMep = listOfMep + i + ": " + meps.get(i) + "\n";
            }
            return listOfMep;
        }
    }

   public boolean removeMEP(int MepToRemove){
        if(!meps.isEmpty()) {
            meps.remove(MepToRemove);
            return true;
        }
        else {
            return false;
        }
   }

   public MEP getMEP(int fetched){
        if (!meps.isEmpty()&&fetched<=meps.size()) {
            return meps.get(fetched);
        }
        else return null;
   }

   public int numberOfMEPs(){
        return meps.size();
   }

   public String listOfMEPsByParty(Party party) {

       String parti = party.getPartyName();
       ArrayList<MEP> MEPsByParty = new ArrayList();

       for (MEP mep : meps) {

           if (mep.getMEPParty().equals(parti)) {
               MEPsByParty.add(mep);
           }
       }

       String listOfMEPsByParty = "";
       for (int x = 0; x < MEPsByParty.size(); x++) {

           listOfMEPsByParty = listOfMEPsByParty + x + ": " + MEPsByParty.get(x) + "\n";

       }
       return listOfMEPsByParty;
   }

   public int noOfMEPsByParty(Party party){

         String partyName = party.getPartyName();

         ArrayList<MEP> tempMeps = new ArrayList<>();

        for ( MEP mep : meps){
            if (mep.getMEPParty().equals(partyName)){
                tempMeps.add(mep);
            }
        }
        return tempMeps.size();

   }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", noMEPs=" + noMEPs +
                '}';
    }
}


