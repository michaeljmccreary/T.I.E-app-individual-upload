
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author micha
 */
public class Stress {
    
    public void stressTipsButtonClick(String stressLevelText, String easyStressedText, String stressHelpText) {
        
        StringBuilder errorMessages = new StringBuilder();

        try {
            int stressLevel = Integer.parseInt(stressLevelText);

            // Validate stressLevel
            if (stressLevel < 1 || stressLevel > 10) {
                errorMessages.append("Please enter a valid number for stress level between 1 and 10.\n");
            }

            // Validate easyStressed and stressHelp
            if (!"Yes".equalsIgnoreCase(easyStressedText) && !"No".equalsIgnoreCase(easyStressedText)) {
                errorMessages.append("Please enter 'Yes' or 'No' for Easy Stressed.\n");
            }

            if (!"Yes".equalsIgnoreCase(stressHelpText) && !"No".equalsIgnoreCase(stressHelpText)) {
                errorMessages.append("Please enter 'Yes' or 'No' for Stress Help.\n");
            }

            // If there are any errors, display them and exit the method
            if (errorMessages.length() > 0) {
                JOptionPane.showMessageDialog(null, errorMessages.toString());
                return;
            }

            // If all validations pass, proceed to generate stress tips
            String tips = generateStressTips(stressLevel, "Yes".equalsIgnoreCase(easyStressedText), "Yes".equalsIgnoreCase(stressHelpText));
            JOptionPane.showMessageDialog(null, tips);

        } catch (NumberFormatException ex) {
            errorMessages.append("Please enter a valid number for stress level.\n");
            JOptionPane.showMessageDialog(null, errorMessages.toString());
        }
    }

    private String generateStressTips(int stressLevel, boolean easyStressed, boolean stressHelp) {
        StringBuilder tipsBuilder = new StringBuilder();

        // Stress Level Tips
        if (stressLevel >= 7) {
            tipsBuilder.append("Your stress level is high. Consider taking some time for relaxation and stress reduction activities. \n");
        } else if (stressLevel >= 4) {
            tipsBuilder.append("Your stress level is moderate. Try incorporating stress-relief techniques into your routine. \n");
        } else {
            tipsBuilder.append("You're doing well in managing stress. Keep up the good work! \n");
        }

        // Easy Stressed Tips
        if (!easyStressed) {
            tipsBuilder.append("It seems you are easily stressed. Practice mindfulness and deep breathing to manage stress more effectively. \n");
        } else {
            tipsBuilder.append("Even people who handle stressful situations well have their limits. Be mindful of your situations and try not to take on more than you can handle. \n");
        }

        // Stress Help Tips
        if (stressHelp) {
            tipsBuilder.append("It is great that you have someone around you to talk to. You should use this invaluable resource whenever you need. \n");
        } else {
            tipsBuilder.append("\nHaving someone to rely on when things get stressful is a fundamental part of managing stress" + '\n'
                    + "You can even reach out to a professional counseling at https://www.iacp.ie/ '\n");
        }

        return tipsBuilder.toString();
    }
}
