
package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

public abstract class TransportPerformer
{

    public TransportPerformer()
    {
    }

    public void onAudioFocusChange(int i)
    {
        byte byte0 = 0;
        switch(i)
        {
        case -1: 
            byte0 = 127;
            break;
        }
        if(byte0 != 0)
        {
            long l = SystemClock.uptimeMillis();
            onMediaButtonDown(byte0, new KeyEvent(l, l, 0, byte0, 0));
            onMediaButtonUp(byte0, new KeyEvent(l, l, 1, byte0, 0));
        }
    }

    public int onGetBufferPercentage()
    {
        return 100;
    }

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public int onGetTransportControlFlags()
    {
        return 60;
    }

    public abstract boolean onIsPlaying();

    public boolean onMediaButtonDown(int i, KeyEvent keyevent)
    {
        switch(i)
        {
        case 79: // 'O'
        case 85: // 'U'
            if(onIsPlaying())
            {
                onPause();
                return true;
            } else
            {
                onStart();
                return true;
            }

        case 86: // 'V'
            onStop();
            return true;

        case 127: // '\177'
            onPause();
            return true;

        case 126: // '~'
            onStart();
            return true;
        }
        return true;
    }

    public boolean onMediaButtonUp(int i, KeyEvent keyevent)
    {
        return true;
    }

    public abstract void onPause();

    public abstract void onSeekTo(long l);

    public abstract void onStart();

    public abstract void onStop();

    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
}
