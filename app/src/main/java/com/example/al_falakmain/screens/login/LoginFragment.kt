package com.example.al_falakmain.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import com.example.al_falakmain.R
import com.example.al_falakmain.screens.SplashScreen

class LoginFragment(private val navController: NavController) : Fragment() {

//    private var navController:NavController?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_login, container, false)



        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        navController=findNavController()
        val composeView = view.findViewById<ComposeView>(R.id.composeView)
//        composeView.setContent {
//            LoginPage(navController as NavHostController)
//        }
    }
}