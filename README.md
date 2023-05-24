# Martian Robots

Written in Kotlin using Java 19

### Running the program

Navigate to the cloned folder and run the following command to build the project

``./gradlew clean build``

Run the following command to start the project. Input can be changed by editing the text file at resources/sample_input.txt

``./gradlew run``

Run the following command to execute tests

``./gradlew test``

### Time limitations

Points that could be improved with additional time:

- Update objects to be immutable, make code more functional rather than iterative
- Acceptance testing, test full flow end to end
- Add tests for ParseInput class
- Add more test cases for MarsSurfaceTest
- Catch specific exceptions rather than any Exception in ParseInput
