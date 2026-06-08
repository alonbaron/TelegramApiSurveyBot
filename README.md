# Telegram API Survey Bot

Java desktop application with a Telegram bot integration for creating community surveys, collecting votes through inline Telegram buttons, and viewing results in a Swing UI.

## Tech Stack

- Java 23
- Maven
- TelegramBots Java API
- Swing with FlatLaf

## Required Configuration

The bot reads runtime configuration from environment variables. Do not commit real tokens or chat IDs.

| Variable | Purpose |
|---|---|
| `TELEGRAM_BOT_TOKEN` | Bot token from BotFather |
| `TELEGRAM_BOT_USERNAME` | Telegram bot username |
| `ADMIN_TELEGRAM_ID` | Telegram user ID for the survey creator/admin |
| `DEV_MODE` | Optional. Set to `true` to allow one-member survey testing |

PowerShell example:

```powershell
$env:TELEGRAM_BOT_TOKEN = "replace-with-token-from-botfather"
$env:TELEGRAM_BOT_USERNAME = "your_bot_username"
$env:ADMIN_TELEGRAM_ID = "123456789"
$env:DEV_MODE = "true"
```

## Run

```bash
mvn compile exec:java -Dexec.mainClass=org.example.Main
```

Or run `org.example.Main` from your IDE after setting the required environment variables.

## Security Note

An earlier version of this repository committed a Telegram bot token directly in source code. That token must be revoked and replaced in BotFather. Removing a secret from the latest commit is not enough once it has been published in Git history.
