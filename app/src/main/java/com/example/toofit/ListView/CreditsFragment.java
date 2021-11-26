package com.example.toofit.ListView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.toofit.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {
    ListView listView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String param1, String param2) {
        CreditsFragment fragment = new CreditsFragment();
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

        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        listView = view.findViewById(R.id.listView);
        ArrayList<Credit> arrayList = new ArrayList<>();
        arrayList.add(new Credit("What Proteins Do/ Why They're Needed:", "https://www.betterhealth.vic.gov.au/health/healthyliving/protein"));
        arrayList.add(new Credit("How Much Protein Daily:", "https://www.sclhealth.org/blog/2019/07/how-much-protein-is-simply-too-much/"));
        arrayList.add(new Credit("What Grains Do/ Why They're Needed:", "https://www.healthyeating.org/nutrition-topics/general/food-groups/grains"));
        arrayList.add(new Credit("How Much Grains Daily:", "https://www.webmd.com/food-recipes/features/go-with-whole-grains"));
        arrayList.add(new Credit("What Vegetables Do/ Why They're Needed:", "https://food.unl.edu/NEP/NEP%20Documents/Vegetable%20group.pdf"));
        arrayList.add(new Credit("How Much Vegetables Daily:", "https://www.cdc.gov/media/releases/2017/p1116-fruit-vegetable-consumption.html"));
        arrayList.add(new Credit("What Fruits Do/ Why They're Needed:", "https://www.medicalnewstoday.com/articles/324431"));
        arrayList.add(new Credit("How Much Fruit Daily:", "https://www.healthline.com/nutrition/how-much-fruit-per-day"));
        arrayList.add(new Credit("Fruit Tip 3:", "https://www.abc.net.au/news/health/2017-04-21/can-you-have-too-many-antioxidants/8457336"));
        arrayList.add(new Credit("What Dairy Does/ Why It's Needed:", "https://www.myplate.gov/eat-healthy/dairy\nhttps://www.pcrm.org/good-nutrition/nutrition-information/health-concerns-about-dairy"));
        arrayList.add(new Credit("Protein Pic Steak: ", "https://www.pexels.com/photo/photo-of-steak-and-french-fries-on-gray-plate-3535383/"));
        arrayList.add(new Credit("Protein Pic Drumsticks: ", "https://www.pexels.com/photo/close-up-photo-of-cooked-chicken-2611917/"));
        arrayList.add(new Credit("Protein Pic Shishkabob: ", "https://www.pexels.com/photo/plate-of-barbeques-on-dining-table-2689419/"));
        arrayList.add(new Credit("Grain Pic Bread: ", "https://www.pexels.com/photo/bread-on-wicker-basket-1755785/"));
        arrayList.add(new Credit("Grain Pic Pasta: ", "https://www.pexels.com/photo/close-up-photography-of-pasta-with-white-sauce-2703468/"));
        arrayList.add(new Credit("Grain Pic Bagel: ", "https://www.pexels.com/photo/bagels-on-black-plates-3957500/"));
        arrayList.add(new Credit("Vegetable Pic Broccoli: ", "https://www.pexels.com/photo/bowl-of-sliced-broccoli-1359326/"));
        arrayList.add(new Credit("Vegetable Pic Soup: ", "https://www.pexels.com/photo/cooked-rice-and-curry-food-served-on-white-plate-674574/"));
        arrayList.add(new Credit("Vegetable Pic Salad: ", "https://www.pexels.com/photo/yellow-green-and-white-vegetables-2894651/"));
        arrayList.add(new Credit("Fruit Pic Apple: ", "https://www.pexels.com/photo/board-with-slices-of-fresh-apples-and-knife-near-window-6368799/"));
        arrayList.add(new Credit("Fruit Pic Smoothie: ", "https://www.pexels.com/photo/strawberry-smoothie-on-glass-jar-775032/"));
        arrayList.add(new Credit("Fruit Pic Fruit Bowl: ", "https://www.pexels.com/photo/food-healthy-dawn-dry-6708435/"));
        arrayList.add(new Credit("Dairy Pic Cheese: ", "https://www.pexels.com/photo/photo-of-cheese-on-wooden-tray-3758131/"));
        arrayList.add(new Credit("Dairy Pic Yogurt: ", "https://www.pexels.com/photo/delicious-dessert-with-berries-on-coaster-5946069/"));
        arrayList.add(new Credit("Dairy Pic Milk: ", "https://www.pexels.com/photo/crop-person-pouring-milk-into-glass-on-table-5946720/"));
        listView.setAdapter(new CustomListViewAdapter(getContext(), arrayList));

        return view;
    }
}