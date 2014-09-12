
package android.support.v4.text;

import java.util.Locale;


public class TextUtilsCompat
{

    public TextUtilsCompat()
    {
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale)
    {
        switch(Character.getDirectionality(locale.getDisplayName(locale).charAt(0)))
        {
        case 1: // '\001'
        case 2: // '\002'
            return 1;
        }
        return 0;
    }

    public static int getLayoutDirectionFromLocale(Locale locale)
    {
label0:
        {
            if(locale != null && !locale.equals(ROOT))
            {
                String s = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
                if(s == null)
                    return getLayoutDirectionFromFirstChar(locale);
                if(s.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || s.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG))
                    break label0;
            }
            return 0;
        }
        return 1;
    }

    public static String htmlEncode(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            switch(c)
            {
            case 34: // '"'
                stringbuilder.append("&quot;");
                break;

            case 39: // '\''
                stringbuilder.append("&#39;");
                break;

            case 38: // '&'
                stringbuilder.append("&amp;");
                break;

            case 62: // '>'
                stringbuilder.append("&gt;");
                break;

            case 60: // '<'
                stringbuilder.append("&lt;");
                break;

            default:
                stringbuilder.append(c);
                break;
            }
        }

        return stringbuilder.toString();
    }

    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
    public static final Locale ROOT = new Locale("", "");

}
