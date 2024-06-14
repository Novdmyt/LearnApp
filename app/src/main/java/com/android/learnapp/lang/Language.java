package com.android.learnapp.lang;

import android.content.Context;
import android.view.MenuInflater;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Spinner;

import com.android.learnapp.R;

public class Language {
    private final Context context;

    public Language(Context context) {
        this.context = context;
    }

    public void showWordLanguageMenu(View v, Spinner spinner) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.language_word, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.language_english) {
                spinner.setSelection(0); // Assuming 0 is the position for English in the spinner
            } else if (itemId == R.id.language_german) {
                spinner.setSelection(1); // Assuming 1 is the position for German in the spinner
            }
            return false;
        });
        popupMenu.show();
    }

    public void showTranslationLanguageMenu(View v, Spinner spinner) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.language_translation, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.language_ukrainian) {
                spinner.setSelection(0); // Assuming 0 is the position for Ukrainian in the spinner
            } else if (itemId == R.id.language_russian) {
                spinner.setSelection(1); // Assuming 1 is the position for Russian in the spinner
            }
            return false;
        });
        popupMenu.show();
    }
}
