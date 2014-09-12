
package android.support.v4.print;

import android.graphics.*;
import android.os.*;
import android.print.*;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;


class val.fittingMode extends PrintDocumentAdapter
{

    public void onLayout(PrintAttributes printattributes, PrintAttributes printattributes1, CancellationSignal cancellationsignal, android.print..LayoutResultCallback layoutresultcallback, Bundle bundle)
    {
        boolean flag = true;
        mAttributes = printattributes1;
        android.print.PrintDocumentInfo printdocumentinfo = (new android.print.ilder(val$jobName)).setContentType(flag).setPageCount(flag).build();
        if(printattributes1.equals(printattributes))
            flag = false;
        layoutresultcallback.onLayoutFinished(printdocumentinfo, flag);
    }

    public void onWrite(PageRange apagerange[], ParcelFileDescriptor parcelfiledescriptor, CancellationSignal cancellationsignal, android.print..WriteResultCallback writeresultcallback)
    {
        PrintedPdfDocument printedpdfdocument = new PrintedPdfDocument(mContext, mAttributes);
        android.graphics.pdf.t t = printedpdfdocument.startPage(1);
        RectF rectf = new RectF(t.Info().getContentRect());
        android.graphics.Matrix matrix = PrintHelperKitkat.access$000(PrintHelperKitkat.this, val$bitmap.getWidth(), val$bitmap.getHeight(), rectf, val$fittingMode);
        t.Canvas().drawBitmap(val$bitmap, matrix, null);
        printedpdfdocument.finishPage(t);
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

    private PrintAttributes mAttributes;
    final PrintHelperKitkat this$0;
    final Bitmap val$bitmap;
    final int val$fittingMode;
    final String val$jobName;

    tCallback()
    {
        this$0 = final_printhelperkitkat;
        val$jobName = s;
        val$bitmap = bitmap1;
        val$fittingMode = I.this;
        super();
    }
}
