
package com.ssrootdev.apps.playfixer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.*;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import java.io.File;
import java.util.*;

public class InsufficientStorageFixer
{

    public InsufficientStorageFixer(Context context)
    {
        mContext = context;
        mPackageManager = context.getPackageManager();
    }

    private List getLibDirectories()
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        Shell.CommandResult commandresult = Shell.SU.run(new String[] {
            "ls /data/app-lib"
        });
        if(commandresult.isSuccess())
        {
            String as[] = commandresult.stdout.split("\n");
            for(int j = as.length; i < j; i++)
                arraylist.add(new File("/data/app-lib", as[i]));

        }
        return arraylist;
    }

    public void run()
    {
        final ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        (new Thread() {

            public void run()
            {
                StringBuilder stringbuilder = new StringBuilder();
                List list = mPackageManager.getInstalledPackages(0);
                List list1 = getLibDirectories();
                Log.d("FOO", (new StringBuilder("dirs: ")).append(list1.size()).append(" | packages: ").append(list.size()).toString());
                Iterator iterator = list.iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        if(stringbuilder.toString().length() == 0)
                            stringbuilder.append("<big>No errors found.</big><br><br><small>If you continue to receive the '<i>Insufficient Storage Available</i>' error in Google Play you most likely need to clear up some free space.</small>");
                        mHandler.post(stringbuilder. new Runnable() {

                            public void run()
                            {
                                progressDialog.dismiss();
                                (new android.app.AlertDialog.Builder(mContext)).setTitle("Results").setMessage(Html.fromHtml(sb.toString())).setPositiveButton("Close", new android.content.DialogInterface.OnClickListener() {

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

                            final _cls1 this$1;
                            private final ProgressDialog val$progressDialog;
                            private final StringBuilder val$sb;

            
            {
                this$1 = final__pcls1;
                progressDialog = progressdialog;
                sb = StringBuilder.this;
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
                                if(Shell.SU.run(as).success())
                                    stringbuilder.append((new StringBuilder("&#160;<font color=\"#0099CC\">&#10003;</font> ")).append(packageinfo.applicationInfo.loadLabel(mPackageManager).toString()).append("<br>").toString());
                                else
                                    stringbuilder.append((new StringBuilder("&#160;<font color=\"#0099CC\">&#cc0000;</font> Error Fixing ")).append(packageinfo.applicationInfo.loadLabel(mPackageManager).toString()).append("<br>").toString());
                            }
                        }
                    }
                } while(true);
            }

            final InsufficientStorageFixer this$0;
            private final ProgressDialog val$progressDialog;


            
            {
                this$0 = InsufficientStorageFixer.this;
                progressDialog = progressdialog;
                super();
            }
        }).start();
    }

    private static final String APPLIB_DIR = "/data/app-lib";
    private Context mContext;
    private final Handler mHandler = new Handler();
    private PackageManager mPackageManager;




}
