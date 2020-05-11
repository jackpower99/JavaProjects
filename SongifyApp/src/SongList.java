public class SongList {


    //Declare Array List called songs containing objects called songs
    private ArrayList<Song> songs;


    //ArrayList function called ArtistList that allows Artist Objects to be passed into the ArrayList artists.
    public SongList() {
        songs = new ArrayList<Song>();
    }

    //Function that adds the Song objects into songs Array List
    public void addSong(Song song) {
        songs.add(song);
    }

    //Function that takes in an index from user and returns the chosen song
    public Song getSong(int index) {
        Song yourSong = songs.get(index);
        if ((index >= 0) && (index < songs.size())) {
            return yourSong;
        } else {
            return null;
        }
    }

    public boolean removeSong(int index) {
        if ((index >= 0) && (index < songs.size())) {
            //if the index is valid, delete the Song object at the given index from the songs array list
            songs.remove(index);

            return true;

        } else {

            return false;
        }
    }

    public int numberOfSongs() {

        return songs.size();
    }


    public String listOfSongs() {
        if (songs.size() == 0){
            return "No songs";
        }
        else{
            String listSongs = "";
            for (int i = 0; i < songs.size(); i++){
                listSongs = listSongs + i + ": " + songs.get(i) + "\n";
            }
            return listSongs;
        }
    }

    public String listSongsBySpecificGenre( String genre ) {

        for(int i = 0; i <= songs.size; i++)

            if (songs.contains(genre)){
                return ;
            }
        }
        System.out.println("No doctors with that ID!");
        return null;
    }

    }
}




