package optamizedTable;

import java.util.Arrays;
import java.util.function.Function;

public class Table {

	private StringBuilder sb = new StringBuilder();
//	private String colSize = "8";
	private int colSize = 8;
	private int numCols;

	private final char NEW_LINE = '\n';
	private boolean firstRow = true;
	private boolean lastRow = false;

	private boolean neePadding = false;

	public Table(int numberOfColumns) {
		numCols = numberOfColumns;

	}

	public void addHeader(String[] headers) {

		for (String el : headers) {
			int elSize = el.length();
			if (elSize > colSize)
				colSize = elSize;
		}

		addRow(headers);
	}

	public void addRow(String[] elements) {

		if (!neePadding) {
			addCellBorder();
		}

		neePadding = false;

		if (firstRow)
			firstRow = false;

		boolean first = true;

		String[] padding = null;
		for (int i = 0; i < elements.length; i++) {

			int elSize = elements[i].length();

			if (elSize > colSize) {
				if (padding == null) {
					padding = new String[numCols];
					Arrays.fill(padding, " ");
					neePadding = true;
				}
				first = addCellString(elements[i].substring(0, colSize), first);
				padding[i] = elements[i].substring(colSize);
			} else {
				first = addCellString(elements[i], first);
			}

		}

		sb.append(NEW_LINE);

		if (padding != null)
			addRow(padding);

	}

	private boolean addCellString(String el, boolean first) {
		if (first) {
			sb.append(String.format("| %" + colSize + "s |", el));
			first = false;
		} else {
			sb.append(String.format(" %" + colSize + "s |", el));
		}

		return false;
	}

	public void print() {

		lastRow = true;
		addCellBorder();

		// print row
		System.out.print(sb.toString());

	}

	private void addCellBorder() {

		if (firstRow || lastRow)
			sb.append("o");
		else
			sb.append("|");

//		int lineLength = numCols * (colSize + 2) + numCols - 1;

		for (int i = 0; i < numCols; i++) {
			char[] sep = new char[colSize + 2];
			Arrays.fill(sep, '-');
			sb.append(sep);
			if (i == numCols - 1) {
				if (!(firstRow || lastRow))
					sb.append('|');

			} else
				sb.append('+');
		}
		
		if (firstRow || lastRow)
			sb.append("o");


		sb.append(NEW_LINE);
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

	public static void main(String[] arg) {
		Table t = new Table(3);
		t.addHeader(new String[] { "NAME", "LAST NAME", "AGE" });
		t.addRow(new String[] { "Jorge", "Jimenez", "myageisnotyourproblem" });
		t.print();
	}
}
