
package android.support.v4.view;

import android.database.DataSetObserver;


private class <init> extends DataSetObserver
    implements r, ener
{

    public void onAdapterChanged(PagerAdapter pageradapter, PagerAdapter pageradapter1)
    {
        updateAdapter(pageradapter, pageradapter1);
    }

    public void onChanged()
    {
        updateText(mPager.getCurrentItem(), mPager.getAdapter());
        int i = PagerTitleStrip.access$100(PagerTitleStrip.this) != 0.0F;
        float f = 0.0F;
        if(i >= 0)
            f = PagerTitleStrip.access$100(PagerTitleStrip.this);
        updateTextPositions(mPager.getCurrentItem(), f, true);
    }

    public void onPageScrollStateChanged(int i)
    {
        mScrollState = i;
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if(f > 0.5F)
            i++;
        updateTextPositions(i, f, false);
    }

    public void onPageSelected(int i)
    {
        if(mScrollState == 0)
        {
            updateText(mPager.getCurrentItem(), mPager.getAdapter());
            int j = PagerTitleStrip.access$100(PagerTitleStrip.this) != 0.0F;
            float f = 0.0F;
            if(j >= 0)
                f = PagerTitleStrip.access$100(PagerTitleStrip.this);
            updateTextPositions(mPager.getCurrentItem(), f, true);
        }
    }

    private int mScrollState;
    final PagerTitleStrip this$0;

    private ener()
    {
        this$0 = PagerTitleStrip.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
