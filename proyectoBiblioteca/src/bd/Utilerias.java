package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilerias {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://";

  public static Connection conectar(String usuario, String pass, String bd, String host) {
    Connection res = null;
    try {
      // Registrar JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      String url = DB_URL + host + '/' + bd;
      res = DriverManager.getConnection(url, usuario, pass);
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return res;
  }



}
