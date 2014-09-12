
package android.support.v4.content;



public static final class  extends Enum
{

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(android/support/v4/content/ModernAsyncTask$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    private static final .VALUES $VALUES[];
    public static final .VALUES FINISHED;
    public static final .VALUES PENDING;
    public static final .VALUES RUNNING;

    static 
    {
        PENDING = new <init>("PENDING", 0);
        RUNNING = new <init>("RUNNING", 1);
        FINISHED = new <init>("FINISHED", 2);
        s_3B_.clone aclone[] = new <init>[3];
        aclone[0] = PENDING;
        aclone[1] = RUNNING;
        aclone[2] = FINISHED;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
