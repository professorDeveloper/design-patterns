Mavzu: Minecraft o‘yin dunyosi

Vazifa:

Turli xil bloklardan tashkil topgan kichik o‘yin dunyosi tizimini yarating: Grass, Stone, Dirt, Water.

Bir xil blok ma'lumotlari xotirada takroran saqlanmasligi uchun Flyweight patternidan foydalaning.

4 ta klass yaratish kerak:

BlockType — blokning umumiy ma'lumotlarini saqlaydi: nomi, teksturasi, rangi.

Block — X, Y, Z koordinatalari va BlockType obyektiga havolani saqlaydi.

BlockFactory — HashMap yordamida yagona blok turlarini yaratadi va saqlaydi. Agar blok turi avval yaratilgan bo‘lsa, mavjud obyektni qaytaradi.

World — o‘yin dunyosidagi bloklarni saqlaydi va ularni ekranga chiqaradi.

Ishlatish namunasi:

World world = new World();

world.addBlock(0, 0, 0, "Grass");
world.addBlock(1, 0, 0, "Grass");
world.addBlock(2, 0, 0, "Stone");
world.addBlock(3, 0, 0, "Grass");
world.addBlock(4, 0, 0, "Dirt");

world.render();

Qo‘shimcha talab:

== operatori yordamida bir xil turdagi barcha bloklar bitta BlockType obyektidan foydalanayotganini tekshiring.

Natija: 5 ta blok, lekin faqat 3 ta noyob BlockType obyekti.
