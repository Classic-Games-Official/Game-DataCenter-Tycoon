public DataCenter() {
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

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DataCenter dataCenter = new DataCenter();
    
    System.out.println("Bienvenue dans RénoDataCenter!");
    
    while (true) {
        System.out.println("\nQue souhaitez-vous faire ?");
        System.out.println("1. Rénover le Data Center");
        System.out.println("2. Embaucher un nouvel employé");
        System.out.println("3. Acheter un nouvel emplacement");
        System.out.println("4. Afficher le statut du Data Center");
        System.out.println("5. Quitter");
        System.out.print("Votre choix: ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("\nChoisissez le niveau de rénovation:");
                System.out.println("1. Rénovation de base (200 pièces)");
                System.out.println("2. Rénovation avancée (400 pièces)");
                int renovationChoice = scanner.nextInt();
                dataCenter.renovate(renovationChoice);
                break;
            case 2:
                dataCenter.hireEmployee();
                break;
            case 3:
                dataCenter.buyNewLocation();
                break;
            case 4:
                dataCenter.displayStatus();
                break;
            case 5:
                System.out.println("Merci d'avoir joué à RénoDataCenter!");
                return;
            default:
                System.out.println("Choix invalide!");
        }
    }
}