package be.vdab.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import be.vdab.entities.Saus;


public class SausDAO {
	private static final Map<Long, Saus> sauzen = new ConcurrentHashMap<>();
	
	static {
		sauzen.put(12L, new Saus(12, "cocktail", Arrays.asList("mayonaise", "ketchup", "cognac")));
		sauzen.put(14L, new Saus(14, "mayonaise", Arrays.asList("ei", "mosterd")));
		sauzen.put(17L, new Saus(17, "mosterd", Arrays.asList("mosterd", "azijn", "witte wijn")));
		sauzen.put(23L, new Saus(23, "tartare", Arrays.asList("mayonaise", "augurk", "tabasco")));
		sauzen.put(44L, new Saus(44,"vinaigrette",Arrays.asList("olijfolie","mosterd","azijn")));
	}
	
	public Iterable<Saus> findAll(){
		return new ArrayList<>(sauzen.values());
	}
	
	public List<Saus> findByIngredi�nt(String ingredi�nt) {
		String ingredi�ntLowerCase = ingredi�nt.toLowerCase();
		List<Saus> sauzen = new ArrayList<>();
		for (Saus saus : SausDAO.sauzen.values()) {
			List<String> ingredi�ntenList = saus.getIngredi�nten();
			for(int i=0; i < ingredi�ntenList.size(); i++) {
				ingredi�ntenList.set(i, ingredi�ntenList.get(i).toLowerCase());
			}
			if (ingredi�ntenList.contains(ingredi�ntLowerCase)) {
				sauzen.add(saus);
			}
		}
		return sauzen;
	}
	public void remove(Long id){
		sauzen.remove(id);
	}
}
