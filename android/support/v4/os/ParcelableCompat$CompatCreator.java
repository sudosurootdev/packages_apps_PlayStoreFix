
package android.support.v4.os;

import android.os.Parcel;


static class mCallbacks
    implements android.os.patCreator
{

    public Object createFromParcel(Parcel parcel)
    {
        return mCallbacks.createFromParcel(parcel, null);
    }

    public Object[] newArray(int i)
    {
        return mCallbacks.newArray(i);
    }

    final ParcelableCompatCreatorCallbacks mCallbacks;

    public s(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
    {
        mCallbacks = parcelablecompatcreatorcallbacks;
    }
}
