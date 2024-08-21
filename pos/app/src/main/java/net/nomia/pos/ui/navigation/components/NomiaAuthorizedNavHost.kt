package net.nomia.pos.ui.navigation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.nomia.pos.ui.ManagerScreenDestination
import net.nomia.pos.ui.argumentList
import net.nomia.pos.ui.route

@Composable
internal fun NomiaAuthorizedNavHost(
    navHostController: NavHostController = rememberNavController(),
) {
    fun ManagerScreen() {
        // Ваш UI-код здесь
        Text(text = "Welcome to the Manager Screen")
    }
    NavHost(
        navController = navHostController,
        startDestination = ManagerScreenDestination.route
    ) {
        composable(
            route = ManagerScreenDestination.route,
            arguments = ManagerScreenDestination.argumentList
        ) {
            ManagerScreen()


            /**
             * YOUR CODE GOES HERE
             */
        }
    }
}
