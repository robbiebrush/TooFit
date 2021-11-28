package com.example.toofit;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.actions.ReserveIntents;
import com.google.android.material.snackbar.Snackbar;

import javax.xml.namespace.QName;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private EditText weightEdit;
    private EditText heightEdit;
    private EditText ageEdit;
    private RadioGroup sexRadio;
    private EditText desiredWeightEdit;
    private RadioGroup objectiveRadio;

    private TextView intro;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        SharedPreferences sp = getContext().getSharedPreferences("name", Context.MODE_PRIVATE);
        String userName = sp.getString("name", "");
        intro = view.findViewById(R.id.introGreet);
        intro.setText("Hello" + userName + ", Welcome to TooFit");

        weightEdit = view.findViewById(R.id.weightInput);
        heightEdit = view.findViewById(R.id.heightInput);
        ageEdit = view.findViewById(R.id.ageInput);
        sexRadio = view.findViewById(R.id.sexInput);
        desiredWeightEdit = view.findViewById(R.id.desiredWeightInput);
        objectiveRadio = view.findViewById(R.id.objectiveInput);

        Button webButt = view.findViewById(R.id.webButton);
        webButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://food-guide.canada.ca/en/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button mapButt = view.findViewById(R.id.mapButton);
        mapButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=gym+fitness");
                Intent intent = new Intent(Intent.ACTION_VIEW, location);
                intent.setPackage("com.google.android.apps.maps");
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button cabButt = view.findViewById(R.id.cabButton);
        cabButt.setOnClickListener(new View.OnClickListener() {
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
        Button phoneHotlineButt = view.findViewById(R.id.phoneHotlineButton);
        phoneHotlineButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:1-800-668-6868");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button smsHotlineButt = view.findViewById(R.id.smsHotlineButton);
        smsHotlineButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:686868"));
                intent.putExtra("sms_body", "CONNECT");
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button contactUsButt = view.findViewById(R.id.contactUsButton);
        contactUsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddress = {"W0741993@myscc.ca"};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, I am contacting you regarding ");
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button planButt = view.findViewById(R.id.planButton);
        planButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weightEdit.getText().toString();
                int weight = Integer.parseInt(weightStr);

                String heightStr = heightEdit.getText().toString();
                int height = Integer.parseInt(heightStr);

                String ageStr = ageEdit.getText().toString();
                int age = Integer.parseInt(ageStr);

                String desiredWeightStr = desiredWeightEdit.getText().toString();
                int desiredWeight = Integer.parseInt(desiredWeightStr);

                int checkedSexId = sexRadio.getCheckedRadioButtonId();
                String sex = null;

                int checkedObjectiveId = objectiveRadio.getCheckedRadioButtonId();
                String objective = null;
                switch (checkedSexId) {
                    case R.id.maleRadio:
                        sex = "male";
                        break;
                    case R.id.femaleRadio:
                        sex = "female";
                        break;
                }
                switch (checkedObjectiveId) {
                    case R.id.slimRadio:
                        objective = "slim";
                        break;
                    case R.id.gainRadio:
                        objective = "gain";
                        break;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("WEIGHT", weight);
                bundle.putInt("HEIGHT", height);
                bundle.putInt("AGE", age);
                bundle.putInt("DESIREDWEIGHT", desiredWeight);
                bundle.putString("SEX", sex);
                bundle.putString("OBJECTIVE", objective);
                Navigation.findNavController(v)
                        .navigate(R.id.action_main_to_plan, bundle);
            }
        });
        return view;
    }
}