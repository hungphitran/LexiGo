package com.ptithcm.lexigo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.api.models.VocabLesson;

import java.util.List;

public class VocabLessonAdapter extends RecyclerView.Adapter<VocabLessonAdapter.ViewHolder> {
    
    private Context context;
    private List<VocabLesson> lessons;
    
    public VocabLessonAdapter(Context context, List<VocabLesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vocab_lesson, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VocabLesson lesson = lessons.get(position);
        
        holder.tvWord.setText(lesson.getWord());
        holder.tvPronunciation.setText(lesson.getPronunciation());
        holder.tvMeaning.setText(lesson.getMeaning());
        holder.tvExample.setText(lesson.getExample());
        
        // TODO: Load image with Glide or Picasso
        // if (lesson.getImageUrl() != null) {
        //     Glide.with(context).load(lesson.getImageUrl()).into(holder.ivImage);
        // }
        
        // TODO: Add audio playback functionality
        holder.ivAudio.setOnClickListener(v -> {
            // Play audio from lesson.getAudioUrl()
        });
    }
    
    @Override
    public int getItemCount() {
        return lessons.size();
    }
    
    public void updateLessons(List<VocabLesson> newLessons) {
        this.lessons = newLessons;
        notifyDataSetChanged();
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage, ivAudio;
        TextView tvWord, tvPronunciation, tvMeaning, tvExample;
        
        ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_word_image);
            ivAudio = itemView.findViewById(R.id.iv_audio);
            tvWord = itemView.findViewById(R.id.tv_word);
            tvPronunciation = itemView.findViewById(R.id.tv_pronunciation);
            tvMeaning = itemView.findViewById(R.id.tv_meaning);
            tvExample = itemView.findViewById(R.id.tv_example);
        }
    }
}
