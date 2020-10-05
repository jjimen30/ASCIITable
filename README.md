# ASCII Table

** A lightweight ASCII table generator ** 

## About

A table to easily generate CLI tables. I created this library to save me some time in my CS classes. No tricky syntax, no clever notation, just a simple table making library. 

## How To Use

** FastTable ** 
A FastTable is a fast way to create a table. It is optimized and will not resized. The cell width will be calculated according to the longest `String` in the header.

``` Java
	
	// Initialize the table with the number of columns.
	FastTable t = new FastTable(3);

	// Call addHeader and pass a String array.
	t.addHeader(new String[] { "NAME", "LAST NAME", "AGE" });

	// Add one row at a time.
	t.addRow(new String[] { "John", "Danky", "23" });
	t.addRow(new String[] { "Peter", "The cell with add padding vertically to accomodate long strings", "23" });

	t.print();
	
```
