package lesson31

//1. a
//2. c
//3. d
//4. kotlin - это сын java

import de.fabmax.kool.KoolApplication
import de.fabmax.kool.addScene
import de.fabmax.kool.pipeline.ClearColorLoad
import de.fabmax.kool.modules.ui2.*
import de.fabmax.kool.util.Color

fun main() = KoolApplication {
    val game = GameState()

    addScene {
        setupUiScene(ClearColorLoad)

        addPanelSurface {
            modifier
                .size(300.dp, 150.dp)
                .align(AlignmentX.Start, AlignmentY.Top)
                .padding(16.dp)
                .background(RoundRectBackground(Color(0.1f, 0.1f, 0.2f, 0.6f), 12.dp))

            Column {
                Text("Здоровье: ${game.hp.use()}%") {
                    modifier.margin(bottom = 8.dp)
                }
                Box(){
                    modifier
                        .width(200.dp)
                        .height(20.dp)
                        .background(RoundRectBackground(Color(0.2f, 0.2f, 0.2f, 1f), 10.dp))
                    Box(){
                        modifier
                            .width((game.hp.use() * 2).dp)
                            .height(20.dp)
                            .background(RoundRectBackground(Color(0f, 0.8f, 0.2f, 1f), 10.dp))
                    }
                }
                Row {
                    modifier.padding(top = 12.dp)
                    Button("-10") {
                        modifier
                            .padding(8.dp)
                            .margin(8.dp)
                            .onClick {
                                game.hp.value = (game.hp.value - 10).coerceIn(0, 100)
                            }
                    }
                    Button("+10") {
                        modifier
                            .padding(8.dp)
                            .margin(8.dp)
                            .onClick {
                            game.hp.value = (game.hp.value + 10).coerceIn(0, 100)
                        }
                    }
                }
            }
        }
    }
}

class GameState {
    val hp = mutableStateOf(100)
}