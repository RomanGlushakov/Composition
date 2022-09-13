package com.example.composition.presentation

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResult


interface OnOptionClickListener{
   fun onOptionClick(option: Int)
}

@BindingAdapter ("requiredAnswers")
fun bindRequireAnswer(textView: TextView, count: Int) {
    textView.text = String.format(
            textView.context.getString(R.string.required_answers),
            count
        )
}

@BindingAdapter("requiredPercent")
fun bindRequiredPercent (textView: TextView, count: Int) {
    textView.text = String.format(
            textView.context.getString(R.string.need_percent_answers),
            count
        )
}

@BindingAdapter("rightAnswers")
fun bindRightAnswers(textView: TextView, count: Int) {
            textView.text = String.format(
            textView.context.getString(R.string.current_score),
            count
        )
}

@BindingAdapter("percentOfRightAnswers")
fun bindPercentOfRightAnswers (textView: TextView, gameResult: GameResult) {

    textView.text =
        String.format(textView.context.getString(
            R.string.percente_of_right_answers),
            getPercentOfRightAnswers(gameResult))
}

@BindingAdapter("imageOfTheResult")
fun bindImageOfTheResult (imageView: ImageView, winner: Boolean) {
    val drawable = if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad_smile
    }
    imageView.setImageResource(drawable)
}

private fun getPercentOfRightAnswers(gameResult: GameResult): Int  {

    return if (gameResult.countOfRightAnswers == 0)
        0
    else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()
    }


}

@BindingAdapter ("percentProgress")
fun bindPercentProgress(progressBar: ProgressBar, progress: Int) {
    progressBar.setProgress(progress, true)
}


@BindingAdapter("colorOfAnswer")
fun bindColorOfAnswer(textView: TextView, winner: Boolean) {
    val color = if (winner) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    textView.setTextColor(ContextCompat.getColor(textView.context, color))
}

@BindingAdapter("colorOfPercent")
fun bindColorOfPercent(progressBar: ProgressBar, winner: Boolean) {
    val color = if (winner) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    progressBar.progressTintList = ColorStateList.valueOf(
        ContextCompat.getColor(progressBar.context, color))
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener (textView: TextView, clickListener: OnOptionClickListener) {
        textView.setOnClickListener {
            clickListener.onOptionClick(textView.text.toString().toInt())
        }
}





