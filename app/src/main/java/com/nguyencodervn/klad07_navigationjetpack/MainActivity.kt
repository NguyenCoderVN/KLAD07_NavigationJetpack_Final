package com.nguyencodervn.klad07_navigationjetpack

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var badgeWelcome: BadgeDrawable
    private lateinit var badgeHelp: BadgeDrawable

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        window.decorView.windowInsetsController!!.hide(
//            android.view.WindowInsets.Type.statusBars()
//        )

        toolbar = findViewById(R.id.toolbar)
        bottomNavView = findViewById(R.id.bottom_nav)
        navView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupWithNavController(bottomNavView, navController)

        badgeWelcome = bottomNavView.getOrCreateBadge(R.id.welcomeFragment)
        badgeHelp = bottomNavView.getOrCreateBadge(R.id.helpFragment)
        badgeHelp.isVisible = false

        bottomNavView.setOnItemSelectedListener {
            checkBadge(it)
            findNavController(R.id.fragmentContainerView).navigate(it.itemId)
            false
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            checkBadge(menuItem)
            findNavController(R.id.fragmentContainerView).navigate(menuItem.itemId)
            drawerLayout.close()
            true
        }

    }

    private fun checkBadge(menuItem: MenuItem) {
        badgeWelcome.isVisible = false
        badgeHelp.isVisible = false
        when (menuItem.itemId) {
            R.id.welcomeFragment -> {
                badgeWelcome.isVisible = true
            }
            R.id.helpFragment -> {
                badgeHelp.isVisible = true
            }
            else -> {}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}