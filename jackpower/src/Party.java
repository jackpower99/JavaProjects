public class Party {

    private String partyName;
    private String partyLeader;
    private String partyGenre;
    private int numLocalReps;

    public Party(String partyName, String partyLeader, String partyGenre, int numLocalReps) {

        if (partyName.length() <= 30) {
            this.partyName = partyName;
        }

        this.partyLeader = partyLeader;

        if (partyGenre.equals("RIGHT") || partyGenre.equals("LEFT") || partyGenre.equals("EXTREME RIGHT") || partyGenre.equals("EXTREME LEFT") || partyGenre.equals("CENTRE") || partyGenre.equals("UNCATEGORISED")) {
            this.partyGenre = partyGenre;
        }
        else this.partyGenre = "unknown";

        if (numLocalReps >= 0) {
            this.numLocalReps = numLocalReps;
        }
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        if (partyName.length() <= 30) {
            this.partyName = partyName;
        }
    }

    public String getPartyLeader() {
        return partyLeader;
    }

    public void setPartyLeader(String partyLeader) {
        this.partyLeader = partyLeader;
    }

    public String getPartyGenre() {
        return partyGenre;
    }

    public void setPartyGenre(String partyGenre) {
        if (partyGenre.equals("RIGHT") || partyGenre.equals("LEFT") || partyGenre.equals("EXTREME RIGHT") || partyGenre.equals("EXTREME LEFT") || partyGenre.equals("CENTRE") || partyGenre.equals("UNCATEGORISED")) {
            this.partyGenre = partyGenre;
        } else {
            this.partyGenre = "unknown";
        }
    }

    public int getNumLocalReps() {
        return numLocalReps;
    }

    public void setNumLocalReps(int numLocalReps) {
        if (numLocalReps >= 0) {
            this.numLocalReps = numLocalReps;
        }
    }

    @Override
    public String toString() {
        return "Party{" +
                "partyName='" + partyName + '\'' +
                ", partyLeader='" + partyLeader + '\'' +
                ", partyGenre='" + partyGenre + '\'' +
                ", numLocalReps=" + numLocalReps +
                '}';
    }
}
