Run from command line:

mvn test -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src/test/resources/regression-suite.xml

mvn test -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src/test/resources/regression-suite.xml

mvn test -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src/test/resources/smoke-suite.xml

mvn test -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src/test/resources/smoke-suite.xml