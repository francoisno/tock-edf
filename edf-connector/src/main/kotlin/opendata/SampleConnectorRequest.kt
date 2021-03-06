package opendata

import ai.tock.bot.engine.action.SendChoice
import ai.tock.bot.engine.action.SendSentence
import ai.tock.bot.engine.event.Event
import ai.tock.bot.engine.user.PlayerId
import ai.tock.bot.engine.user.PlayerType.bot
import ai.tock.shared.defaultLocale
import java.util.Locale

data class SampleConnectorRequest(val query: String? = null, val payload: String? = null, val userId: String, val locale: Locale = defaultLocale) {

    fun toEvent(applicationId: String): Event =
        if (query != null) {
            SendSentence(
                PlayerId(userId),
                applicationId,
                PlayerId(applicationId, bot),
                query
            )
        } else if (payload != null) {
            val (intent, parameters) = SendChoice.decodeChoiceId(payload)
            SendChoice(
                PlayerId(userId),
                applicationId,
                PlayerId(applicationId, bot),
                intent,
                parameters
            )
        } else {
            error("query & payload are both null")
        }

}