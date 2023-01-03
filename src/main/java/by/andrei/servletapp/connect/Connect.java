package by.andrei.servletapp.connect;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

    public static Connection dbCon()
    {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\springbootapp\\JsonRestApp\\servletApp\\src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Connection con=null;
        String driver=properties.getProperty("driver");
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String pass=properties.getProperty("pass");
        try {

            Class.forName(driver);
            con= DriverManager.getConnection(url,user,pass);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
