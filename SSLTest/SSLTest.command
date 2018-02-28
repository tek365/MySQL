#/bin/bash

# Replace %user% with your path
source /etc/profile
cd /Users/%user%/Java/
rm -r -f /Users/%user%/Java/SSLTest.class
javac SSLTest.java
java SSLTest
