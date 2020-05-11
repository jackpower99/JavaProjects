

public class Artist {

    private String artistName;
    private String artistEmail;
    private String artistPhone;

    /**
     * constructor for all objects oc the class Artist
     *
     * @param artistName  Name of the artist
     * @param artistEmail Email of the artist
     * @param artistPhone Phone number of the artist
     */

    public Artist(String artistName, String artistEmail, String artistPhone) {

        this.artistName = artistName;
        this.artistEmail = artistEmail;
        this.artistPhone = artistPhone;

    }

    //Getters

    /**
     * Returns the artist Name
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Returns the artist Email
     */
    public String getArtistEmail() {
        return artistEmail;
    }

    /**
     * * Returns the artist Phone Number
     */
    public String getArtistPhone() {
        return artistPhone;
        }


    //Setters

    /**
     * Updates the Artist Name to the value passed in as a parameter
     * @param artistName The new Artist Name
     */
    public void setArtistName (String artistName){
        if (artistName.size <= 30) {
            this.artistName = artistName;
        }
    }


    /**
     * Updates the Artist Email to the value passed in as a parameter
     * @param artistEmail The new Artist Email
     * Set artist Email
     */

    public void setArtistEmail(String artistEmail) {
        if (artistEmail.contains("@")) {
            this.artistEmail = artistEmail;
        } else {
            this.artistEmail = "invalid Format Email";
        }
    }

    /**
     * Updates the Artist Phone number to the value passed in as a parameter
     * @param artistPhone  The new Artist Number
     */

    public void setArtistPhone(String artistPhone) {
        for (int i = 0; i < artistPhone.length(); i++) {
            if (artistPhone.isDigit(artistPhone.charAt(i))) {
                this.artistPhone = artistPhone;
            }
            else if (!artistPhone.isDigit(artistPhone.charAt(i))) {
                this.artistPhone = "Unknown";

            }
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return artistName
        + "(email: "+artistEmail
        + ", phone: "+artistPhone
        + ")";
    }
}
