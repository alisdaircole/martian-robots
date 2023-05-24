class ParseInput(private val fileName: String) {
    var gridX: Int? = null
    var gridY: Int? = null
    val robots: MutableList<Robot> = mutableListOf()

    init {
        readFile()
    }

    private fun readFile() {
        val readLines = this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.readLines()
        val firstLineSplit: List<String>? = readLines?.get(0)?.split(" ")

        try {
            gridX = firstLineSplit?.get(0)?.toInt()
            gridY = firstLineSplit?.get(1)?.toInt()
        } catch (e: Exception) {
            throw Exception("Invalid input on line 1")
        }

        if (!readLines.isNullOrEmpty()) {
            var x: Int? = null
            var y: Int? = null
            var orientation: Orientation? = null

            var counter = 1

            for (i in 1..readLines.size) {
                when (counter) {
                    1 -> {
                        val currentLineSplit: List<String> = readLines[i].split(" ")
                        try {
                            x = currentLineSplit[0].toInt()
                            y = currentLineSplit[1].toInt()
                            orientation = Orientation.valueOf(currentLineSplit[2])
                        } catch (e: Exception) {
                            throw Exception("Invalid input on line $i")
                        }
                    }

                    2 -> {
                        val currentLine: String = readLines[i]
                        val instructions = parseInstructions(currentLine, i)

                        x?.let {
                            y?.let {
                                orientation?.let {
                                    val robot = Robot(Coordinates(x, y), orientation, instructions)
                                    robots.add(robot)
                                }
                            }
                        }
                    }
                    3 -> counter = 0
                }
                counter += 1
            }
        }
    }

    private fun parseInstructions(instructions: String, lineNumber: Int): List<Instruction> =
        instructions.map {
            try {
                Instruction.valueOf(it.toString())
            } catch (e: IllegalArgumentException) {
                throw Exception("Invalid instruction '$it' on line ${lineNumber + 1}")
            }
        }
}
