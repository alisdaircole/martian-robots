enum class Orientation(val xForwardMove: Int, val yForwardMove: Int) {
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    fun left() = if (this == N) W else values()[ordinal - 1]
    fun right() = if (this == W) N else values()[ordinal + 1]
}
