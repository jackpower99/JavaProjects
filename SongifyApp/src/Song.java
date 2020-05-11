public class Song {

private String songName;
private String songGenre;
private int songLength;
private Artist artist;

/** constructor for all objects oc the class Song
 * @param songName Name of the song
 * @param songGenre Genre of the song
 * @param songLength Length of the song
 * @param artist Artist object
 */

    public Song (String songName, String songGenre, int songLength, Artist artist) {

        this.songName = songName;
        this.songGenre = songGenre;
        this.songLength = songLength;
        this.artist = artist;
    }

    //Getters


    public String getSongName() {
        return songName;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public int getSongLength() {
        return songLength;
    }

    public Artist getArtist() {
        return artist;
    }


    //Setters


    public void setSongName(String songName) {

        if (songName.size <= 30) {
            this.songName = songName;

        }
    }


    public void setSongGenre(String songGenre) {
        String a = "Rock";
        String b = "Pop";
        String c = "Blues";
        String d = "Rap";
        String e = "Dance";
        String f = "Classical";

        if (songGenre.equals(a, b, c, d, e, f)) {
            this.songGenre = songGenre;
        } else {
            this.songGenre = "Unknown";
        }
    }

    public void setSongLength(int songLength) {
        if (songLength >= 10 && songLength <= 1200) {
            this.songLength = songLength;
        } else {
            this.songLength = 0;
        }
    }

    public void setArtist(Artist artist) {
        if (artist != null){
            this.artist = artist;
        } else {
            ArtistList.addArtist(new Artist("Unknown","Invalid Format Email", "Unknown"));
        }
    }



        int lengthInMin = songLength / 60;

    @java.lang.Override
    public java.lang.String toString() {
        return
                songName + ", Artist:" + artist +
                "("+lengthInMin+")" +
                ", Genre:" + songGenre;

    }

}
