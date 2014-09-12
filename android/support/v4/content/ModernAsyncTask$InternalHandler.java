
package android.support.v4.content;

import android.os.Handler;
import android.os.Message;


private static class <init> extends Handler
{

    public void handleMessage(Message message)
    {
        <init> <init>1 = (<init>)message.obj;
        switch(message.what)
        {
        case 2: // '\002'
            <init>1.mTask.onProgressUpdate(<init>1.mData);
            return;

        case 1: // '\001'
            ModernAsyncTask.access$500(<init>1.mTask, <init>1.mData[0]);
            return;
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
