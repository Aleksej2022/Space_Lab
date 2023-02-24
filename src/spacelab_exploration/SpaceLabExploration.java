package spacelab_exploration;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpaceLabExploration {
    /*
    * Author Name: -> Aleksej Babako
    * Program Name: -> SpaceLab_Exploration.java
    * Program Description: -> This program is intended to provide prospect space explorer passengers with information they need to know
    * before travelling on a space journey to other planets. Such information includes: -> finding their age and weight on other planets in the
    * solar system
    * Date Created: -> 08.02.2023
    * */

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner number = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        Main telescope_1 = new Main();
        Main telescope_2 = new Main();
        Main space_explorer = new Main();
        System.out.println("******************************************************************************");
        System.out.println("Please take a moment to listen to the welcome audio and replay where necessary");
        System.out.println("******************************************************************************");

        // Inserting Audio
        File file = new File("Space_Welcome.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        System.out.println("Enter R to play audio");
        String response = text.nextLine();
        response = response.toUpperCase();
        if (response.equals("P")){
            clip.start();
            System.out.println("Enter P = Stop P = Replay");
             response = text.nextLine();
             response = response.toUpperCase();

             if (response.equals("S")){
                 clip.stop();
                 System.out.println("Thank you!");
             }
             else if (response.equals("B")){
                 clip.setMicrosecondPosition(0);
                 clip.start();

                 System.out.println("Enter E to exit");
                 response = text.nextLine();
                 response = response.toUpperCase();
                 System.out.println("Thank you!");
             }
        }

        System.out.println("******************************************************************************");
        System.out.println("Important Information About Focal Ratio of Telescopes");
        System.out.println("A longer focal ratio means a higher magnification which is great for observing the moon, planets and double stars");
        System.out.println("A lower focal ratio means a lower magnification which is ideal for observing star clusters, galaxies and the milky way");
        System.out.println("******************************************************************************");

        //Focal Ratio Of Each Telescope 1 Calculation

        telescope_1.focal_length = 1000;
        telescope_1.aperture = 102;
        telescope_1.focal_ratio = telescope_1.focal_length/telescope_1.aperture;

        //Focal Ratio Of Each Telescope 2 Calculation

        telescope_2.focal_length = 1270;
        telescope_2.aperture = 250;
        telescope_2.focal_ratio = telescope_2.focal_length/telescope_2.aperture;

        //Display focal ratio for each telescope in a tabular format

        System.out.println("+++++++++++++++++++ Focal Ratio For The Telescopes +++++++++++++++++++");

        System.out.printf("%30s", "Telescope Names");
        System.out.printf("%15s","Focal Ratio");
        System.out.printf("%35s", "Telescope Capacity Description");

        System.out.println();

        System.out.printf("%30s", "The Skwatcher Evostar 120(90deg)");
        System.out.printf("%15s",telescope_1.focal_ratio);
        System.out.printf("%5s", "");
        if (telescope_1.focal_ratio > 7){
            System.out.printf("%s", "Great for observing the moon, planets and double stars");
        }
        else if (telescope_1.focal_ratio >= 1 && telescope_1.focal_ratio <= 7){
            System.out.printf("%s", "Great for observing the clusters, galaxies and the milky way");
        }

        System.out.println();

        System.out.printf("%30s", "The Celestron Starhopper");
        System.out.printf("%15s",telescope_2.focal_ratio);
        System.out.printf("%5s", "");
        if (telescope_2.focal_ratio > 7){
            System.out.printf("%s", "Great for observing the moon, planets and double stars");
        }
        else if (telescope_2.focal_ratio >= 1 && telescope_2.focal_ratio <= 7){
            System.out.printf("%s", "Great for observing the clusters, galaxies and the milky way");
        }
        //Choosing the telescope of their choice
        System.out.println();

        System.out.println("******************************************************************************");
        System.out.println("Which telescope do you choose?\n.A The Skwatcher Evostar 120\n.B The Celestron Starhopper\n");
        System.out.println("******************************************************************************");
        String user_choice = text.nextLine();
        if (user_choice.equals("A") || user_choice.equals("B")){
            System.out.println("Great choice!");
            //Age Calculation in Other Planets Section

            System.out.println("******************************************************************************");
            System.out.println("Age calculation in other planets");
            System.out.println("******************************************************************************");
            System.out.println("Enter your current age ");
            space_explorer.spaceexplorer_age = number.nextDouble();
            double mercury_terrestage = (space_explorer.spaceexplorer_age * 365)/88;
            double venus_terrestage = (space_explorer.spaceexplorer_age * 365)/225;
            double mars_terrestage = (space_explorer.spaceexplorer_age * 365)/687;
            double jupiter_outerage = space_explorer.spaceexplorer_age / 30;
            double uranus_outerage = space_explorer.spaceexplorer_age / 84;
            double neptune_outerage = space_explorer.spaceexplorer_age / 165;
            //Weight Calculation in Other Planets
            System.out.println("******************************************************************************");
            System.out.println("Weight(kg) calculation in other planets");
            System.out.println("******************************************************************************");
            System.out.println("Enter your weight in kilograms ");

            space_explorer.spaceexplorer_weight = number.nextDouble();

            double mercury_terrestweight = space_explorer.spaceexplorer_weight * 0.38;
            double venus_terrestweight = space_explorer.spaceexplorer_weight * 0.91;
            double mars_terrestweight = space_explorer.spaceexplorer_weight * 0.38;
            double jupiter_gasgiantweight = space_explorer.spaceexplorer_weight * 2.34;
            double saturn_gasgiantweight = space_explorer.spaceexplorer_weight * 1.06;
            double uranus_iceweight = space_explorer.spaceexplorer_weight * 0.92;
            double neptune_iceweight = space_explorer.spaceexplorer_weight * 1.19;
            //Display the age and the weight in other planets
            System.out.println("+++++++++++++++++++ Space Exploration Data Results +++++++++++++++++++");
            System.out.printf("%20s","Planet Names");
            System.out.printf("%20s","Planet Type");
            System.out.printf("%20s","Age");
            System.out.printf("%20s","Weight(kg)");

            System.out.println();
            System.out.printf("%20s","Mercury");
            System.out.printf("%20s","Terrestrial");
            System.out.printf("%20f",mercury_terrestage);
            System.out.printf("%20f",mercury_terrestweight);

            System.out.println();
            System.out.printf("%20s","Venus");
            System.out.printf("%20s","Terrestrial");
            System.out.printf("%20f",venus_terrestage);
            System.out.printf("%20f",venus_terrestweight);

            System.out.println();
            System.out.printf("%20s","Mars");
            System.out.printf("%20s","Terrestrial");
            System.out.printf("%20f",mars_terrestage);
            System.out.printf("%20f",mars_terrestweight);

            System.out.println();
            System.out.printf("%20s","Jupiter");
            System.out.printf("%20s","Gas giants");
            System.out.printf("%20f",jupiter_outerage);
            System.out.printf("%20f",jupiter_gasgiantweight);

            System.out.println();
            System.out.printf("%20s","Uranus");
            System.out.printf("%20s","Ice giants");
            System.out.printf("%20f",uranus_outerage);
            System.out.printf("%20f",uranus_iceweight);

            System.out.println();
            System.out.printf("%20s","Neptune");
            System.out.printf("%20s","Ice giants");
            System.out.printf("%20f",neptune_outerage);
            System.out.printf("%20f",neptune_iceweight);

            //Conclusion message to space explorers
            System.out.println("\nThank you for using space lab programmed system,have a wonderful space journey!");

        } else {
            System.out.println("You have entered an incorrect option!, please restart the program");
        }

    }
    
}
