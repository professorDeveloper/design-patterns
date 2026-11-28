Topshiriq: Chain of Responsibility — «Qo'llab-quvvatlash xizmati»

Qo'llab-quvvatlash xizmatiga turli murakkablikdagi murojaatlar (tiketlar) keladi. Har bir xodim tiketni hal qila olsa, hal qiladi. Hal qila olmasa, keyingisiga uzatadi.

Darsdagi misoldan farqi: tiketni FAQAT BIRINCHI mos kelgan ishlovchi hal qiladi, shundan keyin zanjir to'xtaydi.

Ticket klassi: id, message, level maydonlari (1 — oddiy, 2 — o'rtacha, 3 — murakkab, 4 — kritik)

SupportHandler abstrakt klassi:
- next maydoni va setNext(SupportHandler next) metodi
- handle(Ticket t) metodi: agar canHandle(t) bo'lsa, tiketni hal qilib to'xtash; aks holda next ga uzatish; agar next bo'lmasa, "Tiket #id hal qilinmadi!" deb chiqarish
  - abstract boolean canHandle(Ticket t)
- abstract void process(Ticket t)

Ishlovchilar:
- ChatBot level 1 tiketlarni hal qiladi
- Operator level 2 tiketlarni hal qiladi
- Manager level 3 tiketlarni hal qiladi

main da ChatBot → Operator → Manager zanjirini yig'ing va 4 ta tiket yuboring:
1. "Parolni qanday o'zgartiraman?" (level 1)
2. "To'lov o'tmadi" (level 2)
3. "Pulni qaytarish" (level 3)
4. "Ma'lumotlar sizib chiqdi" (level 4)

Kutilayotgan natija:
[Bot] Tiket #1 hal qilindi: Parolni qanday o'zgartiraman?
[Operator] Tiket #2 hal qilindi: To'lov o'tmadi
[Menejer] Tiket #3 hal qilindi: Pulni qaytarish
Tiket #4 hal qilinmadi!
