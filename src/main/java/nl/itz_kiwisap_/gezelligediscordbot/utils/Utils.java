package nl.itz_kiwisap_.gezelligediscordbot.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Utils {

    public static String numberWithDots(Number value) {
        DecimalFormatSymbols format = new DecimalFormatSymbols();
        format.setDecimalSeparator(',');
        format.setGroupingSeparator('.');
        DecimalFormat form = new DecimalFormat();
        form.setDecimalFormatSymbols(format);
        return form.format(value);
    }
}
