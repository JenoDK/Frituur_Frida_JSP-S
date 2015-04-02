package be.vdab.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import be.vdab.entities.Saus;


public class SausDAO {
	private static final Map<Long, Saus> sauzen = new ConcurrentHashMap<>();
	
	static {
		sauzen.put(12L, new Saus(3, "cocktail", Arrays.asList("mayonaise", "ketchup", "cognac")));
		sauzen.put(14L, new Saus(6, "mayonaise", Arrays.asList("ei", "mosterd")));
		sauzen.put(17L, new Saus(7, "mosterd", Arrays.asList("mosterd", "azijn", "witte wijn")));
		sauzen.put(23L, new Saus(12, "tartare", Arrays.asList("mayonaise", "augurk", "tabasco")));
		sauzen.put(23L, new Saus(44,"vinaigrette",Arrays.asList("olijfolie","mosterd","azijn")));
	}
	
	public Iterable<Saus> findAll(){
		return new ArrayList<>(sauzen.values());
	}
}
