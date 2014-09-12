
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;


final class FragmentManagerState
    implements Parcelable
{

    public FragmentManagerState()
    {
    }

    public FragmentManagerState(Parcel parcel)
    {
        mActive = (FragmentState[])parcel.createTypedArray(FragmentState.CREATOR);
        mAdded = parcel.createIntArray();
        mBackStack = (BackStackState[])parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedArray(mActive, i);
        parcel.writeIntArray(mAdded);
        parcel.writeTypedArray(mBackStack, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FragmentManagerState createFromParcel(Parcel parcel)
        {
            return new FragmentManagerState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FragmentManagerState[] newArray(int i)
        {
            return new FragmentManagerState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    FragmentState mActive[];
    int mAdded[];
    BackStackState mBackStack[];

}
