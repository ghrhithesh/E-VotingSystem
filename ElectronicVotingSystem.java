import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectronicVotingSystem {
    private static Map<String, Voter> voters = new HashMap<>();
    private static Map<String, Integer> candidates = new HashMap<>();
    private static Map<String, Boolean> voteStatus = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize candidates
        candidates.put("Candidate A".toLowerCase(), 0);
        candidates.put("Candidate B".toLowerCase(), 0);
        candidates.put("Candidate C".toLowerCase(), 0);

        while (true) {
            System.out.println("Electronic Voting System");
            System.out.println("1. Register Voter");
            System.out.println("2. Vote");
            System.out.println("3. Show Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    registerVoter(scanner);
                    break;
                case 2:
                    vote(scanner);
                    break;
                case 3:
                    showResults();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerVoter(Scanner scanner) {
        System.out.print("Enter Voter Name: ");
        String name = scanner.next();
        System.out.print("Enter Voter ID: ");
        String voterId = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        voters.put(voterId, new Voter(name, password));
        voteStatus.put(voterId, false);
        System.out.println("Voter registered successfully.");
    }

    private static void vote(Scanner scanner) {
        System.out.print("Enter Voter ID: ");
        String voterId = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        Voter voter = voters.get(voterId);

        if (voter != null && voter.getPassword().equals(password)) {
            if (voteStatus.get(voterId)) {
                System.out.println("You have already voted. One person, one vote!");
                return;
            }
            System.out.println("Candidates:");
            for (String candidate : candidates.keySet()) {
                System.out.println(capitalize(candidate));
            }
            System.out.print("Enter your candidate's name: ");
            scanner.nextLine(); // consume newline
            String candidateName = scanner.nextLine().toLowerCase();
            if (candidates.containsKey(candidateName)) {
                candidates.put(candidateName, candidates.get(candidateName) + 1);
                voteStatus.put(voterId, true);
                System.out.println("Vote cast successfully. Thank you for voting!");
            } else {
                System.out.println("Invalid candidate.");
            }
        } else {
            System.out.println("Invalid voter ID or password.");
        }
    }

    private static void showResults() {
        System.out.println("Election Results:");
        String leadingCandidate = null;
        int maxVotes = -1;
        int secondMaxVotes = -1;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            String candidate = capitalize(entry.getKey());
            int votes = entry.getValue();
            System.out.println(candidate + ": " + votes + " votes");

            if (votes > maxVotes) {
                secondMaxVotes = maxVotes;
                maxVotes = votes;
                leadingCandidate = candidate;
            } else if (votes > secondMaxVotes) {
                secondMaxVotes = votes;
            }
        }

        if (leadingCandidate != null && secondMaxVotes != -1) {
            int leadBy = maxVotes - secondMaxVotes;
            System.out.println(leadingCandidate + " is leading by " + leadBy + " votes.");
        }
    }1

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear invalid input
        }
        return scanner.nextInt();
    }

    static class Voter {
        private String name;
        private String password;

        public Voter(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }
}
