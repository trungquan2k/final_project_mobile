package com.example.jetsellbook.components


import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.RatingBar
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.viewinterop.AndroidView
import coil.load

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue
import com.example.jetsellbook.R
import com.example.jetsellbook.model.places
import com.flaviofaria.kenburnsview.KenBurnsView

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ScrollEffectPager() {
    val pagerState = rememberPagerState(
        pageCount = places.size,
        // We increase the offscreen limit, to allow pre-loading of images
        initialOffscreenLimit = 2,
    )
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(3000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }
    Column {
        HorizontalPager(
            state = pagerState,
        ) { pageIndex ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(pageIndex).absoluteValue
                        // We animate the scaleX + scaleY, between 85% and 100%
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .height(150.dp)
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                    ),
                shape = RoundedCornerShape(24.dp),
            ) {
                val place = places[pageIndex]
                Box {
                    val customView = KenBurnsView(LocalContext.current).also { imageView ->
                        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                        imageView.load(place.url)
                    }
                    AndroidView(
                        factory = { customView },
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(Color(android.graphics.Color.parseColor("#80000000")))
                    ) {}
                    Column(
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = place.title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        val ratingBar = RatingBar(
                            LocalContext.current, null, R.attr.ratingBarStyleSmall
                        ).apply {
                            rating = place.rating
                            progressDrawable.setColorFilter(
                                android.graphics.Color.parseColor("#ff8800"),
                                PorterDuff.Mode.SRC_ATOP
                            )
                        }
                        AndroidView(
                            factory = { ratingBar },
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = place.description,
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
private fun lerp(start: Float, stop: Float, fraction: Float): Float =(1 - fraction) * start + fraction * stop

@Preview
@Composable
fun ScrollEffectPagerPreview() {
    Surface(color = MaterialTheme.colors.background) {
        ScrollEffectPager()
    }
}