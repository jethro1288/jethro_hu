##### The programming language I used for this programming test is Java
#### The java classes that I wrote include:
* `Employee.java` - an entity class representing an employee
* `TreeNode.java` - an tree node class used for representing the organization hierarchy
* `OrgHierarchyHelper.java` -  a helper class handling the logic of the organization hierarchy
* `Main.java` - an entry class with main method
* `OrgHierarchyHelperTest.java` a test class for testing the creation of organization hierarchy of the helper

#### The CSV file 
* `employees.csv` a CSV file including all records of employees has been added into the folder of `jethro_hu/src/main/resources`, which is used as data sources in this code challenge.

### Steps of reviewing and verifying my changes
* Make sure the running environment has Maven and Java (1.8) installed. 
* Download the ZIP file or clone the repository from Github
* Run CMD and navigate to the main folder(jethro_hu) that includes my changes, and run the command of `mvn clean package`
* Under the main folder, run the command of `java -jar target/momenton-1.0.jar` and then the organization 
hierarchy will be printed on the console, which is similar to the following:

*******Organization Hierarchy*********</br>

 Jamie

             Alan

                         Martin

                         Alex

             Steve

                         David

 
#### Where you can find the java classes:
* All java classes except the testing code have been put under`jethro_hu/src/main/java/jethro/momenton`
* Test testing class has been put under `jethro_hu/src/test/java/jethro/momenton`
