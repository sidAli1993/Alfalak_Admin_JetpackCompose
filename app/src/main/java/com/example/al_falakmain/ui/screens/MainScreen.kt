package com.example.al_falakmain.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.screens.login.LoginPage
import com.example.alfalakandroidapp.screens.SignUpPage

@Composable
fun MainPage() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Routes.Login.route) {
            LoginPage(navHostController = navController)
        }
        composable(Routes.SplashScreen.route){
            SplashScreen(navHostController = navController)
        }
        
        composable(Routes.SignUp.route){
            SignUpPage(navHostController = navController)
        }
        
        composable(Routes.ForgotPassword.route){
            ForgotPasswordPage(navHostController = navController)
        }
        composable(Routes.DashboardScreen.route){
            DashboardScreen(navHostController = navController)
        }

        composable(Routes.LoanRequestScreen.route){
            LoanRequestScreen(navController)
        }
        composable(Routes.SummaryScreen.route){
            SummaryScreen(navHostController = navController)
        }

        composable(Routes.CashPaymentScreen.route){
            CashPaymentScreen(navHostController = navController)
        }

        composable(Routes.CashReceiptScreen.route){
            CashReceiptScreen(navHostController = navController)
        }

        composable(Routes.BankPaymentScreen.route){
            BankPaymentScreen(navHostController = navController)
        }

        composable(Routes.BankReceiptScreen.route){
            BankReceiptScreen(navHostController = navController)
        }

        composable(Routes.DashboardComposeTypeScreen.route){
            DashboardComposeType(navHostController = navController)
        }

        composable(Routes.RecoveryScreen.route){
            RecoverScreen(navHostController = navController)
        }

        composable(Routes.StatementScreen.route){
            StatementScreen(navHostController = navController)
        }
        composable(Routes.RoleManagementScreen.route){
            RoleManagementScreen(navHostController = navController)
        }

        composable(Routes.CreateRolesScreen.route){
            CreateRoleScreen(navHostController = navController)
        }
        composable(Routes.LubeReportScreen.route){
            LubeReportScreen(navHostController = navController)
        }
    }
}