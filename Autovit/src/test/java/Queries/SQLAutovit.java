package Queries;

import DataBase.DataBase;
import Objects.SpecificatiiCeruteObject;
import Objects.SpecificatiiGasiteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLAutovit {
    ResultSet Result;
    DataBase dataBase;

    public SQLAutovit (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public int getNumberRows() throws SQLException {
        String select = "select count(*) from MasiniCautate";
        PreparedStatement Prepare= dataBase.Connection.prepareStatement(select);
        Result=Prepare.executeQuery();
        int countNumber=0;
        if(Result.next()){
            countNumber=Result.getInt(1);
        }
        return countNumber;
    }

    //Marca
    public void SelectMarca(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setMarca(Result.getString(2));
        }
    }

    //Model
    public void SelectModel(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setModel(Result.getString(3));
        }
    }

    //Pretmin
    public void SelectPretmin(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setPretmin(Result.getString(4));
        }
    }

    //Pretmax
    public void SelectPretmax(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setPretmax(Result.getString(5));
        }
    }

    //Anmin
    public void SelectAnmin(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setAnmin(Result.getString(6));
        }
    }

    //Anmax
    public void SelectAnmax(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setAnmax(Result.getString(7));
        }
    }

    //Combustibil
    public void SelectCombustibil(SpecificatiiCeruteObject specificatiiCeruteObject, String NumeTabel, int id) throws SQLException {
        String Select = "select * from " + NumeTabel + " where idMasiniCautate=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            specificatiiCeruteObject.setCombustibil(Result.getString(8));
        }
    }

    //Insert
    public void InsertDescriere(SpecificatiiGasiteObject specificatiiGasiteObject,String NumeTabel) throws SQLException {
        String Insert = "insert into " + NumeTabel + " values ('" + specificatiiGasiteObject.getDenumire()
                + "', '" + specificatiiGasiteObject.getDescriere() + "', '" + specificatiiGasiteObject.getMotorizare()
                + "', '" + specificatiiGasiteObject.getKm() + "', '" + specificatiiGasiteObject.getAn()
                + "', '" + specificatiiGasiteObject.getLocatie() + "', '" + specificatiiGasiteObject.getPret()
                + "', '" + specificatiiGasiteObject.getLink() + "') ";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Insert);
        Prepare.execute();
    }


}

