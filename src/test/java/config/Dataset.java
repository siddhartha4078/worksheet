package config;

import java.util.*;

public class Dataset {

	public String username(int index) {

		List<String> assignmenttype = new ArrayList<String>();
		assignmenttype.add("performance.test");

		assignmenttype.add("live.student");

		String a = assignmenttype.get(index);
		return a;

	}

	public String assignmenttype(Integer index) {

		List<String> assignmenttype = new ArrayList<String>();
		assignmenttype.add("Level 3");

		assignmenttype.add("Level 3");

		assignmenttype.add("Level 2");

		assignmenttype.add("Level K2");

		assignmenttype.add("Level 2");

		assignmenttype.add("Vedic mathematics");

		assignmenttype.add("Level K2");

		assignmenttype.add("Vedic mathematics");

		assignmenttype.add("Level 1");
		assignmenttype.add("Level 4");

		String a = assignmenttype.get(index);
		return a;

	}

	public String book(Integer index) {

		List<String> book = new ArrayList<String>();
		book.add("Math Skills L3");

		book.add("Math Skills L3");

		book.add("Math Skills L2");

		book.add("Math Skills K2");

		book.add("Math Skills L2");

		book.add("Math Skills K2");

		book.add("Vedic Math  Book");

		book.add("Math Skills L1");

		book.add("Vedic Math  Book");

		book.add("Math Skills L4");

		String b = book.get(index);
		return b;
	}

	public String chapter(Integer index) {

		List<String> chapter = new ArrayList<String>();
		chapter.add("Fractions");

		chapter.add("Whole numbers");

		chapter.add("Fractions");

		chapter.add("Patterns");

		chapter.add("Division");

		chapter.add("Patterns");

		chapter.add("Digit Sums");

		chapter.add("Count");

		chapter.add("Addition");

		chapter.add("Fractions");

		String c = chapter.get(index);
		return c;

	}

	public String worksheet(int index) {

		List<String> worksheetname = new ArrayList<String>();
		worksheetname.add("Order : ascending / descending ( worksheet 1 )");
		worksheetname.add("Biggest and smallest number identification word problems");
		worksheetname.add("Identify : using shapes ( worksheet 2 )");
		worksheetname.add("Identify the matching pattern");
		worksheetname.add("Visual understanding of division and multiplication");

		worksheetname.add("Identify the right pattern sequence");
		worksheetname.add("Digit sums by casting out nines ( with steps )");
		worksheetname.add(" Compare shapes : more than or less than");

		worksheetname.add("Two digit numbers on a nine point circle");
		worksheetname.add("Ordering fractions in ascending / descending series");

		String w = worksheetname.get(index);
		return w;

	}

	public String imageissue(Integer index) {

		List<String> assignmenttype = new ArrayList<String>();
		assignmenttype.add("Write the missing number : descending number series upto 1000_1");

		assignmenttype.add("2 digit multiply with 2 digit");

		assignmenttype.add("Halving of big numbers with decimal");

		assignmenttype.add("Halving of big numbers with remainder");

		assignmenttype.add("Halving of small numbers with decimal");

		assignmenttype.add("Halving of small numbers with remainder");

		assignmenttype.add("Division by 9 (big numbers)");

		assignmenttype.add("Multiplication of bigger numbers");

		assignmenttype.add("Single digit multiplication");

		assignmenttype.add("Addition and subtraction facts - numbers up to 18");

		String a = assignmenttype.get(index);
		return a;

	}

}
