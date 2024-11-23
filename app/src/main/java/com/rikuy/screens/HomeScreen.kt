package com.rikuy.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rikuy.ui.theme.RikuyTheme

@Composable
fun HomeScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        CustomButtonNavigation()
    }
}

@Composable
fun CustomButtonNavigation() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 40.dp)
    ) {
        // Lista de pantallas a las que se puede navegar
        val screens = listOf(Screen.Search, Screen.Add, Screen.Location, Screen.Profile)

        // Lista de íconos correspondientes a cada pantalla
        val icons = listOf(Icons.Filled.Search, Icons.Filled.AddCircle, Icons.Filled.LocationOn, Icons.Filled.Person)

        // Crear un botón para cada pantalla con el ícono correspondiente
        icons.forEachIndexed { index, image ->
            IconButton(
                onClick = {
                    // Navegar a la pantalla seleccionada usando su ruta
                    navController.navigate(screens[index].route) {
                        // Evitar volver a la misma pantalla si ya estamos en ella
                        launchSingleTop = true
                    }
                }
            ) {
                Icon(
                    imageVector = image,
                    contentDescription = null, // Descripción del ícono (puedes agregar texto si es necesario para accesibilidad)
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp) // Tamaño del ícono
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    RikuyTheme {
        HomeScreen()
    }
}
