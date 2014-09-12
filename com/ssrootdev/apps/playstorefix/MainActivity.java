
package com.ssrootdev.apps.playfixer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity
{

    public MainActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        findViewById(0x7f080000).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                (new InsufficientStorageFixer(MainActivity.this)).run();
            }

            final MainActivity this$0;

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }
}
