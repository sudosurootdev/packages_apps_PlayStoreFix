
package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;


static final class llbacks
    implements ParcelableCompatCreatorCallbacks
{

    public llbacks createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return new nit>(parcel, classloader);
    }

    public volatile Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return createFromParcel(parcel, classloader);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    llbacks()
    {
    }
}
