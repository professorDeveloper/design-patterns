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
FIO/
├── main.py # Main application entry point
├── test.py # Test for system
├── core/ # Core system components
│ ├── controller.py # Central controller / Facade / Singleton
│ ├── factories/ # Creational patterns (Factory, Abstract Factory)
│ ├── builders/ # Builder for step-by-step object construction
│ ├── adapters/ # Adapter for external service integration
│ ├── proxy/ # Proxy for subsystem access control
│ └── singleton/ # Singleton for unique components
├── modules/ # Smart city subsystems
│ ├── transport/ # Transportation management
│ ├── lighting/ # Lighting management
│ ├── security/ # Security subsystem
│ └── energy/ # Energy saving and monitoring
└── README.md # Assignment description and project structure


````

## 🧮 Baholash mezonlari

| Mezon | Ballar |
|- ...