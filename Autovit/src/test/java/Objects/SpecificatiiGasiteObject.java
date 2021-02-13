package Objects;

public class SpecificatiiGasiteObject {

    private String Descriere;
    private String Motorizare;
    private String Km;
    private String An;
    private String Locatie;
    private String Pret;
    private String Link;
    private String Denumire;

    public SpecificatiiGasiteObject(){}

    public String getDescriere() {
        if(Descriere == null){
            Descriere="";
        }
        return Descriere;
    }

    public void setDescriere(String descriere) {
        Descriere = descriere;
    }

    public String getMotorizare() {
        if(Motorizare == null){
            Motorizare ="";
        }
        return Motorizare;
    }

    public void setMotorizare(String motorizare) {
        Motorizare = motorizare;
    }

    public String getKm() {
        if(Km == null){
            Km = "";
        }
        return Km;
    }

    public void setKm(String km) {
        Km = km;
    }

    public String getAn() {
        if(An == null){
            An = "";
        }
        return An;
    }

    public void setAn(String an) {
        An = an;
    }

    public String getLocatie() {
        if(Locatie == null){
            Locatie ="";
        }
        return Locatie;
    }

    public void setLocatie(String locatie) {
        Locatie = locatie;
    }

    public String getPret() {
        if(Pret == null){
            Pret = "";
        }
        return Pret;
    }

    public void setPret(String pret) {
        Pret = pret;
    }

    public String getLink() {
        if(Link == null){
            Link ="";
        }
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getDenumire() {
        if(Denumire == null){
            Denumire="";
        }
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }
}
