package klapper.caseupload;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by c1103304 on 2017/8/16.
 */

public class fragment2 extends Fragment {
    private View rootView;
    private TextView receiveString;
    private String tmpString;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment2_layout, container, false);
        receiveString = (TextView)rootView.findViewById(R.id.textView2);

        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEven(SomeEvent event){
        tmpString += event.getMessage() + "\n";

        receiveString.setText(tmpString);
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
