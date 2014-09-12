
package android.support.v4.app;

import android.os.*;


public static class mState
    implements Parcelable
{

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(mState);
    }

    public static final android.os..SavedState.mState CREATOR = new android.os.Parcelable.Creator() {

        public Fragment.SavedState createFromParcel(Parcel parcel)
        {
            return new Fragment.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Fragment.SavedState[] newArray(int i)
        {
            return new Fragment.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    final Bundle mState;


    _cls1(Bundle bundle)
    {
        mState = bundle;
    }

    mState(Parcel parcel, ClassLoader classloader)
    {
        mState = parcel.readBundle();
        if(classloader != null && mState != null)
            mState.setClassLoader(classloader);
    }
}
