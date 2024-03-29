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
 * Use the {@link FruitsFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FruitsFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FruitsFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FruitsFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FruitsFactFragment newInstance(String param1, String param2) {
        FruitsFactFragment fragment = new FruitsFactFragment();
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
        View view = inflater.inflate(R.layout.fragment_fruits_fact, container, false);
        ArrayList<Fact> facts = new ArrayList<>();
        facts.add(new Fact("What do they do?", "Fruits are very similar in function to vegetables. They have a very high nutrient and fiber content that aid our bodies in " +
                "everything they do. They too are very low in calories. Although, on average, their nutrient densities are slightly lower than vegetables, " +
                "they also supply a reasonable amount of natural sugars and antioxidants."));
        facts.add(new Fact("Why are they needed?", "Just like vegetables, we need fruits to keep us healthy and away from illness. The nutrients are majority the same as vegetables," +
                " maintaining our bodies in specific ways as well as fuelling the immune system, lowering chance of chronic disease, stroke," +
                " and cancer. The natural sugars are good as its a healthy amount, yet we all consume too much sugar regardless. The" +
                " antioxidants help flush toxins (waste products from bodily functions) out of our bodies quicker. Also contains great" +
                " fiber for digestion. "));
        facts.add(new Fact("How much should I have daily?", "You should consume 2 to 5 servings of fruits daily."));
        facts.add(new Fact("Tips", "1. Personally, some fruits like apples taste great when cooked with a protein like vegetables.\n\n2. Fruits are a great snack substitute to high in sugar defaults (cookies, chocolate, etc.).\n\n3. An extreme excess in fruits can result in reverse effects from the antioxidants. "));
        RecyclerView recyclerView = view.findViewById(R.id.factRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(facts));
        return view;
    }
}