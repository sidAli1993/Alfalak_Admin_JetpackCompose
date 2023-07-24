package com.example.al_falakmain.ui.routes

sealed class Routes(val route: String) {
    object Login : Routes("Login")

    object SignUp: Routes("Sign up")

    object ForgotPassword : Routes("Forgot Password")

    object SplashScreen: Routes("Splash_screen")

    object DashboardScreen : Routes("Dashboard_screen")

    object LoanRequestScreen: Routes("loan_request")

    object SummaryScreen: Routes("summary_screen")

    object CashPaymentScreen: Routes("cash_payment")

    object CashReceiptScreen: Routes("cash_receipt")

    object BankPaymentScreen: Routes("bank_payment")

    object BankReceiptScreen: Routes("bank_receipt")

    object DashboardComposeTypeScreen: Routes("dashboard_type")

    object RecoveryScreen: Routes("recovery_screen")

    object StatementScreen: Routes("statement_screen")

    object RoleManagementScreen: Routes("roles")

    object CreateRolesScreen: Routes("create_roles")

    object LubeReportScreen: Routes("lube_report")
}
