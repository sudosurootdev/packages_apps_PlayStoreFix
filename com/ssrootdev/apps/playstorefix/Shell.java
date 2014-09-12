
package com.ssrootdev.apps.playfixer;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import java.io.*;
import java.util.List;

public class Shell
{
    public static interface CommandListener
    {

        public abstract void onExecuteCommand(String s);

        public abstract void onFinished(CommandResult commandresult);

        public abstract void onReadOutput(String s, boolean flag);
    }

    public static class CommandResult
    {

        public boolean hasOutput()
        {
            return !TextUtils.isEmpty(stdout);
        }

        public boolean isSuccess()
        {
            return success() && hasOutput();
        }

        public boolean success()
        {
            return exitValue == 0;
        }

        public int exitValue;
        public String stderr;
        public String stdout;

        public CommandResult()
        {
            exitValue = -1;
        }

        public CommandResult(int i, String s, String s1)
        {
            exitValue = -1;
            exitValue = i;
            stdout = s;
            stderr = s1;
        }
    }

    public static class SH
    {

        public static CommandResult run(List list)
        {
            return run((String[])list.toArray(new String[0]));
        }

        public static transient CommandResult run(String as[])
        {
            return (new Shell("sh")).run(as);
        }

        public SH()
        {
        }
    }

    public static class SU
    {

        public static CommandResult run(List list)
        {
            return run((String[])list.toArray(new String[0]));
        }

        public static transient CommandResult run(String as[])
        {
            return (new Shell("su")).run(as);
        }

        public SU()
        {
        }
    }


    public Shell()
    {
        this("su");
    }

    public Shell(String s)
    {
        shell = s;
    }

    public static boolean canSu()
    {
        return canSu(false);
    }

    public static boolean canSu(boolean flag)
    {
        if(canSu == null || flag)
        {
            CommandResult commandresult = SU.run(new String[] {
                "id"
            });
            StringBuilder stringbuilder = new StringBuilder();
            if(commandresult.stdout != null)
                stringbuilder.append(commandresult.stdout).append(" ; ");
            if(commandresult.stderr != null)
                stringbuilder.append(commandresult.stderr);
            Log.d("Shell", (new StringBuilder("canSU() su[")).append(commandresult.exitValue).append("]: ").append(stringbuilder).toString());
            canSu = Boolean.valueOf(commandresult.success());
        }
        return canSu.booleanValue();
    }

    private void onReadLine(final String line, final boolean stdout)
    {
label0:
        {
            if(mListener != null)
            {
                if(mHandler == null)
                    break label0;
                mHandler.post(new Runnable() {

                    public void run()
                    {
                        mListener.onReadOutput(line, stdout);
                    }

                    final Shell this$0;
                    private final String val$line;
                    private final boolean val$stdout;

            
            {
                this$0 = Shell.this;
                line = s;
                stdout = flag;
                super();
            }
                });
            }
            return;
        }
        mListener.onReadOutput(line, stdout);
    }

    private String readStream(InputStreamReader inputstreamreader, boolean flag)
    {
        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
        String s = bufferedreader.readLine();
        StringBuffer stringbuffer = null;
        if(s == null) goto _L2; else goto _L1
_L1:
        StringBuffer stringbuffer1 = new StringBuffer(s);
_L5:
        String s1 = bufferedreader.readLine();
        if(s1 != null) goto _L4; else goto _L3
_L3:
        stringbuffer = stringbuffer1;
_L2:
        IOException ioexception;
        if(stringbuffer != null)
            return stringbuffer.toString();
        else
            return null;
_L4:
        onReadLine(s1, flag);
        stringbuffer1.append("\n").append(s1);
          goto _L5
        ioexception;
        stringbuffer = stringbuffer1;
_L6:
        Log.i("Shell", (new StringBuilder("Error: ")).append(ioexception.getMessage()).toString());
          goto _L2
        ioexception;
        stringbuffer = null;
          goto _L6
    }

    public static CommandResult run(String s, String as[])
    {
        return (new Shell(s)).run(as);
    }

    public String getShell()
    {
        return shell;
    }

    public transient CommandResult run(String as[])
    {
        final CommandResult result;
        InputStreamReader inputstreamreader;
        InputStreamReader inputstreamreader1;
        DataOutputStream dataoutputstream;
        Process process;
        result = new CommandResult();
        inputstreamreader = null;
        inputstreamreader1 = null;
        dataoutputstream = null;
        process = null;
        Runtime.getRuntime().gc();
        DataOutputStream dataoutputstream1;
        process = Runtime.getRuntime().exec(shell);
        dataoutputstream1 = new DataOutputStream(process.getOutputStream());
        InputStreamReader inputstreamreader2 = new InputStreamReader(process.getInputStream());
        InputStreamReader inputstreamreader3 = new InputStreamReader(process.getErrorStream());
        int i = as.length;
        int j = 0;
_L7:
        if(j < i) goto _L2; else goto _L1
_L1:
        dataoutputstream1.writeBytes("exit\n");
        dataoutputstream1.flush();
        result.stdout = readStream(inputstreamreader2, true);
        result.stderr = readStream(inputstreamreader3, false);
        result.exitValue = process.waitFor();
_L9:
        if(dataoutputstream1 == null)
            break MISSING_BLOCK_LABEL_146;
        dataoutputstream1.close();
        if(inputstreamreader2 == null)
            break MISSING_BLOCK_LABEL_156;
        inputstreamreader2.close();
        if(inputstreamreader3 == null)
            break MISSING_BLOCK_LABEL_166;
        inputstreamreader3.close();
        IOException ioexception;
        Exception exception;
        Exception exception3;
        InterruptedException interruptedexception;
        String s;
        final String cmd;
        if(process != null)
            try
            {
                process.destroy();
            }
            catch(Exception exception4) { }
        if(mListener == null) goto _L4; else goto _L3
_L3:
        if(mHandler == null) goto _L6; else goto _L5
_L5:
        mHandler.post(new Runnable() {

            public void run()
            {
                mListener.onFinished(result);
            }

            final Shell this$0;
            private final CommandResult val$result;

            
            {
                this$0 = Shell.this;
                result = commandresult;
                super();
            }
        });
_L4:
        return result;
_L2:
        s = as[j];
        if(shell.equals("su") && LD_LIBRARY_PATH != null)
            s = (new StringBuilder("LD_LIBRARY_PATH=")).append(LD_LIBRARY_PATH).append(" ").append(s).toString();
        if(mListener == null)
            break MISSING_BLOCK_LABEL_299;
        if(mHandler == null)
            break MISSING_BLOCK_LABEL_335;
        cmd = s;
        mHandler.post(new Runnable() {

            public void run()
            {
                mListener.onExecuteCommand(cmd);
            }

            final Shell this$0;
            private final String val$cmd;

            
            {
                this$0 = Shell.this;
                cmd = s;
                super();
            }
        });
_L8:
        dataoutputstream1.writeBytes((new StringBuilder(String.valueOf(s))).append("\n").toString());
        dataoutputstream1.flush();
        j++;
          goto _L7
        mListener.onExecuteCommand(s);
          goto _L8
        interruptedexception;
        Log.i("Shell", (new StringBuilder("Error running commands: ")).append(interruptedexception.getMessage()).toString(), interruptedexception);
          goto _L9
        ioexception;
        dataoutputstream = dataoutputstream1;
        inputstreamreader1 = inputstreamreader3;
        inputstreamreader = inputstreamreader2;
_L12:
        Log.i("Shell", (new StringBuilder("Error: ")).append(ioexception.getMessage()).toString());
        if(dataoutputstream == null)
            break MISSING_BLOCK_LABEL_431;
        dataoutputstream.close();
        if(inputstreamreader == null)
            break MISSING_BLOCK_LABEL_439;
        inputstreamreader.close();
        if(inputstreamreader1 == null)
            break MISSING_BLOCK_LABEL_449;
        inputstreamreader1.close();
        if(process != null)
            try
            {
                process.destroy();
            }
            catch(Exception exception2) { }
        break MISSING_BLOCK_LABEL_176;
        exception3;
        Log.i("Shell", (new StringBuilder("Error running commands: ")).append(exception3.getMessage()).toString(), exception3);
          goto _L9
        exception;
        dataoutputstream = dataoutputstream1;
        inputstreamreader1 = inputstreamreader3;
        inputstreamreader = inputstreamreader2;
_L11:
        if(dataoutputstream == null)
            break MISSING_BLOCK_LABEL_523;
        dataoutputstream.close();
        if(inputstreamreader == null)
            break MISSING_BLOCK_LABEL_531;
        inputstreamreader.close();
        if(inputstreamreader1 == null)
            break MISSING_BLOCK_LABEL_541;
        inputstreamreader1.close();
        if(process != null)
            try
            {
                process.destroy();
            }
            catch(Exception exception1) { }
        throw exception;
_L6:
        mListener.onFinished(result);
        return result;
        exception;
        continue; /* Loop/switch isn't completed */
        exception;
        dataoutputstream = dataoutputstream1;
        inputstreamreader1 = null;
        inputstreamreader = null;
        continue; /* Loop/switch isn't completed */
        exception;
        dataoutputstream = dataoutputstream1;
        inputstreamreader = inputstreamreader2;
        inputstreamreader1 = null;
        if(true) goto _L11; else goto _L10
_L10:
        ioexception;
        dataoutputstream = null;
        inputstreamreader1 = null;
        inputstreamreader = null;
          goto _L12
        ioexception;
        dataoutputstream = dataoutputstream1;
        inputstreamreader1 = null;
        inputstreamreader = null;
          goto _L12
        ioexception;
        dataoutputstream = dataoutputstream1;
        inputstreamreader = inputstreamreader2;
        inputstreamreader1 = null;
          goto _L12
    }

    public Shell setCommandListener(Handler handler, CommandListener commandlistener)
    {
        mHandler = handler;
        mListener = commandlistener;
        return this;
    }

    public Shell setCommandListener(CommandListener commandlistener)
    {
        return setCommandListener(null, commandlistener);
    }

    public void setShell(String s)
    {
        shell = s;
    }

    private static final String LD_LIBRARY_PATH = System.getenv("LD_LIBRARY_PATH");
    private static final String TAG = "Shell";
    private static Boolean canSu;
    private Handler mHandler;
    private CommandListener mListener;
    private String shell;


}
