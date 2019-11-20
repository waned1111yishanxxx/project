package dao;


import java.sql.*;

/*

 * 该处的HandleMySQL负责与本地数据库连接，因此只需要修改数据库名，用户名，密码即可

 * */
public class MySQLUtils {
    private String driver = "com.mysql.jdbc.Driver";
    private String dbName = "isbn_database?useUnicode=true&characterEncoding=utf8";//数据库名字

    private String url = "jdbc:mysql://localhost:3306/";//数据库地址以及名称
    private String user = "root";//数据库用户名
    private String password = "123456";//数据库用户密码
    private Connection conn;

    public Statement linkMySQL() {
        try {
            Class.forName(driver);//加载驱动程序
            conn = DriverManager.getConnection(url + dbName, user, password);//连接数据库
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            Statement statement = conn.createStatement();// statement用来执行SQL语句

            return statement;

        } catch (ClassNotFoundException e) {

            // TODO Auto-generated catch block

            System.err.println("HandleMySQL Class.forName出错");

            System.err.println(e.getMessage());

            e.printStackTrace();

            return null;

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            System.err.println("HandleMySQL Connection出错");

            System.err.println(e.getMessage());

            //e.printStackTrace();

            return null;

        }


    }


    public PreparedStatement linkMySQL(String sql) {


        try {

            Class.forName(driver);//加载驱动程序

            Connection conn = DriverManager.getConnection(url + dbName, user, password);//连接数据库

            if (!conn.isClosed())

                System.out.println("Succeeded connecting to the Database!");

            PreparedStatement preStatement = conn.prepareStatement(sql);// PreparedStatement用来执行SQL语句

            return preStatement;

        } catch (ClassNotFoundException e) {

            // TODO Auto-generated catch block

            System.err.println("HandleMySQL Pre Class.forName出错");

            System.err.println(e.getMessage());

            //e.printStackTrace();

            return null;

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            System.err.println("HandleMySQL Pre Connection出错");

            System.err.println(e.getMessage());

            //e.printStackTrace();

            return null;

        }


    }


    public void closeMySQL(Statement statement) {

        try {

            if (statement == null)

                return;

            statement.close();

            System.out.println("close the link to datebase");

            //conn.close();

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            //e.printStackTrace();

            System.err.println("HandleMySQL Pre closeMySQL出错");

            System.err.println(e.getMessage());

        }

    }


    public void closeMySQL(PreparedStatement preStatement) {

        try {

            if (preStatement == null)

                return;

            preStatement.close();

            System.out.println("close the link to datebase");

            //conn.close();

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            //e.printStackTrace();

            System.err.println("HandleMySQL Pre closeMySQL出错");

            System.err.println(e.getMessage());

        }

    }


}
