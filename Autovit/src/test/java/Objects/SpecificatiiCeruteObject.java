package Objects;

public class SpecificatiiCeruteObject {

    private String Marca;
    private String Model;
    private String Pretmin;
    private String Pretmax;
    private String Anmin;
    private String Anmax;
    private String Combustibil;

    public SpecificatiiCeruteObject(){}

    public String getMarca(){
        return Marca;
    }

    public void setMarca (String marca){
        Marca = marca;
    }

    public String getModel(){
        return Model;
    }

    public void setModel (String model){
        Model = model;
    }

    public String getPretmin(){
        return Pretmin;
    }

    public void setPretmin (String pretmin){
        Pretmin = pretmin;
    }

    public String getPretmax(){
        return Pretmax;
    }

    public void setPretmax (String pretmax){
        Pretmax = pretmax;
    }

    public String getAnmin(){
        return Anmin;
    }

    public void setAnmin (String anmin){
        Anmin = anmin;
    }

    public String getAnmax(){
        return Anmax;
    }

    public void setAnmax (String anmax){
        Anmax = anmax;
    }

    public String getCombustibil(){
        return Combustibil;
    }

    public void setCombustibil (String combustibil){
        Combustibil = combustibil;
    }

}
