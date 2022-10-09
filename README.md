# 2x2x2 Rubik solver

An example of using BFS to solve Rubik's cube. Choosing Rubik of size 2 simplifies a lot of coding but the idea remains the same.

## Some reading

### God's number
The smallest number of steps for solving any (3x3x3) Rubik's cube configuration (the diameter of Rubik graph). Finding this number is a difficult question and requires a lot of computing power.

There are two types of moves:

* Quarter moves only (QTM): rotation of a 90 degree: 20 (Rokicki et al. (2010), 35 CPU-years)

[https://www.cube20.org/](https://www.cube20.org/)

* Quarter or half moves (HTM): 26

### 2x2x2 cube (Pocket Cube)
[https://en.wikipedia.org/wiki/Pocket_Cube](https://en.wikipedia.org/wiki/Pocket_Cube)

* $7!\times 3^6 = 3,674,160$ possible positions (assuming one piece is always solved from orienting the puzzle)
* 11 turns (HTM) / 14 turns (QTM) (the number of configurations for each number of steps are listed below)

| $n$ | HTM              | QTM                      |
|-----|------------------|--------------------------|
| 0   | 1                | 1                        |
| 1   | 9                | 6                        |
| 2   | 54               | 27                       |
| 3   | 321              | 120                      |
| 4   | 1847             | 534                      |
| 5   | 9992             | 2256                     |
| 6   | 50136            | 8969                     |
| 7   | 227536           | 33058                    |
| 8   | 870072           | 114149                   |
| 9   | 1887748          | 360508                   |
| 10  | 623800           | 930588                   |
| 11  | 2644             | 1350852                  |
| 12  | 0                | 782536                   |
| 13  | 0                | 90280                    |
| 14  | 0                | 276                      |
