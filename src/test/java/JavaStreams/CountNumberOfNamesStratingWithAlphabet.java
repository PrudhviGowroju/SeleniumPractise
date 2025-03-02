package JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CountNumberOfNamesStratingWithAlphabet {
	
	//@Test
	public void regular() {
		// Count number of names starting with alphabet a 
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abjeeth");
		names.add("Don");
		names.add("alekya");
		names.add("Adam");
		
		int count = 0; 
		
		for(int i=0; i<names.size(); i++) {
			
			String actual = names.get(i);
			if(actual.startsWith("A")) 
			{
				count++;
			}
		}
		System.out.println(count);

	}
	
	@Test
	public void streamFilter() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abjeeth");
		names.add("Don");
		names.add("alekaya");
		names.add("anu");
		
		long c= names.stream().filter(a->a.startsWith("A")).count();
		//There is no life for intermediate Operations if there is no terminal op
		// Terminal operation will exclude only if inter Operations return true 
		// We can create stream
		// How to use filter in stream API
		// Lambda expressions with arrow 
		// 1.Left side specifies Parameter required by the expression
		// 2. Right side specifies the action of the lambda expression
		
		long d= Stream.of("Abhijeeth","Anu","Deepu","ani").filter(s->
		{
			//s.equalsIgnoreCase("a");
			s.startsWith("A");
			return true; //filters should only return true other wise it will throw error 
		}).count();
		
		System.out.println(c);
		
		System.out.println(d);
		
		//Print names of length greater than 4 
		names.stream().forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println("only one word- "+ s));
	}
	
	@Test
	public void streamMap() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhi");
		names.add("Dhoni");
		names.add("Alekya");
		names.add("Harsha");
		
		//Print names which have last letter as "a" with UpperCase
		Stream.of("Azbhijeet","Arjun","Anoohya","Adam","Rama").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));

		// Print names which has first letter as "a" with Upper case and sorted
		List<String>names1= Arrays.asList("Abhijeet","Arjun","Anoohya","Adam","Rama");
		
		names1.stream().filter(s->s.startsWith("A")).sorted().map(a->a.toUpperCase()).forEach(s->System.out.println("sorted String "+ s));
		// this are case sensitive
		
		// How to Merge two array list
		Stream <String> newStreams= Stream.concat(names.stream(), names1.stream());
		//newStreams.sorted().forEach(s->System.out.println("two streams merged and sorted : "+ s));
		
		boolean flag= newStreams.anyMatch(s->s.equalsIgnoreCase("Rama"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
	@Test
	public void streamCollect() {
		List <String> lis= Stream.of("Adam","Abhijeeth","Anoohya","Anu","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(lis.get(0));
	
	//collect method - is used to collect results and convert back into a new list
	//Assignment - Eliminate duplicates and print only duplicates
	
	List<Integer> listnum = Arrays.asList(8,1,2,5,2,1,4,5,4,6);
	
	List newnum= listnum.stream().distinct().sorted().collect(Collectors.toList());
	//1,2,4,5,6,8
	
	/*here newnum is the new list */
	System.out.println(newnum.get(2));
	
	}
	
	
		
}
