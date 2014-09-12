
package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


class this._cls0
    implements android.widget.temClickListener
{

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        onListItemClick((ListView)adapterview, view, i, l);
    }

    final ListFragment this$0;

    Listener()
    {
        this$0 = ListFragment.this;
        super();
    }
}
