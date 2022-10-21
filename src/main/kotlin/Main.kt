fun main() {
    val secondsAgo = 59
    println("Был(а) в сети ${agoToText(secondsAgo)}")
}


fun agoToText(seconds: Int) = when (seconds) {
    in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "позавчера"
    in 24 * 60 * 60..24 * 60 * 60 * 2 -> "вчера"
    in 60 * 60..24 * 60 * 60 -> "${secondsToHours(seconds)} ${hoursToText(secondsToHours(seconds))} назад"
    in 60..60 * 60 -> "${secondsToMinutes(seconds)} ${minutesToText(secondsToMinutes(seconds))} назад"
    in 0..60 -> "только что"
    else -> "давно"
}

fun secondsToMinutes(seconds: Int): Int {
    return seconds / 60
}

fun secondsToHours(seconds: Int): Int {
    return seconds / 3600
}

fun minutesToText(minutes: Int) = if (minutes < 21) {
    when (minutes) {
        1 -> "минуту"
        in 2..4 -> "минуты"
        else -> "минут"
    }
} else {
    when (minutes % 10) {
        0 -> "минут"
        1 -> "минуту"
        in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun hoursToText(hours: Int) = if (hours < 21) {
    when (hours) {
        1 -> "час"
        in 2..4 -> "часа"
        else -> "часов"
    }
} else {
    when (hours) {
        21 -> "час"
        else -> "часа"
    }
}

