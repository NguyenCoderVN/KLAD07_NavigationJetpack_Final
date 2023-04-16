package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.nguyencodervn.klad07_navigationjetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Truyền menu option khi không khai báo trong
//        com.google.android.material.appbar.MaterialToolbar
//        app:menu="@menu/menu_toolbar"
//        setSupportActionBar(binding.materialToolbar)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Không cho slide Drawer sau start
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
            if (nd.id == nc.graph.startDestinationId) {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        binding.apply {
            NavigationUI.setupWithNavController(materialToolbar, navController, drawerLayout)
            NavigationUI.setupWithNavController(navigationView, navController)
            NavigationUI.setupWithNavController(bottomNavigationView, navController)
            materialToolbar.setOnMenuItemClickListener {
                navController.navigate(it.itemId)
                true
            }

//          Lấy sự kiện từ bottomNavigationView
//            bottomNavigationView.setOnItemSelectedListener {menuItem ->
//                Toast.makeText(
//                    applicationContext,
//                    menuItem.itemId.toString(),
//                    Toast.LENGTH_SHORT
//                ).show()
//                navController.navigate(menuItem.itemId)
//                false
//            }

//          Lấy sự kiện từ navigationView
//            navigationView.setNavigationItemSelectedListener { menuItem ->
//                Toast.makeText(
//                    applicationContext,
//                    menuItem.itemId.toString(),
//                    Toast.LENGTH_SHORT
//                ).show()
//
//                navController.navigate(menuItem.itemId)
//                drawerLayout.close()
//                true
//            }
        }


    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_toolbar, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController)
//                || super.onOptionsItemSelected(item)
//    }
}