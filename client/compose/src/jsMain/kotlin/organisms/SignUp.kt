package organisms

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.*

@Composable
fun SignUp(signUp: (email: String, password: String) -> Unit, error: Throwable? = null) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isCorrectFormattedPassword by remember { mutableStateOf(false) }

    val regex =
        Regex("""^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9!"#$%&'()*+,\-./:;<=>?\[\\\]^_`{|}~]{8,}$""")
    isCorrectFormattedPassword = regex.matches(password)

    Div {
        H2 { Text("Sign Up") }

        error?.run {
            P { Text(message ?: "Unknown Error") }
        }

        Div {
            Text("E-Mail")
            Input(InputType.Email) {
                onInput {
                    email = it.value
                }
            }
        }

        Div {
            Text("Password")
            Input(InputType.Password) {
                onInput {
                    password = it.value
                }
            }
            if (!isCorrectFormattedPassword) {
                P { Text("Incorrect password") }
            }
        }

        Button(
            attrs = {
                onClick {
                    signUp(email, password)
                }
                if (!isCorrectFormattedPassword) disabled()
            },
        ) {
            Text("Sign Up")
        }
    }
}
