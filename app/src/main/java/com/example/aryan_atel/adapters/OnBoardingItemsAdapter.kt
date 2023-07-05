package com.example.aryan_atel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aryan_atel.models.OnBoardingItems
import com.example.aryan_atel.R

public class OnBoardingItemsAdapter(private val onBoardingItems: List<OnBoardingItems>) :
    RecyclerView.Adapter<OnBoardingItemsAdapter.OnboardingItemViewHolder>() {

    inner class OnboardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageOnBoarding = view.findViewById<ImageView>(R.id.imageOnBoarding)
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private val mainLayout = view.findViewById<RelativeLayout>(R.id.mainLayout)


        fun bind(onBoardingItems: OnBoardingItems) {
            imageOnBoarding.setImageResource(onBoardingItems.onBoardingImage)
            textTitle.text = onBoardingItems.onBoardingTitle
            textDescription.text = onBoardingItems.onBoardingDescription
            mainLayout.setBackgroundResource(onBoardingItems.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.onboarding_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItems[position])
    }
}