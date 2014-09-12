
package android.support.v4.print;

import android.graphics.*;
import android.net.Uri;
import android.os.*;
import android.print.*;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.*;


class Callback extends AsyncTask
{

    protected transient Bitmap doInBackground(Uri auri[])
    {
        Bitmap bitmap;
        try
        {
            bitmap = PrintHelperKitkat.access$200(_fld0, imageFile, 3500);
        }
        catch(FileNotFoundException filenotfoundexception)
        {
            return null;
        }
        return bitmap;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Uri[])aobj);
    }

    protected void onCancelled(Bitmap bitmap)
    {
        val$layoutResultCallback.onLayoutCancelled();
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((Bitmap)obj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        boolean flag = true;
        super.onPostExecute(bitmap);
        itmap = bitmap;
        if(bitmap != null)
        {
            android.print.PrintDocumentInfo printdocumentinfo = (new android.print.der(jobName)).setContentType(flag).setPageCount(flag).build();
            if(val$newPrintAttributes.equals(val$oldPrintAttributes))
                flag = false;
            val$layoutResultCallback.onLayoutFinished(printdocumentinfo, flag);
            return;
        } else
        {
            val$layoutResultCallback.onLayoutFailed(null);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    protected void onPreExecute()
    {
        val$cancellationSignal.setOnCancelListener(new android.os.CancellationSignal.OnCancelListener() {

            public void onCancel()
            {
                cancelLoad();
                cancel(false);
            }

            final PrintHelperKitkat._cls2._cls1 this$2;

            
            {
                this$2 = PrintHelperKitkat._cls2._cls1.this;
                super();
            }
        });
    }

    final cancel this$1;
    final CancellationSignal val$cancellationSignal;
    final android.print.ayoutResultCallback val$layoutResultCallback;
    final PrintAttributes val$newPrintAttributes;
    final PrintAttributes val$oldPrintAttributes;

    Callback()
    {
        this$1 = final_callback;
        val$cancellationSignal = cancellationsignal;
        val$newPrintAttributes = printattributes;
        val$oldPrintAttributes = printattributes1;
        val$layoutResultCallback = android.print.ayoutResultCallback.this;
        super();
    }

    // Unreferenced inner class android/support/v4/print/PrintHelperKitkat$2

/* anonymous class */
    class PrintHelperKitkat._cls2 extends PrintDocumentAdapter
    {

        private void cancelLoad()
        {
            Object obj = PrintHelperKitkat.access$300(PrintHelperKitkat.this);
            synchronized(obj)
            {
                if(mDecodeOptions != null)
                {
                    mDecodeOptions.requestCancelDecode();
                    mDecodeOptions = null;
                }
            }
            return;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onFinish()
        {
            super.onFinish();
            cancelLoad();
            loadBitmap.cancel(true);
        }

        public void onLayout(final PrintAttributes oldPrintAttributes, final PrintAttributes newPrintAttributes, final CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.LayoutResultCallback layoutresultcallback, Bundle bundle)
        {
            boolean flag = true;
            if(cancellationSignal.isCanceled())
            {
                layoutresultcallback.onLayoutCancelled();
                mAttributes = newPrintAttributes;
                return;
            }
            if(mBitmap != null)
            {
                android.print.PrintDocumentInfo printdocumentinfo = (new android.print.PrintDocumentInfo.Builder(jobName)).setContentType(flag).setPageCount(flag).build();
                if(newPrintAttributes.equals(oldPrintAttributes))
                    flag = false;
                layoutresultcallback.onLayoutFinished(printdocumentinfo, flag);
                return;
            } else
            {
                loadBitmap = layoutresultcallback. new PrintHelperKitkat._cls2._cls1();
                loadBitmap.execute(new Uri[0]);
                mAttributes = newPrintAttributes;
                return;
            }
        }

        public void onWrite(PageRange apagerange[], ParcelFileDescriptor parcelfiledescriptor, CancellationSignal cancellationsignal, android.print.PrintDocumentAdapter.WriteResultCallback writeresultcallback)
        {
            PrintedPdfDocument printedpdfdocument = new PrintedPdfDocument(mContext, mAttributes);
            android.graphics.pdf.PdfDocument.Page page = printedpdfdocument.startPage(1);
            RectF rectf = new RectF(page.getInfo().getContentRect());
            android.graphics.Matrix matrix = PrintHelperKitkat.access$000(PrintHelperKitkat.this, mBitmap.getWidth(), mBitmap.getHeight(), rectf, fittingMode);
            page.getCanvas().drawBitmap(mBitmap, matrix, null);
            printedpdfdocument.finishPage(page);
            printedpdfdocument.writeTo(new FileOutputStream(parcelfiledescriptor.getFileDescriptor()));
            PageRange apagerange1[] = new PageRange[1];
            apagerange1[0] = PageRange.ALL_PAGES;
            writeresultcallback.onWriteFinished(apagerange1);
_L2:
            if(printedpdfdocument != null)
                printedpdfdocument.close();
            if(parcelfiledescriptor == null)
                break MISSING_BLOCK_LABEL_150;
            parcelfiledescriptor.close();
            return;
            IOException ioexception1;
            ioexception1;
            Log.e("PrintHelperKitkat", "Error writing printed content", ioexception1);
            writeresultcallback.onWriteFailed(null);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            if(printedpdfdocument != null)
                printedpdfdocument.close();
            IOException ioexception2;
            if(parcelfiledescriptor != null)
                try
                {
                    parcelfiledescriptor.close();
                }
                catch(IOException ioexception) { }
            throw exception;
            ioexception2;
        }

        AsyncTask loadBitmap;
        private PrintAttributes mAttributes;
        Bitmap mBitmap;
        final PrintHelperKitkat this$0;
        final int val$fittingMode;
        final Uri val$imageFile;
        final String val$jobName;


            
            {
                this$0 = final_printhelperkitkat;
                jobName = s;
                imageFile = uri;
                fittingMode = I.this;
                super();
                mBitmap = null;
            }
    }

}
