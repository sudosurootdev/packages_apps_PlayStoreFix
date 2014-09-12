
package android.support.v4.os;

import android.os.Parcel;


public class ParcelableCompat
{
    static class CompatCreator
        implements android.os.Parcelable.Creator
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

        public CompatCreator(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
        {
            mCallbacks = parcelablecompatcreatorcallbacks;
        }
    }


    public ParcelableCompat()
    {
    }

    public static android.os.Parcelable.Creator newCreator(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
    {
        if(android.os.Build.VERSION.SDK_INT >= 13)
            ParcelableCompatCreatorHoneycombMR2Stub.instantiate(parcelablecompatcreatorcallbacks);
        return new CompatCreator(parcelablecompatcreatorcallbacks);
    }
}
