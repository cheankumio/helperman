package klapper.caseupload.util;

import android.util.Log;

/**
 * Created by c1103304 on 2017/8/31.
 */

public class f_a {
    protected int v = 10;
    public int b = 11;
    private int n = 12;

    public void show(){
        Log.d("MYLOG", "show: "+v+", "+b+", "+n);
    }

    public void setV(){
        v = 151;
        show();
    }
}
