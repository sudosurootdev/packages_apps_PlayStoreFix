
package android.support.v4.widget;



public static abstract class 
{

    public boolean onQueryTextChange(String s)
    {
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        return false;
    }

    final Object mListener = SearchViewCompat.access$000().QueryTextListener(this);

    public ()
    {
    }
}
