
package android.support.v4.app;

import android.app.Notification;


static class 
    implements 
{

    public Notification build( )
    {
        Notification notification = .;
        notification.setLatestEventInfo(., ., ., .);
        if(. > 0)
            notification.flags = 0x80 | notification.flags;
        return notification;
    }

    ()
    {
    }
}
