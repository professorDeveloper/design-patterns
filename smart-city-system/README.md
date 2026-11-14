# 🧩 Laboratoriya ishi №1
### Loyiha: SmartCity tizimi

---

## 📘 Topshiriq tavsifi

SmartCity tizimi - bu aqlli shahar boshqaruv tizimining ishlashini simulyatsiya qiluvchi konsol ilovasi.

Tizim yoritish, transport, xavfsizlik, energiya tejash, monitoring va boshqa shahar infratuzilmasi funktsiyalari uchun mas'ul bo'lgan turli xil quyi tizimlarni birlashtiradi.

Har bir quyi tizim loyihaning me'moriy barqarorligi va kengayishini ta'minlaydigan dizayn naqshlari yordamida amalga oshiriladi.

---

## 🧱 Asosiy talablar

1. Loyiha **ob'ektga yo'naltirilgan dasturlash** yordamida **har qanday tilda* amalga oshirilishi kerak.

2. Arxitektura taqdim etilgan ro'yxatdan **kamida beshta dizayn naqshini** o'z ichiga olishi kerak.

3. Har bir dizayn naqshida tizim ichida funktsional maqsad bo'lishi kerak.

4. Tizim mantiqiy jihatdan izchil bo'lishi va o'zaro bog'liq komponentlardan iborat bo'lishi kerak.

5. Foydalanuvchi bilan o'zaro aloqa konsol interfeysi orqali amalga oshiriladi.

6. Har bir dizayn naqshida uning ishlatilishi va maqsadi ko'rsatilishi kerak.

---

## 🧩 Ruxsat etilgan dizayn naqshlari

### Yaratilish:
- Abstrakt fabrika
- Zavod usuli
- Quruvchi
- Prototip
- Singleton

### Strukturaviy:
- Adapter
- Ko'prik
- Kompozit
- Dekorator
- Fasad
- Yengil vazn
- Proksi


````
smart-city-system/src/main/kotlin/uz/azamov/smartcity/
├── Main.kt                  # Konsol menyusi, dastur kirish nuqtasi
├── core/
│   ├── facade/              # Facade: SmartCityFacade barcha quyi tizimlarni boshqaradi
│   ├── factories/           # Factory Method: DeviceFactory, StreetLight, Camera, TrafficLight
│   ├── builders/            # Builder: SmartStreet.Builder
│   ├── adapters/            # Adapter: WeatherAdapter, ExternalWeatherApi
│   ├── proxy/               # Proxy: SecurityProxy, EmergencyService
│   └── singleton/           # Singleton: Log
└── modules/
    ├── transport/           # Transport boshqaruvi
    ├── lighting/            # Yoritish boshqaruvi
    ├── security/            # Xavfsizlik tizimi
    └── energy/              # Energiya tejash va monitoring
src/test/kotlin/uz/azamov/smartcity/Test.kt   # Tizim testlari
````

## 🧮 Baholash mezonlari

| Mezon | Ballar |
|- ...

---

## 🧩 Ishlatilgan naqshlar

| Naqsh | Fayl | Vazifasi |
|---|---|---|
| Facade | `core/facade/SmartCityFacade.kt` | Menyu barcha quyi tizimlarni bitta klass orqali boshqaradi |
| Factory Method | `core/factories/DeviceFactory.kt` | Turiga qarab chiroq, kamera yoki svetafor yaratadi |
| Builder | `core/builders/SmartStreet.kt` | Ko'chani bosqichma-bosqich quradi |
| Adapter | `core/adapters/WeatherAdapter.kt` | Tashqi API ma'lumotini (°F, satr) `Weather` ga o'giradi |
| Proxy | `core/proxy/SecurityProxy.kt` | Favqulodda rejimni faqat `SC-2026` kodi bilan ochadi |
| Singleton | `core/singleton/Log.kt` | Butun dastur uchun yagona logger |

Ishga tushirish: `./gradlew :smart-city-system:run --console=plain`, testlar: `./gradlew :smart-city-system:test`
