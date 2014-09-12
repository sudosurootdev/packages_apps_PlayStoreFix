
package android.support.v4.app;

import android.view.MenuItem;


static class 
    implements 
{

    private static void withinStyle(StringBuilder stringbuilder, CharSequence charsequence, int i, int j)
    {
        for(int k = i; k < j; k++)
        {
            char c = charsequence.charAt(k);
            if(c == '<')
            {
                stringbuilder.append("&lt;");
                continue;
            }
            if(c == '>')
            {
                stringbuilder.append("&gt;");
                continue;
            }
            if(c == '&')
            {
                stringbuilder.append("&amp;");
                continue;
            }
            if(c <= '~' && c >= ' ')
            {
                if(c != ' ')
                {
                    stringbuilder.append(c);
                    continue;
                }
                for(; k + 1 < j && charsequence.charAt(k + 1) == ' '; k++)
                    stringbuilder.append("&nbsp;");

                stringbuilder.append(' ');
            } else
            {
                stringbuilder.append((new StringBuilder()).append("&#").append(c).append(";").toString());
            }
        }

    }

    public void configureMenuItem(MenuItem menuitem,  )
    {
        menuitem.setIntent(.ChooserIntent());
    }

    public String escapeHtml(CharSequence charsequence)
    {
        StringBuilder stringbuilder = new StringBuilder();
        withinStyle(stringbuilder, charsequence, 0, charsequence.length());
        return stringbuilder.toString();
    }

    ()
    {
    }
}
