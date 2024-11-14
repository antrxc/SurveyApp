package com.example.surveyapplication.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),  // Increased corner radius for small elements
    medium = RoundedCornerShape(16.dp), // Larger corners for medium elements
    large = RoundedCornerShape(24.dp), // More pronounced rounded corners for large elements
)
