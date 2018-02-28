import java.sql.*;

// TESTING A NEW MYSQL SERVER WITH OR WITHOUT SSL 3306
//
// HOW TO SETUP ON YOUR LOCAL MACHINE
// Put into your folder ConnectJ Driver /Users/%User%/Java
// /Users/%User%/driver-bin/mysql-connector-java-5.1.45-bin.jar
// Setup in /etc/profiles the following CLASSPATH to driver
// export CLASSPATH=.:/Users/%User%/driver-bin/mysql-connector-java-5.1.45-bin.jar
// Put in /Users/%User%/Java/SSLTest.command
// Put in /Users/%User%/Java/SSLTest.java
// Click on "SSLTest.command" or run at shell to execute
//
// IMPORTANT SWITCHES FOR CONNECTORJ
// useSSL=false (initialy test SSL off)
// enabledTLSProtocols=TLSv1.2 (force TLSv1.2 a good idea)
// relaxAutoCommit=false (not that important for testing)
// interactiveClient=false (not that important for testing, some docs refernence it)
// autoReconnectForPools=true (not that important for testing, some docs refernence it)
// verifyServerCertificate=false (use with MySQL PEM for 2 way binding, eaisier than trustkey/keystore)
// useSSL=true (use in final SSL tesing set to this value, initialy set false)
// requireSSL=true (use in final SSL tesing set to this value, initialy set false)
//
// THIS CAN BE SET TO CUSTOM QUERY IF NEEDED
// rs = s1.executeQuery("show status;");

 
public class SSLTest
{
    public static void main (String[] args)
    {
        Connection conn = null;
            
            try
            {
                String userName = "{db_user}";
                String password = "{db_pass}";
                String hosts = "{databaseIP}:3306";
                String url = "jdbc:mysql://" + hosts + "/{database_name}?useSSL=false&enabledTLSProtocols=TLSv1.2&relaxAutoCommit=false&interactiveClient=false&autoReconnectForPools=true";
  //  added enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true&requireSSL=true
  //              java.util.Properties connProperties = new java.util.Properties();
  //              connProperties.put(useSSL, false);
                Class.forName ("com.mysql.jdbc.Driver").newInstance ();
  //            conn = DriverManager.getConnection (url, userName, password, connProperties);
                conn = DriverManager.getConnection (url, userName, password);


                System.out.println ("Database connection established");
            }
            catch (Exception e)
            {
                System.err.println ("Cannot connect to database server: " + e);
            }
 
            try
            {
                conn.setAutoCommit(false);

                Statement s1 = conn.createStatement ();
                ResultSet rs;
                String response_value;
                rs = s1.executeQuery("show status;");
           //   rs = s1.executeQuery("show status like 'Ssl_version';");
                while (rs.next()) {
                        // response_value = rs.getString("@@hostname");
                        response_value = rs.getString("Value");
                        System.out.println("Query result: " + response_value);
                }
            }
            catch (SQLException e)
            {
                System.err.println ("Error when executing SQL statement: " + e);
            }
            // Close connection
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e)
                {
                    System.err.println( "Error when closing database connection: " + e );
                }
            }
            try { Thread.sleep(1000); } catch( Exception e ) { }
        }
    }
