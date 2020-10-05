# ASCII Table

**A lightweight ASCII table generator** 

## About

An API to easily generate CLI tables. I created this library to save time when working on CS class assignements, it is also a great tool for debugging. No tricky syntax, no clever notation, just a simple table making library. 

## How To Use

### **FastTable**

A FastTable is a fast way to create a table. It is optimized and will not resize automatically. The cell width will be calculated according to the longest `String` in the header. 

### Sample Code

``` Java
		// Initialize the table with the number of columns.
		FastTable table = new FastTable(3);

		// Call addHeader and pass a String array. The header is left
		// aligned by default. Use overloaded constructor to right align.
		table.addHeader(new String[] { "NAME", "LAST NAME", "AGE" });

		// Add one row at a time.
		table.addRow(new String[] { "John", "Danky", "23" });
		table.addRow(new String[] { "Peter",
				"The cell will add padding vertically to accomodate according to the column width", "23" });
		table.addRow(new String[] { "James", "Rondonon", "43" });

		// Use the overloaded constructor to add left aligned.
		table.addRow(new String[] { "Spunky", "McDonomonk", "34" }, true);
		
		table.addRow(new String[] { "The table adjusts the cell height automatically", "Trump",
				"12" });
		table.print();
	
```

### Sample Output

``` 
•-----------+-----------+-----------•
| NAME      | LAST NAME | AGE       |
•-----------+-----------+-----------•
|      John |     Danky |        23 |
•-----------+-----------+-----------•
|     Peter | The cell  |        23 |
|           | will add  |           |
|           | padding v |           |
|           | ertically |           |
|           |  to accom |           |
|           | odate acc |           |
|           | ording to |           |
|           |  the colu |           |
|           |  mn width |           |
•-----------+-----------+-----------•
|     James |  Rondonon |        43 |
•-----------+-----------+-----------•
| Spunky    | McDonomon | 34        |
|           |         k |           |
•-----------+-----------+-----------•
| The table |     Trump |        12 |
|  adjusts  |           |           |
| the cell  |           |           |
| height au |           |           |
| tomatical |           |           |
|        ly |           |           |
•-----------+-----------+-----------•
```
