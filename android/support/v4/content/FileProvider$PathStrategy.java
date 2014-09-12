
package android.support.v4.content;

import android.net.Uri;
import java.io.File;


static interface 
{

    public abstract File getFileForUri(Uri uri);

    public abstract Uri getUriForFile(File file);
}
