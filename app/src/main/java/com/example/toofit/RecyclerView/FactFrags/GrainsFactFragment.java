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
 * Use the {@link GrainsFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GrainsFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GrainsFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GrainsFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GrainsFactFragment newInstance(String param1, String param2) {
        GrainsFactFragment fragment = new GrainsFactFragment();
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
        View view = inflater.inflate(R.layout.fragment_grains_fact, container, false);
        ArrayList<Fact> facts = new ArrayList<>();
        facts.add(new Fact("What do they do?", "Grains are one of the best sources of energy we can obtain due to the amount of complex carbohydrates within them. Whole grains\n" +
                " are also a great source of some nutrients such as B vitamins (thiamin, riboflavin, etc.), minerals (iron, magnesium, etc.) and " +
                " fiber. Fiber also improves digestion substantially, and fills your stomach quickly."));
        facts.add(new Fact("Why are they needed?", "No one needs grains. They are not essential to humans as all the vitamins, minerals, and energy are plentifully available in \\n\" +\n" +
                " other foods. However, in your typcial grain food item, the energy and fibre supplies are abundant. Energy " +
                " is crucial to any orgainism, allowing us to move, perform bodily functions, and think. Even consuimg a viable amount " +
                " of energy daily, yet not ideal, will result in noticeable effects such as much quicker fatigue, mental fog, depression, " +
                " a lessened drive to achieve, reproduce, even prepare/ eat food, and more. The abundant fiber supply helps prevent over-eating " +
                " by filling you quicker, and greatly improving overall digestion."));
        facts.add(new Fact("How much should I have daily?", "You're daily caloric intake should be approximately 55% grains. That equates to between 6 and 11 servings of grains daily, 3 of " +
                "which should be servings of whole grains."));
        facts.add(new Fact("Tips", "Eating grains immediately in the morning as part of your breakfast produces the best energy 'spike' and often makes people feel much more productive as it aligns with their bodies circadian rhythm. Your body wants to be most productive in the morning, until the early afternoon.\n\n" +
                "Eating whole grain pastries or 'desserts' do not diminish the effect grains produce or is in anyway 'less healthy' on the grain's end. " +
                "The less healthy part is the weekly intake of simple carbohydatrates (sugars) layered on top.\n\nWhen attempting to lose weight, a high whole grain diet is very beneficial. It delivers all of its benefits, fills you up well, and is low in fats and sugars."));
        RecyclerView recyclerView = view.findViewById(R.id.factRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(facts));
        return view;
    }
}