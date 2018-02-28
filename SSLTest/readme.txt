TESTING A NEW MYSQL SERVER WITH OR WITHOUT SSL 3306

HOW TO SETUP ON YOUR LOCAL MACHINE
Put into your folder ConnectJ Driver /Users/%User%/Java
/Users/%User%/driver-bin/mysql-connector-java-5.1.45-bin.jar
Setup in /etc/profiles the following CLASSPATH to driver
export CLASSPATH=.:/Users/%User%/driver-bin/mysql-connector-java-5.1.45-bin.jar
Put in /Users/%User%/Java/SSLTest.command
Put in /Users/%User%/Java/SSLTest.java
Click on "SSLTest.command" or run at shell to execute

IMPORTANT SWITCHES FOR CONNECTORJ
useSSL=false (initialy test SSL off)
enabledTLSProtocols=TLSv1.2 (force TLSv1.2 a good idea)
relaxAutoCommit=false (not that important for testing)
interactiveClient=false (not that important for testing, some docs refernence it)
autoReconnectForPools=true (not that important for testing, some docs refernence it)
verifyServerCertificate=false (use with MySQL PEM for 2 way binding, eaisier than trustkey/keystore)
useSSL=true (use in final SSL tesing set to this value, initialy set false)
requireSSL=true (use in final SSL tesing set to this value, initialy set false)

THIS CAN BE SET TO CUSTOM QUERY IF NEEDED
rs = s1.executeQuery("show status;");
