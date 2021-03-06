/*
 * Copyright (C) 2020 e-voyageurs technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package allocovid.allomedia

import ai.tock.bot.definition.bot
import ai.tock.bot.registerAndInstallBot

val alloCovidBot = bot(
    "allocovid",
    stories = listOf(detectCoronavirus),
    unknownStory = detectCoronavirus
)

fun main() {
    initProperties()
    //register the bot
    registerAndInstallBot(alloCovidBot)
}

private fun initProperties() {
    //default is fr
    System.setProperty("tock_default_locale", "fr")
}