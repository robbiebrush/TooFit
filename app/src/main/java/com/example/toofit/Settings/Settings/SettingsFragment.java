package com.example.toofit.Settings.Settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.toofit.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}