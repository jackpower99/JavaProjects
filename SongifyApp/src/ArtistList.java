import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArtistList {



    //Declare Array List  called artists containing objects called Artist

    private ArrayList<Artist> artists;



    //ArrayList function called ArtistList that allows Artist Objects to be passed into the ArrayList artists.

    public ArtistList() {
        artists = new ArrayList<Artist>();
    }



    //Add a Artist object to the collection of Artists in the artist array list artists

    public void addArtist(Artist artist) {
        artists.add(artist);
    }



    //Return Artist object in given index in the artists array list

    //if the index is valid, return the Artist object at the given index

    public Artist getArtist(int index) {
        Artist yourArtist = artists.get(index);
        if ((index >= 0) && (index < artists.size())) {
            return yourArtist;
        }
        else {
            return null;
        }
    }



    //Returns number of Artist objects in the artist array list

    public String numberOfArtists() {

        if (artists.size() == 0) {
            return "No artists";
        }
        else {
            return artists.size;
        }
    }


    //If the index is valid remove the object at index passed in from array list artists

    public boolean removeArtist(int index){

        if ((index >= 0) && (index < artists.size())) {
            //if the index is valid, delete the Artist object at the given index
            artists.remove(index);

            return true;

        } else {

            return false;
        }
    }

    public String listOfArtists(){

        if (artists.size() == 0){
            return "No artists";
        }
        else{
            String listArtists = "";
            for (int i = 0; i < artists.size(); i++){
                listArtists = listArtists + i + ": " + artists.get(i) + "\n";
            }
            return listArtists;
        }


    }


}