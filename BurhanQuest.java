import java.util.Scanner;

public class BurhanQuest {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di
    // awal dan di akhir program
    private static final String BANNER = ".--.          .                .--.              .  .\r\n" + //
            "|   )         |               :    :            _|_ |\r\n" + //
            "|--: .  . .--.|--. .-.  .--.  |    |.  . .-. .--.|  |\r\n" + //
            "|   )|  | |   |  |(   ) |  |  :  ( ;|  |(.-' `--.|  '\r\n" + //
            "'--' `--`-'   '  `-`-'`-'  `-  `--`-`--`-`--'`--'`-'o";
    private static final String STUDENT_NAME = "subidi";
    private static final String STUDENT_ID = "777";

    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di
    // dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input, silakan manfaatkan variabel ini untuk mengambil input
    // dari user
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO: Tampilkan banner
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // TODO: Seeding data quest dan pengembara
        int questCount = 1;
        int travelerCount = 1;
        boolean invalidInput = true;

        // TODO: Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String questCountInput = input.nextLine();
            // TODO: Validasi input jumlah quest
            if (questCountInput.matches("^(0|[1-9][0-9]*)$")) {
                questCount = Integer.parseInt(questCountInput);
                invalidInput = false;
            } else {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        }

        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput)

        {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            if (travelerCountInput.matches("^(0|[1-9][0-9]*)$")) {
                travelerCount = Integer.parseInt(travelerCountInput);
                invalidInput = false;
            } else {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        // TODO: Input data quest sebanyak quest yang diminta
        for (int i = 0; i < questCount; i++) {
            boolean questValid = true;

            while (questValid) {
                System.out.println("Quest " + questId);

                System.out.print("Masukkan nama quest: ");
                String questName = input.nextLine();
                System.out.print("Masukkan deskripsi quest: ");
                String questDesc = input.nextLine();
                System.out.print("Masukkan reward quest berupa bilangan bulat nonnegatif: ");
                String questReward = input.nextLine();
                System.out.print("Masukkan bonus exp quest berupa bilangan bulat nonnegatif: ");
                String questBonus = input.nextLine();
                System.out.print("Masukkan tingkan kesulitan quest (opsi: mudah, menengah, sulit): ");
                String questDiff = input.nextLine();

                if (questName.matches("^[a-zA-Z0-9 ]*$") && questDesc.matches("^[a-zA-Z0-9 ]*$")
                        && questReward.matches("(0|[1-9][0-9]*)$") && questBonus.matches("(0|[1-9][0-9]*)$")
                        && questDiff.toLowerCase().matches("^(mudah|menengah|sulit)")) {

                    questData += "Q" + questId + NAME_IDENTIFIER + questName +
                            DESC_IDENTIFIER + questDesc +
                            REWARD_IDENTIFIER + questReward +
                            EXP_IDENTIFIER + questBonus +
                            DIFFICULTY_IDENTIFIER + questDiff +
                            STATUS_IDENTIFIER + "tersedia\n";
                    System.out.println("Quest berhasil ditambahkan.");
                    questValid = false;
                    questId++;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                }
            }
        }
        System.out.println();

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            boolean travelerValid = true;

            while (travelerValid) {
                double travelerExp;
                String travelerStatus = "";
                System.out.println();
                System.out.println("Pengembara " + travelerId);

                System.out.print("Masukkan nama pengembara: ");
                String travelerName = input.nextLine();
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1, 20]: ");
                String travelerLevelInput = input.nextLine();

                if (travelerName.matches("^[a-zA-Z0-9 ]*$") && travelerLevelInput.matches("([1-9]|1[0-9]|20)")) {
                    int travelerLevel = Integer.parseInt(travelerLevelInput);
                    if (travelerLevel == 1) {
                        travelerExp = 0;
                    } else {
                        travelerExp = 5000 * (Math.pow(2, travelerLevel - 2));
                    }
                    travelerData += NAME_IDENTIFIER + travelerName + LEVEL_IDENTIFIER + travelerLevel
                            + EXP_IDENTIFIER + travelerExp + STATUS_IDENTIFIER + travelerStatus;

                    System.out.println("Pengembara berhasil ditambahkan");
                    travelerId++;
                    travelerValid = false;

                } else {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                    System.out.println();
                }
            }
        }

        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        // TODO: Loop menu utama
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    // TODO: Tampilkan daftar quest
                    System.out.println("Quest yang terdaftar: ");
                    int i = 0;
                    while(i < questCount) {
                        int akhir = questData.indexOf('\n', i);
                        if (akhir == -1){
                            akhir = questData.length();
                        }
                        
                        int indexquestName = questData.indexOf(NAME_IDENTIFIER);
                        int indexquestDesc = questData.indexOf(DESC_IDENTIFIER);
                        int indexquestReward = questData.indexOf(REWARD_IDENTIFIER);
                        int indexquestBonus = questData.indexOf(EXP_IDENTIFIER);
                        int indexquestDiff = questData.indexOf(DIFFICULTY_IDENTIFIER);
                        int indexquestStat = questData.indexOf(STATUS_IDENTIFIER);

                        String questId = questData.substring(0, indexquestName);
                        String questName = questData.substring(indexquestName + 1, indexquestDesc);
                        String questDesc = questData.substring(indexquestDesc + 1, indexquestReward);
                        String questReward = questData.substring(indexquestReward + 1, indexquestBonus);
                        String questBonus = questData.substring(indexquestBonus + 1, indexquestDiff);
                        String questDiff = questData.substring(indexquestDiff + 1, indexquestStat);
                        String questStat = questData.substring(indexquestStat+1);

                        // Difficulty
                        if (questDiff.equals("mudah")) {
                            questDiff = "\u2605";
                        } else if (questDiff.equals("menengah")) {
                            questDiff = "\u2605\u2605";
                        } else {
                            questDiff = "\u2605\u2605\u2605";
                        }

                        // Status implement nanti aja pas udh nguruh kesana

                        System.out.println();
                        System.out.println("ID Quest: " + questId);
                        System.out.println("Nama Quest: " + questName);
                        System.out.println("Deskripsi Quest: " + questDesc);
                        System.out.println("Reward Quest: " + questReward);
                        System.out.println("Bonus Exp Quest: " + questBonus);
                        System.out.println("Tingkat Kesulitan Quest: " + questDiff);
                        System.out.println("Status Quest: " + questStat);
                        
                        i = akhir +1;
                    }
                    break;
                case "2":
                    // TODO: Tampilkan daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "3":
                    // TODO: Tambah quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "4":
                    // TODO: Tambah pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "5":
                    // TODO: Menjalankan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    // TODO: Tampilkan daftar pengembara terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11":
                    // TODO: Keluar
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
