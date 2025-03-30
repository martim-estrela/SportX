package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    private static int versiondb = 2; //(1-Martim ; 2-Sérgio ; 3- Miguel

    static
    {
        if (versiondb == 1)
        {
            URL = "jdbc:mysql://localhost:3306/sportx_db";
            USER = "root";
            PASSWORD = "130213";
        }
        else if (versiondb == 2)
        {
            URL = "jdbc:mysql://localhost:3306/sportx_db";
            USER = "root";
            PASSWORD = "s1845163";
        }
        else if (versiondb == 3)
        {
            URL = "jdbc:mysql://localhost:3306/sportx_db";
            USER = "root";
            PASSWORD = "???";  // Por pass real
        }
        else
        {
            throw new IllegalStateException("Invalid versiondb value");
        }
    }

    public static Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e)
        {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    public static void main(String[] args)
    {
        Connection conn = getConnection();
        if (conn != null)
        {
            System.out.println("Conexão bem-sucedida!");
        }
    }
}
