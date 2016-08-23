

The developing process

•	Java 1.8 used 

•	Junit 4 used for testing (TDD)

•	IDE : eclipse

First question was does the provided Regex working was efficient, the answer is no and the only way to grantee 100% accuracy is to search each code in the database because there are many special cases and even the rules provided is not accurate 100% 
For example the postcode FY9 9AA that you have given in your table in the task describtion, this code succeeded all the validation rules but in the fact it is not a true postcode
So, I tried to optimize the expression for the A9 9AA and A99 9AA formats I have changed the expression of the first character from [A-PR-UWYZ] to [BEGLMNSW] as the rules state that only these letters is allowed for the first character for these two formats, 
also I have added  a list of the NHS special codes that I though it will be very important since these records comes from NHS database …
At part two and three of the task, I first tried to read all the records and store it in a collection , and then sort it before start validating the records, after that I noticed that this might be more expensive in terms of time and resources to read then sort then validate, so I changed the design to read each record and validate it immediately and then save it to a natural sorted collection "TreeMap" where the row_id is used as a key and the post code as a value, this step saved a sometime and resources.
After finishing the third part I decided to add a feature to the application to generate the expected problem like the table you have given, so I decided to implement such method which will be very useful if used within an online form where the user might fill his postcode by mistake, it will guide him to the expected problem, Since this method is quite expensive than the normal validation one, so I decided to use it only after finishing sorting the unvalid codes to avoid applying it on correct codes

To implement this method I have decided to use the State Design Pattern, but since I will not need for external event to change the validator state, I decided to implement the Chain Of Responsibility Pattern as a combination of both, singleton pattern was also used with the states classes ..
This additional feature have increased the application runtime for about 10% …
