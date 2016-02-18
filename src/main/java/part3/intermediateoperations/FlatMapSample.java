package part3.intermediateoperations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * @author aohz
 *
 */
public class FlatMapSample {

	
	public static void main (String[] args) {
		List<Developer> team = new ArrayList<>();
		
		Developer polyglot = new Developer("esoteric");
		polyglot.add("clojure");
		polyglot.add("scala");
		polyglot.add("groovy");
		polyglot.add("go");

		Developer busy = new Developer("pragmatic");
		busy.add("java");
		busy.add("javascript");

		team.add(polyglot);
		team.add(busy);

		List<String> teamLanguages = team.stream()
				.map((Developer d) -> d.getLanguages())
				.flatMap((Set<String>l) -> l.stream())
				.collect(Collectors.toList());
		
		teamLanguages.forEach(System.out::println);
		
	}
}

class Developer {
	
	private String name;
	private Set<String> languages;

	public Developer(String name) {
		this.languages = new HashSet<>();
		this.name = name;
	}

	public void add(String language) {
		this.languages.add(language);
	}

	public Set<String> getLanguages() {
		return languages;
	}
	
	public String getName() {
		return name;
	}
}
