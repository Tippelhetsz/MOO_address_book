# MOO_address_book
An address book API

How to run application:
1) Clone the repositorie
2) Import into IDE as a Maven Project
(I used Eclipse to develop the project, in Eclipse: File -> "Import..." -> "Existing Maven Project" -> Search for the directory where the pom.xml is -> "Finish"
3) Right click in the project -> "Runa as..." -> "maven install" -> Deploy the .war file to a server
(I used Tomcat v8.0)
4) Start server
5) You can call the API at http://localhost:8080/AddressBook/api/customer which return the list of Customers in the address book or with http://localhost:8080/AddressBook/api/customer/{surname} to ask for the details of a customer.
