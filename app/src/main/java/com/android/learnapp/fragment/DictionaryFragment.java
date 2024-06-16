package com.android.learnapp.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learnapp.R;
import com.android.learnapp.adapter.WordAdapter;
import com.android.learnapp.database.DataBase;
import com.android.learnapp.lang.Language;

import java.util.Locale;

public class DictionaryFragment extends Fragment {
   private Spinner spinnerLanguage;
   private Spinner tableSpinner;
   private SearchView searchView;
   private RecyclerView recyclerView;
    private Language language;
    private WordAdapter wordAdapter;
    private DataBase dbHelper;
    private SQLiteDatabase db;
    private TextToSpeech tts;
    private Locale selectedLanguage = Locale.GERMAN;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);
        spinnerLanguage = view.findViewById(R.id.languageSpinnerDin);
        tableSpinner = view.findViewById(R.id.spinner);
        searchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.recyclerView);


        return view;
    }
    private void setDrawableRightClickListener(EditText editText, Spinner spinner, boolean isWordEditText) {
        Drawable drawable = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_more_vert);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            editText.setCompoundDrawables(null, null, drawable, null);
        }

        editText.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP && event.getRawX() >= (editText.getRight() - drawable.getBounds().width())) {
                if (isWordEditText) {
                    language.showWordLanguageMenu(v, spinner, editText);
                } else {
                    language.showTranslationLanguageMenu(v, spinner, editText);
                }
                return true;
            }
            return false;
        });
    }

}
