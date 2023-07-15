package com.example.al_falakmain.common

import androidx.navigation.NavHostController
import com.example.al_falakmain.routes.Routes

fun navigateToScreens(navHostController: NavHostController, value:String){
    when(value.lowercase()){
        "Loan request".lowercase() ->{
            navHostController.navigate(Routes.LoanRequestScreen.route)
        }
        "Cash type".lowercase()->{
            navHostController.navigate(Routes.DashboardComposeTypeScreen.route)
        }
        "cash payment".lowercase()->{
            navHostController.navigate(Routes.CashPaymentScreen.route)
        }
        "cash receipt".lowercase()->{
            navHostController.navigate(Routes.CashReceiptScreen.route)
        }
        "bank payment".lowercase()->{
            navHostController.navigate(Routes.BankPaymentScreen.route)
        }
        "bank receipt".lowercase()->{
            navHostController.navigate(Routes.BankReceiptScreen.route)
        }
        "Recovery".lowercase()->{
            navHostController.navigate(Routes.RecoveryScreen.route)
        }
        "Ledger".lowercase()->{
            navHostController.navigate(Routes.StatementScreen.route)
        }
        "Roles".lowercase()->{
            navHostController.navigate(Routes.RoleManagementScreen.route)
        }
        "Lube report".lowercase()->{
            navHostController.navigate(Routes.LubeReportScreen.route)
        }
        else->{}
    }
}