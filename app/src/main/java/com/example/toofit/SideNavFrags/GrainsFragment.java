package com.example.toofit.SideNavFrags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toofit.R;
import com.example.toofit.ViewPager.CustomViewPageAdapterGrain;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GrainsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GrainsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PIC = "pic";
    ViewPager2 viewPager2;

    // TODO: Rename and change types of parameters
    private int pic;

    public GrainsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProteinsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GrainsFragment newInstance(String param1, String param2) {
        GrainsFragment fragment = new GrainsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PIC, fragment.pic);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pic = getArguments().getInt(ARG_PIC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grains, container, false);
        viewPager2 = view.findViewById(R.id.exPicViewPager);
        viewPager2.setAdapter(new CustomViewPageAdapterGrain(getActivity()));
        return view;
    }
}