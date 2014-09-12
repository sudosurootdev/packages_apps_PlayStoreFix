
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;


static class <init> extends android.view.avedState
{

    public String toString()
    {
        return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(curTab).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.Parcel(parcel, i);
        parcel.writeString(curTab);
    }

    public static final android.os..SavedState.curTab CREATOR = new android.os.Parcelable.Creator() {

        public FragmentTabHost.SavedState createFromParcel(Parcel parcel)
        {
            return new FragmentTabHost.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FragmentTabHost.SavedState[] newArray(int i)
        {
            return new FragmentTabHost.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String curTab;


    private _cls1(Parcel parcel)
    {
        super(parcel);
        curTab = parcel.readString();
    }

    curTab(Parcel parcel, curTab curtab)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
