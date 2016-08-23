#This application is for validating UK postal codes to use the application please download the java runable file "zip.jar" from this link https://github.com/DavidIndrawes/ZipCode/raw/master/ZipCode/zip.jar
and use the cmd to navigate to the directory where you saved the zip.jar and use the following command to execute the application
java -jar zip.jar import_data.csv
where import_data.csv is the file containing the codes you want to validate you can replace import_data.csv with your file name, the file should be stored in a table format, where the first row is for the table heading and two columns the first one hold the row_id and the second one store all the postcodes, the application will print the running time on the cmd and produce two files to the same directory one is "failed_validation.csv" containing a table of three columns row_id , the failed post codes and the expected reason for failing, and the second file "Succedded_validtion.csv" with table of two columns row_id and the succeeded post codes, 
import_data.csv should be placed in the same directory with the zip.jar otherwise you will have to submit the absolute path of the file instead of just the name.

for more about the developing process and the analysis please read "analysis.md"
