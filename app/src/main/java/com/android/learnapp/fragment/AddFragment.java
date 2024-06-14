package com.android.learnapp.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;

import com.android.learnapp.R;
import com.android.learnapp.lang.Language;

public class AddFragment extends Fragment {
    private EditText wordEditText;
    private EditText translateEditText;
    private Spinner wordLanguageSpinner;
    private Spinner translateLanguageSpinner;
    private Language language;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        wordEditText = view.findViewById(R.id.wordEditText);
        translateEditText = view.findViewById(R.id.translateEditText);
        wordLanguageSpinner = view.findViewById(R.id.wordLanguageSpinner);
        translateLanguageSpinner = view.findViewById(R.id.translateLanguageSpinner);

        language = new Language(getContext()); // Pass context to Language

        setDrawableRightClickListener(wordEditText, wordLanguageSpinner, true);
        setDrawableRightClickListener(translateEditText, translateLanguageSpinner, false);

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
                    language.showWordLanguageMenu(v, spinner);
                } else {
                    language.showTranslationLanguageMenu(v, spinner);
                }
                return true;
            }
            return false;
        });
    }
}
