package game.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// lazy storage area for random names
public class Names {
	private List<String> names;
	private Set<String> usedNames;
	private Random random;
	
	public Names() {
		this.createNames();
		this.random = new Random();
		this.usedNames = new HashSet<String>();
	}
	
	private void createNames() {
		this.names = new ArrayList<String>();
		names.add("Susan");
		names.add("Eric");
		names.add("Terrence");
		names.add("Geoff");
		names.add("Freddie");
		names.add("Margerie");
		names.add("Jessica");
		names.add("Diana");
		names.add("Steve");
		names.add("Dave");
		names.add("James");
		names.add("Jack");
		names.add("Joseph");
		names.add("Oliver");
		names.add("Hannah");
		names.add("Gertrude");
		names.add("Mavis");
	}
	
	public String name() {
		if (names.size() == usedNames.size())
			return "";
		
		boolean added = false;
		String name = "";
		while(!added) {
			name = getRandomName();
			added = usedNames.add(name);
		}
		return name;
	}
	
	private String getRandomName() {
		return names.get(random.nextInt(names.size()));
	}
	
	public void addName(String name) {
		names.add(name);
	}
}
