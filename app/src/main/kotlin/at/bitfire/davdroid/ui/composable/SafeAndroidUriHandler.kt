/*
 * Copyright © All Contributors. See LICENSE and AUTHORS in the root directory for details.
 */

package at.bitfire.davdroid.ui.composable

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.AndroidUriHandler
import androidx.compose.ui.platform.UriHandler
import at.bitfire.davdroid.R
import java.util.logging.Level
import java.util.logging.Logger

class SafeAndroidUriHandler(
    val context: Context
): UriHandler {

    override fun openUri(uri: String) {
        try {
            AndroidUriHandler(context).openUri(uri)
        } catch (e: Exception) {
            Logger.getGlobal().log(Level.WARNING, "No browser available", e)
            // no browser available
            Toast.makeText(context, R.string.install_browser, Toast.LENGTH_LONG).show()
        }
    }

}