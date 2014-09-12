
package android.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks
{

    public abstract Object createFromParcel(Parcel parcel, ClassLoader classloader);

    public abstract Object[] newArray(int i);
}
