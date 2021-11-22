package com.example.toofit.RecyclerView.FactFrags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toofit.R;
import com.example.toofit.RecyclerView.CustomRecyclerViewAdapter;
import com.example.toofit.RecyclerView.Fact;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DairyFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DairyFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DairyFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DairyFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DairyFactFragment newInstance(String param1, String param2) {
        DairyFactFragment fragment = new DairyFactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dairy_fact, container, false);
        ArrayList<Fact> facts = new ArrayList<>();
        facts.add(new Fact("What do they do?", "Dairy products simply provide more of the nutrients we need, and being very high in calcium. Dairy products that are not " +
                "the low fat versions do contain a high level of saturated fat, which has been linked to increase chance of heart disease, " +
                "type 2 diabetes, and even Alzheimer's disease. Dairy is also very high in potassium, which the average person lacks the proper " +
                "amount of."));
        facts.add(new Fact("Why are they needed?", "Like grains, dairy is not essential. You can obtain reasonable sources of all that dairy provides, elsewhere.\n" +
                "However, dairy is a fantastic source of calcium, which does strengthen your bones, and prevent some diseases. " +
                "The high potassium content also helps tremendusly in regulating healthy blood pressure. It is also an easy " +
                "source of lots of the nutrients we need."));
        facts.add(new Fact("How much should I have daily?", "You should consume 3 servings daily as an adult, and 2 as a child."));
        facts.add(new Fact("Tips", "It is recommended to stick with low fat or fat free dairy products, especially if heart disease runs in your gene pool.\n\nProtein supplements can be mixed with dairy products (as well as vegetable or fruit products) to make a quick, high protein meal with some nutritional content ('protein shakes' are not remotely close to true meal supplements due to the very low nutrient density).\n\nCheese goes with anything."));
        RecyclerView recyclerView = view.findViewById(R.id.factRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(facts));
        return view;
    }
}