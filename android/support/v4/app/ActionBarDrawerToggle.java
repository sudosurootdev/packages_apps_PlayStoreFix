
package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.*;


public class ActionBarDrawerToggle
    implements android.support.v4.widget.DrawerLayout.DrawerListener
{
    private static interface ActionBarDrawerToggleImpl
    {

        public abstract Drawable getThemeUpIndicator(Activity activity);

        public abstract Object setActionBarDescription(Object obj, Activity activity, int i);

        public abstract Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i);
    }

    private static class ActionBarDrawerToggleImplBase
        implements ActionBarDrawerToggleImpl
    {

        public Drawable getThemeUpIndicator(Activity activity)
        {
            return null;
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i)
        {
            return obj;
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i)
        {
            return obj;
        }

        private ActionBarDrawerToggleImplBase()
        {
        }

    }

    private static class ActionBarDrawerToggleImplHC
        implements ActionBarDrawerToggleImpl
    {

        public Drawable getThemeUpIndicator(Activity activity)
        {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(activity);
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i)
        {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(obj, activity, i);
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i)
        {
            return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(obj, activity, drawable, i);
        }

        private ActionBarDrawerToggleImplHC()
        {
        }

    }

    public static interface Delegate
    {

        public abstract Drawable getThemeUpIndicator();

        public abstract void setActionBarDescription(int i);

        public abstract void setActionBarUpIndicator(Drawable drawable, int i);
    }

    public static interface DelegateProvider
    {

        public abstract Delegate getDrawerToggleDelegate();
    }

    private class SlideDrawable extends InsetDrawable
        implements android.graphics.drawable.Drawable.Callback
    {

        public void draw(Canvas canvas)
        {
            int i = 1;
            copyBounds(mTmpRect);
            canvas.save();
            int j;
            if(ViewCompat.getLayoutDirection(mActivity.getWindow().getDecorView()) == i)
                j = i;
            else
                j = 0;
            if(j != 0)
                i = -1;
            int k = mTmpRect.width();
            canvas.translate(-mOffset * (float)k * mPosition * (float)i, 0.0F);
            if(j != 0 && !mHasMirroring)
            {
                canvas.translate(k, 0.0F);
                canvas.scale(-1F, 1.0F);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition()
        {
            return mPosition;
        }

        public void setOffset(float f)
        {
            mOffset = f;
            invalidateSelf();
        }

        public void setPosition(float f)
        {
            mPosition = f;
            invalidateSelf();
        }

        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final ActionBarDrawerToggle this$0;

        private SlideDrawable(Drawable drawable)
        {
            this$0 = ActionBarDrawerToggle.this;
            super(drawable, 0);
            int i = android.os.Build.VERSION.SDK_INT;
            boolean flag = false;
            if(i > 18)
                flag = true;
            mHasMirroring = flag;
            mTmpRect = new Rect();
        }

    }


    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerlayout, int i, int j, int k)
    {
        mDrawerIndicatorEnabled = true;
        mActivity = activity;
        if(activity instanceof DelegateProvider)
            mActivityImpl = ((DelegateProvider)activity).getDrawerToggleDelegate();
        else
            mActivityImpl = null;
        mDrawerLayout = drawerlayout;
        mDrawerImageResource = i;
        mOpenDrawerContentDescRes = j;
        mCloseDrawerContentDescRes = k;
        mThemeImage = getThemeUpIndicator();
        mDrawerImage = activity.getResources().getDrawable(i);
        mSlider = new SlideDrawable(mDrawerImage);
        mSlider.setOffset(0.3333333F);
    }

    Drawable getThemeUpIndicator()
    {
        if(mActivityImpl != null)
            return mActivityImpl.getThemeUpIndicator();
        else
            return IMPL.getThemeUpIndicator(mActivity);
    }

    public boolean isDrawerIndicatorEnabled()
    {
        return mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        mThemeImage = getThemeUpIndicator();
        mDrawerImage = mActivity.getResources().getDrawable(mDrawerImageResource);
        syncState();
    }

    public void onDrawerClosed(View view)
    {
        mSlider.setPosition(0.0F);
        if(mDrawerIndicatorEnabled)
            setActionBarDescription(mOpenDrawerContentDescRes);
    }

    public void onDrawerOpened(View view)
    {
        mSlider.setPosition(1.0F);
        if(mDrawerIndicatorEnabled)
            setActionBarDescription(mCloseDrawerContentDescRes);
    }

    public void onDrawerSlide(View view, float f)
    {
        float f1 = mSlider.getPosition();
        float f2;
        if(f > 0.5F)
            f2 = Math.max(f1, 2.0F * Math.max(0.0F, f - 0.5F));
        else
            f2 = Math.min(f1, f * 2.0F);
        mSlider.setPosition(f2);
    }

    public void onDrawerStateChanged(int i)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if(menuitem != null && menuitem.getItemId() == 0x102002c && mDrawerIndicatorEnabled)
        {
            if(mDrawerLayout.isDrawerVisible(0x800003))
                mDrawerLayout.closeDrawer(0x800003);
            else
                mDrawerLayout.openDrawer(0x800003);
            return true;
        } else
        {
            return false;
        }
    }

    void setActionBarDescription(int i)
    {
        if(mActivityImpl != null)
        {
            mActivityImpl.setActionBarDescription(i);
            return;
        } else
        {
            mSetIndicatorInfo = IMPL.setActionBarDescription(mSetIndicatorInfo, mActivity, i);
            return;
        }
    }

    void setActionBarUpIndicator(Drawable drawable, int i)
    {
        if(mActivityImpl != null)
        {
            mActivityImpl.setActionBarUpIndicator(drawable, i);
            return;
        } else
        {
            mSetIndicatorInfo = IMPL.setActionBarUpIndicator(mSetIndicatorInfo, mActivity, drawable, i);
            return;
        }
    }

    public void setDrawerIndicatorEnabled(boolean flag)
    {
        if(flag != mDrawerIndicatorEnabled)
        {
            if(flag)
            {
                SlideDrawable slidedrawable = mSlider;
                int i;
                if(mDrawerLayout.isDrawerOpen(0x800003))
                    i = mCloseDrawerContentDescRes;
                else
                    i = mOpenDrawerContentDescRes;
                setActionBarUpIndicator(slidedrawable, i);
            } else
            {
                setActionBarUpIndicator(mThemeImage, 0);
            }
            mDrawerIndicatorEnabled = flag;
        }
    }

    public void syncState()
    {
        if(mDrawerLayout.isDrawerOpen(0x800003))
            mSlider.setPosition(1.0F);
        else
            mSlider.setPosition(0.0F);
        if(mDrawerIndicatorEnabled)
        {
            SlideDrawable slidedrawable = mSlider;
            int i;
            if(mDrawerLayout.isDrawerOpen(0x800003))
                i = mCloseDrawerContentDescRes;
            else
                i = mOpenDrawerContentDescRes;
            setActionBarUpIndicator(slidedrawable, i);
        }
    }

    private static final int ID_HOME = 0x102002c;
    private static final ActionBarDrawerToggleImpl IMPL;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.3333333F;
    private final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;
    private Drawable mThemeImage;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 11)
            IMPL = new ActionBarDrawerToggleImplHC();
        else
            IMPL = new ActionBarDrawerToggleImplBase();
    }

}
