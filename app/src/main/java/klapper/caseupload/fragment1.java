package klapper.caseupload;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.greenrobot.event.EventBus;

/**
 * Created by c1103304 on 2017/8/16.
 */

public class fragment1 extends Fragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment1_layout, container, false);
        Button sendMessage = (Button)rootView.findViewById(R.id.send_btn);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new SomeEvent("Hello this is Fragment1!!"));
            }
        });


        return rootView;
    }
}
