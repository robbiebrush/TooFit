package com.example.toofit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.actions.ReserveIntents;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolFragment extends Fragment {
    Bundle extras = getArguments();

    Integer weight = extras.getInt("WEIGHT");
    Integer height = extras.getInt("HEIGHT");
    Integer desiredWeight = extras.getInt("DESIREDWEIGHT");
    Integer age = extras.getInt("AGE");
    String sex = extras.getString("SEX");
    String objective = extras.getString("OBJECTIVE");

    String dailyProtein;
    String dailyCarbs;
    String dailyFat;
    String foodEnergy;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToolFragment() {
        // Required empty public constructor
    }

    public String[] nutritionCalc(Integer weight, Integer height, Integer desiredWeight,
                                    Integer age, String sex, String objective) {
        double weightKg = weight / 2.20462;
        double heightCm = height * 100;

        double dailyCalsToChangeWeight1LbInWeek = 550;
        double currentDailyCalsMale = (88.362 + (13.397 * weightKg) + (4.799 * heightCm) - (5.677 * age)) * 1.2;
        double currentDailyCalsFemale = (447.593 + (9.247 * weightKg) + (3.098 * heightCm) - (4.33 * age)) * 1.2;

        double dailyProteinGrams;
        double dailyCarbsGrams;
        double dailyFatGrams;
        double newDailyCals;
        String tips = "";
        String details = "";

        double weeksToLose = weight - desiredWeight;
        double weeksToGain = desiredWeight - weight;


        if (objective == "slim") {
            if (sex == "male") {
                dailyProteinGrams = ((currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek) * 0.25) * 4;
                dailyCarbsGrams = ((currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek) * 0.6) * 4;
                dailyFatGrams = ((currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek) * 0.15) * 9;
                newDailyCals = currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek;
            } else {
                dailyProteinGrams = ((currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek) * 0.25) * 4;
                dailyCarbsGrams = ((currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek) * 0.6) * 4;
                dailyFatGrams = ((currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek) * 0.15) * 9;
                newDailyCals = currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek;
            }

        } else {
            if (sex == "male") {
                dailyProteinGrams = ((currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek) * 0.25) * 4;
                dailyCarbsGrams = ((currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek) * 0.6) * 4;
                dailyFatGrams = ((currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek) * 0.15) * 9;
                newDailyCals = currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek;
            } else {
                dailyProteinGrams = ((currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek) * 0.25) * 4;
                dailyCarbsGrams = ((currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek) * 0.6) * 4;
                dailyFatGrams = ((currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek) * 0.15) * 9;
                newDailyCals = currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek;
            }
        }
        String dailyProteinStr = dailyProteinGrams + "g";
        String dailyCarbsStr = dailyCarbsGrams + "g";
        String dailyFatStr = dailyFatGrams + "g";
        String newDailyCalsStr = newDailyCals + " cals";

        String[] macrosInfo = {dailyProteinStr, dailyCarbsStr, dailyFatStr, newDailyCalsStr, tips, details};
        return macrosInfo;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolFragment newInstance(String param1, String param2) {
        ToolFragment fragment = new ToolFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tool, container, false);

        Button emailPlanButt = view.findViewById(R.id.emailPlanButton);
        emailPlanButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddress = {""};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                intent.putExtra(Intent.EXTRA_TEXT, " ");
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button smsPlanButt = view.findViewById(R.id.smsPlanButton);
        smsPlanButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"));
                intent.putExtra("sms_body", " ");
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button planSocialButt = view.findViewById(R.id.planSocialButton);
        planSocialButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReserveIntents.ACTION_RESERVE_TAXI_RESERVATION);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}