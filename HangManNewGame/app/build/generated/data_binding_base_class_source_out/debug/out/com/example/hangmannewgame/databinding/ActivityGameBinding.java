// Generated by view binder compiler. Do not edit!
package com.example.hangmannewgame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hangmannewgame.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGameBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView hangmanDrawing;

  @NonNull
  public final ImageButton imageButton;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final TextView letterUsed;

  @NonNull
  public final TextView pauseButton;

  @NonNull
  public final AppCompatButton playButton2;

  @NonNull
  public final EditText playerGuess1;

  @NonNull
  public final TextView scoreText;

  @NonNull
  public final TextView timer;

  @NonNull
  public final TextView toBeGuessed;

  @NonNull
  public final ImageButton tryButton;

  private ActivityGameBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView hangmanDrawing,
      @NonNull ImageButton imageButton, @NonNull ImageView imageView5,
      @NonNull ImageView imageView6, @NonNull TextView letterUsed, @NonNull TextView pauseButton,
      @NonNull AppCompatButton playButton2, @NonNull EditText playerGuess1,
      @NonNull TextView scoreText, @NonNull TextView timer, @NonNull TextView toBeGuessed,
      @NonNull ImageButton tryButton) {
    this.rootView = rootView;
    this.hangmanDrawing = hangmanDrawing;
    this.imageButton = imageButton;
    this.imageView5 = imageView5;
    this.imageView6 = imageView6;
    this.letterUsed = letterUsed;
    this.pauseButton = pauseButton;
    this.playButton2 = playButton2;
    this.playerGuess1 = playerGuess1;
    this.scoreText = scoreText;
    this.timer = timer;
    this.toBeGuessed = toBeGuessed;
    this.tryButton = tryButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGameBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_game, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGameBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.hangmanDrawing;
      ImageView hangmanDrawing = ViewBindings.findChildViewById(rootView, id);
      if (hangmanDrawing == null) {
        break missingId;
      }

      id = R.id.imageButton;
      ImageButton imageButton = ViewBindings.findChildViewById(rootView, id);
      if (imageButton == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.imageView6;
      ImageView imageView6 = ViewBindings.findChildViewById(rootView, id);
      if (imageView6 == null) {
        break missingId;
      }

      id = R.id.letterUsed;
      TextView letterUsed = ViewBindings.findChildViewById(rootView, id);
      if (letterUsed == null) {
        break missingId;
      }

      id = R.id.pauseButton;
      TextView pauseButton = ViewBindings.findChildViewById(rootView, id);
      if (pauseButton == null) {
        break missingId;
      }

      id = R.id.playButton2;
      AppCompatButton playButton2 = ViewBindings.findChildViewById(rootView, id);
      if (playButton2 == null) {
        break missingId;
      }

      id = R.id.playerGuess1;
      EditText playerGuess1 = ViewBindings.findChildViewById(rootView, id);
      if (playerGuess1 == null) {
        break missingId;
      }

      id = R.id.scoreText;
      TextView scoreText = ViewBindings.findChildViewById(rootView, id);
      if (scoreText == null) {
        break missingId;
      }

      id = R.id.timer;
      TextView timer = ViewBindings.findChildViewById(rootView, id);
      if (timer == null) {
        break missingId;
      }

      id = R.id.toBeGuessed;
      TextView toBeGuessed = ViewBindings.findChildViewById(rootView, id);
      if (toBeGuessed == null) {
        break missingId;
      }

      id = R.id.tryButton;
      ImageButton tryButton = ViewBindings.findChildViewById(rootView, id);
      if (tryButton == null) {
        break missingId;
      }

      return new ActivityGameBinding((ConstraintLayout) rootView, hangmanDrawing, imageButton,
          imageView5, imageView6, letterUsed, pauseButton, playButton2, playerGuess1, scoreText,
          timer, toBeGuessed, tryButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}