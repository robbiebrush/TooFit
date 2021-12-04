package com.example.toofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.actions.ReserveIntents;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolFragment extends Fragment {
    private TextView dailyProteinView;
    private TextView dailyCarbsView;
    private TextView dailyFatsView;
    private TextView dailyCalsView;
    private TextView planTipsView;
    private TextView planDetailsView;

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

    public String[] planCalculator(Integer userWeight, Integer userHeight, Integer userDesiredWeight,
                                    Integer userAge, String userSex, String userObjective) {
        int dailyCalsToChangeWeight1LbInWeek = 600;
        //Calculates daily calories used currently
        double currentDailyCalsMale = (88.362 + (13.397 * userWeight) + (4.799 * userHeight) - (5.677 * userAge)) * 1.25;
        double currentDailyCalsFemale = (447.593 + (9.247 * userWeight) + (3.098 * userHeight) - (4.33 * userAge)) * 1.25;

        double dailyProteinGrams;
        double dailyCarbsGrams;
        double dailyFatGrams;
        double newDailyCals;
        String tips;
        String details;
        //Calculates number of weeks to achieve weight difference at 1lb per week
        double weeksToLose = userWeight - userDesiredWeight;
        double weeksToGain = userDesiredWeight - userWeight;

        if (userObjective == "slim") {
            if (userSex == "male") {
                //Calculates daily needed calories to achieve goal at 1lb/week, then ratios specific weekly calories per macro,
                // converts to grams
                dailyProteinGrams = ((currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek) * 0.25) / 4;
                dailyCarbsGrams = ((currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek) * 0.6) / 4;
                dailyFatGrams = ((currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek) * 0.15) / 9;
                newDailyCals = currentDailyCalsMale - dailyCalsToChangeWeight1LbInWeek;
            } else {
                dailyProteinGrams = ((currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek) * 0.25) / 4;
                dailyCarbsGrams = ((currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek) * 0.6) / 4;
                dailyFatGrams = ((currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek) * 0.15) / 9;
                newDailyCals = currentDailyCalsFemale - dailyCalsToChangeWeight1LbInWeek;
            }
            tips = "-The best way to lose body fat is High Intensity Interval Training (HIIT). This includes sprinting, biking, combat arts, explosive/ demanding weight training, and others." +
                    "\n\n-Sticking to your macros and calories with three main meals a day and at least 60 minutes of HIIT will lead to the most progress." +
                    "\n\n-Always staying hydrated and giving targeted muscles rest to build proteins/remove waste will also lead to the most progress and prevent injury.";
            details = "-Should take " + weeksToLose + " weeks to achieve at 1lb lost per week." +
                    "\n\n-Prioritize carbs and protein with low fat to best achieve a low body fat/ toned definition." +
                    "\n\n-Based on experiencing an elevated heart rate for 0-30 minutes a day." +
                    "\n\n-All nutritional information is a generalized approximation of your otherwise individual bodies needs. Not exact." +
                    "\n\n-Please contact a doctor or our health hotlines with serious health inquiries or crises.";
        } else {
            if (userSex == "male") {
                dailyProteinGrams = ((currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek) * 0.3) / 4;
                dailyCarbsGrams = ((currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek) * 0.55) / 4;
                dailyFatGrams = ((currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek) * 0.15) / 9;
                newDailyCals = currentDailyCalsMale + dailyCalsToChangeWeight1LbInWeek;

            } else {
                dailyProteinGrams = ((currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek) * 0.3) / 4;
                dailyCarbsGrams = ((currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek) * 0.55) / 4;
                dailyFatGrams = ((currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek) * 0.15) / 9;
                newDailyCals = currentDailyCalsFemale + dailyCalsToChangeWeight1LbInWeek;
            }
            tips = "-The best way to gain muscle is through strength training, ideally with weight. Exhausting a muscle through repeating controlled contractions with break days is how to build mass most efficiently." +
                    "\n\n-The proper amount of weight for a workout is usually how much you are able to perform 10 contractions against 3 times, with 2 minute breaks between." +
                    "\n\n-Sticking to your macros and calories with three main meals a day and at least 60 minutes of strength training will lead to the most progress." +
                    "\n\n-Always staying hydrated and giving targeted muscles rest to build proteins/remove waste will also lead to the most progress and prevent injury.";
            details = "-Should take " + weeksToGain + " weeks to achieve at 1lb gained per week." +
                    "\n\n-Prioritize caloric intake relative to desired muscle mass for increased results. Keep your macros and diet balanced." +
                    "\n\n-Based on experiencing an elevated heart rate for 0-30 minutes a day." +
                    "\n\n-All nutritional information is a generalized approximation of your otherwise individual bodies needs. Not exact." +
                    "\n\n-Please contact a doctor or our health hotlines with serious health inquiries or crises.";
        }
        //Formats output
        String dailyProteinStr = String.format("%.1f",dailyProteinGrams) + "g";
        String dailyCarbsStr = String.format("%.1f",dailyCarbsGrams) + "g";
        String dailyFatStr = String.format("%.1f",dailyFatGrams) + "g";
        String newDailyCalsStr = Math.round(newDailyCals) + " cals";

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

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        String userEmail = sp.getString("email", "");
        String userNumber = sp.getString("number", "");

        Bundle extras = getArguments();
        Integer weight = extras.getInt("WEIGHT");
        Integer height = extras.getInt("HEIGHT");
        Integer desiredWeight = extras.getInt("DESIREDWEIGHT");
        Integer age = extras.getInt("AGE");
        String sex = extras.getString("SEX");
        String objective = extras.getString("OBJECTIVE");
        String[] planInfo = planCalculator(weight, height, desiredWeight, age, sex, objective);

        dailyProteinView = view.findViewById(R.id.proteinMacroView);
        dailyProteinView.setText(planInfo[0]);

        dailyCarbsView = view.findViewById(R.id.carbsMacroView);
        dailyCarbsView.setText(planInfo[1]);

        dailyFatsView = view.findViewById(R.id.fatMacroView);
        dailyFatsView.setText(planInfo[2]);

        dailyCalsView = view.findViewById(R.id.calsPerDayView);
        dailyCalsView.setText(planInfo[3]);

        planTipsView = view.findViewById(R.id.tipsView);
        planTipsView.setText(planInfo[4]);

        planDetailsView = view.findViewById(R.id.detailsView);
        planDetailsView.setText(planInfo[5]);

        Button emailPlanButt = view.findViewById(R.id.emailPlanButton);
        emailPlanButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + userEmail));
                intent.putExtra(Intent.EXTRA_TEXT, "Protein: " + planInfo[0] + "\nCarbs: " + planInfo[1] + "\nFat: " + planInfo[2] + "\nDaily Calories: " + planInfo[3]);
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
                intent.setData(Uri.parse("smsto:" + userNumber));
                intent.putExtra("sms_body", "Protein: " + planInfo[0] + "\nCarbs: " + planInfo[1] + "\nFat: " + planInfo[2] + "\nDaily Calories: " + planInfo[3]);
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