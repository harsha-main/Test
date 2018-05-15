
import java.util.HashMap;

public class StringConstants {
	public static final String ruler="Who is the ruler of Southeros?".toLowerCase();
	public static final String allies="Allies of Ruler?".toLowerCase();
	public static final String messages="Input Messages to kingdoms from King Shan:".toLowerCase();
	public static final String ruler_name="King Shan";
	static HashMap<String, String> map = new HashMap<String, String>();           
static{
	map.put("Air", "Owl");
	map.put("Water", "Octopus");
	map.put("Ice", "Mammoth");
	map.put("Fire", "Dragon");
	map.put("Land", "Panda");
}
}
