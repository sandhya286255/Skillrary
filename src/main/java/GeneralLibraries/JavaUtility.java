package GeneralLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * This class contains reusable methods to perform java related actions
 * @author sreek
 *
 */
public class JavaUtility {

	public int generateRandomNumber(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}


public String getCurrentTime() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_sss");
	return sdf.format(date);
}
}