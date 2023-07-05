package com.example.aryan_atel

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.aryan_atel.models.OnBoardingItems
import com.example.aryan_atel.adapters.OnBoardingItemsAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var OnBoardingItemsAdapter: OnBoardingItemsAdapter
    private lateinit var indicatorContainer: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnBoardingItems()
        setupIndicators()
        setCurrentIndicator(0)


    }

    private fun setOnBoardingItems() {
        OnBoardingItemsAdapter = OnBoardingItemsAdapter(

            listOf(

                OnBoardingItems(
                    onBoardingImage = R.drawable.about,
                    onBoardingTitle = "About Us",
                    onBoardingDescription = "Thank you for your interest in our internship opening. As a next step, we are expecting you to complete a short assignment",
                    color = R.color.pink


                ), OnBoardingItems(
                    onBoardingImage = R.drawable.goal,
                    onBoardingTitle = "Our Mission",
                    onBoardingDescription = "Thank you for your interest in our internship opening. As a next step, we are expecting you to complete a short assignment",
                    color = R.color.blue


                ), OnBoardingItems(
                    onBoardingImage = R.drawable.vision,
                    onBoardingTitle = "Our Vision",
                    onBoardingDescription = "Thank you for your interest in our internship opening. As a next step, we are expecting you to complete a short assignment",
                    color = R.color.orange

                )

            )
        )
        val onBoardingViewPager = findViewById<ViewPager2>(R.id.onBoardingViewPager)
        onBoardingViewPager.adapter = OnBoardingItemsAdapter

        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }


        })
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        findViewById<TextView>(R.id.btnSkip).setOnClickListener {
            navigateToUserChoiceActivity()
        }


    }

    private fun navigateToUserChoiceActivity() {

        startActivity(Intent(applicationContext, UserChoiceActivity::class.java))
        finish()
    }


    private fun setupIndicators() {
        indicatorContainer = findViewById(R.id.indicatorContainer)
        val indicators = arrayOfNulls<ImageView>(OnBoardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive
                    )
                )
                it.layoutParams = layoutParams
                indicatorContainer.addView(it)
            }

        }

    }

    private fun setCurrentIndicator(position: Int) {
        val window: Window = this@MainActivity.window
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_active

                    )
                )
                if (position == 0) {
                    window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.pink)

                } else if (position == 1) {
                    window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.blue)

                } else {
                    window.statusBarColor =
                        ContextCompat.getColor(this@MainActivity, R.color.orange)

                    val readyButton = findViewById<Button>(R.id.btnReady)
                    readyButton.text = "Ready "

                    readyButton.setOnClickListener {
                        navigateToUserChoiceActivity()
                    }


                }


            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive

                    )
                )

            }

        }
    }


}