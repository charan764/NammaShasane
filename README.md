# 🪨 Namma Shasane (ನಮ್ಮ ಶಾಸನ)
### *"Turning Old Stones into Talking History"*

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-brightgreen?style=for-the-badge&logo=android"/>
  <img src="https://img.shields.io/badge/Language-Kotlin-purple?style=for-the-badge&logo=kotlin"/>
  <img src="https://img.shields.io/badge/AI-Gemini-blue?style=for-the-badge&logo=google"/>
  <img src="https://img.shields.io/badge/Maps-Google%20Maps-red?style=for-the-badge&logo=googlemaps"/>
  <img src="https://img.shields.io/badge/UI-Jetpack%20Compose-orange?style=for-the-badge&logo=jetpackcompose"/>
</p>

---

## 📖 The Problem We're Solving

Karnataka holds the **highest number of stone inscriptions (Shasanas) in all of India** —
etched on temple walls, village boundary stones, and ancient ruins across the state.

These inscriptions are **primary historical documents** — recording land gifts, royal decrees,
heroic sacrifices, and the daily life of civilizations that shaped modern India.

Yet today, they are:
- 🎨 **Painted over** by people who don't know their significance
- 🔨 **Demolished** during construction and renovation
- 🌿 **Forgotten** in overgrown fields and neglected temples
- 📦 **Lost forever** because no one documented them in time

**Namma Shasane** changes that.

---

## 💡 What is Namma Shasane?

Namma Shasane is a **GenAI-powered Android application** that acts as a digital bridge
between Karnataka's citizens and their 2000-year-old heritage.

It empowers anyone — a student, a tourist, a farmer — to **find, photograph, understand,
and protect** ancient stone inscriptions using just their smartphone.

> *"That old rock in your village? It might be a royal decree from the Rashtrakutas.
> Namma Shasane will tell you its story."*

---

## ✨ Core Features

### 🗺️ Heritage Map
An interactive map powered by **Google Maps SDK** showing documented inscriptions
and heritage sites across Karnataka — including Hampi, Badami, Halebidu, Belur,
and hundreds of lesser-known village sites. Get directions, distances, and
site previews — all from the app.

### 🤖 AI-Powered Inscription Stories
Powered by **Google Gemini AI**, the app analyzes inscription photos and generates
rich historical narratives in plain language:
> *"This stone, dating to 1150 CE, records a land grant by King Vikramaditya VI
> of the Western Chalukyas to a local Shiva temple. The gift included 10 acres
> of fertile land and was witnessed by village elders."*

Complete with **Text-to-Speech narration** — history literally speaks to you.

### 📸 Inscription Scanner
Using **CameraX integration**, users can photograph any stone inscription they
encounter. The image is processed by Gemini AI to identify the script (Kannada,
Sanskrit, Tamil, Telugu), estimate the dynasty and era, and generate a
translation and historical context.

### 🚨 Preservation Alert System
Found an inscription being damaged or painted over? Report it instantly with
photo evidence and GPS coordinates. Alerts are logged and can be shared with
heritage authorities.

### 🏛️ Heritage Trail
Follow curated GPS trails through clusters of inscriptions — turning a village
walk into a guided history tour. Each trail connects inscriptions into a
coherent historical narrative.

### 🔐 Secure Authentication
- Email/Password login
- Google Sign-In (One Tap)
- Secure session management

### 👤 Explorer Profile
Track your personal heritage journey:
- Number of inscriptions scanned
- Heritage sites visited
- Preservation alerts filed
- Badges earned for contributions

---

## 🛠️ Tech Stack

| Component | Technology | Purpose |
|-----------|-----------|---------|
| Language | Kotlin | Primary development language |
| UI Framework | Jetpack Compose + Material 3 | Modern declarative UI |
| AI Engine | Google Gemini API | Inscription analysis & story generation |
| Maps | Google Maps SDK | Heritage site mapping & trails |
| Camera | CameraX | Inscription scanning |
| Database | Room DB | Local inscription & site storage |
| Image Loading | Coil | Efficient photo rendering |
| Auth | Firebase Auth + Google Sign-In | Secure user authentication |
| TTS | Android TextToSpeech API | Audio narration of inscriptions |
| Architecture | MVVM + Clean Architecture | Scalable, maintainable codebase |

---

## 📂 Project Structure
