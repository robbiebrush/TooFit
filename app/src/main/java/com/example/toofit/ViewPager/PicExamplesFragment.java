package com.example.toofit.ViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.toofit.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PicExamplesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PicExamplesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PIC = "pic";

    // TODO: Rename and change types of parameters
    private int pic;

    public PicExamplesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PicExamplesFragment newInstance(int pic) {
        PicExamplesFragment fragment = new PicExamplesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PIC, pic);
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
        View view = inflater.inflate(R.layout.fragment_pic_examples, container, false);
        ImageView picView = (ImageView) view.findViewById(R.id.exPic);
        picView.setImageResource(pic);

        return view;
    }
}