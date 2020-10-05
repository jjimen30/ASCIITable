# ASCII Table

**A lightweight ASCII table generator** 

## About

A table to easily generate CLI tables. I created this library to save me some time in my CS classes. No tricky syntax, no clever notation, just a simple table making library. 

## How To Use

**FastTable** 
A FastTable is a fast way to create a table. It is optimized and will not resize automatically. The cell width will be calculated according to the longest `String` in the header. 

### Sample Code

``` Java
	
	// Initialize the table with the number of columns.
	FastTable table = new FastTable(3);

	// Call addHeader and pass a String array.
	table.addHeader(new String[] { "NAME", "LAST NAME", "AGE" });

	// Add one row at a time.
	table.addRow(new String[] { "John", "Danky", "23" });
	table.addRow(new String[] { "Peter", "The cell will add padding vertically to accomodate according to the column width", "23" });
	table.addRow(new String[] { "Donald", "Trump", "12" });

	table.print();
	
```

### Sample Output

``` 
o-----------+-----------+-----------o
|      NAME | LAST NAME |       AGE |
|-----------+-----------+-----------|
|      John |     Danky |        23 |
|-----------+-----------+-----------|
|     Peter | The cell  |        23 |
|           | with add  |           |
|           | padding v |           |
|           | ertically |           |
|           |  to accom |           |
|           | odate lon |           |
|           | g strings |           |
o-----------+-----------+-----------o

```
