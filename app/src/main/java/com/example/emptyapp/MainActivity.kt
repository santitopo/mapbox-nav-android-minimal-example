package com.example.emptyapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import com.mapbox.navigation.dropin.NavigationView

class ReactNativeMapboxNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    init {
        val accessToken = resources.getString(R.string.mapbox_access_token)
        val navigationView = NavigationView(context = context, accessToken = accessToken)
        navigationView.api.routeReplayEnabled(true)
        val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        addView(navigationView, params)
    }

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ReactNativeMapboxNavigationView(this))
    }
}
