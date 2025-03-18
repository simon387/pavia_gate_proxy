package it.simonecelia.pavia_gate_proxy.util;

import org.jsoup.Jsoup;


public class HtmlUtils {

	public static String formatUptime ( int seconds ) {
		var days = seconds / ( 24 * 3600 );
		seconds %= 24 * 3600;
		var hours = seconds / 3600;
		seconds %= 3600;
		var minutes = seconds / 60;
		seconds %= 60;
		return String.format ( "%d giorni, %d ore, %d minuti, %d secondi", days, hours, minutes, seconds );
	}

	public static String updateUptime ( String htmlString ) {
		var doc = Jsoup.parse ( htmlString );
		var uptimeElement = doc.selectFirst ( "td:contains(secondi)" );

		if ( uptimeElement != null ) {
			var uptimeSeconds = Integer.parseInt ( uptimeElement.text ().split ( " " )[0] );
			uptimeElement.text ( formatUptime ( uptimeSeconds ) );
		}

		return doc.html ();
	}
}
