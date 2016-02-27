git pull
mvn clean dependency:copy-dependencies package
java -jar target/budgtr-<version>.jar