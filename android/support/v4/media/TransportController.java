
package android.support.v4.media;



public abstract class TransportController
{

    public TransportController()
    {
    }

    public abstract int getBufferPercentage();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract int getTransportControlFlags();

    public abstract boolean isPlaying();

    public abstract void pausePlaying();

    public abstract void registerStateListener(TransportStateListener transportstatelistener);

    public abstract void seekTo(long l);

    public abstract void startPlaying();

    public abstract void stopPlaying();

    public abstract void unregisterStateListener(TransportStateListener transportstatelistener);
}
