package hr.fer.zemris.java.hw06.demo4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class presents several ways of filtering and arranging student data.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class StudentDemo {
	
	/**
	 * Main method. Accepts not arguments.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		String path = "./src/main/resources/studenti.txt";
		List<String> lines = null;
		
		try {
			lines = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			System.out.println("Unable to read the file. Path: " + path);
			e.printStackTrace();
		}
		
		List<StudentRecord> records = convert(lines);
		printInfo(records);
		
	}
	
	/**
	 * Method that prints out student data arranged in several different ways. </br>
	 * If needed, uncomment some parts of code.
	 * 
	 * @param records list of student records.
	 */
	private static void printInfo(List<StudentRecord> records) {
		System.out.format("Broj studenata s više od 25 bodova: %d%n", vratiBodovaViseOd25(records));
		printBoundaryLine();
		
//		System.out.format("Broj studenata koji su dobili ocjenu 5: %d%n", vratiBrojOdlikasa(records));
//		printBoundaryLine();
//		
//		System.out.println("Studenti koji su dobili ocjenu 5:");
//		vratiListuOdlikasa(records).forEach(System.out::println);
//		printBoundaryLine();
//		
//		System.out.println("Studenti koji su dobili ocjenu 5 sortirani po broju bodova:");
//		vratiSortiranuListuOdlikasa(records).forEach(System.out::println);
//		printBoundaryLine();
//		
//		System.out.println("Lista jmbagova studenata koji nisu položili kolegij:");
//		vratiPopisNepolozenih(records).forEach(System.out::println);
//		printBoundaryLine();
//		
//		System.out.println("Studenti razvrstani po ocjenama: ");
//		printMapWithListAsValue(razvrstajStudentePoOcjenama(records));
//		printBoundaryLine();
//		
//		System.out.println("Broj studenata po ocjenama:");
//		printMap(vratiBrojStudenataPoOcjenama(records));
//		printBoundaryLine();
//		
//		System.out.println("Studenti razvrstani na one koji su proložili kolegij ('true') i oni koji nisu ('false'):");
//		printMapWithListAsValue(razvrstajProlazPad(records));
//		printBoundaryLine();
	
	}
	
	
	/**
	 * Generic method for printing map that has {@code List} as values to standard output.
	 * 
	 * @param map map that is printed.
	 */
	@SuppressWarnings("unused")
	private static <K, V> void printMapWithListAsValue(Map<K, List<V>> map) {
		Set<K> keys = map.keySet();
		for (K key : keys) {
			System.out.println("'" + key + "':");
			map.get(key).forEach(v -> System.out.println("\t" + v));
		}
	}
	
	/**
	 * Generic method for printing map to standard output.
	 * 
	 * @param map map that is printed.
	 */
	@SuppressWarnings("unused")
	private static <K, V> void printMap(Map<K, V> map) {
		Set<K> keys = map.keySet();
		for (K key : keys) {
			System.out.print("'" + key + "':");
			System.out.println("\t" + map.get(key));
		}
	}
	
	/**
	 * Method that prints out line used for splitting different parts of output.
	 */
	private static void printBoundaryLine() {
		System.out.println("______________________________________________________________");
	}
	 
	/**
	 * Method returns number of students that have more than 25 points.
	 * 
	 * @param records list of student records
	 * @return number of students that have more than 25 points.
	 */
	private static long vratiBodovaViseOd25(List<StudentRecord> records) {
		long broj = records.stream()
				.filter(r -> r.getMidtermPoints() + r.getFinalPoints() + r.getLabPoints() > 25)
				.count();
		
		return broj;
	}
	
	/**
	 * Method returns number of students that have grade 5.
	 * 
	 * @param records list of student records
	 * @return number of students that have grade 5.
	 */
	@SuppressWarnings("unused")
	private static long vratiBrojOdlikasa(List<StudentRecord> records) {
		long broj5 = records.stream()
				.filter(r -> r.getGrade() == 5)
				.count();
		
		return broj5;
	}
	
	/**
	 * Method that returns list of students that have grade 5.
	 * 
	 * @param records list of student records
	 * @return list of students that have grade 5.
	 */
	@SuppressWarnings("unused")
	private static List<StudentRecord> vratiListuOdlikasa(List<StudentRecord> records) {
		List<StudentRecord> odlikasi = records.stream()
				.filter(r -> r.getGrade() == 5)
				.collect(Collectors.toList());
		
		return odlikasi;
	}
	
	/**
	 * Method that returns sorted list of students that have grade 5.
	 * 
	 * @param records list of student records
	 * @return sorted list of students that have grade 5.
	 */
	@SuppressWarnings("unused")
	private static List<StudentRecord> vratiSortiranuListuOdlikasa(List<StudentRecord> records) {
		List<StudentRecord> odlikasiSortirano = records.stream()
				.filter(r -> r.getGrade() == 5)
				.sorted((r1, r2) -> r2.getAllPoints().compareTo(r1.getAllPoints()))
				.collect(Collectors.toList());
		
		return odlikasiSortirano;
	}
	
	/**
	 * Method that returns list of students that have grade 1.
	 * 
	 * @param records list of student records
	 * @return list of students that have grade 1.
	 */
	@SuppressWarnings("unused")
	private static List<String> vratiPopisNepolozenih(List<StudentRecord> records) {
		List<String> nepolozeniJMBAGovi = records.stream()
				.filter(r -> r.getGrade() == 1)
				.map(r -> r.getJmbag())
				.sorted((j1, j2) -> j1.compareTo(j2))
				.collect(Collectors.toList());
		
		return nepolozeniJMBAGovi;
	}

	/**
	 * Method used for arranging students in such way </br>
	 * that all students with the same grade are in one group.
	 * 
	 * @param records list of students
	 * @return map whose keys are grades and 
	 * 			   whose values are list of students with that grade
	 */
	@SuppressWarnings("unused")
	private static Map<Integer, List<StudentRecord>> razvrstajStudentePoOcjenama(List<StudentRecord> records) {
		Map<Integer, List<StudentRecord>> mapaPoOcjenama = records.stream()
				.collect(Collectors.groupingBy(r -> r.getGrade()));
		
		return mapaPoOcjenama;
	}
	
	/**
	 * Method used for creating map that as key contains grades </br>
	 * and as values contains number of students with that grade.
	 * 
	 * @param records list of students
	 * @return map whose keys are grades and 
	 * 			   whose values number of students with that grade
	 */
	@SuppressWarnings("unused")
	private static Map<Integer, Integer> vratiBrojStudenataPoOcjenama(List<StudentRecord> records) {
		Map<Integer, Integer> mapaPoOcjenama = records.stream()
				.collect(Collectors.<StudentRecord, Integer, Integer>toMap(
				r -> r.getGrade(), 
				r -> 1,
				(a,b) -> a + 1));
		
		return mapaPoOcjenama;
	}
	
	/**
	 * Method used for arranging students in such way that </br>
	 * all students that have passed the course are in one group </br>
	 * and same for students that have not passed the course.
	 * 
	 * @param records list of students
	 * @return map whose keys are {@code true} or {@code false} and </br>
	 * 			   values that are assigned to true are students that have passed the course, </br>
	 * 			   and analogously same for students that have not passed the course.
	 */
	@SuppressWarnings("unused")
	private static Map<Boolean, List<StudentRecord>> razvrstajProlazPad(List<StudentRecord> records) {
		Map<Boolean, List<StudentRecord>> prolazNeprolaz = records.stream()
				.collect(Collectors.<StudentRecord>partitioningBy(
				r -> r.getGrade() > 1));
		
		return prolazNeprolaz;
	}
	
	/**
	 * Method converts list of lines that contain student information
	 * into list of student records.
	 * 
	 * @param lines list of lines that contain student information.
	 * @return list of student records
	 */
	private static List<StudentRecord> convert(List<String> lines) {
		List<StudentRecord> records = new ArrayList<>();
		for (String line : lines) {
			if (!line.isEmpty())
				records.add(getStudentRecordFromString(line));
		}
		return records;
	}
	
	/**
	 * Method used for parsing String line into student record.
	 * 
	 * @param line String line that contains student information
	 * @return {@link StudentRecord} that given {@code line} describes.
	 */
	private static StudentRecord getStudentRecordFromString(String line) {
		if (line == null)
			throw new NullPointerException("Given line is null");
		
		String[] lineParts = line.split("\\s+");
		String jmbag = lineParts[0];
		String surname = lineParts[1];
		String firstName = lineParts[2];
		Double midtermPoints = Double.parseDouble(lineParts[3]);
		Double finalPoints = Double.parseDouble(lineParts[4]);
		Double labPoints = Double.parseDouble(lineParts[5]);
		Integer grade = Integer.parseInt(lineParts[6]);
		
		return  new StudentRecord(jmbag, surname, firstName, midtermPoints, finalPoints, labPoints, grade);
	}

}
