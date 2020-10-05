package Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Table {

	private StringBuilder sb = new StringBuilder();
	private String colSize = "8";
	private List<Row> rows = new ArrayList<>();
	private int numCols;
	private boolean headerEmpty = true;
	private final char NEW_LINE = '\n';
	private boolean firstRow = true;
	private boolean lastRow = false;

	public Table(int numberOfColumns) {
		numCols = numberOfColumns;
	}

	public void addHeader(String[] headers) {
		this.headerEmpty = false;
		addRow(headers);
//
//		for (String el : this.rows.get(0).elements) {
//			if (el.length() > Integer.parseInt(colSize)) {
//				colSize = Integer.toString(el.length());
//			}
//		}

	}

	public void addRow(String[] elements) {
		
		
		rows.add(new Row(elements));

	}

	public void print() {
		if (headerEmpty)
			throw new RuntimeException("The header list is empty.");

		// set row
		StringBuilder sb = new StringBuilder();

		for (Row row : this.rows) {

			sb.append(seperator() + NEW_LINE);

			if (firstRow)
				firstRow = false;

			boolean first = true;
			for (int i = 0; i < this.numCols; i++) {

				if (first) {
					sb.append(String.format("| %" + colSize + "s |", row.elements[i]));
					first = false;
				} else {
					sb.append(String.format(" %" + colSize + "s |", row.elements[i]));
				}
			}

			sb.append(NEW_LINE);

		}

		lastRow = true;
		sb.append(seperator() + NEW_LINE);

		// print row
		System.out.print(sb.toString());

	}

	private String seperator() {
		StringBuilder sb = new StringBuilder();
		if (firstRow || lastRow)
			sb.append("o");
		else
			sb.append("|");
		int lineLength = this.numCols * (Integer.parseInt(this.colSize) + 2) + this.numCols - 1;

//		for (int i = 0; i < lineLength; i++)
//			sb.append("-");

		char[] sep = new char[lineLength];
		Arrays.fill(sep, '-');
		sb.append(sep);

		if (firstRow || lastRow)
			sb.append("o");
		else
			sb.append("|");
		return sb.toString();
	}

	public void fillHeaderRow(Function<Integer, String> callback) {
		String[] s = new String[this.numCols];

		for (int i = 0; i < this.numCols; i++) {
			s[i] = callback.apply(i);
		}

		this.addHeader(s);

	}

	public void fillRow(Function<Integer, String> callback) {
		String[] s = new String[this.numCols];

		for (int i = 0; i < this.numCols; i++) {
			s[i] = callback.apply(i);
		}

		this.addRow(s);

	}

	private class Row {

		public String[] elements;

		public Row(String[] el) {
			this.elements = el.clone();
			for (String rowEl : elements) {
				if (rowEl.length() > Integer.parseInt(colSize)) {
					colSize = Integer.toString(rowEl.length());
				}
			}

		}
	}
}
