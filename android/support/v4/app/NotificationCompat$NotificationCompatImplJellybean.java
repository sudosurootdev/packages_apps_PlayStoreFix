
package android.support.v4.app;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;


static class 
    implements 
{

    public Notification build( )
    {
        NotificationCompatJellybean notificationcompatjellybean = new NotificationCompatJellybean(., ., ., ., ., ., ., ., ., ., ., ., ., ., ., .);
         4;
        for(Iterator iterator = ..iterator(); iterator.hasNext(); notificationcompatjellybean.addAction(4., 4., 4.))
            4 = ()iterator.next();

        if(. != null)
            if(. instanceof )
            {
                 3 = ().;
                notificationcompatjellybean.addBigTextStyle(3., 3., 3., 3.);
            } else
            if(. instanceof )
            {
                 2 = ().;
                notificationcompatjellybean.addInboxStyle(2., 2., 2., 2.);
            } else
            if(. instanceof )
            {
                 1 = ().;
                notificationcompatjellybean.addBigPictureStyle(1., 1., 1., 1., 1., 1.);
            }
        return notificationcompatjellybean.build();
    }

    ()
    {
    }
}
