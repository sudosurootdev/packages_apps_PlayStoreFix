
package android.support.v4.os;

import android.os.Parcel;


class ParcelableCompatCreatorHoneycombMR2
    implements android.os.Parcelable.ClassLoaderCreator
{

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
    {
        mCallbacks = parcelablecompatcreatorcallbacks;
    }

    public Object createFromParcel(Parcel parcel)
    {
        return mCallbacks.createFromParcel(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return mCallbacks.createFromParcel(parcel, classloader);
    }

    public Object[] newArray(int i)
    {
        return mCallbacks.newArray(i);
    }

    private final ParcelableCompatCreatorCallbacks mCallbacks;
}
