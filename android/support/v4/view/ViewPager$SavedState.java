
package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;


public static class loader extends android.view.SavedState
{

    public String toString()
    {
        return (new StringBuilder()).append("FragmentPager.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(position).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.riteToParcel(parcel, i);
        parcel.writeInt(position);
        parcel.writeParcelable(adapterState, i);
    }

    public static final android.os.CompatCreatorCallbacks CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {

        public ViewPager.SavedState createFromParcel(Parcel parcel, ClassLoader classloader)
        {
            return new ViewPager.SavedState(parcel, classloader);
        }

        public volatile Object createFromParcel(Parcel parcel, ClassLoader classloader)
        {
            return createFromParcel(parcel, classloader);
        }

        public ViewPager.SavedState[] newArray(int i)
        {
            return new ViewPager.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    });
    Parcelable adapterState;
    ClassLoader loader;
    int position;


    _cls1(Parcel parcel, ClassLoader classloader)
    {
        super(parcel);
        if(classloader == null)
            classloader = getClass().getClassLoader();
        position = parcel.readInt();
        adapterState = parcel.readParcelable(classloader);
        loader = classloader;
    }

    public loader(Parcelable parcelable)
    {
        super(parcelable);
    }
}
