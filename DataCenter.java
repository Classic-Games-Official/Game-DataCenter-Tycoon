import java.util.Timer;
import java.util.TimerTask;

public class Gestion {
    private int renovationLevel;
    private int numberOfEmployees;
    private double coins; // Utilisation de double pour gérer les grandes sommes d'argent

    public Gestion() {
        renovationLevel = 0;
        numberOfEmployees = 0;
        coins = 1000;
    }

    public void renovate(int choice) {
        switch (choice) {
            case 1:
                renovationLevel += 1;
                coins -= 200; // Coût pour une rénovation de base
                break;
            case 2:
                renovationLevel += 2;
                coins -= 400; // Coût pour une rénovation avancée
                break;
            // Ajoutez d'autres options de rénovation ici
            default:
                System.out.println("Choix invalide!");
        }
    }

    public void hireEmployee() {
        numberOfEmployees += 1;
        coins -= 300; // Coût pour embaucher un nouvel employé
    }

    public void buyNewLocation() {
        coins -= 10000; // Coût pour acheter un nouvel emplacement
    }

    public void displayStatus() {
        System.out.println("=== Statut du Data Center ===");
        System.out.println("Niveau de rénovation: " + renovationLevel);
        System.out.println("Nombre d'employés: " + numberOfEmployees);
        System.out.println("Pièces disponibles: " + coins);
    }

    public void saveData() {
        // Code pour sauvegarder les données (non implémenté dans cet exemple)
        System.out.println("Sauvegarde des données...");
    }

    public void startAutoSave() {
        Timer timer = new Timer();
        TimerTask autoSaveTask = new TimerTask() {
            @Override
            public void run() {
                saveData();
            }
        };
        // Auto-save toutes les 3 minutes (180000 ms)
        timer.schedule(autoSaveTask, 180000, 180000);
    }

    public void increaseCoinsPeriodically() {
        // Utilisation d'un thread pour augmenter les pièces toutes les secondes
        Thread increaseCoinsThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); // Attente d'une seconde
                    coins += 2 * Math.pow(2, renovationLevel); // Augmentation du nombre de pièces
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        increaseCoinsThread.start(); // Démarrer le thread
    }

    public static void main(String[] args) {
        Gestion gestion = new Gestion();

        // Démarrer le thread pour augmenter les pièces périodiquement
        gestion.increaseCoinsPeriodically();

        // Démarrer l'auto-sauvegarde toutes les 3 minutes
        gestion.startAutoSave();
    }
}