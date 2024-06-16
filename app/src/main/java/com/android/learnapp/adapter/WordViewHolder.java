package com.android.learnapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learnapp.R;

public class WordViewHolder extends RecyclerView.ViewHolder {
    TextView wordTextView;
    TextView translationTextView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordTextView = itemView.findViewById(R.id.textView4);
        translationTextView = itemView.findViewById(R.id.translationTextView);
    }
}
