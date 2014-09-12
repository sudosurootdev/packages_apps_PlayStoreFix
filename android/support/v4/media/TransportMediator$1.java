
package android.support.v4.media;

import android.view.KeyEvent;


class this._cls0
    implements TransportMediatorCallback
{

    public long getPlaybackPosition()
    {
        return mCallbacks.onGetCurrentPosition();
    }

    public void handleAudioFocusChange(int i)
    {
        mCallbacks.onAudioFocusChange(i);
    }

    public void handleKey(KeyEvent keyevent)
    {
        keyevent.dispatch(mKeyEventCallback);
    }

    public void playbackPositionUpdate(long l)
    {
        mCallbacks.onSeekTo(l);
    }

    final TransportMediator this$0;

    lback()
    {
        this$0 = TransportMediator.this;
        super();
    }
}
