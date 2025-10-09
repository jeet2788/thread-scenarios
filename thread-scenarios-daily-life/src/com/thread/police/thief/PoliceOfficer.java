package com.thread.police.thief;

class PoliceOfficer extends Thread {
    private volatile boolean isRunning = true;
    private Thief thief;

    public PoliceOfficer(Thief thief) {
        this.thief = thief;
    }

    public void run() {
        try {
            System.out.println("Police officer is on patrol...");
            Thread.sleep(500); // Wait for 5 seconds

            if (isRunning) {
                System.out.println("Police officer caught the thief!");
                thief.arrest();
                System.exit(1);
            } else {
                System.out.println("Police officer missed the thief!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopPatrol() {
        isRunning = false;
    }
}

class Thief extends Thread {
    private boolean isRunning = true;

    public void run() {
        System.out.println("Thief is committing a crime...");

        while (isRunning) {
            // Carry out the crime
        }

        System.out.println("Thief got away!");
    }

    public void arrest() {
        isRunning = false;
        // Perform the arrest
    }
}

class MainThread {
    public static void main(String[] args) {
        Thief thief = new Thief();
        PoliceOfficer officer = new PoliceOfficer(thief);

        thief.start();
        officer.start();

        try {
            Thread.sleep(10000); // Let the scenario run for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        officer.stopPatrol(); // Stop the police officer's patrol

        // Wait for both threads to complete
        try {
            thief.join();
            officer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Scenario finished.");
    }
}

