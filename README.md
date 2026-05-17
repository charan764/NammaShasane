# Namma Shasane - Preserving Karnataka's Heritage

Namma Shasane is a mobile application dedicated to exploring and preserving the ancient inscriptions and historical sites of Karnataka. Using modern technology like AI and Google Maps integration, it bridges the gap between history and the digital age.

## Features

- **Heritage Map**: Interactive map showing historical places (Hampi, Badami, Halebidu, etc.) with coordinates and directions via Google Maps.
- **AI-Powered Inscription Stories**: Discover the history behind ancient stones with AI-generated explanations and Text-to-Speech narration.
- **Visual Exploration**: High-quality photos of heritage sites and inscriptions.
- **Modern Authentication**: Secure login with Email or Google Account.
- **Profile Management**: Track your journey, scanned stones, and visited sites.
- **Inscription Scanner**: Tools for scanning and analyzing ancient inscriptions (CameraX integration).

## Tech Stack

- **Kotlin** & **Jetpack Compose** for a modern UI.
- **Google Maps SDK** for heritage site mapping.
- **Google Generative AI (Gemini)** for historical analysis.
- **Room Database** for local data persistence.
- **Coil** for efficient image loading.
- **Material 3** for contemporary design.

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/charan764/Namma-Shasane.git
   ```
2. **Setup API Keys**:
   - Add your Gemini AI API Key to `local.properties` as `GEMINI_API_KEY=your_key_here`.
   - Setup Google Cloud Project for Google Sign-In and Maps.
3. **Build & Run**: Open the project in Android Studio and run it on an emulator or physical device.

## Security

This project follows security best practices by:
- Using a `.gitignore` to prevent leaking local configuration and secrets.
- Keeping sensitive API keys out of version control (placeholders are used in the source).
- Implementing secure Google Sign-In.

## License

This project is for educational and heritage preservation purposes.
