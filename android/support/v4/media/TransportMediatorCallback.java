
package android.support.v4.media;

import android.view.KeyEvent;

interface TransportMediatorCallback
{

    public abstract long getPlaybackPosition();

    public abstract void handleAudioFocusChange(int i);

    public abstract void handleKey(KeyEvent keyevent);

    public abstract void playbackPositionUpdate(long l);
}
