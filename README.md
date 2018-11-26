# FamilyTree
A Java project that uses Maven as a build tool. 
Application takes a file containing children and their parents names and outputs a family tree.

## Example of input and output
### Content of input file:
Adam Ivan
Marko Stjepan
Stjepan Adam
Robert Stjepan
Fran Ivan
Leopold Luka
Leopold Ivan
Teodor Leopold
Stjepan Josip

### Expected utput:
Ivan
    Adam
        Stjepan
            Marko
            Robert
    Fran
    Leopold
        Teodor
Luka
    Leopold
        Teodor
Josip
    Stjepan
        Marko
        Robert

## Running and testing the application
Application takes a file path as an argument from command line and outputs a result.

### Example of running an application through command line using javac
..\FamilyTree\src\main\java>javac App.java
..\FamilyTree\src\main\java>java App C:\FamilyTree\src\main\resources\podaci.txt
Ivan
    Adam
        Stjepan
            Marko
            Robert
    Fran
    Leopold
        Teodor
Luka
    Leopold
        Teodor
Josip
    Stjepan
        Marko
        Robert

Application can be tested from command line using Maven commands.

### Example of running tests from command line using Maven
..\FamilyTree>mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< com.altima:FamilyTree >------------------------
[INFO] Building FamilyTree 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ FamilyTree ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ FamilyTree ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ FamilyTree ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ FamilyTree ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ FamilyTree ---
[INFO] Surefire report directory: C:\FamilyTree\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running FamilyEditorTest
RelationNotAllowedException: Msg: Adam cannot be its parent or child!
RelationNotAllowedException: Msg: Trying to make cyclic relation with Adam and Robert!
RelationNotAllowedException: Msg: Adam is already a child of Ivan!
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.103 sec
Running PersonTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec

Results :

Tests run: 13, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.275 s
[INFO] Finished at: 2018-11-26T16:59:51+01:00
[INFO] ------------------------------------------------------------------------
