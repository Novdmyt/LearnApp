package com.android.learnapp.adapter;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learnapp.R;
import com.android.learnapp.database.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private List<Word> words = new ArrayList<>();
    private List<Word> filteredWords = new ArrayList<>();
    private TextToSpeech tts;
    private Locale language;

    public WordAdapter(TextToSpeech tts, Locale language) {
        this.tts = tts;
        this.language = language;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = filteredWords.get(position);
        holder.wordTextView.setText(word.getWord());
        holder.translationTextView.setText(word.getTranslation());

        holder.itemView.setOnClickListener(v -> {
            if (tts != null) {
                tts.speak(word.getWord(), TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredWords.size();
    }

    public void setWords(List<Word> words) {
        this.words = words;
        this.filteredWords = new ArrayList<>(words);
        notifyDataSetChanged();
    }

    public void filter(String query) {
        filteredWords.clear();
        if (query.isEmpty()) {
            filteredWords.addAll(words);
        } else {
            query = query.toLowerCase();
            for (Word word : words) {
                if (word.getWord().toLowerCase().contains(query) || word.getTranslation().toLowerCase().contains(query)) {
                    filteredWords.add(word);
                }
            }
        }
        notifyDataSetChanged();
    }
}




