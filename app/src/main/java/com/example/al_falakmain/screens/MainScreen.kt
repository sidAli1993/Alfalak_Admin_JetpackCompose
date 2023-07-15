package com.example.alfalakandroidapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.routes.Routes
import com.example.al_falakmain.screens.BankPaymentScreen
import com.example.al_falakmain.screens.BankReceiptScreen
import com.example.al_falakmain.screens.CashPaymentScreen
import com.example.al_falakmain.screens.CashReceiptScreen
import com.example.al_falakmain.screens.CreateRoleScreen
import com.example.al_falakmain.screens.DashboardComposeType
import com.example.al_falakmain.screens.DashboardScreen
import com.example.al_falakmain.screens.ForgotPasswordPage
import com.example.al_falakmain.screens.LoanRequestScreen
import com.example.al_falakmain.screens.login.LoginPage
import com.example.al_falakmain.screens.LubeReportScreen
import com.example.al_falakmain.screens.RecoverScreen
import com.example.al_falakmain.screens.RoleManagementScreen
import com.example.al_falakmain.screens.SplashScreen
import com.example.al_falakmain.screens.StatementScreen
import com.example.al_falakmain.screens.SummaryScreen
import com.example.al_falakmain.screens.login.LoginFragment

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