# DATA WAREHOUSING

### TDT4300 - Assignment 1

#### By Magnus L. Holtet and Andreas Amundsen

## Modeling

Star Schema:

![Flights Star Scheme (1) (1)](/Users/magnusholtet/Downloads/Flights Star Scheme (1) (1).png)

Concept Hierarchies:

![Concept Hierarcht (2)](/Users/magnusholtet/Downloads/Concept Hierarcht (2).png)



No particular assumptions made.

## OLAP Operations

### Report 1

```sql
SELECT 
	[Measures].[elapsed_time_m] ON COLUMNS
	FROM [MyCube]
```

![Screenshot 2020-02-07 at 15.22.17](/Users/magnusholtet/Library/Application Support/typora-user-images/Screenshot 2020-02-07 at 15.22.17.png)

No OLAP operation.



### Report 2

```sql
SELECT 
	[Measures].[elapsed_time_a] ON COLUMNS,
  [AirlinesD].[AirlinesH].[AirlinesL] ON ROWS
 	FROM [MyCube]
```

![Screenshot 2020-02-07 at 15.22.44](/Users/magnusholtet/Library/Application Support/typora-user-images/Screenshot 2020-02-07 at 15.22.44.png)

- Drill-down on AirlinesD from All to AirlinesL.

### Report 3

```sql
SELECT 
	[Measures].[flight_c] ON COLUMNS
  FROM [MyCube] WHERE [TimeD].[TimeH].[DayL].&[2015-01-03]
```

![Screenshot 2020-02-07 at 15.23.32](/Users/magnusholtet/Library/Application Support/typora-user-images/Screenshot 2020-02-07 at 15.23.32.png)

- Drill-down on TimeD to DayL.
- Slice on TimeD with DayL equal to "2015-01-03"

### Report 4

```sql
SELECT
	NON EMPTY TopCount([LocationD].[LocationH].[AirportL].MEMBERS, 1, [Measures].[airport_c]) ON ROWS,
	NON EMPTY TopCount([TimeD].[TimeH].[DayL], 1, [Measures].[airport_c]) ON COLUMNS
	FROM MyCube
```

![Screenshot 2020-02-07 at 15.24.01](/Users/magnusholtet/Desktop/Screenshot 2020-02-07 at 15.24.01.png)

- Drill-down on LocationD from All to AirportL.
- Drill-down on TimeD from All to DayL.

### Report 5

```sql
SELECT 
	[Measures].[distance_S] ON COLUMNS,
	NON EMPTY Order([TimeD].[TimeH].[DayL], [Measures].[distance_s],BASC) ON ROWS
	FROM [MyCube]
```

![Screenshot 2020-02-07 at 15.24.51](/Users/magnusholtet/Library/Application Support/typora-user-images/Screenshot 2020-02-07 at 15.24.51.png)

- Drill-down on TimeD from All to DayL.

