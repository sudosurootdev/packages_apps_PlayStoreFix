
package android.support.v4.app;

import android.view.animation.Animation;


class val.fragment
    implements android.view.animation.tener
{

    public void onAnimationEnd(Animation animation)
    {
        if(val$fragment.mAnimatingAway != null)
        {
            val$fragment.mAnimatingAway = null;
            moveToState(val$fragment, val$fragment.mStateAfterAnimating, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    final FragmentManagerImpl this$0;
    final Fragment val$fragment;

    tener()
    {
        this$0 = final_fragmentmanagerimpl;
        val$fragment = Fragment.this;
        super();
    }
}
