# Bingo-ticket-generator

## Specification

Ticket Generator Challenge
A small challenge that involves building a Bingo 90 ticket generator.

#### Requirements:
* Generate a strip of 6 tickets
* Tickets are created as strips of 6, because this allows every number from 1 to 90 to appear across all 6 tickets. If they buy a full strip of six it means that players are guaranteed to mark off a number every time a number is called.
* A bingo ticket consists of 9 columns and 3 rows.
* Each ticket row contains five numbers and four blank spaces
* Each ticket column consists of one, two or three numbers and never three blanks.
* The first column contains numbers from 1 to 9 (only nine),
* The second column numbers from 10 to 19 (ten), the third, 20 to 29 and so on up until
* The last column, which contains numbers from 80 to 90 (eleven).
* Numbers in the ticket columns are ordered from top to bottom (ASC).
* There can be no duplicate numbers between 1 and 90 in the strip (since you generate 6 tickets with 15 numbers each)
* Please make sure you add unit tests to verify the above conditions and an output to view the strips generated (command line is ok).
* Try to also think about the performance aspects of your solution. How long does it take to generate 10k strips? The recommended time is less than 1s (with a lightweight random implementation)

## Solution
### Prerequisites
* [JAVA 21](https://www.java.com/en/download/) SDK or later version
* [Apache Maven 3.9.6](https://maven.apache.org/) - dependency management tool

### Build
For build the application use the following command in the project root:
```
mvn clean install
```

### Run
In the root directory use the following command to run the application:

```
java -jar target/bingo-ticket-generator-1.0-SNAPSHOT.jar
```

### Example output

```
[ 1 __ 23 __ 46 __ 62 __ 81 ]
[ _ 12 __ 30 __ 50 __ 70 86 ]
[ _ 16 __ 36 __ 56 67 71 __ ]

[ _ 14 __ 38 __ 53 __ 75 83 ]
[ 6 __ 21 __ 41 __ 66 __ 84 ]
[ 7 __ 26 __ 45 57 __ 76 __ ]

[ 8 __ 22 __ 47 __ 60 __ 82 ]
[ _ 13 __ 33 __ 51 __ 77 89 ]
[ _ 18 24 34 __ 55 __ 78 __ ]

[ 2 __ 25 __ 42 52 63 __ __ ]
[ 4 __ 28 __ 43 __ 65 __ 80 ]
[ _ 11 __ 37 __ 54 __ 73 87 ]

[ _ 10 20 31 40 __ 64 __ __ ]
[ 5 __ 27 __ 48 __ 68 __ 85 ]
[ _ 15 __ 35 __ 58 __ 72 88 ]

[ 3 __ 29 __ 44 __ 61 74 __ ]
[ _ 17 __ 32 __ 59 __ 79 90 ]
[ 9 19 __ 39 49 __ 69 __ __ ]
```

### Tests

For run the tests use the following command in the project root:
```
mvn verify 
```
The required tests are in `BingoTicketTest` and `BingoTicketTest`class.
On 2024 M3 MAC 36GB RAM, the application generates 10k strips in 192ms. 