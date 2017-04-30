package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inventslab.hacareemps_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Custom_PopUp extends Fragment {


    public Custom_PopUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom__pop_up, container, false);
    }

}
