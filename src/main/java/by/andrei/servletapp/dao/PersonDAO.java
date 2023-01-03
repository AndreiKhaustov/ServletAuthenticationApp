package by.andrei.servletapp.dao;

import by.andrei.servletapp.connect.Connect;
import jsp.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean userLogin(Person person) {
        String checkData = "Select * from Person where username=? and password=?";

        con = Connect.dbCon();

        try {
            ps = con.prepareStatement(checkData);

            ps.setString(1, person.getUsername());
            ps.setString(2, person.getPassword());

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}