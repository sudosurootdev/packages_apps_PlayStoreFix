
package com.ssrootdev.apps.playfixer;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.*;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.List;


class val.progressDialog extends Thread
{

    public void run()
    {
        final StringBuilder sb = new StringBuilder();
        List list = InsufficientStorageFixer.access$0(InsufficientStorageFixer.this).getInstalledPackages(0);
        List list1 = InsufficientStorageFixer.access$1(InsufficientStorageFixer.this);
        Log.d("FOO", (new StringBuilder("dirs: ")).append(list1.size()).append(" | packages: ").append(list.size()).toString());
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                if(sb.toString().length() == 0)
                    sb.append("<big>No errors found.</big><br><br><small>If you continue to receive the '<i>Insufficient Storage Available</i>' error in Google Play you most likely need to clear up some free space.</small>");
                InsufficientStorageFixer.access$2(InsufficientStorageFixer.this).post(new Runnable() {

                    public void run()
                    {
                        progressDialog.dismiss();
                        (new android.app.AlertDialog.Builder(InsufficientStorageFixer.access$3(this$0))).setTitle("Results").setMessage(Html.fromHtml(sb.toString())).setPositiveButton("Close", new android.content.DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

                            final _cls1 this$2;

            
            {
                this$2 = _cls1.this;
                super();
            }
                        }).show();
                    }

                    final InsufficientStorageFixer._cls1 this$1;
                    private final ProgressDialog val$progressDialog;
                    private final StringBuilder val$sb;

            
            {
                this$1 = InsufficientStorageFixer._cls1.this;
                progressDialog = progressdialog;
                sb = stringbuilder;
                super();
            }
                });
                return;
            }
            PackageInfo packageinfo = (PackageInfo)iterator.next();
            Iterator iterator1 = list1.iterator();
            while(iterator1.hasNext()) 
            {
                File file = (File)iterator1.next();
                if(file.getName().startsWith((new StringBuilder(String.valueOf(packageinfo.packageName))).append("-").toString()))
                {
                    String s = (new File(packageinfo.applicationInfo.sourceDir)).getName().replace(".apk", "");
                    if(!file.getName().equals(s))
                    {
                        String as[] = new String[1];
                        as[0] = (new StringBuilder("rm -rf ")).append(file).toString();
                        if(_mth1(as).())
                            sb.append((new StringBuilder("&#160;<font color=\"#0099CC\">&#10003;</font> ")).append(packageinfo.applicationInfo.loadLabel(InsufficientStorageFixer.access$0(InsufficientStorageFixer.this)).toString()).append("<br>").toString());
                        else
                            sb.append((new StringBuilder("&#160;<font color=\"#0099CC\">&#cc0000;</font> Error Fixing ")).append(packageinfo.applicationInfo.loadLabel(InsufficientStorageFixer.access$0(InsufficientStorageFixer.this)).toString()).append("<br>").toString());
                    }
                }
            }
        } while(true);
    }

    final InsufficientStorageFixer this$0;
    private final ProgressDialog val$progressDialog;


    _cls1.val.sb()
    {
        this$0 = final_insufficientstoragefixer;
        val$progressDialog = ProgressDialog.this;
        super();
    }
}
