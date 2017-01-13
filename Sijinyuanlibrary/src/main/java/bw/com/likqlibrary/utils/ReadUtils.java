package bw.com.likqlibrary.utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xueh on 2016/11/12.
 */

public class ReadUtils {
    /**
     * 读输入流
     *
     * @param is
     * @return
     */
    public static String getStringByInputStream(InputStream is) {
        String content = null;
        try {
            if (is != null) {
                byte[] buffer = new byte[is.available()];
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int readLength = is.read(buffer);
                    if (readLength == -1)
                        break;
                    arrayOutputStream.write(buffer, 0, readLength);
                }
                is.close();
                arrayOutputStream.close();
                content = new String(arrayOutputStream.toByteArray());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            content = null;
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return content;
    }
    /**
     * 读assets文件的方法
     *
     * @param is
     * @return
     */
    public static String readAssets(Context context, String fileName) {
        InputStream is = null;
        try {
            is = context.getAssets().open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getStringByInputStream(is);
    }

    /**
     * 读raw文件的方法：
     *
     * @param is
     * @return
     */
    public static String readRaws(Context context, int id) {
        InputStream is = context.getResources().openRawResource(id);
        return getStringByInputStream(is);
    }
}
