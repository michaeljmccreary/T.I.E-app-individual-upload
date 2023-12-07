
import javax.swing.JOptionPane;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Michael McCreary - x22171363
 */
public class Mood {

    private static final String FILE_NAME = "mood.txt";

    public void moodTipsButtonClick(String moodLevelText, String socialiseRegularlyInput, String unitsOfAlcoholText, String hoursInNatureText) {
        StringBuilder errorMessages = new StringBuilder();

        try {
            int moodLevelValue = Integer.parseInt(moodLevelText);

            // Validate moodLevelValue
            if (moodLevelValue < 1 || moodLevelValue > 10) {
                errorMessages.append("Invalid input. Please enter a valid number for mood level between 1 and 10.\n");
            }

            // Validate socialiseRegularlyInput
            if (!socialiseRegularlyInput.equalsIgnoreCase("Yes") && !socialiseRegularlyInput.equalsIgnoreCase("No")) {
                errorMessages.append("Invalid input. Please enter 'Yes' or 'No' for socialising regularly.\n");
            }

            int unitsOfAlcoholValue = Integer.parseInt(unitsOfAlcoholText);

            // Validate unitsOfAlcoholValue
            if (unitsOfAlcoholValue < 0) {
                errorMessages.append("Invalid input. Please enter a valid number for units of alcohol (non-negative).\n");
            }

            int hoursInNatureValue = Integer.parseInt(hoursInNatureText);

            // Validate hoursInNatureValue
            if (hoursInNatureValue < 0) {
                errorMessages.append("Invalid input. Please enter a valid number for hours in nature (non-negative).\n");
            }

            // If there are any errors, display them and exit the method
            if (errorMessages.length() > 0) {
                JOptionPane.showMessageDialog(null, errorMessages.toString());
                return;
            }

            // If all validations pass, proceed to generate mood tips
            String tips = generateMoodTips(moodLevelValue, "Yes".equalsIgnoreCase(socialiseRegularlyInput),
                    unitsOfAlcoholValue, hoursInNatureValue);

            // Display the tips using JOptionPane
            JOptionPane.showMessageDialog(null, tips);

            // Attempt to write the generated tips to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                // Write the generated tips to the file
                writer.write(tips);

                // Add a newline to separate sets of tips in the file
                writer.newLine();
            } catch (IOException ex) {
                // Handle any IOException that might occur during file writing
                ex.printStackTrace(); // Print the stack trace to the console (for debugging purposes)
            }

            // Print file information
            File file = new File(FILE_NAME);
            String filePath = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null, "Tips written to file: " + FILE_NAME + "\nFile path: " + filePath);

        } catch (NumberFormatException ex) {

            // Handle the case where the input is not a valid number
            errorMessages.append("Invalid input. Please enter numeric values for mood level, alcohol units, and hours in nature.\n");
            JOptionPane.showMessageDialog(null, errorMessages.toString());
        } catch (IllegalArgumentException ex) {

            // Handle the case where there is an invalid input
            errorMessages.append(ex.getMessage()).append("\n");
            JOptionPane.showMessageDialog(null, errorMessages.toString());
        }
    }

    public String generateMoodTips(int moodLevel, boolean socialiseRegularly, int unitsOfAlcohol, int hoursInNature) {
        StringBuilder tipsBuilder = new StringBuilder();

        // Mood Level Tips
        if (moodLevel < 5) {
            tipsBuilder.append("Your mood is quite low. Consider seeking support from friends or professionals. \n");
        } else if (moodLevel < 7) {
            tipsBuilder.append("Your mood is moderate. Engage in activities that bring you joy. \n");
        } else {
            tipsBuilder.append("You are in a good mood. Keep up the positive vibes! \n");
        }

        // Socialising Tips
        if (!socialiseRegularly) {
            tipsBuilder.append("Socialising is important for mental well-being. Make an effort to connect with others. \n");
        } else {
            tipsBuilder.append("Great job on maintaining regular social activities! \n");
        }

        // Alcohol Tips
        if (unitsOfAlcohol >= 3) {
            tipsBuilder.append("Binge drinking can negatively impact your mood. Consider cutting down on alcohol consumption." + '\n'
                    + "If you need help getting your alcohol consumption under control, please visit: https://www.drinkaware.ie/  \n");
        } else if (unitsOfAlcohol > 0) {
            tipsBuilder.append("Your alcohol consumption is below recommended levels. Be mindful of its effects on your mood. \n");
        } else {
            tipsBuilder.append("You haven't consumed any alcohol. This is beneficial for your overall well-being. \n");
        }

        // Nature Tips
        if (hoursInNature < 2) {
            tipsBuilder.append("Spending more time in nature can improve your mood and well-being. \n");
        } else if (hoursInNature >= 2 && hoursInNature < 5) {
            tipsBuilder.append("You are spending a decent amount of time in nature. Consider increasing it for additional benefits. \n");
        } else {
            tipsBuilder.append("You are getting a good dose of nature! Keep enjoying the outdoors. \n");
        }

        return tipsBuilder.toString();
    }
}
