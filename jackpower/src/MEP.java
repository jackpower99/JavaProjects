public class MEP {

    private String MEPName;
    private String MEPEmail;
    private String MEPPhone;
    private String MEPParty;

    public MEP(String MEPName, String MEPEmail, String MEPPhone, String MEPParty) {
        this.MEPName = MEPName;
        this.MEPEmail = MEPEmail;
        this.MEPPhone = MEPPhone;
        this.MEPParty = MEPParty;
    }

    public String getMEPName() {
        return MEPName;
    }

    public void setMEPName(String MEPName) {
        if (MEPName.length()<=30) {
            this.MEPName = MEPName;
        }
    }

    public String getMEPEmail() {
        return MEPEmail;
    }

    public void setMEPEmail(String MEPEmail) {
        if(MEPEmail.contains("@")) {
            this.MEPEmail = MEPEmail;
        }
    }

    public String getMEPPhone() {

        return MEPPhone;
    }

    public void setMEPPhone(String MEPPhone){
        if(MEPPhone.matches("[0-9]+"))
        {
            this.MEPPhone = MEPPhone;
        }
        else {
            this.MEPPhone = "Unknown";
        }
    }

    public String getMEPParty() {
        return MEPParty;
    }

    public void setMEPParty(String MEPParty) {

        this.MEPParty = MEPParty;
    }

    @Override
    public String toString() {
        return "MEP{" +
                "MEPName='" + MEPName + '\'' +
                ", MEPEmail='" + MEPEmail + '\'' +
                ", MEPPhone='" + MEPPhone + '\'' +
                ", MEPParty='" + MEPParty + '\'' +
                '}';
    }
}
