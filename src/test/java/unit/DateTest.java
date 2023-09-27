package unit;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.testng.annotations.Test;

public class DateTest {

	@Test
	public void test() {
		System.out.println(Instant.now());
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM_dd_yyyy hh.mm.ss");
		String formattedDate = simpleDateFormat.format(date);
		System.out.println(formattedDate);
	}
}
