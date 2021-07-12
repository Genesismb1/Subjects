# Subjects
Subjects taught at university


Create a Subject class, whose instances will represent the subjects for study at a university. A subject will have a name, just a String, and a subject code, which is a six-character String. The first three characters of a subject code are alphabetic and the last three are numeric. The first three characters define the subject's discipline area. A subject code must be unique but do not need to check subject name for uniqueness.

You will also write a TestSubject class to test the use of your Subject class. In particular this will maintain an array of subjects. In order to manage the uniqueness of the subject codes, your program will need to display information about existing subject codes as well as checking that any new subject code supplied by the user is not the same as any existing subject code.

The following state and functionality should be provided for the Subject class:



* Two fields will hold the subject’s name (e.g. Programming in java 1) and the six-character subject code (e.g. ITC206).
* A constructor will allow a name and a new, validated subject code to be provided when a new subject is created.
* Getters will provide access to the attributes.
* An accessor method called codeMatches will return a boolean value indicating if the subject's code matches the string argument provided. "Matches" is used here in the same sense as for the matches method of the String class.
* A toString method will return a string containing the subject code and subject name.
To assist with managing subject codes and their uniqueness you will provide the Subject class with some class methods as follows (you may add more method9s) if you need):



An isValidCode method will accept a string that is a possible new subject code, and return a boolean indicating whether it satisfies the structural requirements for a subject code (i.e. first three characters are letters and last three characters are digits).
A codeExists method will accept an array of Subject objects and a possible new subject code. It will return a boolean indicating whether that code has already been allocated to one of the subjects in the array.
Your TestSubject program will perform the following sequence of actions, using good design techniques such as in the appropriate use of methods:



An initial array of Subject objects will be created from any data in a file that was previously saved by the program (not using programming in java, just open a text file and write subject name and code and then save the file). You need to read those data from the file and process other requirements (using java programming)
The user interaction will then proceed to allow the user to add one or more new subjects to the array. If the user wishes to add new subjects, the existing subjects should be displayed. Each subject code entered by the user should be checked against the existing subject codes. The user can enter any new subject, but only non-existing subject codes and their names should be added in the subject list, otherwise, give opportunity to enter new code if the entered subject code already exists in the list. The user should be given the choice of repeating the processing for more subjects.
When the user has finished adding subjects, and only if subjects have indeed been added, the program will overwrite the data file with the updated data if anyone open the file using file explorer, he/she can see the all subjects including the newly added subjects.