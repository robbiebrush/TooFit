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
 * Use the {@link VegsFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VegsFactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VegsFactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VegFactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VegsFactFragment newInstance(String param1, String param2) {
        VegsFactFragment fragment = new VegsFactFragment();
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
        View view = inflater.inflate(R.layout.fragment_vegs_fact, container, false);
        ArrayList<Fact> facts = new ArrayList<>();
        facts.add(new Fact("What do they do?", "Vegetables are the most dense source of vitamins and minerals out there. They are very low in fats and calories, and provide" +
                " virtually every nutrient we need in our body. They also contain high dietary fibre."));
        facts.add(new Fact("Why are they needed?", "The nutrients provided by vegetables keeps our body healthy and able to fight off illness. Potassium and folate for example, helps\n" +
                " maintain healthy blood pressure and formation of new blood cells. Vitamin C for example, helps heal wounds and maintains" +
                " oral health. On top of the specific health benefits from each nutrient, the squad of nutrients consumed with a vegetable" +
                " substantially improves the immune system, lessening the chances of chronic disease, stroke, cancer, and illness in general." +
                " Their fibre also greatly improves digestion."));
        facts.add(new Fact("How much should I have daily?", "You should consume 2 to 3 cups of vegetables daily as an adult, and if a child can stick out those numbers too, they'll" +
                " experience nothing but benefits, and possibly a tinted urine colour due to vitamin excess."));
        facts.add(new Fact("Tips", "Vegetables prepared to any size, can be cooked into any other food and retain its full nutrient density (the juices drawn out during cooking included).\n\nVegetables can be seasoned and fried to taste incredible and retain most of its nutrient density.\n\nIt is very important for pregnant women to consume lots of vegeatbles, as to create/ have the extra blood cells and nutrients to supply the fetus."));
        RecyclerView recyclerView = view.findViewById(R.id.factRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(facts));
        return view;
    }
}