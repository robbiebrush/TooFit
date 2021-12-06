package com.example.toofit.RecyclerView.FactFrags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.toofit.RecyclerView.CustomRecyclerViewAdapter;
import com.example.toofit.RecyclerView.Fact;

import com.example.toofit.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProteinsFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProteinsFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProteinsFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProteinsFactFragment newInstance(String param1, String param2) {
        ProteinsFactFragment fragment = new ProteinsFactFragment();
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
        View view = inflater.inflate(R.layout.fragment_proteins_fact, container, false);
        ArrayList<Fact> facts = new ArrayList<>();
        facts.add(new Fact("What do they do?", "Proteins are chemical \'building blocks\' called amino acids. They are mainly responsible for building/ repairing muscles and bones. They are also used to create hormones and enzymes, and can be used as an energy source as well."));
        facts.add(new Fact("Why are they needed?", "We need proteins to maintain/ grow our bodies' size, strength, physical endurance, and durability in order to " +
                "better execute tasks in our lives. When energy is exerted in the contracting or extending of muscles, muscle fibers responsible for such actions " +
                "are ripped and stretched apart. Consumed proteins then have the primary function of filling those gaps with new proteins, growing the muscle in size, " +
                "strength, etc. This is the same process for bones, relative to their frequency and degree of stress. Creating/ regulating hormones and enzymes also " +
                "keeps our bodies' and minds' chemically balanced."));
        facts.add(new Fact("How much should I have daily?", "You should consume 0.8g of protein per kg of body weight daily. Therefore, a person 165lbs, should eat 60g of protein a day."));
        facts.add(new Fact("Tips", "1. Most protein dense foods are also extremely dense in nutrients and water (beef, steak, chicken, salmon).\n\n" +
                "2. When attempting to gain size or strength, one should adopt a high protein diet.\n\n" +
                "3. For most, the best way to prepare a high density protein food (meat) is to cook with tons of seasoning, and to base the protein (with " +
                "butter, olive oil, apple sauce, etc.)."));
        RecyclerView recyclerView = view.findViewById(R.id.factRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(facts));
        return view;
    }
}