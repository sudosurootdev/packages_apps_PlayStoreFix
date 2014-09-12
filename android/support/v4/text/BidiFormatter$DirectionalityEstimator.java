
package android.support.v4.text;



private static class length
{

    private static byte getCachedDirectionality(char c)
    {
        if(c < '\u0700')
            return DIR_TYPE_CACHE[c];
        else
            return Character.getDirectionality(c);
    }

    private byte skipEntityBackward()
    {
        int i = charIndex;
        do
        {
            if(charIndex <= 0)
                break;
            String s = text;
            int j = -1 + charIndex;
            charIndex = j;
            lastChar = s.charAt(j);
            if(lastChar == '&')
                return 12;
        } while(lastChar != ';');
        charIndex = i;
        lastChar = ';';
        return 13;
    }

    private byte skipEntityForward()
    {
        char c;
        do
        {
            if(charIndex >= length)
                break;
            String s = text;
            int i = charIndex;
            charIndex = i + 1;
            c = s.charAt(i);
            lastChar = c;
        } while(c != ';');
        return 12;
    }

    private byte skipTagBackward()
    {
        int i = charIndex;
        do
        {
            if(charIndex <= 0)
                break;
            String s = text;
            int j = -1 + charIndex;
            charIndex = j;
            lastChar = s.charAt(j);
            if(lastChar == '<')
                return 12;
            if(lastChar == '>')
                break;
            if(lastChar != '"' && lastChar != '\'')
                break;
            char c = lastChar;
            char c1;
            do
            {
                if(charIndex <= 0)
                    break;
                String s1 = text;
                int k = -1 + charIndex;
                charIndex = k;
                c1 = s1.charAt(k);
                lastChar = c1;
            } while(c1 != c);
        } while(true);
        charIndex = i;
        lastChar = '>';
        return 13;
    }

    private byte skipTagForward()
    {
        int i = charIndex;
        while(charIndex < length) 
        {
            String s = text;
            int j = charIndex;
            charIndex = j + 1;
            lastChar = s.charAt(j);
            if(lastChar == '>')
                return 12;
            if(lastChar != '"' && lastChar != '\'')
                break;
            char c = lastChar;
            char c1;
            do
            {
                if(charIndex >= length)
                    break;
                String s1 = text;
                int k = charIndex;
                charIndex = k + 1;
                c1 = s1.charAt(k);
                lastChar = c1;
            } while(c1 != c);
        }
        charIndex = i;
        lastChar = '<';
        return 13;
    }

    byte dirTypeBackward()
    {
        lastChar = text.charAt(-1 + charIndex);
        byte byte0;
        if(Character.isLowSurrogate(lastChar))
        {
            int i = Character.codePointBefore(text, charIndex);
            charIndex = charIndex - Character.charCount(i);
            byte0 = Character.getDirectionality(i);
        } else
        {
            charIndex = -1 + charIndex;
            byte0 = getCachedDirectionality(lastChar);
            if(isHtml)
            {
                if(lastChar == '>')
                    return skipTagBackward();
                if(lastChar == ';')
                    return skipEntityBackward();
            }
        }
        return byte0;
    }

    byte dirTypeForward()
    {
        lastChar = text.charAt(charIndex);
        byte byte0;
        if(Character.isHighSurrogate(lastChar))
        {
            int i = Character.codePointAt(text, charIndex);
            charIndex = charIndex + Character.charCount(i);
            byte0 = Character.getDirectionality(i);
        } else
        {
            charIndex = 1 + charIndex;
            byte0 = getCachedDirectionality(lastChar);
            if(isHtml)
            {
                if(lastChar == '<')
                    return skipTagForward();
                if(lastChar == '&')
                    return skipEntityForward();
            }
        }
        return byte0;
    }

    int getEntryDir()
    {
        int i;
        byte byte0;
        int j;
        charIndex = 0;
        i = 0;
        byte0 = 0;
        j = 0;
_L10:
        if(charIndex >= length || j != 0)
            break; /* Loop/switch isn't completed */
        dirTypeForward();
        JVM INSTR tableswitch 0 18: default 169
    //                   0 131
    //                   1 120
    //                   2 120
    //                   3 169
    //                   4 169
    //                   5 169
    //                   6 169
    //                   7 169
    //                   8 169
    //                   9 11
    //                   10 169
    //                   11 169
    //                   12 169
    //                   13 169
    //                   14 161
    //                   15 161
    //                   16 153
    //                   17 153
    //                   18 145;
           goto _L1 _L2 _L3 _L3 _L1 _L1 _L1 _L1 _L1 _L1 _L4 _L1 _L1 _L1 _L1 _L5 _L5 _L6 _L6 _L7
_L4:
        continue; /* Loop/switch isn't completed */
_L3:
        if(i == 0)
            return 1;
        j = i;
        continue; /* Loop/switch isn't completed */
_L2:
        if(i == 0)
        {
            byte0 = -1;
        } else
        {
            j = i;
            continue; /* Loop/switch isn't completed */
        }
          goto _L8
_L7:
        i--;
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        i++;
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        i++;
        byte0 = -1;
        continue; /* Loop/switch isn't completed */
_L1:
        j = i;
        if(true) goto _L10; else goto _L9
_L9:
        if(j == 0)
            return 0;
        if(byte0 != 0) goto _L8; else goto _L11
_L11:
        if(charIndex > 0)
            switch(dirTypeBackward())
            {
            case 18: // '\022'
                i++;
                break;

            case 16: // '\020'
            case 17: // '\021'
                if(j == i)
                    return 1;
                i--;
                break;

            case 14: // '\016'
            case 15: // '\017'
                if(j == i)
                    return -1;
                i--;
                break;
            }
        else
            return 0;
        continue; /* Loop/switch isn't completed */
_L8:
        return byte0;
        if(true) goto _L11; else goto _L12
_L12:
    }

    int getExitDir()
    {
        charIndex = length;
        int i = 0;
        int j = 0;
label0:
        do
        {
label1:
            {
                if(charIndex <= 0)
                    break label0;
                switch(dirTypeBackward())
                {
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                case 10: // '\n'
                case 11: // '\013'
                case 12: // '\f'
                case 13: // '\r'
                default:
                    break label1;

                case 9: // '\t'
                    continue;

                case 18: // '\022'
                    i++;
                    continue;

                case 16: // '\020'
                case 17: // '\021'
                    if(j == i)
                        return 1;
                    i--;
                    continue;

                case 1: // '\001'
                case 2: // '\002'
                    if(i == 0)
                        return 1;
                    if(j == 0)
                        j = i;
                    continue;

                case 14: // '\016'
                case 15: // '\017'
                    if(j != i)
                    {
                        i--;
                        continue;
                    }
                    break;

                case 0: // '\0'
                    if(i != 0)
                    {
                        if(j == 0)
                            j = i;
                        continue;
                    }
                    break;
                }
                return -1;
            }
            if(j == 0)
                j = i;
        } while(true);
        return 0;
    }

    private static final byte DIR_TYPE_CACHE[];
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final String text;

    static 
    {
        DIR_TYPE_CACHE = new byte[1792];
        for(int i = 0; i < 1792; i++)
            DIR_TYPE_CACHE[i] = Character.getDirectionality(i);

    }

    (String s, boolean flag)
    {
        text = s;
        isHtml = flag;
        length = s.length();
    }
}
